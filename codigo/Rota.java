package codigo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Rota {
    private double quilometragem;
    private Date data;

    /*
     * Construtor da classe Rota
     * Recebe como parametro a quilometragem da rota e a data da rota
     */
    public Rota(double quilometragem, Date data) {
        this.quilometragem = quilometragem;
        this.data = data;
    }

    /*
     * 
     */
    public static int getMonthFromDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        String month = dateFormat.format(date);
        return Integer.parseInt(month);
    }

    //Gets
    public double getQuilometragem() {
        return quilometragem;
    }

    public Date getData() {
        return data;
    }

    public int getMes(){
        return getMonthFromDate(data);
    }

    /*
     * 
     */
    public String relatorio(){
        return "";
    }
}
