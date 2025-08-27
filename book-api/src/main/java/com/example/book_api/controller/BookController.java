package com.example.book_api.controller;


import com.example.book_api.model.Book;
import com.example.book_api.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //add a Book
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    //fetch all books
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    //fetch book by id
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable int bookId){
        return bookService.getBookById(bookId);
        }

    //update a specific book
    @PutMapping("/{bookId}")
    public Book updateBookById(@PathVariable int bookId,@RequestBody Book updatedBook) {
    return bookService.updateBook(bookId,updatedBook);
    }

    //delete a specific book
    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable int bookId){
        boolean removed = bookService.deleteBook(bookId);
        return removed ? "Book with ID " + bookId + " Deleted Successfully" : "Book with ID " + bookId +" Not Found!";
    }

    //search the book with the help of the authors name
    @GetMapping("/search")
    public List<Book> getBooksByAuthorName(@RequestParam String authorName){
        return bookService.getBooksByAuthorName(authorName);
    }

    //filter the books by price
    @GetMapping("/filter")
    public List<Book> getBooksCheaperThan(@RequestParam("bookPrice")double bookPrice){
        return bookService.getBooksCheaperThan(bookPrice);
    }

    //get the total number of books
    @GetMapping("/count")
    public int getTotalBooks(){
        return bookService.getTotalNumberOfBooks();
    }

    //fetch the most expensive book available
    @GetMapping("/expensive")
    public Book getTheMostExpensiveBook(){
        return bookService.getMostExpensiveBook();
    }
}
