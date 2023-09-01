package com.example.graphql;

import com.example.graphql.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private GraphQLService graphQLService;

    @QueryMapping
    public List<Book> getAllBooks() {
        return graphQLService.getAllBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument("id") Long id) {
        return graphQLService.getBookById(id).orElse(null);
    }

    @MutationMapping
    public Book createBook(@Argument("title") String title, @Argument("authorId") Long authorId) {
        return graphQLService.createBook(title, authorId);
    }

    @MutationMapping
    public Book updateBook(@Argument("id") Long id, @Argument("title") String title) {
        return graphQLService.updateBook(id, title);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument("id") Long id) {
        return graphQLService.deleteBook(id);
    }

}
