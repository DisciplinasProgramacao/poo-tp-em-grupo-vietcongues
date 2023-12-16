# Correção

## Nota base 9

## Comentários

  - sistema não funcional na apresentação
  - classes com pouca documentação
  - "fromInt" não faz sentido no enumerador. Tem o método ordinal, tem o values e pode tentar a string se precisar.
  - manutenções no enum estão idênticas para peças e para periódicas
  - só dá problema ao tentar percorrer a rota, mas a classe aceita a rota sem autonomia. Ela ficaria no histórico. Quem está barrando isso é o app, o que não é papel dele.
  - depois eu não entendi o menu "percorrer próxima rota": saiu percorrendo rotas que não sei quais são, sem eu ter inserido. Ou percorre ao ser registrada, ou deixa escolher as registradas para saber qual percorrer. É uma boa ideia a ordenação no histórico, mas
    - não era um requisito (ou seja, gastando tempo com coisas desnecessárias em projeto com prazo estourado)
    - há outros problemas mais importantes nos requisitos básicos, listados acima e abaixo.
  - get de get ferindo encapsulamento. Ex:
  ```
  tipoVeiculo.getManutencaoPeriodica().getKmProgramada()){
  ```
    
além do que é um método que, no veículo, deveria estar com modularização melhor (ex: this.verificarManutencoes() logo após contar os km)

  - relatório pouco informativo (só maior km total e média, só placa)
  - não consigo ver o custo do veículo, só km
  - pedir data em três linhas diferentes, começando pelo ano, não dá. Data é dd/mm/aaaa

