package codigo;

import java.time.*;
import java.time.format.*;

public class ManutencaoExecutada {
    private Manutencao manutencao;
    private LocalDate data;


    private void Init(Manutencao manutencao, LocalDate data){
        this.manutencao = Manutencao.newInstance(manutencao);
        this.data = data;
    }


    public ManutencaoExecutada(Manutencao manutencao, LocalDate data){
        Init(manutencao, data); 
    }


    public ManutencaoExecutada(Manutencao manutencao, LocalDateTime dataHora){
        Init(manutencao, dataHora.toLocalDate());
    }


    public Manutencao getManutencao(){
        return this.manutencao;
    }


    public LocalDate getData(){
        return this.data;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy, MMM dd");
        String dataFormatada = data.format(formatador);

        return "Manutencao  executada { Data: " + dataFormatada + "; " + manutencao.toString() + "}";
    }
    
}