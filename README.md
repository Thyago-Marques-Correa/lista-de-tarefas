# Lista de Tarefas

Lista de tarefas onde da para adicionar, marcar como concluida e remover itens.

Feito com Java 17, Spring Boot 3 e Thymeleaf. Os dados ficam em memoria, entao reiniciar a aplicacao limpa tudo.

## Como rodar

Precisa de Java 17+ e Maven.

```bash
mvn spring-boot:run
```

Depois abra http://localhost:8082

Para gerar o jar:

```bash
mvn package
java -jar target/app.jar
```

## Estrutura

- `src/main/java`: controller e classe principal
- `src/main/resources/templates`: pagina HTML (Thymeleaf)
- `src/main/resources/static`: CSS

Projeto de portfolio, criado por Thyago Marques Correa (Engenharia de Software, PUC Minas).
