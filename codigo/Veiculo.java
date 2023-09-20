package codigo;

import java.util.List;

public class Veiculo {
    protected int maxRotas;
    protected double consumo;
    protected String placa;
    private List<Rota> rotas;
    protected int qtdRotas;
    protected double tanqueAtual;
    protected double tanqueMax;
    protected double totalReabastecido;

    // Construtor da classe Veiculo:
    public Veiculo(int Max_Rotas, double Consumo, String Placa, int Qtd_Rotas,
                   double Tanque_Atual, double Tanque_Max, double Total_Reabastecido) {
        this.maxRotas = Max_Rotas;
        this.consumo = Consumo;
        this.placa = Placa;
        this.qtdRotas = Qtd_Rotas;
        this.tanqueAtual = Tanque_Atual;
        this.tanqueMax = Tanque_Max;
        this.totalReabastecido = Total_Reabastecido;
    }
}
