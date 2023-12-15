package codigo;

import java.util.Scanner;

public class App {

    /**
     * "Limpa" a tela
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void Menu(){
    limparTela();
    System.out.println
    (
        "1-" + "\n" +
        "2-" + "\n" +
        "3-" + "\n" +
        "4-" + "\n" +
        "5-" + "\n" +
        "6-" + "\n" +
        "7- Realizar manutenção no Veiculo" + "\n" +
        "8- Calcular despesa total de um veiculo" + "\n" +
        "9- Quilometragem total percorrida por um veiculo" + "\n" +
        "10- Relatório de Rotas" + "\n"+
        "0- Sair" + "\n"

    );
    
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = -1;

        Menu();
        opcao = ler.nextInt();

        while (opcao != 0) {
        Menu();
        System.out.println("Selecione uma opção");
        opcao = ler.nextInt();
        }

        System.out.println("Fim");
        ler.close();
    }
}