package com.library_test.library_test.controllers;

import com.library_test.library_test.models.Book;
import com.library_test.library_test.services.BookService;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/all")
    @Timed(value = "Get.Allbooks.time", description = "Time tekn to execute get endpoint to list all books")
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> books = this.bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/query")
    @Timed(value = "Get.findBookByQerys.time", description = "Time taken to execute get endpoint to get a book by filters")
    public ResponseEntity<List<Book>> findBookByQuerys(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) Integer releaseYear
    ){
        List<Book> book = this.bookService.findBooksByCriteria(title, author, publisher, releaseYear);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    @Timed(value = "Post.create book.time", description = "Time taken to execute post endpoint to create a book")
    public ResponseEntity<Book> createBook(@RequestBody Book newBook){
        Book serviceBook = this.bookService.createBook(newBook);
        return new ResponseEntity<>(serviceBook, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @Timed(value = "Post.createBook.time", description = "Time taken to execute post endpoint to create a book")
    public void updateBook(@RequestBody Book newBookData, @PathVariable Integer id){
        newBookData.setId(id);
        this.bookService.updateBookData(newBookData);
    }


    @DeleteMapping("/{id}")
    @Timed(value = "Delete.book.time", description = "Time taken to execute delete endpoint to delete a book")
    public void deleteBook(@PathVariable Integer id){
        this.bookService.deleteBook(id);
    }
}
