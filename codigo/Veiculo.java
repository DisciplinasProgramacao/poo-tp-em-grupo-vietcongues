package codigo;

import java.util.*;

public class Veiculo {
    private static final int maxRotas = 30;
    private static final double consumo = 8.2;
    private String placa;
    private List<Rota> rotas;
    private int qtdRotas;
    private double tanqueAtual;
    private double tanqueMax;
    private double totalReabastecido;

    /*
     * Construtor da classe Veiculo
     * Recebe como parametro a placa do veiculo, a quantidade de litos atualmente no
     * tanque e a capacidade máxima do tanque
     */
    public Veiculo(String Placa, double Tanque_Atual, double Tanque_Max) {
        this.placa = Placa;
        this.tanqueAtual = Tanque_Atual;
        this.tanqueMax = Tanque_Max;
    }

    /*
     * Método que valida se a quantidade de rotas cadastradas para o veiculo é maior que 0 e menor que 30
     * Não possui paramentros
     * Retorna "true" ou "false"
     */
    public boolean validaQtdRota() {
        if (this.qtdRotas >= 0 && this.qtdRotas <= 30) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Metodo para atribuir uma rota para um veiculo
     * Recebe uma rota como parametros
     * Verifica se a autonomia atual é suficiente pra execultar a rota e verifica se o veiculo não atingiu o limite máximo de rotas
     * Retorna "true" ou "false"
     */
    public boolean addRota(Rota rota) {
        if(autonomiaAtual() >= rota.getQuilometragem() && validaQtdRota() == true){
            rotas.add(rota);
            qtdRotas ++;
            return true;
        }
        else{
            return false;

        }
    }

    /*
     * Método que calcula a autonomia máxima do veiculo
     * Não possui paramentros
     * Retorna um número do tipo double
     */
    public double autonomiaMaxima() {
        return this.tanqueMax * consumo;
    }

    /*
     * Metodo para calcular a autonomia atual do veiculo
     * Não possui paramentros
     * Retorna um número do tipo double
     */
    public double autonomiaAtual() {
        return this.tanqueAtual * consumo;
    }

    /*
     * Metodo para abastecer o veiculo
     * Recebe como parametro a quantidade de litros do abastecimento
     * Retorna o tanque atual: Se a quantidade de litros couber no tanque, altera a quantidade, se não retorna a mesma quantidade anterior
     */
    public double abastecer(double litros) {
        if(this.tanqueAtual + litros <= this.tanqueMax){
            this.tanqueAtual = this.tanqueAtual + litros;
            this.totalReabastecido = this.totalReabastecido + litros;
            return tanqueAtual;
        }
        else{
            return tanqueAtual;
        }
    }

    /*
     * Metodo para calcular a quantidade total de km no mês
     * Recebe como parametro o numero do mês
     * Retorna a quantidade de km do mês
     */
    public double kmTotalPorMes(int mes) {
        double kmTotal = 0;
        for (Rota rota : rotas) {
            // Verifique se a rota ocorreu no mês especificado
            if (rota.getMes() == mes) {
                kmTotal += rota.getQuilometragem();
            }
        }
        return kmTotal;
    }

    /*
     * Metodo para calcular a quantidade total de km
     * Não recebe paramentros
     * Retorna a quantidade de km total
     */
    public double kmTotal() {
        double kmTotal = 0 ;
        for (Rota rota : rotas) {
            kmTotal = kmTotal + rota.getQuilometragem();
        }
        return kmTotal();
    }

    /*
     * Metodo para percorrer a rota
     * Recebe a rota como parametro
     * Diminui a quantidade de litros do tanque conforme a distancia percorrida
     */
    public void percorrerRota(Rota rota) {
        for (Rota r : rotas) {
            if( rota == r)
            {
                this.tanqueAtual = tanqueAtual-(rota.getQuilometragem()/consumo);
            }
        }
    }
}
