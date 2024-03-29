# Hangman Game: Peer-to-Peer

- __*Hangman Game: Peer-to-Peer*__ é uma implementação do clássico jogo da forca, todavia nesta versão, um jogador se conecta diretamente a um servidor através de uma conexão `TCP/IP` para jogar. Este projeto utiliza tecnologias como `Threads`, `WebSockets` e outros recursos para proporcionar uma experiência interativa e dinâmica.

## Funcionalidades 

- Conexão `Peer-to-Peer`: Os jogadores se conectam diretamente ao servidor utilizando comunicação bidirecional via `TCP/IP`, permitindo uma interação direta e em tempo real.

- __*Sorteio de Palavras*__: O servidor seleciona uma palavra aleatória de um banco de palavras ou lista predefinida, garantindo uma experiência de jogo diversificada.

- __*Adivinhação de Letras*__: Os jogadores tentam adivinhar as letras da palavra oculta, fornecendo suas escolhas através da interface do jogo.

- __*Feedback Interativo*__: O servidor fornece feedback instantâneo aos jogadores sobre suas escolhas, indicando se a letra está correta ou não, a quantidade de erros e o estado atual do jogo.

- __*Gerenciamento de Conexões*__: O servidor gerencia múltiplas conexões de clientes simultaneamente, garantindo uma experiência de jogo fluida para todos os jogadores.

- __*Comunicação Assíncrona*__: O projeto utiliza `Threads` para lidar com a comunicação assíncrona entre os jogadores e o servidor, permitindo que múltiplas operações ocorram simultaneamente.

##  :exclamation: Requisitos do Sistema 

1. Certifique-se de ter o `Java JDK` instalado em seu sistema. Link para [download](https://www.oracle.com/java/technologies/downloads/).

     1.1 Instalação __*Windows 10*__: [Link do tutorial](https://www.youtube.com/watch?v=AUL--F5Wdh8).

    1.2 Instalação __*Windows 11*__: [Link do tutorial](https://www.youtube.com/watch?v=krGadRGdESQ).

    1.3 Instalação __*Linux 22.04 LTS*__: [Link do tutorial](https://www.youtube.com/watch?v=vVrIDJ--GOA).


<br>

2. IDE para execução, como [VSCode](https://code.visualstudio.com/) ou [IntelliJ](https://www.jetbrains.com/idea/download/?section=windows).


## Tecnologias Utilizadas

- __*Java Threads*__: Utilizadas para lidar com comunicação assíncrona e paralela entre os jogadores e o servidor.

- __*TCP/IP*__: Protocolo de comunicação utilizado para estabelecer conexões peer-to-peer entre o jogador e o servidor.


<br>

## Como Executar

<br>
  
1. Execute primeiro o servidor. Entre na pasta onde a classe __*Servidor*__ se encontra, pelo próprio terminal do `VSCode` ou pelo `CMD`. O __*path*__ `seu_disco_rídigo\seu_usuário\local_do_projeto\Hangman-Game-Server\Servidor\src`, após ser alcançado, deve ser digitado o comando `java Servidor`.

<br>

> <div style="text-align: center;">
>     <p align = "center">
> Se preferir, pode optar por passar uma porta que deseje que o servidor nela execute. Por padrão, caso não seja passado nenhuma porta, assume-se a '3000'.
>     </p>
> </div>

<br>

2. Entre na pasta onde a classe __*Cliente*__ se encontra, pelo próprio terminal do `VSCode` ou pelo `CMD`. Digite o O __*path*__ `seu_disco_rídigo\seu_usuário\local_do_projeto\Hangman-Game-Server\Cliente\src`, após ser alcançado, deve ser digitado o comando `java Cliente`.

<br>
  
> <div style="text-align: center;">
>     <p align = "center">
> Se preferir, pode optar por passar um endereço IP e uma porta que deseje para que o servidor nela execute. Por padrão, caso não seja passado nenhuma porta e nem o 'host', assume-se a porta '3000' e 'localhost', respectivamente.
>     </p>
> </div>

<br>

> <div style="text-align: center;">
>     <p align = "center">
> Caso os argumentos pelo terminal ultrapasse o limite definido anteriormente, para as classes 'Cliente' e 'Servidor',  o sistema denunciará um erro e solicitará que sejam enviados apenas 2 argumentos para 'Cliente', e 1 para o 'Servidor'.
>     </p>
> </div>

<br>

> <div style="text-align: center;">
>     <p align = "center">
>    O Funcionamento do projeto pode ser encontrado no <a href="https://github.com/Matheus-Oliveira-Marino/Hangman-Game-Peer-to-Peer/blob/main/videos/Jogo%20Funcionando.mp4">video1</a>, e o 
>     <a href="https://github.com/Matheus-Oliveira-Marino/Hangman-Game-Peer-to-Peer/blob/main/videos/Acertando%20a%20palavra.mp4">video2</a>. Apenas é necessário realizar o download de ambos.
>     </p>
> </div>
     
## Estrutura da Pasta

O espaço de trabalho contém por padrão duas pastas, onde:

- `src`: a pasta para manter os arquivos de origem
- `lib`: a pasta para manter as dependências.

Enquanto isso, os arquivos de saída compilados serão gerados na pasta `bin` por padrão.

> Se você deseja personalizar a estrutura de pastas, abra `.vscode/settings.json` e atualize as configurações relacionadas lá.

## Gerenciamento de Dependências

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Licenca
Este projeto está licenciado sob a [MIT LICENSE](https://github.com/Matheus-Oliveira-Marino/Hangman-Game-Peer-to-Peer/blob/main/LICENSE). Consulte o arquivo para obter detalhes.
