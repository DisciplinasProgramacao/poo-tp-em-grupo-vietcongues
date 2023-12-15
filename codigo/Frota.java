package codigo;

import java.time.*;
import java.util.*;

public class Frota {
    private int tamanhoFrota;
    private ArrayList<Veiculo> listaVeiculos;


    public Frota() {

        this.listaVeiculos = new ArrayList<>();
    }

    public void limparListaVeiculos(){
        listaVeiculos.clear();
    }


    public String relatorioFrota() {
        StringBuilder relatorio = new StringBuilder("Relatório Frota {\n");

        String placaMaiorTotal = maiorKmTotal().map(Veiculo::getPlaca).orElse("-");
        String placaMaiorMedia = maiorKmMedia().map(Veiculo::getPlaca).orElse("-");
        
        relatorio.append("Total de veículos: " + listaVeiculos.size() +";\n");
        relatorio.append("Veículo com maior Km Total: "+ placaMaiorTotal +";\n");
        relatorio.append("Veículo com maior Km Média: "+ placaMaiorMedia +";\n\n");

        listaVeiculos.stream().forEach(veiculo -> relatorio.append(veiculo.relatorioCurto() + ";\n") );

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
