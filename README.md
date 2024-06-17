# Desafio do curso Java: persistência de dados e consultas com Spring Data JPA

## A ideia do desafio é utilizar os conceitos e ferramentas aprendidas ao longo deste curso e da formação anterior, Java: trabalhando com lambdas, streams e Spring Framework.

O desafio proposto requer que seja criado uma classe Artista que tenha entre seus atributos um ENUM tipo do artista para caracterizar se aquele artista é solo, dupla ou banda; também como atributo do Artista é uma lista de Músicas. 
A classe de Música deve fazer referência ao Artista. Os demais atributos de cada classe ficam à critério.

É necessário também que o projeto persista os dados em um banco de dados SQL, no meu caso escolhi o MySQL; é também fazer conexão com a API da OpenAi para obter os dados de algum artista solicitado pelo usuário. 
O desafio é um projeto de linha de comando, então fiz uso da interface CommandLineInterface. 

Uma melhor descrição do desafio e de seu código proposto pelas instrutoras pode ser visto no GitHub da Alura: https://github.com/alura-cursos/3355-java-desafio
