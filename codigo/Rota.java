package codigo;

import java.sql.Date;

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
    public String relatorio(){
        return "";
    }
}
