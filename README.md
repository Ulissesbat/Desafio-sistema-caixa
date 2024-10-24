Sistema de Caixa de Comércio em Java com Spring Boot.

O objetivo é criar um sistema básico para gerenciar vendas e compras, com funcionalidades de gerenciamento de produtos, transações e relatórios.

Requisitos do Sistema
1. Entidades
   
Produto:

id: Long

nome: String

preco: BigDecimal

quantidadeEstoque: int

Cliente:

id: Long

nome: String

cpf: String

email: String

Venda:

id: Long

cliente: Cliente

itens: List<ItemVenda>

valorTotal: BigDecimal

dataHora: LocalDateTime


ItemVenda (representa cada item na venda)

id: Long

produto: Produto

quantidade: int

precoUnitario: BigDecimal

subtotal: BigDecimal

2. Funcionalidades
   
Gerenciamento de Produtos:

Adicionar, 
atualizar, 
remover e listar produtos.
Atualizar o estoque ao cadastrar uma nova venda.

Gerenciamento de Clientes:

Adicionar, atualizar e listar clientes.
Registrar Vendas:

Criar uma venda para um cliente.

Adicionar produtos à venda.

Calcular o valor total da venda com base nos produtos selecionados.

Reduzir a quantidade em estoque dos produtos vendidos.

Relatórios:

Listar todas as vendas.
Listar todas as vendas por cliente.
Listar produtos que estão com estoque baixo (defina um limite para o que é considerado "baixo").

3. Validações


O sistema deve verificar se há estoque suficiente ao realizar uma venda.
Não deve ser possível vender um produto que não esteja cadastrado ou que tenha quantidade insuficiente.
Valide dados obrigatórios no cadastro de produtos e clientes, como nome, CPF, email, etc.

4. Testes com Postman:

Implemente testes de todas as funcionalidades usando o Postman para garantir que todas as operações estejam funcionando corretamente (GET, POST, PUT, DELETE).

5. Segurança:
   
Implemente autenticação básica para acessar o sistema de caixa.
Defina dois perfis de usuários: administrador (pode fazer todas as operações) e operador (apenas registrar vendas e listar clientes/produtos).

7. Tecnologias sugeridas:
   
Spring Boot
Spring Data JPA
H2 ou MySQL para o banco de dados
Bean Validation para validação de dados
Postman para testar as requisições
(Opcional) Spring Security para autenticação.
Extra (opcional)
Adicione um relatório financeiro diário, mostrando o total de vendas feitas no dia e o lucro total.
Esse sistema deve cobrir várias funcionalidades práticas para você reforçar seus conhecimentos em Java com Spring Boot!
