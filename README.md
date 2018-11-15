# spring-upload


```sh
O objetivo desse projeto demostrar como realizar upload e dowload de fotos,
Ao realizar o dowload a extensão da foto e realizada de forma automatica.
```


 
## 1. Dependências

Instalar as seguintes ferramentas:

    1. JDK 1.8
    2. Maven
    3. Docker compose
    
O projeto utiliza um banco embarcado (Postgres) para desenvolvimento.
 
## 2. Executando o Projeto
 IDEA Intellij pode ser recomendado
Após baixar o projeto, para executá-lo é necessário rodar os seguintes comandos dentro da pasta raiz.

```sh
$ docker-compose up   
$ mvn clean install   
$ mvn spring-boot:run 
```
## 3. Testando os serviços
Realizar a chamada dos serviços. 
Para testar os serviços utilize um browser ou o postman


## UPLOAD NA PASTA /tmp/contato-disco
VEJA O ARQUEIVO: application.properties linha 25

O postman pode ser recomendado
POST / 
```sh
$ curl localhost:8080/fotos
key                         value
foto        file            escolher arquivo

clique em send
```

## UPLOAD no banco de dados
O postman pode ser recomendado
POST / 
```sh
$ curl localhost:8080/foto
key                         value
foto        file            escolher arquivo

clique em send
```

## DOWNLOAD do banco de dados
GET / 
```sh

$ curl localhost:8080/download
key                         value
id                          1

clique em send ou send and download
```