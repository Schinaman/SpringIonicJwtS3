# SpringIonicJwtS3

# CaseAgendaTransferencias
A shopping store
API que simula agendamentos de transferencias financeiras entre 2 contas.<br>
Tecnologias utilizadas:<br>
Java, Jpa-Hibernate, Spring.

## Overview
The project runs through an RESTful API and checks whether a DNA sequence belongs to a human or a simian. <br>
It will be simian, if a DNA has one or more sequences of four identical characters in horizontal, vertical or any diagonals. 
![alt text](https://github.com/Schinaman/teste-simio/blob/main/isSimian.jpg?raw=true)

## Endpoints

<br>
Path: /contas <br>

__Conta__ <br>
método GET retorna dados de contas e agendamentos. <br>
http://localhost:8080/contas <br>

Response example:

```
[
    {
        "conta": "123450",
        "transferenciasContaOrigem": [],
        "transferenciasContaDestino": [
            {
                "id": 1,
                "valorTransferencia": 200.0,
                "dataTransferencia": "30/04/2022",
                "dataAgendamento": "30/09/2022",
            }
        ]
    },
    {
        "conta": "123456",
        "transferenciasContaOrigem": [
            {
                "id": 1,
                "valorTransferencia": 200.0,
                "dataTransferencia": "30/04/2022",
                "dataAgendamento": "30/09/2022",
            }
        ],
        "transferenciasContaDestino": []
    }
    }
]
```

Método GET retorno específico para uma conta e a relação de transferencias. <br>
http://localhost:8080/contas/{conta} <br>
Response example:

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
