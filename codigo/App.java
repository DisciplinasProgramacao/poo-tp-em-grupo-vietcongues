package codigo;

import java.time.*;
import java.util.Scanner;

public class App {

    public static Frota frota;
    public static Scanner scanner;

    /**
     * "Limpa" a tela
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void QuebraLinha(){
        System.out.println("______________________");
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        MainMenu();

        QuebraLinha();
        System.out.println("Fim");
        QuebraLinha();
        scanner.close();
    }

    
    static void BaseMenuLoop(){
        int opcao = -1;

        while (opcao != 0) {
            limparTela();

            StringBuilder MenuText = new StringBuilder();
            {
                MenuText.append("\n" + "Selecione uma opção");
                MenuText.append("\n" + " - ");
                MenuText.append("\n" + "0 - Voltar");
            }            
            System.out.println(MenuText.append("\n").toString());
            
            // Casos
            {
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                }

                switch (opcao) {
                    case 1:
                        
                        break;

                    case 0:                        
                        return;
                
                    default: // -1 ou número fora dos casos;
                        break;
                }
            }
        }
    }


    static void MainMenu(){
        int opcao = -1;

        while (opcao != 0) {
            limparTela();

            StringBuilder MenuText = new StringBuilder();
            {
                MenuText.append("\n" + "Selecione uma opção:");
                MenuText.append("\n" + "1 - Carregar dados teste");
                
                MenuText.append("\n" + "0 - Voltar");
            }
            
            System.out.println(MenuText.append("\n\n" + "Opção:").toString());

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            }

            // Casos
            {
                switch (opcao) {
                    case 1:
                        
                        break;

                    case 0:
                        return;
                
                    default: // -1 ou número fora dos casos;
                        break;
                }
            }
        }
    }


    static void DadosTeste(){
        
    }
}