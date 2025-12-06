# **Aplicacao java para contar palavra e frases**

:link: Aplicativo Java simples para contar as ocorrências de uma palavra ou frase em uma página web.

:man: Os usuários podem inserir um URL e uma frase, e o programa busca o conteúdo da página e calcula a contagem.

:bar_chart: Conta a frase completa e cada palavra individual separadamente.

## Tecnologias Usadas

<details>
  <summary>📚 Backend / Core</summary>
    <div>
      <samp>
        <p align="center">
          <img src="https://img.shields.io/badge/Java-1e1e2e?&style=for-the-badge&logo=openjdk&logoColor=cba6f7"/>
          <img src="https://img.shields.io/badge/Maven-1e1e2e?&style=for-the-badge&logo=maven&logoColor=cba6f7"/>
          <img src="https://img.shields.io/badge/Apache%20HttpClient-1e1e2e?&style=for-the-badge&logoColor=cba6f7"/>
          <img src="https://img.shields.io/badge/Jsoup-1e1e2e?&style=for-the-badge&logoColor=cba6f7"/>
          <img src="https://img.shields.io/badge/Docker-1e1e2e?&style=for-the-badge&logo=docker&logoColor=cba6f7"/>
        </p>
      </samp>
    </div>
</details>

<img src="https://github.com/AnderMendoza/AnderMendoza/raw/main/assets/line-neon.gif" width="100%">

## Metodologia
Sistema baseado em **classes separadas** por **responsabilidade**: HttpService, TextCounterService e Main.
Utiliza entrada do usuário para informar URL e frase/palavra, facilitando **testes sem necessidade de configuração extra**.
Permite contar ocorrências de uma frase inteira e **contar palavras** individualmente.
Projetado para **modularidade**, **código limpo** e **fácil manutenção**, com tratamento de exceções adequado.

<img src="https://github.com/AnderMendoza/AnderMendoza/raw/main/assets/line-neon.gif" width="100%">

## Estrutura do Projeto

```bash
src/
├── com/exam/                 # Pacote principal do projeto
│   ├── Main.java             # Classe principal que gerencia entrada do usuário e exibição
│   └── service/              # Serviços separados por responsabilidade
│       ├── HttpService.java  # Classe que busca o conteúdo de páginas web
│       └── TextCounterService.java # Classe que conta palavras e frases
├── resources/                # Recursos do projeto (se houver)
├── target/                   # Saída do build, JAR compilado
├── pom.xml                   # Arquivo de configuração Maven
└── README.md                 # Documentação do projeto
```

 <img src="https://github.com/AnderMendoza/AnderMendoza/raw/main/assets/line-neon.gif" width="100%">

## Testes

O projeto é estruturado para **testes unitários** nas classes de **serviço** (HttpService e TextCounterService), permitindo expandir facilmente com **JUnit** ou outro framework de testes, se necessário.

## Modo de uso
1. Build a imagem Docker local
```bash
    docker build -t text-counter-java .
```

2. Testar
```bash
    docker run -it text-counter-java
```
Exampo de retorno

```bash
Digite uma URL: https://en.wikipedia.org/wiki/Linux
Digite uma frase para buscar: linux

Buscando conteúdo da página...
"linux" → repete 471 vezes

Detalhe por palavra:
"linux" → repete 471 vezes
```

## como usar com cluster Kind

1. Criar o cluster Kind
```bash
    kind create cluster --name text-counter-cluster
```
2. Carregar a imagem local no Kind
```bash
    kind load docker-image text-counter-java:latest --name text-counter-cluster
```
3.  Aplicar o Deployment no cluster
```bash
    kubectl apply -f deployment-kind.yaml
```
4. Listar pods para verificar se estão rodando
```bash
    kubectl get pods
```
7. Acessar o pod interativamente
```bash
    kubectl exec -it <nome-do-pod> -- /bin/sh
```
8. Dentro do pod, rodar a aplicação
```bash
    java -jar app.jar
```
9. Quando terminar, deletar o cluster
```bash
    kind delete cluster --name text-counter-cluster
```

<img src="https://github.com/AnderMendoza/AnderMendoza/raw/main/assets/line-neon.gif" width="100%">
<img src="https://github.com/AnderMendoza/AnderMendoza/raw/main/assets/banner-header.gif">
