package codigo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota frota = new Frota();
        String placa, placaVeiculo, placaReabastecer;
        double quilometragem, litros;
        LocalDate data;
        Veiculo veiculo, veiculoParaRota, veiculoParaReabastecer;
        Rota rota;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Adicionar Rota");
            System.out.println("3. Reabastecer Veículo");
            System.out.println("4. Relatório da Frota");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    placa = scanner.next();
                    veiculo = new Veiculo(placa);
                    frota.adicionarVeiculo(veiculo);
                    System.out.println("Veículo adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    placaVeiculo = scanner.next();
                    veiculoParaRota = frota.localizarVeiculo(placaVeiculo);
                    if (veiculoParaRota != null) {
                        System.out.print("Digite a quilometragem da rota: ");
                        quilometragem = scanner.nextDouble();
                        System.out.print("Digite a data da rota (formato: dd/MM/yyyy): ");
                        String dataString = scanner.next();
                        data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        rota = new Rota(quilometragem, data);
                        veiculoParaRota.addRota(rota);
                        System.out.println("Rota adicionada ao veículo com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado na frota.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a placa do veículo: ");
                    placaReabastecer = scanner.next();
                    veiculoParaReabastecer = frota.localizarVeiculo(placaReabastecer);
                    if (veiculoParaReabastecer != null) {
                        System.out.print("Digite a quantidade de litros a ser reabastecida: ");
                        litros = scanner.nextDouble();
                        veiculoParaReabastecer.abastecer(litros);
                        System.out.println("Veículo reabastecido com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado na frota.");
                    }
                    break;
                case 4:
                    System.out.println(frota.relatorioFrota());
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }

    }

}
