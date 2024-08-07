# API de Envio de Email em Java + Spring Boot

Esta API de envio de email foi desenvolvida utilizando Java e Spring Boot com conceitos de Arquitetura Limpa. O projeto tem como objetivo fornecer uma base para aprendizado e integração com o Amazon SES (Simple Email Service).

## Funcionalidades

A API contempla as seguintes funcionalidades:

- **Envio de Email**: Permite o envio de emails utilizando o Amazon SES.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para simplificar a configuração e o desenvolvimento da API.
- **Amazon SES**: Serviço de e-mail baseado na nuvem que oferece uma solução econômica, flexível e escalável para que empresas de todos os portes se comuniquem com seus clientes por e-mail.

## Endpoints

### Envio de Email

- **Método**: POST
- **URL**: `/api/email`
- **Descrição**: Envia um email utilizando o serviço Amazon SES.
- **Corpo da Requisição**: O corpo da requisição deve conter os seguintes parâmetros em formato JSON:
  - `to`: Endereço de email do destinatário.
  - `subject`: Assunto do email.
  - `body`: Corpo do email.

- **Resposta**: A resposta inclui o status do envio e, caso haja um erro, uma mensagem de erro detalhada.

## Exemplo de Requisição

```json
{
  "to": "exemplo@dominio.com",
  "subject": "Assunto do Email",
  "body": "Conteúdo do email."
}
