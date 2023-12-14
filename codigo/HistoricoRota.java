import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    public int TotalRotasPorMes(int mes) {

        return RotasAtribuidas.stream()
        .filter(rota -> rota.getData().getMonthValue() == mes)
        .count();
    }

    /*
     * Método que retorna o Total Quilômetros Percorridos Mensal
     * Retorna Float com a quantidade de quilômetros
     */
    public float TotalQuilometragemPercorridaMensal(LocalDate data) {
        return RotasAtribuidas.stream()
                .filter(rota -> rota.getData().isAfter(data) || rota.getData().isEqual(data))
                .mapToFloat(Rota::getQuilometragem)
                .sum();
    }

    /*
     * Método que retorna o Total Quilometros Percorridos
     * Retorna Float com a quantidade de quilometros percorridos total
     */
    public float TotalQuilometragemPercorrido() {
        return RotasAtribuidas.stream()
                .mapToFloat(Rota::getQuilometragem)
                .sum();
    }

    /*
     * Método que imprime todas as rotas a partir de uma data
     * Imprime todas as rotas do períodos
     */
    public void imprimirRotasAPartirDaData(LocalDate data) {
        RotasAtribuidas.stream()
                .filter(rota -> rota.getData().isAfter(data) || rota.getData().isEqual(data))
                .forEach(System.out::println);
    }
}
