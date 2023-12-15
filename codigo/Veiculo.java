package codigo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

public class Veiculo {
    private static final int MAX_ROTAS = 30;
    
    private String placa;
    private EVeiculo tipoVeiculo;
    
    private HistoricoRota historicoRota;

    Tanque tanque;

    private ArrayList<ManutencaoExecutada> manutencoesExecutadas;


    public double autonomiaMaxima() {
        return tanque.autonomiaMaxima();
    }


    private double autonomiaAtual() {
        return tanque.autonomiaAtual();
    }


    public Veiculo(String Placa, EVeiculo tipoVeiculo, ECombustivel combustivel) {
        this.placa = Placa;
        this.tipoVeiculo = tipoVeiculo;
        this.historicoRota = new HistoricoRota();
        this.tanque = new Tanque(combustivel, tipoVeiculo.getcapacidadeMaximaTanque());
        this.manutencoesExecutadas = new ArrayList<ManutencaoExecutada>();
    }

    public String getPlaca(){
        return placa;
    }


    public boolean addRota(Rota rota)
        //throws IllegalArgumentException
    {        
        if (historicoRota.TotalRotasMensal(YearMonth.from(rota.getData())) >= MAX_ROTAS) {
            return false;
            //throw new IllegalArgumentException("Máximo de rotas mensais já atingidas para o veículo " + getPlaca());
        }

        historicoRota.add(rota);
        return true;
    }


    public double kmNoMes() {
        LocalDate dataAtual = LocalDate.now();
        YearMonth mes = YearMonth.from(dataAtual);

        return historicoRota.totalKmMes(mes);
    }


    public double kmTotal() {
        return historicoRota.totalKmVida();
    }


    public double KmMedia()
    {
        return historicoRota.mediaKmVida();
    }


    public double getTotalReabastecidoVida(){
        return tanque.getTotalReabastecidoVida();
    }


    public String percorrerRota(Rota rota) 
        throws IllegalArgumentException
    {
        if (rota.getQuilometragem() > tanque.autonomiaMaxima() ){
            throw new IllegalArgumentException("Veículo " + getPlaca() + " não tem autonomia ("+ tanque.autonomiaMaxima() +"Km) para rotas de " + rota.getQuilometragem() + "Km.");
        }

        StringBuilder sb = new StringBuilder("Evento Percorrer Rota " + getPlaca() + " {\n");
        
        if (rota.getQuilometragem() > tanque.autonomiaAtual()){
            double litrosCombustivel = rota.getQuilometragem() / tanque.ConsumoKmL();

            tanque.abastecerAte(litrosCombustivel, rota.getData());

            sb.append("abasteceu " + litrosCombustivel + "L de " + tanque.DescricaoCombustivel() + ",\n");
        }

        double totalPercorrido = historicoRota.totalKmVida() + rota.getQuilometragem();

        if (totalPercorrido > tipoVeiculo.getManutencaoPeriodica().getKmProgramada()){
            manutencoesExecutadas.add(new ManutencaoExecutada(tipoVeiculo.getManutencaoPeriodica(), rota.getData()));

            sb.append("executou Manutenção Periódica (" + historicoRota.totalKmVida() + "Km),\n");
        }

        if (totalPercorrido > tipoVeiculo.getManutencaoTrocaPecas().getKmProgramada()){
            manutencoesExecutadas.add(new ManutencaoExecutada(tipoVeiculo.getManutencaoTrocaPecas(), rota.getData()));

            sb.append("executou Manutenção Troca de Peças (" + historicoRota.totalKmVida() + "Km),\n");
        }

        historicoRota.PercorrerRota(rota);
        tanque.Consumir(rota.getQuilometragem());

        sb.append("percorreu rota  (" + rota.getQuilometragem() + "Km)\n}");
        return sb.toString();
    }


    public Optional<Rota> getProximaRota(){
        return historicoRota.getProximaRota();
    }


    public String toString(){
        return "Veículo {"+ getPlaca() + ", " + tipoVeiculo.getDescricao() + ", " + tanque.DescricaoCombustivel() + '}';
    }

    

    public String relatorio(){
        StringBuilder relatorio = new StringBuilder("Veículo {\n");
        relatorio.append(getPlaca() + ", " + tipoVeiculo.getDescricao() + ", " + tanque.DescricaoCombustivel() + "\n");
        
        relatorio.append("Litros de combustível já reabastecidos: " + String.format("%.2f", tanque.getTotalReabastecidoVida())  + "L\n");
        relatorio.append("Quilometragem rodada no mês atual: " + String.format("%.2f", historicoRota.totalKmMes(YearMonth.from(LocalDate.now())))  + "Km\n");
        relatorio.append("Quilometragem rodada no tempo de vida: "+ String.format("%.2f", historicoRota.totalKmVida()) + "Km\n");

        relatorio.append('}');
        
        return relatorio.toString();
    }
}
