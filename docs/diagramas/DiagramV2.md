# Diagramas de classe 2
23/11


##	Premissa

Uma empresa de logística está procurando automatizar todos os seus processos e, neste sentido, uma das tarefas
mais importantes é automatizar o controle de frota de seus veículos. Um veículo da empresa é identificado por
sua placa. Cada veículo tem um tanque de combustível de capacidade diferente, dependente de seu modelo.

No momento inicial, como simplificação, a empresa considera que o consumo é igual para todos os
veículos: 8,2 km/litro. Cada veículo realiza até 30 rotas por mês e, no início do mês seguinte, estas rotas podem
ser descartadas. Cada rota tem uma data definida e uma quilometragem a ser percorrida. Uma rota só pode ser
atribuída a um veículo se ele tiver autonomia de combustível para realizá-la, seja com o combustível atual, seja
completando o tanque com um reabastecimento antes de sair para a rota.
A empresa precisa saber, ainda:
• Quantos litros de combustível já foram reabastecidos em cada veículo;
• Quilometragem rodada de um veículo no mês atual;
• Quilometragem total rodada pelo veículo, considerando que eles são adquiridos com 0km.

Os requisitos aprofundados apontaram que existem quatro tipos de veículos: carros, vans, furgões e
caminhões. Cada tipo de veículo tem uma capacidade de tanque de combustível e este tanque usa um
combustível pré-definido. A autonomia diária (quilometragem máxima) do veículo depende do combustível
utilizado. Cada combustível tem, portanto, um consumo médio e um preço médio. Além disso, os veículos precisam realizar manutenções programadas de acordo com quilometragens
definidas.

A gerência da empresa precisa:
a) Examinar relatórios de rotas de cada veículo.
b) Saber a quilometragem total percorrida por um veículo.
c) Realizar as manutenções de um veículo tão cedo quanto forem necessárias.
d) Calcular a despesa total de um veículo, considerando combustível e manutenções.


## Requisitos

- Um veículo da empresa é identificado por sua placa.
- Existem quatro tipos de veículos: carros, vans, furgões e caminhões.
- Cada veículo tem um tanque de combustível.
- Capacidade do tanque dependente do modelo do veículo.
- Cada tipo de veículo usa um combustível pré-definido em seu tanque.
- Cada combustível tem um consumo médio e um preço médio.
- Cada veículo realiza até 30 rotas por mês.
- No início do mês seguinte, estas rotas podem ser descartadas.
- Cada rota tem uma data definida e uma quilometragem a ser percorrida.
- Veículos podem completar o tanque com um reabastecimento antes de sair para a rota.
- A autonomia diária (quilometragem máxima) do veículo depende do combustível utilizado.
- Uma rota só pode ser atribuída a um veículo se ele tiver autonomia de combustível para realizá-la. // perguntar no Menu para reabastecer, antes de executar a rota, caso precise
- Veículo deve informar quantos litros de combustível já foram reabastecidos;
- Veículo deve informar a quilometragem rodada no mês atual;
- Veículo deve informar a quilometragem total rodada, considerando que eles são adquiridos com 0km.
- Veículos precisam realizar manutenções programadas de acordo com quilometragens definidas, tão cedo quanto forem necessárias.
- Veículo deve gerar relatório de rotas.
- Calcular a despesa total do veículo, considerando combustível e manutenções.



## Arquitetura

```

Presentation Layer ---------------------------
	MainMenu


Application Layer ---------------------------
	
	Frota
		- Veiculos: Lista<Veiculo>;
		- Manutencoes: Lista<Manutencao>;
		____________________
		- AtribuirRota(Veiculo);
		____________________
	
	
	Relatório Layer Slice:
	
		<<Interface>> IReportavel
			____________________
			+ GerarRelatorio(): string;
			____________________
		
		RelatorioManager
			____________________
			+ RelatorioVeiculo(placa: String): string;
			+ RelatorioVeiculo(placa: String): string;
			____________________
			
	Manutenção Layer Slice:
	
		Manutencao
			- LimiteQuilometragemParaManutencao: float; (precisam realizar manutenções programadas de acordo com quilometragens definidas.)
			- Preco: float;
			____________________
			+ ProcessarManutencao(IMaintainable): void;
			____________________
		
		<<Interface>> IMaintainable
			- ManutencoesProcessadas: Lista<Manutencao>;
			- CustoAcumuladoEmManutencao: float;
			____________________
			+ ProcessarManutencao(): void;
			____________________


Veículo Domain Layer ---------------------------

	Veículo : IMaintainable
		- <<static>> LIMITE_ROTAS_MES: int = 30;
		- <<final>> placa: string;
		- historicoRotas: Map<mes, Lista<Rota>>;
		- tanque: Tanque;
		- modelo: EModeloVeiculo;
		____________________
		+ QuantidadeReabastecida(): int;
		+ QuilometragemMes(mes: Mes): float;
		+ QuilometragemDesdeQuandoAdquirido(): float; // Veículos são adquiridos com 0,0km;
		+ DespesaTotal(): float;
		+ RelatorioRota(): string;
		+ AtualizarParaNovoMes(); // rotas e quilometragem mensal podem ser descartados.
		____________________
	
	Tanque
		- <<final>> modelo: EModeloVeiculo;
		- nivelAtual: float;
		- TotalReabastecido;
		____________________
		+ <<Construtor>> Tanque(modelo: EModeloVeiculo): Tanque;
		+ ConsumirPorQuilometragem(quilometragem: float);
		+ ReabastecerAte(nivel: float);
		+ AutonomiaAtual(): float; // Ex: 8,2 km
		+ AutonomiaMaxima(): float; // Quando completamente reabastecido
		____________________
	
	<<enum>> EModeloVeiculo
		+ CARRO VAN, FURGAO, CAMINHAO (combustivel: ECombustivel, capacidadeTanque: float)
		- <<static>> combustivel: ECombustivel; // Combustivel pré-definido.
		- <<static>> capacidadeTanque: float; // base - 8,2 km/litro.
		____________________

	<<enum>> ECombustivel
		+ ALCOOL, GASOLINA, DIESEL (ConsumoMedio: float, PrecoMedio: float)
		- <<final>> ConsumoMedio: float // Ex: 8,2 km/litro.
		- <<final>> PrecoMedio: float // Ex: R$ 3,29
		____________________

	Rota
		- dataDefinida: Date;
		- quilometragemApercorrer: float;
		- jaPercorrida: bool = false;
		____________________
		+ <<Construtor>> Rota(dataDefinida: Date, quilometragemApercorrer: float): Rota;
		+ Percorrer(): void
		____________________

```
