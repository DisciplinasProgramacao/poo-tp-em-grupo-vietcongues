package codigo;

public class Manutencao {
    
    private String nome;
    private float quilometragemProgamada;
    private float custo;


    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isBlank();
    }


    public String getNome(){
        return this.nome;
    }


    public float getKmProgramada(){
        return this.quilometragemProgamada;
    }


    public float getCusto(){
        return this.custo;
    }


    public Manutencao(String nome, float quilometragem, float custo)
        throws IllegalArgumentException
    {
        
        if (isNullOrEmpty(nome)){
            throw new IllegalArgumentException("A string não pode ser nula ou vazia.");
        }

        
        if (quilometragem < 0){
            throw new IllegalArgumentException("Quilometragem não pode ser negativa.");
        }
        
        
        if (custo < 0){
            throw new IllegalArgumentException("Custo não pode ser negativo.");
        }
        
        this.nome = nome;
        this.quilometragemProgamada = quilometragem;
        this.custo = custo;
    }


    public static Manutencao newInstance(Manutencao outra) {
        return new Manutencao(outra.getNome(), outra.getKmProgramada(), outra.getCusto());
    }
    

    @Override
    public String toString() {
        return "Manutencao { " + nome + "; Progamada até " + quilometragemProgamada + "km; Custo " + String.format("%.2f", custo)+".}";
    }
}