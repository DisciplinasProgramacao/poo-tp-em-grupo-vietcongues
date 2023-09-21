package codigo;

public class Tanque {
    private static final double consumo = 8.2;
    protected double capacidadeMaxima;
    protected double capacidadeAtual;

    /*
     * Construtor da classe Tanque
     * Recebe como parametro a capacidade maxima do tanque e a quantidade de litos atualmente no tanque
     */
    public Tanque(double capacidadeMaxima, double capacidadeAtual) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
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



}
