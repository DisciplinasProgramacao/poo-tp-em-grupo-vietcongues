package codigo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class Tanque {
    private double capacidadeMaxima;
    private double capacidadeAtual;

    private ArrayList<RegistroAbastecimento> registrosAbastecimentos;
    private ECombustivel combustivel;


    public Tanque(ECombustivel combustivel, double capacidadeMaxima) {
        registrosAbastecimentos = new ArrayList<RegistroAbastecimento>();
        this.combustivel = combustivel;

        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = 0;
    }


    private double getEspaçoRestanteEmLitros(){
        return capacidadeMaxima - capacidadeAtual;
    }
    

    public void abastecer(double litros, LocalDate data) 
        throws IllegalArgumentException
    {        
        if (Util.isDoubleInRange(litros, 0, getEspaçoRestanteEmLitros(), 0.01)) {
            throw new IllegalArgumentException("Litros deve estar entre 0 e " + getEspaçoRestanteEmLitros());
        }

        double preco = litros * combustivel.getPrecoMedioEmRs();

        registrosAbastecimentos.add(new RegistroAbastecimento(litros, preco, data));
    }


    public double autonomiaMaxima() {
        return capacidadeMaxima * ConsumoKmL();
    }



    public double autonomiaAtual() {
        return capacidadeAtual * ConsumoKmL();
    }


    public void Consumir(double quilometragem){
        capacidadeAtual -= quilometragem / ConsumoKmL();
    }


    public double CustoTotalAbastecimentoMensal(YearMonth month){
        return registrosAbastecimentos.stream()
            .filter(regist -> YearMonth.from(regist.getData()).equals(month))
            .mapToDouble(RegistroAbastecimento::getPreco)
            .sum();
    }

    
    public double ConsumoKmL(){
        return combustivel.getConsumoMedioEmKmL();
    }


    public String RelatorioAbastecimentoMensal(YearMonth month){
        StringBuilder sb = new StringBuilder();
        
        registrosAbastecimentos.stream()
            .filter(regist -> YearMonth.from(regist.getData()).equals(month))
            .forEach(regist -> sb.append(regist.toString()+ ";\n") );
        
        return "Registros de abastecimento {"+ sb.toString() + "}";
    }


    public double getTotalReabastecidoVida(){
        return registrosAbastecimentos.stream()
                .mapToDouble(RegistroAbastecimento::getLitros)
                .sum();
    }

    
    public String DescricaoCombustivel(){
        return combustivel.getDescricao();
    }
}
