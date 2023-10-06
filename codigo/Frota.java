package codigo;

import java.util.ArrayList;

public class Frota {
    private int tamanhoFrota;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota() {

        this.listaVeiculos = new ArrayList<>();
    }

    public String relatorioFrota() {
        StringBuilder relatorio = new StringBuilder();

        for (Veiculo veiculo : listaVeiculos) {
            relatorio.append("\n Carro Placa: ").append(veiculo.getPlaca()).append("\n");
            relatorio.append("Litros Reabastecidos: ").append(veiculo.getTotalReabastecido()).append(" litros\n");
            relatorio.append("Quilometragem do Mês Atual: ").append(veiculo.kmTotalNoMesAtual()).append(" km\n");
            relatorio.append("Kilometragem Total: ").append(veiculo.kmTotal()).append(" km\n");

            relatorio.append("\n");
        }

        return relatorio.toString();
    }

    public Veiculo localizarVeiculo(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public double quilometragemTotal() {
        double quilometragemTotal = 0;

        for (Veiculo veiculo : listaVeiculos) {
            quilometragemTotal += veiculo.kmTotal();
        }

        return quilometragemTotal;
    }

    public Veiculo maiorKmTotal() {
        Veiculo veiculoMaiorKm = null;
        double maiorKm = 0;

        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.kmTotal() > maiorKm) {
                maiorKm = veiculo.kmTotal();
                veiculoMaiorKm = veiculo;
            }
        }

        return veiculoMaiorKm;
    }

    public Veiculo maiorKmMedia() {
        Veiculo veiculoMaiorKmMedia = null;
        double maiorKmMedia = 0;

        for (Veiculo veiculo : listaVeiculos) {
            double kmMedia = veiculo.kmTotal() / veiculo.getQtdRotas();
            if (kmMedia > maiorKmMedia) {
                maiorKmMedia = kmMedia;
                veiculoMaiorKmMedia = veiculo;
            }
        }

        return veiculoMaiorKmMedia;
    }

    public int getTamanhoFrota() {
        tamanhoFrota = listaVeiculos.size();
        return tamanhoFrota;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }
}
