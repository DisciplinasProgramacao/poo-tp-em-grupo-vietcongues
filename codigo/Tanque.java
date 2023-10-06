package codigo;

public class Tanque {
    private static final double CONSUMO = 8.2;
    private double capacidadeMaxima;
    private double capacidadeAtual;

    public Tanque(double capacidadeMaxima, double capacidadeAtual) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
    }

    public double abastecer(double litros) {
        double espacoRestante = this.capacidadeMaxima - this.capacidadeAtual;
        if (litros <= espacoRestante) {
            this.capacidadeAtual += litros;
            return this.capacidadeAtual;
        } else {
            this.capacidadeAtual = this.capacidadeMaxima;
            return this.capacidadeAtual;
        }
    }

    public double autonomiaMaxima() {
        return this.capacidadeMaxima * CONSUMO;
    }

    public double autonomiaAtual() {
        return this.capacidadeAtual * CONSUMO;
    }

}
