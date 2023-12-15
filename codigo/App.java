package codigo;

import java.time.*;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static Frota frota;
    public static Scanner scanner;

    static Random random;

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


    public static void QualquerTeclaContinue(){
        QuebraLinha();
        System.out.println("Tecle qualquer dígito para continuar");
        scanner.hasNextByte();
        scanner.next();
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        frota = new Frota();

        MainMenu();

        QuebraLinha();
        System.out.println("Fim");
        QuebraLinha();
        scanner.close();
    }

    /*
    static void BaseMenuLoop(){
        int opcao = -1;

        while (opcao != 0) {
            limparTela();

            StringBuilder MenuText = new StringBuilder();
            {
                MenuText.append("\n" + "Selecione uma opção:");
                MenuText.append("\n" + "1 - ");
                MenuText.append("\n" + "2 - ");
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

                    case 2:
                        
                        break;

                    case 0:
                        return;
                
                    default: // -1 ou número fora dos casos;
                        break;
                }
            }
        }
    }
    */


    static void MainMenu(){
        int opcao = -1;

        while (opcao != 0) {
            limparTela();

            StringBuilder MenuText = new StringBuilder();
            {
                MenuText.append("\n" + "Selecione uma opção:");
                MenuText.append("\n" + "1 - Carregar dados teste");
                MenuText.append("\n" + "2 - Continuar sem dados teste");
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
                        DadosTeste();
                        break;

                    case 2:
                        FrotaMenuLoop();
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
        frota.limparListaVeiculos();

        int days = 30;

        for (int i = 1; i <= 20; i++) {
            EVeiculo tipoVeiculo = EVeiculo.fromInt(random.nextInt(4));
            ECombustivel tipCombustivel = ECombustivel.fromInt(random.nextInt(3));

            Veiculo veiculo = new Veiculo("ABC0D" + String.format("%02d", i), tipoVeiculo, tipCombustivel);

            int daylimit = random.nextInt(5 , 15);

            for (int j = 1; j <= days; j++){
                Rota rota = new Rota(random.nextInt((int)Math.floor(veiculo.autonomiaMaxima())), LocalDate.now().minusDays(days-j));
                
                veiculo.addRota(rota);

                if (j < daylimit) veiculo.percorrerRota(rota);
            }

            frota.adicionarVeiculo(veiculo);
        }
        
        System.out.println("Dados Testes carregados.");
        QualquerTeclaContinue();
    }


    static void FrotaMenuLoop(){
        int opcao = -1;

        while (opcao != 0) {
            limparTela();

            StringBuilder MenuText = new StringBuilder();
            {
                MenuText.append("\n" + "Selecione uma opção:");
                MenuText.append("\n" + "1 - Ver lista de veículos");
                MenuText.append("\n" + "2 - Criar veículo");
                MenuText.append("\n" + "3 - Veículo com maior Km total em vida útil");
                MenuText.append("\n" + "4 - Veículo com maior Km média em vida útil");
                MenuText.append("\n" + "5 - Relatório frota");
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

                    case 2:
                        
                        break;

                    case 3:
                        
                        break;

                    case 4:
                        
                        break;

                    case 5:
                        System.out.println(frota.relatorioFrota());
                        QualquerTeclaContinue();
                        break;

                    case 0:
                        return;
                
                    default: // -1 ou número fora dos casos;
                        break;
                }
            }
        }
    }

}