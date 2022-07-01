<div id="top"></div>

<br />
<div>
 
<h3 align="center">Smoothies builder</h3>

  <p>
    Criador de smoothies:
    <br />
  </p>
</div>


## Como utilizar:

1- Requerimentos:  Java instalado (Jdk 11).<br>
2- Clonar o repositório na pasta desejada.<br>
3- Acessar a pasta clonada e executar no terminal:

  ```sh
  chmod +x gradlew
  ```
  ```sh
  ./gradlew bootRun
  ```
4- Realizar uma requisição para o endpoint "localhost:8080" da seguinte forma:

Tipo da requisição: GET

Informar a url + "/" + Nome do smoothie + "ingredientes separados por vírgula."<br>
Obs.: Antes do nome do ingrediente, incluir o sinal "+" para adicionar ou "-" para remover o ingrediente.

Exemplo de url a ser utilizada:
"localhost:8080/Classic,+chocolate"