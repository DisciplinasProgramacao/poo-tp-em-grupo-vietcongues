package codigo;

import java.util.*;

public class Frota {
    private int tamanhoFrota;
    HashMap<String, Veiculo> mapaPlacaVeiculo = new HashMap<>();

    /*
     * Construtor da classe Frota
     * Recebe como parametro o tamanho da frota e uma lista de veiculos da frota
     */
    public Frota(int tamanhoFrota, HashMap<String, Veiculo> mapaPlacaVeiculo) {
        this.tamanhoFrota = tamanhoFrota;
        this.mapaPlacaVeiculo = mapaPlacaVeiculo;
    }

    /*
     * 
     */
    public String relatorioFrota() {
        StringBuilder relatorio = new StringBuilder();

        for (Map.Entry<String, Veiculo> entry : mapaPlacaVeiculo.entrySet()) {
            String placa = entry.getKey();
            Veiculo veiculo = entry.getValue();

            relatorio.append("Placa: ").append(placa).append("\n");
            relatorio.append("Autonomia Máxima: ").append(veiculo.autonomiaMaxima()).append(" km\n");
            relatorio.append("Autonomia Atual: ").append(veiculo.autonomiaAtual()).append(" km\n");
            relatorio.append("Kilometragem Total: ").append(veiculo.kmTotal()).append(" km\n");
            relatorio.append("Kilometragem Média: ").append(veiculo.kmTotal() / veiculo.getQtdRotas())
                    .append(" km/rota\n");
            relatorio.append("\n");
        }

        return relatorio.toString();
    }

    /*
     * 
     */
    public Veiculo localizarVeiculo(String placa) {
        if (mapaPlacaVeiculo.containsKey(placa)) {
            return mapaPlacaVeiculo.get(placa);
        } else {
            return null;
        }
    }

    /*
     * 
     */
    public double quilometragemTotal() {
        double quilometragemTotal = 0;

        for (Veiculo veiculo : mapaPlacaVeiculo.values()) {
            quilometragemTotal += veiculo.kmTotal();
        }

        return quilometragemTotal;
    }

    /*
    * 
    */
    public Veiculo maiorKmTotal() {
        Veiculo veiculoMaiorKm = null;
        double maiorKm = 0;

        for (Veiculo veiculo : mapaPlacaVeiculo.values()) {
            if (veiculo.kmTotal() > maiorKm) {
                maiorKm = veiculo.kmTotal();
                veiculoMaiorKm = veiculo;
            }
        }

        return veiculoMaiorKm;
    }

    /*
     * 
     */
    public Veiculo maiorKmMedia() {
        Veiculo veiculoMaiorKmMedia = null;
        double maiorKmMedia = 0;

        for (Veiculo veiculo : mapaPlacaVeiculo.values()) {
            double kmMedia = veiculo.kmTotal() / veiculo.getQtdRotas();
            if (kmMedia > maiorKmMedia) {
                maiorKmMedia = kmMedia;
                veiculoMaiorKmMedia = veiculo;
            }
        }

        return veiculoMaiorKmMedia;
    }

}
