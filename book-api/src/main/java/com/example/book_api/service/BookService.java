package com.example.book_api.service;

import com.example.book_api.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private static final List<Book> books = new ArrayList<>();

    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int bookId){
        return books.stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst()
                .orElse(null);
    }

    public Book updateBook(int bookId, Book updatedBook){
        for(Book book : books){
            if(book.getBookId()==bookId){
                book.setBookTitle(updatedBook.getBookTitle());
                book.setBookAuthor(updatedBook.getBookAuthor());
                book.setBookPrice(updatedBook.getBookPrice());
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int bookId){
        return books.removeIf(b -> b.getBookId() == bookId);
    }

    public List<Book> getBooksByAuthorName(String authorName){
        return books.stream()
                .filter(b -> b.getBookAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());

    }

    public List<Book> getBooksCheaperThan(double bookPrice){
        return books.stream()
                .filter(b -> b.getBookPrice() < bookPrice)
                .collect(Collectors.toList());
    }

    public int getTotalNumberOfBooks(){
        return books.size();
    }

    public Book getMostExpensiveBook(){
        return books.stream()
                .max(Comparator.comparing(Book::getBookPrice))
                .orElse(null);
    }
}
