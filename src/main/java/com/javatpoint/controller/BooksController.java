package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javatpoint.logger.AppLogger;
import com.javatpoint.model.Books;
import com.javatpoint.response.BooksResponse;
import com.javatpoint.service.BooksService;

@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/book")
    private BooksResponse getAllBooks() {
        List<Books> books = booksService.getAllBooks();
        AppLogger.LOGGER.info("All books fetched successfully.");
        return new BooksResponse("Books fetched successfully.", books);
    }

    @GetMapping("/book/{bookid}")
    private BooksResponse getBooks(@PathVariable("bookid") int bookid) {
        Books book = booksService.getBooksById(bookid);
        if (book != null) {
            AppLogger.LOGGER.info("Book with ID {} fetched successfully.", bookid);
            return new BooksResponse("Book fetched successfully.", book);
        } else {
            AppLogger.LOGGER.warn("Book with ID {} not found.", bookid);
            return new BooksResponse("Book with ID " + bookid + " not found.", null);
        }
    }

    @DeleteMapping("/book/{bookid}")
    private BooksResponse deleteBook(@PathVariable("bookid") int bookid) {
        booksService.delete(bookid);
        AppLogger.LOGGER.info("Book with ID {} deleted successfully.", bookid);
        return new BooksResponse("Book with ID " + bookid + " deleted successfully.", null);
    }

    @PostMapping("/books")
    private BooksResponse saveBook(@RequestBody Books books) {
        if (booksService.isBookExistsByName(books.getBookname())) {
            AppLogger.LOGGER.warn("Book with name '{}' already exists.", books.getBookname());
            return new BooksResponse("Book already exists in the database", null);
        } else {
            booksService.saveOrUpdate(books);
            AppLogger.LOGGER.info("Book '{}' saved successfully.", books.getBookname());
            return new BooksResponse("Book saved successfully.", booksService.getAllBooks());
        }
    }

    @PutMapping("/books")
    private BooksResponse update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        AppLogger.LOGGER.info("Book with ID {} updated successfully.", books.getBookid());
        return new BooksResponse("Book updated successfully.", books);
    }
}
