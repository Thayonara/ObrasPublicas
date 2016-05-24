import steps.TestDataAndOperations

import static cucumber.api.groovy.EN.*


//#CONTROLLER
//Scenario: Adicionar político não existente
//Given o sistema não tem um político com nome “Eduardo” e CPF "01234567890”
//When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
//Then o sistema irá cadastrar o político com o nome “Eduardo” e CPF “01234567890”

Given(~'^o sistema não tem um político com o CPF "([^"]*)"$'){
    String cpf ->
        Politico politico = Politico.findByCPF(cpf)
        assert politico==null
}

When (~'^eu tentar cadastrar um politico com o CPF "([^"]*)"$'){
    String cpf ->
        TestDataAndOperations.createPolitico(cpf)
}

Then(~'^o sistema irá cadastrar o politico de CPF "([^"]*)"$'){
    String politicoName, cpf ->
        Politico politico = Politico.findByCPF(cpf)
        assert TestDataAndOperations.politicoCompatibleTo(politico, cpf)
}

//Scenario: Adicionar político existente
//Given o sistema tem um político com nome “Eduardo” e CPF "01234567890”
//When eu tentar cadastrar um político com o nome “Eduardo” e CPF “01234567890”
//Then o sistema não irá cadastrar o político

Given(~'^o sistema tem um político de CPF "([^"]*)"$'){
    String cpf ->
        Politico politico = Politico.findByCPF(cpf)
        assert politico != null
}

When (~'^ao tentar cadastrar um político com o CPF "([^"]*)"$'){
    String cpf ->
        TestDataAndOperations.createPolitico(cpf)
}

Then(~'^o sistema não irá cadastrar o político de CPF "([^"]*)"$') {
    String cpf ->
        politicos = Politico.findAllByCPF(cpf)
        assert politicos.size() == 1
}