package codigo;

public class Tanque {
    private static final double consumo = 8.2;
    private double capacidadeMaxima;
    private double capacidadeAtual;

    /*
     * Construtor da classe Tanque
     * Recebe como parametro a capacidade maxima do tanque e a quantidade de litos
     * atualmente no tanque
     */
    public Tanque(double capacidadeMaxima, double capacidadeAtual) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
    }


   /*
 * Método para abastecer o veículo.
 * Recebe como parâmetro a quantidade de litros a serem abastecidos.
 * Retorna a capacidade atual do tanque após o abastecimento.
 */
public double abastecer(double litros) {
    double espacoRestante = this.capacidadeMaxima - this.capacidadeAtual; // Calcula o espaço restante no tanque.

    if (litros <= espacoRestante) { // Verifica se a quantidade de litros cabe no espaço restante no tanque.
        this.capacidadeAtual += litros; // Adiciona os litros ao tanque.
        return this.capacidadeAtual; // Retorna a capacidade atual do tanque após o abastecimento.
    } else {
        this.capacidadeAtual = this.capacidadeMaxima; // Enche completamente o tanque.
        return this.capacidadeAtual; // Retorna a capacidade atual do tanque após o abastecimento.
    }
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

}
