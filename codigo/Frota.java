package codigo;

import java.time.*;
import java.util.*;

public class Frota {
    private int tamanhoFrota;
    private ArrayList<Veiculo> listaVeiculos;


    public Frota() {

        this.listaVeiculos = new ArrayList<>();
    }


    public String relatorioFrota() {
        StringBuilder relatorio = new StringBuilder("Relatório Frota {\n");

        listaVeiculos.stream().forEach(veiculo -> relatorio.append(veiculo.relatorio()+ ";\n") );

        relatorio.append("} // fim Relatório Frota ");        
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


    public Optional<Veiculo> maiorKmTotal() {
        return listaVeiculos.stream()
                .max(Comparator.comparing(Veiculo::kmTotal));
    }


    public Optional<Veiculo> maiorKmMedia() {
        return listaVeiculos.stream()
                .max(Comparator.comparing(Veiculo::KmMedia));
    }


    public int getTamanhoFrota() {
        tamanhoFrota = listaVeiculos.size();
        return tamanhoFrota;
    }


    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }
}
