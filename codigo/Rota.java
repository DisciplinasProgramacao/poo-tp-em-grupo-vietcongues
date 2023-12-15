package codigo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Rota {
    private double quilometragem;
    private LocalDate data;
    private Boolean percorrido;

    
    public Rota(double quilometragem, LocalDate data) {
        this.quilometragem = quilometragem;
        this.data = data;
        percorrido = false;
    }


    public double getQuilometragem() {
        return quilometragem;
    }


    public LocalDate getData() {
        return data;
    }


    public YearMonth getMes() {
        return YearMonth.from(data);
    }


    public void Percorrer(){
        percorrido = true;
    }


    @Override
    public String toString() {
        return "Rota {percorrer " + quilometragem + "Km, em " + data + ", " + (percorrido ? "Percorrido" : "Não percorrido") + '}';
    }
}
