package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatpoint.logger.AppLogger;
import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;
import com.javatpoint.response.BooksResponse;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        booksRepository.findAll().forEach(books::add);
        return books;
    }

    public Books getBooksById(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Books books) {
        booksRepository.save(books);
    }

    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public boolean isBookExistsByName(String bookname) {
        List<Books> books = getAllBooks();
        for (Books book : books) {
            if (book.getBookname().equalsIgnoreCase(bookname)) {
                return true;
            }
        }
        return false;
    }
}
