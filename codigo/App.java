package codigo;

import java.time.*;
import java.util.Optional;
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
            System.out.println("Menu :");
            QuebraLinha();

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
            System.out.println("Menu principal:");
            QuebraLinha();

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
                        FrotaMenu();
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


    static void FrotaMenu(){
        int opcao = -1;

        while (opcao != 0) {
            limparTela();
            System.out.println("Menu Frota:");
            QuebraLinha();

            StringBuilder MenuText = new StringBuilder();
            {
                MenuText.append("\n" + "Selecione uma opção:");
                MenuText.append("\n" + "1 - Ver lista de veículos");
                MenuText.append("\n" + "2 - Criar veículo");
                MenuText.append("\n" + "3 - Menu veículo");
                MenuText.append("\n" + "4 - Relatório frota");
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
                        System.out.println(frota.ListaVeiculosString());
                        QualquerTeclaContinue();
                        break;

                    case 2:
                        CriarVeiculo();
                        QualquerTeclaContinue();
                        break;

                    case 3:
                        VeiculoMenu();
                        break;

                    case 4:
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


    public static void CriarVeiculo(){
        QuebraLinha();
        System.out.println("Novo veículo:");
        
        String placa;
        {
            System.out.println("\nPlaca: ");
            placa = scanner.next();
            System.out.print("");
        }

        EVeiculo tipo;
        {
            System.out.println("\nTipo: ");
            System.out.println("0 - Carro");
            System.out.println("1 - Van");
            System.out.println("2 - Furgão");
            System.out.println("3 - Caminhão");
            System.out.println("Opção: ");

            if (!scanner.hasNextInt()){
                System.out.println("Opção não é número válido");
                return;
            }
            
            int tipoInt = scanner.nextInt();
            if (!Util.isIntInRange(tipoInt, 0, 3))
            {
                System.out.println("Número não equivale à opções");
                return;
            }

            tipo = EVeiculo.fromInt(tipoInt);
        }

        ECombustivel combustivel;
        {
            System.out.println("\nCombustível: ");
            System.out.println("0 - Álcool");
            System.out.println("1 - Gasolina");
            System.out.println("2 - Diesel");
            System.out.println("Opção: ");

            if (!scanner.hasNextInt()){
                System.out.println("Opção não é número válido");
                return;
            }
            
            int combustivelInt = scanner.nextInt();
            if (!Util.isIntInRange(combustivelInt, 0, 2))
            {
                System.out.println("Número não equivale à opções");
                return;
            }

            combustivel = ECombustivel.fromInt(combustivelInt);
        }

        Veiculo v = new Veiculo(placa, tipo, combustivel);
        frota.adicionarVeiculo(v);
        System.out.println("\nNovo " + v.relatorioCurto());
    }


    static void VeiculoMenu(){
        int opcao = -1;

        

        while (opcao != 0) {
            limparTela();
            
            System.out.println("Menu Veículo:");
        
            Veiculo veiculoSelecionado;
            String placa;
            {
                System.out.println("\nPlaca: ");
                placa = scanner.next();
                System.out.print("");

                Optional<Veiculo> veiculoPossivel = frota.localizarVeiculo(placa);

                if (veiculoPossivel.isPresent()) {
                    veiculoSelecionado = veiculoPossivel.get();
                    System.out.println("\nVeículo encontrado: " + veiculoSelecionado.relatorioCurto());
                } else {
                    System.out.println("Nenhum veículo encontrado com a placa " + placa);
                    QualquerTeclaContinue();
                    return;
                }
            }

            QuebraLinha();

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


}