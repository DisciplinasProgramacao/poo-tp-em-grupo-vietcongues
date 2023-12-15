package codigo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class Tanque {
    private static final double CONSUMO = 8.2;
    private double capacidadeMaxima;
    private double capacidadeAtual;

    private ArrayList<RegistroAbastecimento> registrosAbastecimentos;
    private ECombustivel combustivel;

    public Tanque() {
        registrosAbastecimentos = new ArrayList<RegistroAbastecimento>();
    }


    public void abastecer(double litros, LocalDate data) 
        throws IllegalArgumentException
    {        
        if (litros > getEspaçoRestanteEmLitros()) {
            throw new IllegalArgumentException("Litros não podem ser menor que zero.");
        }

        double preco = litros * combustivel.getPrecoMedioEmRs();

        registrosAbastecimentos.add(new RegistroAbastecimento(litros, preco, data));
    }


    public double autonomiaMaxima() {
        return this.capacidadeMaxima * CONSUMO;
    }


    public double autonomiaAtual() {
        return this.capacidadeAtual * CONSUMO;
    }


    public double getTanqueAtual() {
        return capacidadeAtual;
    }


    public double getTanqueMax() {
        return capacidadeMaxima;
    }


    public double getEspaçoRestanteEmLitros(){
        return getTanqueMax() - getTanqueAtual();
    }


    public double CustoTotalAbastecimentoMensal(YearMonth month){
        return registrosAbastecimentos.stream()
            .filter(regist -> YearMonth.from(regist.getData()).equals(month))
            .mapToDouble(RegistroAbastecimento::getPreco)
            .sum();
    }


    public String RelatorioAbastecimentoMensal(YearMonth month){
        StringBuilder sb = new StringBuilder();
        
        registrosAbastecimentos.stream()
            .filter(regist -> YearMonth.from(regist.getData()).equals(month))
            .forEach(regist -> sb.append(regist.toString()+ ";\n") );
        
        return "Registros de abastecimento {"+ sb.toString() + "}";
    }
}
