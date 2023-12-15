package codigo;

import java.time.*;
import java.util.*;

public class HistoricoRota {
    List<Rota> RotasAtribuidas = new ArrayList<>();

    // Construtor que inicializa a lista de RotasAtribuidas
    public HistoricoRota() {
        this.RotasAtribuidas = new ArrayList<>();
    }


    //Métodos:

    /*
     * Método para adicionar uma nova rota a lista histórica de rotas
     * Recebe uma rota como parâmetro 
     * Não retorna nada
     */
    public void novaRota(Rota rota) {
        RotasAtribuidas.add(rota);
    }


    /*
     * Método que retorna a quantidade de rotas atribuídas do mês
     * Não recebe parâmetro
     * Retorna um inteiro, quantidade de rotas
     */
    public int TotalRotasMensal(YearMonth mes) {
        return (int)RotasAtribuidas.stream()
                .filter(rota -> rota.getMes().equals(mes))
                .count();
    }


    /*
     * Método que retorna o Total Quilômetros Percorridos Mensal
     * Retorna double com a quantidade de quilômetros
     */
    public double totalKmMes(YearMonth mes) {
        return RotasAtribuidas.stream()
                .filter(rota -> rota.getMes().equals(mes))
                .filter(rota -> rota.getPercorrido())
                .mapToDouble(Rota::getQuilometragem)
                .sum();
    }


    /*
     * Método que retorna o Total Quilometros Percorridos total na vida
     * Retorna double com a quantidade de quilometros percorridos total
     */
    public double totalKmVida() {
        return RotasAtribuidas.stream()
                .filter(rota -> rota.getPercorrido())
                .mapToDouble(Rota::getQuilometragem)
                .sum();
    }

    public double mediaKmVida() {
        return totalKmVida() / RotasAtribuidas.size();
    }


    /* Cria um `StringBuilder` para armazenar o relatório
     * Adiciona o cabeçalho do relatório
     * Adiciona o número de rotas realizadas no mês
     * Adiciona a quilometragem total percorrida no mês
     * Retorna o `StringBuilder` como uma string
     */
    public String relatorioMes(YearMonth mes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Rotas realizadas no mês de " + Util.MesFormatado(mes) + "{\n");
        sb.append("Número de Rotas: " + TotalRotasMensal(mes) + "Km \n");
        sb.append("Quilometragem total percorrida: " + totalKmMes(mes) + "Km }");
        return sb.toString();
    }


    public void add(Rota rota){
        RotasAtribuidas.add(rota);
    }


    public Optional<Rota> getProximaRota(){
        return RotasAtribuidas.stream()
            .filter(rota -> !rota.getPercorrido())
            .max(Comparator.comparing(Rota::getData));
    }
}
