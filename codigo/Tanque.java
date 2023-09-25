package codigo;

public class Tanque {
    private static final double consumo = 8.2;
    private double capacidadeMaxima;
    private double capacidadeAtual;
    private double totalReabastecido;

    /*
     * Construtor da classe Tanque
     * Recebe como parametro a capacidade maxima do tanque e a quantidade de litos atualmente no tanque
     */
    public Tanque(double capacidadeMaxima, double capacidadeAtual) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
    }

    /*
     * Método que calcula a autonomia máxima do veiculo
     * Não possui paramentros
     * Retorna um número do tipo double
     */
    public double autonomiaMaxima() {
        return this.capacidadeMaxima * consumo;
    }

    /*
     * Metodo para calcular a autonomia atual do veiculo
     * Não possui paramentros
     * Retorna um número do tipo double
     */
    public double autonomiaAtual() {
        return this.capacidadeAtual * consumo;
    }

    /*
     * Metodo para abastecer o veiculo
     * Recebe como parametro a quantidade de litros do abastecimento
     * Retorna o tanque atual: Se a quantidade de litros couber no tanque, altera a quantidade, se não retorna a mesma quantidade anterior
     */
    public double abastecer(double litros) {
        if(this.capacidadeAtual + litros <= this.capacidadeMaxima){
            this.capacidadeAtual = this.capacidadeAtual + litros;
            this.totalReabastecido = this.totalReabastecido + litros;
            return capacidadeAtual;
        }
        else{
            return capacidadeAtual;
        }
    }
    
}
