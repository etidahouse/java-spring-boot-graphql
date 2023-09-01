package com.example.graphql;

import com.example.graphql.entities.Author;
import com.example.graphql.entities.Book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GraphQLService {

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private AtomicLong authorIdCounter = new AtomicLong(1);
    private AtomicLong bookIdCounter = new AtomicLong(1);

    public GraphQLService() {
        Author author = new Author(authorIdCounter.getAndIncrement(), "John Doe");
        authors.add(author);

        Book book1 = new Book(bookIdCounter.getAndIncrement(), "Book One", author);
        Book book2 = new Book(bookIdCounter.getAndIncrement(), "Book Two", author);
        books.add(book1);
        books.add(book2);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book createBook(String title, Long authorId) {
        Author author = authors.stream()
                .filter(a -> a.getId().equals(authorId))
                .findFirst()
                .orElse(null);

        if (author != null) {
            Book newBook = new Book(bookIdCounter.getAndIncrement(), title, author);
            books.add(newBook);
            return newBook;
        } else {
            // Handle author not found scenario
            return null;
        }
    }

    public Book updateBook(Long id, String title) {
        Optional<Book> bookToUpdate = books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    
        if (bookToUpdate.isPresent()) {
            Book updatedBook = bookToUpdate.get();
            updatedBook.setTitle(title);
            return updatedBook;
        } else {
            // Handle book not found scenario
            return null;
        }
    }

    public Boolean deleteBook(Long id) {
        Optional<Book> bookToDelete = books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    
        if (bookToDelete.isPresent()) {
            books.remove(bookToDelete.get());
            return true;
        } else {
            // Handle book not found scenario
            return false;
        }
    }    
    
}
