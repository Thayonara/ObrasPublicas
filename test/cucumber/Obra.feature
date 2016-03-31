Feature Obra:
	As a usu�rio do sistema 
	I want to adicionar, remover, modificar e visualizar obras no sistema
	So That eu posso gerar p�ginas web para exibir informa��es sobre a obra



#CONTROLLER
Scenario: Adicionar obra n�o existente
	Given que eu estou logado no sistema como "Administrador" e o sistema n�o tem uma 
		obra chamada �Pra�a do arsenal�
	When eu tentar cadastrar uma obra com o nome �Pra�a do arsenal�
	Then o sistema ir� cadastrar a obra

Scenario: Adicionar obra existente
	Given que eu estou logado no sistema como "Administrador" e o sistema tem uma 
		obra chamada �Pra�a do arsenal�
	When eu tentar cadastrar uma obra com o nome �Pra�a do arsenal�
	Then o sistema n�o ir� cadastrar a obra



#GUI
Scenario: Receber atualiza��es da obra por email
	Given  eu estou visualizando uma a obra �Pra�a do arsenal�
	When eu seleciono a op��o �Receber atualiza��o por email�
	And preencho os campos de email com o email �teste@obralimpa.com�
	Then eu vejo uma mensagem de confirma��o
	And passo a receber o relat�rio de altera��es da obra no email  �teste@obralimpa.com�

Scenario Visualizar obra
	Given que o visitante �Eduardo� est� no menu de obras e quer visualizar os detalhes da obra �Pra�a do Arsenal�
	When �Guilherme� clica na op��o �Visualizar obras�
	And seleciona a localiza��o da obra �Pra�a do Arsenal� no mapa
	Then o sistema exibe os detalhes da obra

