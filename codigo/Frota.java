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
    public String relatorioFrota(){
        return "";
    }

    /*
     * 
     */
    public Veiculo localizarVeiculo(String placa){
    }

    /*
     * 
     */
    public double quilometragemTotal(){
        return 0;
    }

     /*
     * 
     */
    public Veiculo maiorKmTotal(){
        return Veiculo;
    }

    /*
     * 
     */
    public Veiculo maiorKmMedia(){
        return Veiculo;
    }



}
    