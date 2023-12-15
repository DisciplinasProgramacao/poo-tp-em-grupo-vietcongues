package codigo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Util {
    public static boolean isDoubleInRange(double number, double start, double end, double epsilon) {
        return (number >= start - epsilon) && (number <= end + epsilon);
    }
    
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isBlank();
    }

    public static String dataFormatada(LocalDate data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy, MMM dd");
        String dataFormatada = data.format(formatador);

         return dataFormatada;
    }

    public static String MesFormatado(YearMonth data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy, MMM");
        String dataFormatada = data.format(formatador);

         return dataFormatada;
    }
}