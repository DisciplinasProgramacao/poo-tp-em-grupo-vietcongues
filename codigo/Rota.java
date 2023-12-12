package codigo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rota {
    private double quilometragem;
    private LocalDate data;

    /**
     * Constutor de Rota a partir da extensão coberta pela rota e a data em que ela será feita.
     * @param quilometragem
     * @param data
     */
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

    //TODO: relatório() e toString() possuem a exata mesma responsabilidade. Decidir qual formato permanecerá
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
