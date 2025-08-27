Book API – Spring Boot CRUD operations without the usage of a database
This project is a simple Spring Boot REST API for managing a collection of books using CRUD operations and in-memory storage (no database).

It demonstrates the use of:

@RestController, @RequestMapping, @GetMapping, @PostMapping, etc.
@RequestParam, @PathVariable, @RequestBody
Static in-memory list as data store
Project Requirements & Features
1. Dependencies
Added in pom.xml:

spring-boot-starter-web
spring-boot-devtools (used for hot reload)
lombok (used for reducing boilerplate code)
spring-boot-starter-test (for testing)
2. How to Run
# Run with Maven
mvn spring-boot:run

# Or run the main class directly
BookManagementSystemApplication.java
3.Features
Make Sure the project is running on port 8080

Add a new book (POST /books)
Get all books (GET /books)
Get a book by ID (GET /books/{bookId})
Update a book (PUT /books/{bookId})
Delete a book (DELETE /books/{bookId})
Search books by author (GET /books/search?bookAuthor=...)
Filter books cheaper than a price (GET /books/filter?bookPrice=...)
Get total number of books (GET /books/count)
Get the most expensive book (GET /books/expensive)
