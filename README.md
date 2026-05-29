# Portfolio API - Backend Architecture

Este repositório comporta a API RESTful de alta performance que serve como o motor do meu portfólio profissional. O ecossistema foi desenhado seguindo princípios rígidos de **Clean Architecture**, **Clean Code** e a metodologia **12-Factor App**, garantindo isolamento completo de dependências, escalabilidade e manutenibilidade.

## 🚀 Tecnologias e Ferramentas

- **Java 21**: Utilização de recursos modernos da linguagem (Record types, Pattern Matching, instâncias eficientes).
- **Spring Boot 3.x**: Framework central para gerenciamento de inversão de controlo (IoC) e injeção de dependências.
- **Spring Data JPA & Hibernate**: Camada de persistência robusta com mapeamento objeto-relacional (ORM).
- **PostgreSQL**: Banco de dados relacional de produção hospedado na nuvem gerenciada da **Aiven**.
- **Cloudinary SDK**: Integração nativa para processamento e armazenamento em nuvem de mídias e ficheiros binários estáticos.
- **Maven**: Gestor de dependências e automação de build do ciclo de vida da aplicação.

## 🏛️ Padrão Arquitetural

A aplicação adota uma arquitetura em camadas bem definidas para impor a separação de responsabilidades (Single Responsibility Principle):

1. **Camada de Domínio / Entidades (`domain`)**: Contém os modelos de negócio puros mapeados pelo JPA. Chaves primárias baseadas rigorosamente em **UUID** para mitigar vulnerabilidades de enumeração id-guessing.
2. **Camada de Acesso a Dados (`repository`)**: Interfaces que estendem `JpaRepository`, isolando totalmente as instruções SQL da lógica de negócio.
3. **Camada de Negócio / Orquestração (`service`)**: Centraliza as regras do sistema, como o isolamento do upload de imagens via SDK externo do Cloudinary.
4. **Camada de Entrada / HTTP (`controller`)**: Controladores REST expostos e protegidos, lidando tanto com payloads JSON puros quanto com requisições complexas `multipart/form-data`.

## 📌 Endpoints da API

### Projetos (`/api/projects`)
- `POST`: Cria um novo projeto na vitrine técnica. Aceita dados textuais e um ficheiro binário de imagem (`multipart/form-data`). Realiza o upload para o Cloudinary e persiste o link seguro (`https`) na nuvem PostgreSQL.
- `GET`: Retorna a listagem completa dos projetos integrados para alimentação dinâmica do frontend.

### Serviços Oferta (`/api/services`)
- `POST`: Regista uma nova oferta de serviço especializada através de payload JSON.
- `GET`: Fornece os cards dinâmicos estruturados com referências de ícones tipados.

### Solicitações de Contacto (`/api/contacts`)
- `POST`: Envia uma mensagem de contacto ou proposta de recrutamento diretamente para persistência em auditoria no banco de dados.

## 🔒 Configuração e Segurança (12-Factor App Compliance)

Seguindo as boas práticas de segurança em nuvem, o projeto **não armazena arquivos físicos de credenciais ou chaves privadas** no código-fonte. O ficheiro `.gitignore` bloqueia qualquer ficheiro de configuração local.

A inicialização e o provisionamento de recursos locais ou de produção dependem exclusivamente da injeção de variáveis de ambiente no sistema operacional ou no contêiner da JVM:

```env
DB_URL=jdbc:postgresql://<host>:<port>/<database>?sslmode=require
DB_USER=...
DB_PASSWORD=...
CLOUDINARY_CLOUD_NAME=...
CLOUDINARY_API_KEY=...
CLOUDINARY_API_SECRET=...
