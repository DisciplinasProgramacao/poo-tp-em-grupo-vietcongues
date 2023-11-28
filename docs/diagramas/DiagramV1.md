# Diagramas de classe 2
23/11


##	Premissa

Uma empresa de logística está procurando automatizar todos os seus processos e, neste sentido, uma das tarefas mais importantes é automatizar o controle de frota de seus veículos. Um veículo da empresa é identificado por sua placa. Como simplificação, a empresa considera que o consumo é igual para todos os veículos: 8,2 km/litro.

Cada veículo realiza até 30 rotas por mês e, no início do mês seguinte, estas rotas podem ser descartadas. Cada rota tem uma data definida e uma quilometragem a ser percorrida. Uma rota só pode ser atribuída a um veículo se ele tiver autonomia de combustível para realizá-la, seja com o combustível atual, seja completando o tanque com um reabastecimento antes de sair para a rota.
A empresa precisa saber, ainda:
• Quantos litros de combustível já foram reabastecidos em cada veículo;
• Quilometragem rodada de um veículo no mês atual;
• Quilometragem total rodada pelo veículo, considerando que eles são adquiridos com 0km.

A gerência da empresa precisa:
a) Examinar relatórios de rotas de cada veículo.
b) Saber a quilometragem total percorrida por um veículo.


## Requisitos

- Um veículo da empresa é identificado por sua placa.
- Cada veículo tem um tanque de combustível.
- Capacidade do tanque para todos os veículos: 8,2 km/litro.
- Cada veículo realiza até 30 rotas por mês.
- No início do mês seguinte, estas rotas podem ser descartadas.
- Cada rota tem uma data definida e uma quilometragem a ser percorrida.
- Veículos podem completar o tanque com um reabastecimento antes de sair para a rota.
- Uma rota só pode ser atribuída a um veículo se ele tiver autonomia de combustível para realizá-la.
- Veículo deve informar a quilometragem rodada no mês atual;
- Veículo deve informar a quilometragem total rodada, considerando que eles são adquiridos com 0km.
- Veículo deve gerar relatório de rotas.


## Diagrama

![](/docs/diagramas/POO_TP_Frota_v01.jpg)


## Arquitetura

```
	Frota
		- tamanhoFrota: int;
		- listaVeiculos: ArrayList<Veiculo>;
		_______________
		+ <<constructor>> Frota(): Frota
		+ relatorioFrota(): String;
		+ localizarVeiculo(placa: String);
		+ quilometragemTotal(): double;
		+ maiorKmTotal(): Veiculo;
		+ maiorKmMedia(): Veiculo;
		+ getTamanhoFrota(): int;
		+ adicionarVeiculo(veiculo: Veiculo): void;
		_______________
	
	
	
	Rota
		- quilometragem: double;
		- data: LocalDate;
		_______________
		+ <<constructor>> Rota(quilometragem: double, data: LocalDate): Rota
		+ getQuilometragem(): double;
		+ getData(): LocalDate;
		+ getMes(): int;
		+ relatorio(): String;
		+ toString(): String; {redefines toString}
		_______________
	
	
	
	Tanque
		- <<final>> <<static>> CONSUMO: double = 8.2;
		- tanqueAtual: double;
		- tanqueMax: double;
		- capacidadeMaxima: double;
		- capacidadeAtual: double;
		_______________
		+ abastecer(litros: double): double;
		+ autonomiaMaxima(): double;
		+ autonomiaAtual(): double;
		+ getTanqueAtual(): double;
		+ getTanqueMax(): double;
		_______________
	
	
	
	Veiculo
		- <<final>> <<static>> MAX_ROTAS: int = 30;
		- <<final>> <<static>> CONSUMO: double = 8.2;
		- placa: String;
		- rotas: ArrayList<Rota>;
		- qtdRotas: int;
		- totalReabastecido: double;
		- tanque: Tanque;
		_______________
		+ <<constructor>> Veiculo(placa: String): Veiculo;
		+ addRota(): boolean;
		+ autonomiaMaxima(): double;
		+ autonomiaAtual(): double;
		+ abastecer(litros double): double;
		+ kmTotalNoMesAtual(): double;
		+ kmTotal(): double;
		+ percorrerRota(rota: Rota); // Imprime sucessos e exceções.
		+ validaQtdRota(): boolean;
		+ getQtdRotas(): int;
		+ getPlaca(): Object;
		+ getTotalReabastecido(): double;
		_______________

```
