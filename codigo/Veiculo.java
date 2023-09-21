package codigo;

import java.util.List;

public class Veiculo {
    private static final int maxRotas = 30;
    private static final double consumo = 8.2;
    protected String placa;
    private List<Rota> rotas;
    protected int qtdRotas;
    protected double tanqueAtual;
    protected double tanqueMax;
    protected double totalReabastecido;

    
    /*
     * Construtor da classe Veiculo
     * Recebe como parametro a placa do veiculo, a quantidade de litos atualmente no tanque e a capacidade máxima do tanque
     */
    public Veiculo(String Placa, double Tanque_Atual, double Tanque_Max) {
        this.placa = Placa;
        this.tanqueAtual = Tanque_Atual;
        this.tanqueMax = Tanque_Max;
    }

    /*
     * 
     */
    public boolean addRota(Rota rota){
        return true;
    }

    /*
     * 
     */
    public double autonomiaMaxima(){
        return 0;
    }

    /*
     * 
     */
    public double autonomiaAtual(){
        return 0;
    }

    /*
     * 
     */
    public double abastecer( double litros){
        return 0;
    }

    /*
     * 
     */
    public double kmNoMes(){
        return 0;
    }

    /*
     * 
     */
    public double kmTotal(){
        return 0;
    }

    /*
     * 
     */
    public void percorrerRota( Rota rota){
        
    }
}
