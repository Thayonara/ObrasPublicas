import steps.TestDataAndOperations

import static cucumber.api.groovy.EN.*


//CONTROLLER
//Scenario: Adicionar obra não existente
//	Given que o sistema não tem uma obra chamada “Praça do arsenal”
//	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
//	Then o sistema irá cadastrar a obra de nome "Praça do arsenal"



/**
* @author = ehmr
*/
Given(~'^que o sistema não tem uma obra chamada "([^"]*)"$'){
	String nomeObra -> 
	Obra obra = Obra.findByName(nomeObra)
	assert obra == null
}

When (~'^eu tentar cadastrar uma obra com o nome "([^"]*)"$'){
	String nomeObra ->                        //tem que verificar
	TestDataAndOperations.createObra(nomeObra)//tem que verificar
}

Then(~'^o sistema irá cadastrar a obra de nome "([^"]*)"$'){
	String nomeObra ->
	Obra obra = Obra.findByName(nomeObra)
	assert TestDataAndOperations.compatibleTo(obra, nomeObra)
}


//Scenario: Adicionar obra existente
//	Given que o sistema tem uma obra chamada “Praça do arsenal”
//	When eu tentar cadastrar uma obra com o nome “Praça do arsenal”
//	Then o sistema não irá cadastrar a obra de nome "Praça do arsenal"

/**
* @author = ehmr
*/
Given(~'^que o sistema tem uma obra chamada "([^"]*)"$'){
	String nomeObra -> 
	Obra obra = Obra.findByName(nomeObra)
	assert obra != null
}

When (~'^eu tentar cadastrar uma obra com o nome "([^"]*)"$'){
	String nomeObra ->                        
	TestDataAndOperations.createObra(nomeObra)
}

Then(~'^o sistema não irá cadastrar a obra de nome "([^"]*)"$'){
	String nomeObra ->
	obras = Obra.findAllByName(nomeObra)
    assert obras.size() == 1
}


//GUI
//Scenario: Receber atualizações da obra por email
//	Given  eu estou visualizando a obra “Praça do arsenal”
//	When eu seleciono a opção “Receber atualização por email”
//	And preencho o campo de email com o email “teste@obralimpa.com”
//	Then eu vejo uma mensagem de confirmação
//	And passo a receber o relatório de alterações da obra no email  “teste@obralimpa.com”

/**
* @author = ehmr
*/
Given(~'^eu estou visualizando a obra "([^"]*)"$') { 
	String nomeObra ->
	to ObraPage
	at ObraPage
    page.checkObraAtList(nomeObra)
    page.selectObra(nomeObra)
    at ObraShowPage
}

When(~'^eu seleciono a opção "([^"]*)" And preencho o campo de email com o email "([^"]*)"$') { 
	String option, email ->
    at ObraShowPage
    page.select(option)
    page.fillEmailData(email)
    page.select("Cadastrar")
}

Then(~'^eu vejo uma mensagem de confirmação And passo a receber o relatório de alterações da obra no email "([^"]*)"$'){
	String email ->
	assert page.verifyPageContainsText(email) == true
}

//Scenario Visualizar obra
//	Given que o usuário está no menu de obras e quer visualizar os detalhes da obra "Praça do arsenal"
//	When o usuário seleciona a obra "Praça do arsenal"
//	Then o sistema exibe os detalhes da obra "Praça do arsenal"


/**
* @author = ehmr
*/
Given(~'^Given que o usuário está no menu de obras e quer visualizar os detalhes da obra "([^"]*)"$') { 
	String filename ->
    to ObraPage
    at ObraPage
}

When(~'^o usuário seleciona a obra "([^"]*)"$') { 
	String nomeObra ->
    at ObraPage
    page.checkObraAtList(nomeObra)
    page.selectObra(nomeObra)
}

Then(~'^o sistema exibe os detalhes da obra "([^"]*)"$'){
	String nomeObra ->
	at ObraShowPage
	assert page.verifyName(nomeObra) == true
}