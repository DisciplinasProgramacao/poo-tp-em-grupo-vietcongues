package codigo;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class RegistroAbastecimento {
    private double litros;
    private double preco;
    private LocalDate data;


    public double getLitros() {
        return litros;
    }


    public LocalDate getData() {
        return data;
    }


    public double getPreco()
    {
        return preco;
    }

    
    RegistroAbastecimento(double litros, double preco, LocalDate data)
        throws IllegalArgumentException
    {
        if (litros < 0){
            throw new IllegalArgumentException("Litros não podem ser menor que zero.");
        }

        this.litros = litros;
        this.data = data;
    }

    
    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy, MMM dd");
        String dataFormatada = data.format(formatador);

        return "Registro Abastecimento { " + litros + "L; R$ " + String.format("%.2f", preco) + "; " + dataFormatada + ".}";
    }
}
