package codigo;

public enum ECombustivel {
    ALCOOL("Álcool", 7, 3.29),
    GASOLINA("Gasolina", 10, 5.19),
    DIESEL("Diesel", 4, 6.09);

    private final String descricao;
    private final float consumoMedio; // Km por L.
    private final double precoMedio; // Por L.


    // Construtor do enum (deve ser sempre privado ou package-private)
    ECombustivel(String descricao, float consumoMedio, double precoMedio) {
        this.descricao = descricao;
        this.consumoMedio = consumoMedio;
        this.precoMedio = precoMedio;
    }


    public String getDescricao() {
        return descricao;
    }

    public float getConsumoMedioEmKmL(){
        return consumoMedio;
    }

    public double getPrecoMedioEmRs(){
        return precoMedio;
    }
    
    public static ECombustivel fromInt(int valor){
        ECombustivel combustivel;
        switch (valor) {
            case 1: combustivel = ECombustivel.GASOLINA; break;
            case 2: combustivel = ECombustivel.DIESEL; break;
            default: combustivel = ECombustivel.ALCOOL; break;
        }
        return combustivel;
    }
}