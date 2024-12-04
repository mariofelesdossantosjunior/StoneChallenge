# **Documentação do Projeto**

## **Introdução**
- **Nome do Projeto**: StoneChallenge
- **Descrição**: Um projeto multiplataforma desenvolvido em Kotlin para compartilhar código entre Android e iOS.
- **Tecnologias Usadas**: Kotlin Multiplatform, Koin, Ktor(Server/Client), Kotlinx Serialization, Kotlinx Coroutines, Coil.
- **Arquitetura**: Clean Arch, MVVM/MVI.
- **Backend**: Local implementado com Ktor.

---

## **Funcionalidades**

- **Lógica de Negócios Compartilhada**: Reutilização de código em diferentes plataformas.
- **Injeção de dependência com Koin**: Implementado com [Koin](https://insert-koin.io/docs/reference/koin-mp/kmp).
- **Integração com APIs REST**: Implementado com [Ktor](https://ktor.io).
- **Carregamento de imagem**: Implementado com [Coil](https://github.com/coil-kt/coil).
- **Suporte a Coroutines**: Operações assíncronas eficientes.
- **Testes Unificados**: Testes unitários utilizando Kotlin Test, Coroutines Test, e [Mokkery](https://mokkery.dev/).

---

## **Estrutura do Projeto**
O projeto segue a seguinte estrutura:

```plaintext
- stone-challenge/
  - androidMain/     # Código específico para Android
  - commonMain/      # Código comum para todas as plataformas
  - commonTest/      # Testes do código comum
  - iosMain/         # Código específico para iOS
  - build.gradle.kts # Configuração do Gradle
```

---

## **Estrutura do Projeto Backend**
O projeto segue a seguinte estrutura:

```plaintext
- backend-stone-challenge/
  - main/         # Código
  - build.gradle.kts # Configuração do Gradle
```

---

## **Execução do backend**
Para executar o backend será necessário executar a função main:

```plaintext
- server/src/main/kotlin/com/mario/Application.kt
```
Servidor está configurado pra subir **LocalHoost** porta **8080**

---

## **Execução do Aplicativo**
Para executar o aplicativo será necessário as seguintes configurações:
1. Configuração do IP do servidor
   Defina seu IP, onde está executando servidor Ktor,para descobrir seu ip utilize:

```plaintext
  ifconfig
```

2. Defina seu IP no seguinte arquivo
   Altere a variável **IP**

```plaintext
- composeApp/src/commonMain/kotlin/com/mario/stonechallenge/data/api/ServerConfig.kt
```

3. Após servidor em execução, executar o aplicação através Android Studio ou Terminal

4. Usuário e Senha **padrão** já definidos nos inputs 
   Usuário: admin
   Senha: 123

---

## **Execução dos Testes**
Para executar os testes utilize o seguinte comando:

```plaintext
./gradlew test
```

---

## **demonstração aplicação**

[Screen_recording_20241204_135041.webm](https://github.com/user-attachments/assets/4501fb4a-24a5-4228-b52a-c255642306de)


