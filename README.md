## 💻 Sobre o projeto

Api HelpDesk para abertura e fechamento de chamados. 

## ⚙️ Funcionalidades
- [x] Criação da classe Usuario.
- [x] Classe Roles;
- [x] Autenticação com tokenJWT Auth0.
- [x] Permissão de usuario ADMIN/USER.
- [x] SpringSecurity
- [x] Criptografar a senha com Bcrypt.
- [x] classe ticket.
- [x] Abertura de ticket.
- [x] Classe Enum com o status dos chamados.
- [x] Relacionamento OneToMany e ManyToOne.
- [x] Gerador de protocolo automatico.
- [x] Utilização de JsonIgnore para campos sensiveis e @JsonBackReference.
- [x] Validação não deixar cadastrar usuario já registrado no banco.
- [x] Teste automatizado com mock classe Ticket.
- [x] DOC Swagger.

## Usuario:
Cadastro de usuario<br>
Listar usuarios somente para usuario com permissão ADMIN.<br>
Atualizar usuario.<br>
Excluir Usuario somente para usuario com permissão ADMIN.

## Ticket:
Abertura de chamado.<br>
Listar chamados.<br>
Atualizar chamados.<br>
Excluir chamado, somente para usuario com permissão ADMIN.


## Executar o projeto
Dentro do diretorio utilizando o terminal digite:

# mvn clean install.

Finalizando com sucesso

## Execute.

# mvn spring-boot:run

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MySQL](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[Lombok](https://projectlombok.org)**
- **[Swagger](https://swagger.io/docs/specification/about/)**
- **[SpringSecurity](https://docs.spring.io/spring-security/reference/index.html)**
