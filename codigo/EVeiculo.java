package codigo;

public enum EVeiculo {
    CARRO( "Carro", 
            new Manutencao("Manutenção periódica", 10_000, 5_000), 
            new Manutencao("Manutenção periódica", 10_000, 5_000)),
    
    VAN("Van", 
            new Manutencao("Manutenção periódica", 10_000, 6_000), 
            new Manutencao("Manutenção periódica", 10_000, 6_000)),

    FURGAO("Furgao", 
            new Manutencao("Manutenção periódica", 10_000, 7_000), 
            new Manutencao("Manutenção periódica", 10_000, 7_000)),

    CAMINHAO("Caminhao", 
            new Manutencao("Manutenção periódica", 20_000, 10_000), 
            new Manutencao("Manutenção periódica", 20_000, 10_000));

    private final String descricao;
    private final Manutencao ManutencaoPeriodica;
    private final Manutencao ManutencaoTrocaPecas;


    // Construtor do enum (deve ser sempre privado ou package-private)
    EVeiculo(String descricao, Manutencao ManutencaoPeriodica, Manutencao ManutencaoTrocaPecas) {
        this.descricao = descricao;
        this.ManutencaoPeriodica = ManutencaoPeriodica;
        this.ManutencaoTrocaPecas = ManutencaoTrocaPecas;
    }


    public String getDescricao() {
        return descricao;
    }

    public Manutencao getManutencaoPeriodica(){
        return ManutencaoPeriodica;
    }

    public Manutencao getManutencaoTrocaPecas(){
        return ManutencaoTrocaPecas;
    }
}