# java-spring-boot-graphql

This project serves as an example of how to implement a GraphQL API using Java Spring Boot. GraphQL is a query language for your API and a server-side runtime for executing queries by using a type system you define for your data. Unlike traditional REST APIs, GraphQL allows clients to request only the specific data they need, reducing over-fetching and under-fetching of data.

## Goals of GraphQL

The goals of using GraphQL in this project are:

- Efficient Data Fetching: GraphQL enables clients to request only the specific data they need, preventing over-fetching of data common in REST APIs.

- Flexible Data Composition: Clients can define complex queries and receive all the required data in a single request.

- API Documentation: The GraphQL schema serves as self-documenting documentation for the API, making it easier for clients to understand the available operations and types.

- Versioning Control: GraphQL reduces the need for versioning by allowing the addition of new fields without affecting existing queries.

- Optimized Mobile and Web Apps: GraphQL provides efficient data transfer for mobile and web applications, reducing data transfer and optimizing app performance.

## Requirements
[Docker](https://www.docker.com/)

## Technologies 
[Java 17 (openjdk)](https://openjdk.org/projects/jdk/17/), [Maven](https://maven.apache.org/), [Spring Boot](https://spring.io/projects/spring-boot), [GraphQL](https://graphql.org/)

## sh folder

The sh folder allows you to quickly launch docker commands to perform tasks

## Build project
On the root folder
```bash
sh sh/build
```

## Run the project
```bash
sh sh/deploy
```

The service is deployed at http://localhost:8085/graphql

## Graphiql

GraphiQL is an in-browser IDE that provides a powerful and interactive interface for exploring and testing GraphQL APIs. It allows you to compose and execute GraphQL queries, view documentation, and see real-time responses.
He is deployed at http://localhost:8085/graphiql

## Query

Get all books : 
```graphql
{
  getAllBooks {
    id
    title
    author {
      id
      name
    }
  }
}
```

Get Book By ID:
```graphql
{
  getBookById(id: "1") {
    id
    title
    author {
      id
      name
    }
  }
}
```

Create Book:
```graphql
mutation {
  createBook(title: "New Book Title", authorId: 1) {
    id
    title
    author {
      id
      name
    }
  }
}
```

Update Book:
```graphql
mutation {
  updateBook(id: 1, title: "Updated Book Title") {
    id
    title
    author {
      id
      name
    }
  }
}
```

Delete Book:
```grapql
mutation {
  deleteBook(id: 1)
}
```
