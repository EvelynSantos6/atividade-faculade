# Sistema de Cadastro e Notificação de Eventos

Este projeto é uma atividade prática desenvolvida para a faculdade, com o objetivo de implementar um sistema em Java, no paradigma orientado a objetos, que permita o **cadastro, listagem, notificação e ordenação de eventos** que estejam ocorrendo na cidade do usuário.

## 📋 Requisitos da Atividade

A solução deve atender aos seguintes critérios:

- ✅ Projeto desenvolvido em **Java orientado a objetos**
- ✅ Pode ser organizado em um repositório GIT (opcional)
- ✅ Uso de padrão **MVC é incentivado**, mas não obrigatório
- ✅ Estruturação com **diagrama de classes** (obrigatória)
- ✅ Aplicação em **modo Console**
- ✅ Implementa um sistema de:
  - Cadastro de **usuários** (mínimo 3 atributos definidos)
  - Cadastro de **eventos**, com os seguintes atributos obrigatórios:
    - Nome
    - Endereço
    - Categoria (festas, esportivos, shows etc.)
    - Horário
    - Descrição
  - Delimitação de **categorias** para criação de eventos (ex: festas, esportivos, shows etc.)
  - Listagem de **eventos por categoria**
  - Visualização de eventos com opção de **participar** ou **cancelar participação**
  - Consulta de eventos **já ocorridos**
  - Ordenação de eventos por **horário** (utilizar `DateTime`)
- ✅ Eventos devem ser **salvos em um arquivo** chamado `events.data`
- ✅ Toda vez que o programa for iniciado, ele deve **ler os dados** do arquivo

## 🚀 Tecnologias Utilizadas

- Java 17+
- IDEs sugeridas: Eclipse, IntelliJ, NetBeans ou Replit
- Arquivos `.data` para persistência simples dos dados

## ▶️ Como Executar o Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/EvelynSantos6/atividade-faculade.git
    ```

2. Acesse o diretório:

    ```bash
    cd atividade-faculade
    ```

3. Compile e execute com sua IDE Java preferida ou via terminal:

    ```bash
    javac *.java
    java Main
    ```

> Obs.: Certifique-se de que o arquivo `events.data` esteja no mesmo diretório para carregar os dados salvos.

## 📦 Estrutura Recomendada

```plaintext
src/
├── controller/
├── model/
├── repository/
├── service/
├── util/
└── Main.java
```

## 💾 Persistência

- Os eventos são gravados em um arquivo chamado `events.data`
- A leitura do arquivo ocorre automaticamente ao iniciar o programa

## 🧠 Funcionalidades Adicionais Sugeridas

- Validação de entrada do usuário
- Formatação de data/hora (ex: dd/MM/yyyy HH:mm)
- Menu interativo no console
- Sistema de mensagens para confirmação/cancelamento de participação

## 🎓 Finalidade Educacional

Este projeto tem fins acadêmicos e visa exercitar:

- Programação orientada a objetos
- Manipulação de arquivos
- Estruturação de dados
- Uso da API `java.time`
- Lógica de programação em Java

## 📄 Licença

Este projeto é de uso educacional e não possui licença comercial definida.

---

**📌 Dica:** desenvolva a solução mais completa que puder. A melhor forma de aprender é praticando. Boa sorte!
