Feature Obra:
	As a usu�rio do sistema 
	I want to adicionar, remover, modificar e visualizar obras no sistema
	So That eu posso gerar p�ginas web para exibir informa��es sobre a obra


#CONTROLLER
Scenario: Adicionar obra n�o existente
	Given que o sistema n�o tem uma obra chamada �Pra�a do arsenal�
	When eu tentar cadastrar uma obra com o nome �Pra�a do arsenal�
	Then o sistema ir� cadastrar a obra de nome "Pra�a do arsenal"

Scenario: Adicionar obra existente
	Given que o sistema tem uma obra chamada �Pra�a do arsenal�
	When eu tentar cadastrar uma obra com o nome �Pra�a do arsenal�
	Then o sistema n�o ir� cadastrar a obra de nome "Pra�a do arsenal"

Scenario: Visualizar obra
	Given que um visitante est� logado no sistema como �guilherme�
	And  o sistema tem uma obra com o nome �Pra�a do arsenal�
	When ele tentar visualizar a obra com o nome �Pra�a do arsenal�
	Then o sistema mostrar� as informa��es relacionadas a obra

Scenario: Atualizar obra
	Given que eu estou logado no sistema como �administrador�
 	And existe uma obra no sistema chamada �Pra�a do Arsenal�
	When eu tentar atualizar os dados da obra com o nome �Pra�a do Arsenal�
	Then o sistema ir� atualizar a obra
	And exibir uma mensagem de confirma��o

Scenario: Remover obra n�o existente 
 	Given que eu estou logado no sistema como Administrador e o sistema n�o tem uma 
    obra chamada �Pra�a do arsenal�
  	When eu tentar remover a obra com o nome �Pra�a do arsenal�
  	Then o sistema n�o ir� remover

Scenario: Remover obra existente 
  	Given que eu estou logado no sistema como Administrador e o sistema tem uma 
    obra chamada �Pra�a do arsenal�
  	When eu tentar remover a obra com o nome �Pra�a do arsenal�
  	Then o sistema ir� remover a obra


#GUI
Scenario: Receber atualiza��es da obra por email
	Given  eu estou visualizando a obra �Pra�a do arsenal�
	When eu seleciono a op��o �Receber atualiza��o por email�
	And preencho o campo de email com o email �teste@obralimpa.com�
	Then eu vejo uma mensagem de confirma��o
	And passo a receber o relat�rio de altera��es da obra no email  �teste@obralimpa.com�

Scenario Visualizar obra
	Given que o usu�rio est� no menu de obras e quer visualizar os detalhes da obra "Pra�a do arsenal"
	When o usu�rio seleciona a obra "Pra�a do arsenal"
	Then o sistema exibe os detalhes da obra "Pra�a do arsenal"

Scenario: Nova p�gina de obra
	Given eu estou no menu de �obras�
	And n�o existe uma obra com nome �Pra�a do Arsenal� na lista de obras
	When eu seleciono a op��o �Cadastrar�
	And eu tento cadastrar a obra com o nome �Pra�a do Arsenal�
	And seleciono a op��o �Salvar�
	Then eu recebo uma mensagem de confirma��o
	And vejo o nome �Pra�a do arsenal�

Scenario: compartilhar obra no facebook
	Given eu esteja visualizando uma obra com o nome �Pra�a do Arsenal�
	When  eu selecionar a op��o �compartilhar no facebook �
	And  preencher os campos do facebook
	Then eu recebo uma mensagem de confirma��o 

Scenario: compartilhar obra no twitter
	Given eu esteja visualizando uma �obra� 
	When  eu selecionar a op��o �compartilhar no twitter�
	And  preencher os campos do twitter
	Then eu recebo uma mensagem de confirma��o 
