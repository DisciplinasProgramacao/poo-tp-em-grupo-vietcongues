package codigo;

import java.time.LocalDate;
import java.util.*;

public class Veiculo {
    private static final int MAX_ROTAS = 30;
    private static final double CONSUMO = 8.2;
    private String placa;
    private ArrayList<Rota> rotas;
    private int qtdRotas;
    private double totalReabastecido;
    Tanque tanque;

    public Veiculo(String Placa) {
        this.placa = Placa;
        this.rotas = new ArrayList<>();
        this.tanque = new Tanque();

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
        return tanque.autonomiaMaxima();
    }

    public double autonomiaAtual() {
        return tanque.autonomiaAtual();
    }

    public double abastecer(double litros) {

        return tanque.abastecer(litros);
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
        double combustivelConsumido = rota.getQuilometragem() / CONSUMO;

        // Verifica se há combustível suficiente no tanque para percorrer a rota
        if (combustivelConsumido <= tanque.autonomiaAtual()) {
            // Reduz o tanque atual em função do combustível consumido durante a rota
            tanque.abastecer(-combustivelConsumido);
            System.out.println(
                    "Rota percorrida com sucesso. Combustível consumido: " + combustivelConsumido + " litros.");
        } else {
            System.out.println("Não há combustível suficiente para percorrer a rota.");
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
