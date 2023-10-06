package codigo;

public class Tanque {
    private static final double CONSUMO = 8.2;
    private double tanqueAtual;
    private double tanqueMax;
    private double capacidadeMaxima;
    private double capacidadeAtual;

    public Tanque() {

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
        return this.tanqueMax * CONSUMO;
    }

    public double autonomiaAtual() {
        return this.tanqueAtual * CONSUMO;
    }

    public double getTanqueAtual() {
        return tanqueAtual;
    }

    public double getTanqueMax() {
        return tanqueMax;
    }

}
