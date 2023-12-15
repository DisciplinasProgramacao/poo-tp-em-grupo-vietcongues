package codigo;

public enum EVeiculo {
    CARRO( "Carro", 
            50,
            new Manutencao("Manutenção periódica", 10_000, 5_000), 
            new Manutencao("Manutenção periódica", 10_000, 5_000)),
    
    VAN("Van", 
            60,
            new Manutencao("Manutenção periódica", 10_000, 6_000), 
            new Manutencao("Manutenção periódica", 10_000, 6_000)),

    FURGAO("Furgao", 
            80,
            new Manutencao("Manutenção periódica", 10_000, 7_000), 
            new Manutencao("Manutenção periódica", 10_000, 7_000)),

    CAMINHAO("Caminhao", 
            250,
            new Manutencao("Manutenção periódica", 20_000, 10_000), 
            new Manutencao("Manutenção periódica", 20_000, 10_000));

    private final String descricao;
    private final double capacidadeMaximaTanque;
    private final Manutencao ManutencaoPeriodica;
    private final Manutencao ManutencaoTrocaPecas;


    // Construtor do enum (deve ser sempre privado ou package-private)
    EVeiculo(String descricao, double capacidadeMaximaTanque, Manutencao ManutencaoPeriodica, Manutencao ManutencaoTrocaPecas) {
        this.descricao = descricao;
        this.capacidadeMaximaTanque = capacidadeMaximaTanque;
        this.ManutencaoPeriodica = ManutencaoPeriodica;
        this.ManutencaoTrocaPecas = ManutencaoTrocaPecas;
    }


    public String getDescricao() {
        return descricao;
    }

    public double getcapacidadeMaximaTanque(){
        return capacidadeMaximaTanque;
    }

    public Manutencao getManutencaoPeriodica(){
        return ManutencaoPeriodica;
    }

    public Manutencao getManutencaoTrocaPecas(){
        return ManutencaoTrocaPecas;
    }


    public static EVeiculo fromInt(int tipoVeiculo){
            EVeiculo veiculo;
            switch (tipoVeiculo) {
                case 1: veiculo = EVeiculo.VAN; break;
                case 2: veiculo = EVeiculo.FURGAO; break;
                case 3: veiculo = EVeiculo.CAMINHAO; break;
                default: veiculo = EVeiculo.CARRO; break;
            }
            return veiculo;
    }
}