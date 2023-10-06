package codigo;

import java.time.LocalDate;
import java.util.*;

public class Veiculo {
    private static final int MAX_ROTAS = 30;
    private static final double CONSUMO = 8.2;
    private String placa;
    private ArrayList<Rota> rotas;
    private int qtdRotas;
    private double tanqueAtual;
    private double tanqueMax;
    private double totalReabastecido;

    public Veiculo(String Placa) {
        this.placa = Placa;

    }

    public boolean addRota(Rota rota) {
        if (autonomiaAtual() >= rota.getQuilometragem() && validaQtdRota() == true) {
            rotas.add(rota);
            qtdRotas++;
            return true;
        } else {
            return false;

        }
    }

    public double autonomiaMaxima() {
        return this.tanqueMax * CONSUMO;
    }

    public double autonomiaAtual() {
        return this.tanqueAtual * CONSUMO;
    }

    public double abastecer(double litros) {
        if (this.tanqueAtual + litros <= this.tanqueMax) {
            this.tanqueAtual = this.tanqueAtual + litros;
            this.totalReabastecido = this.totalReabastecido + litros;
            return tanqueAtual;
        } else {
            return tanqueAtual;
        }
    }

    public double kmTotalPorMes(int mes) {
        double kmTotal = 0;
        for (Rota rota : rotas) {

            if (rota.getMes() == mes) {
                kmTotal += rota.getQuilometragem();
            }
        }
        return kmTotal;
    }

    public double kmTotal() {
        double kmTotal = 0;
        for (Rota rota : rotas) {
            kmTotal = kmTotal + rota.getQuilometragem();
        }
        return kmTotal();
    }

    public void percorrerRota(Rota rota) {
        for (Rota r : rotas) {
            if (rota == r) {
                this.tanqueAtual = tanqueAtual - (rota.getQuilometragem() / CONSUMO);
            }
        }
    }

    public boolean validaQtdRota() {
        if (this.qtdRotas >= 0 && this.qtdRotas <= MAX_ROTAS) {
            return true;
        } else {
            return false;
        }
    }

    public double kmTotalNoMesAtual() {
        LocalDate dataAtual = LocalDate.now();
        int mesAtual = dataAtual.getMonthValue();
        double kmTotalMesAtual = 0;

        for (Rota rota : rotas) {
            if (rota.getMes() == mesAtual) {
                kmTotalMesAtual += rota.getQuilometragem();
            }
        }

        return kmTotalMesAtual;
    }

    public int getQtdRotas() {
        return qtdRotas;
    }

    public Object getPlaca() {
        return placa;
    }

    public double getTotalReabastecido() {
        return totalReabastecido;
    }

    

}
