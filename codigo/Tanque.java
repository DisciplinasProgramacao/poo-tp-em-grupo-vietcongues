package codigo;

public class Tanque {
    protected double consumo;
    protected double capacidadeMaxima;
    protected double capacidadeAtual;

    // Construtor da classe Tanque:
    public Tanque(double consumo, double capacidadeMaxima, double capacidadeAtual) {
        this.consumo = consumo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
    }
}
