package codigo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rota {
    private double quilometragem;
    private LocalDate data;

    public Rota(double quilometragem, LocalDate data) {
        this.quilometragem = quilometragem;
        this.data = data;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public LocalDate getData() {
        return data;
    }

    public int getMes() {
        return data.getMonthValue();
    }

    public String relatorio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        return "Rota realizada em " + dataFormatada + " com quilometragem de " + quilometragem + " km.";
    }

    @Override
    public String toString() {
        return "Rota [quilometragem=" + quilometragem + ", data=" + data + "]";
    }
}
