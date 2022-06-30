# A shopping store project - using Java, Spring and Ionic
## Overview
### Conceito:
O projeto consiste na construção de uma API para disponibilizar serviços de uma loja online. <br>
O projeto disponibiliza: <br>
- Tela inicial de login
- Tela de cadastro.
- Tela de perfil
- Tela de categorias, produtos e detalhes dos produtos
- Checkout com envio de confirmação ao e-mail cadastrado
- Logout

### Divisão do Projeto:
- O projeto é dividido em dois repositórios este, o back-end da aplicação construído utilizando Java e Spring Boot. <br>
- E um segundo contendo o front-end: https://github.com/Schinaman/project-spring-ionic. Construído em TypeScript utilizando como framework Angular e Ionic.

### Bibliotecas e tecnologias utilizadas: <br>
- Spring Data <br>
- Spring Security<br>
- Spring WebServices<br>
- Utilização do JPA para mapeamento paradigmas objeto/relacional <br>
- Controle de acesso aos endpoints por perfil, via token Jwt. <br>
- Refresh automático de token Jwt <br>

<br>
<br>

Imagens
![alt text](https://github.com/Schinaman/teste-simio/blob/main/isSimian.jpg?raw=true)
![alt text](https://github.com/Schinaman/teste-simio/blob/main/isSimian.jpg?raw=true)

## Endpoints
###Login
<br>


__POST__: login de client/admistrador cadastrado. <br>
path: /login <br>
request body example:

```
{
    "email": "usuario@dominio.com",
    "senha": "123"
}
```

__POST__:  refresh automatico de token. <br>
path: auth/refresh_token <br>
request body example:

```
{
    "email": "usuario@dominio.com",
    "senha": "123"
}
```

__POST__:  "esqueci minha senha" envia e-mail com nova senha. <br>
path: /auth/forgot <br>
request body example:

```
{
    "email": "usuario@dominio.com"
}
```



#Testar as respostas

###Clientes
<br>
__POST__:  inserção de novo cliente. <br>
path: /clients <br>
request body example:

```
{
    "name": "Joao Silva",
    "email": "usuario@dominio.com",
    "cpfOuCnpj": "05202659000144",
    "type": 2,
    "telephone1": "27363324",
    "telephone2": "93838354",
    "logradouro": "Rua Flores",
    "number": "300",
    "complement": "apto300",
    "cep": "38220834",
    "cityId": 2
}
```

__PUT__:  update de novo cliente. <br>
path: /clients <br>
request body example:

```
{
    "name": "Joao Silva",
    "email": "usuario@dominio.com",
    "cpfOuCnpj": "05202659000144",
    "type": 2,
    "telephone1": "27363324",
    "telephone2": "93838354",
    "logradouro": "Rua Flores",
    "number": "300",
    "complement": "apto300",
    "cep": "38220834",
    "cityId": 2
}
```


###Produtos
<br>

###Pedidos
<br>


###Estados
<br>


###Cidades
<br>




```
{
    "conta": "123450",
    "transferenciasContaOrigem": [],
    "transferenciasContaDestino": [
        {
            "id": 1,
            "valorTransferencia": 200.0,
            "dataTransferencia": "30/04/2022",
            "dataAgendamento": "30/09/2022"
        }
    ]
}
```
Método POST cadastra uma conta. <br>
http://localhost:8080/contas <br>
Parametro body example:

```
{
    "conta": "123450"
}
```
<br>

__Agendamentos__

Path: /agendamentos <br>

Método POST cadastra um agendamento de transferencia. <br>
http://localhost:8080/contas <br>
Parametro body example:

```
{
    "valorTransferencia": 200.0,
    "dataTransferencia": "30/04/2022",
    "dataAgendamento": "30/09/2022"
}
```


## Test environment

Change profile to "test" in the "application.properties" file. <br>
Test environment database uses Spring Boot - H2 Database <br> 
It can be accessed from the following URI: <br>
//localhost:&#60;port&#62;/h2-console/

Repositório para referência
https://github.com/tm-vagas/avaliacao-full-stack
