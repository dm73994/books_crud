package com.library_test.library_test.repository;

import com.library_test.library_test.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleContainingIgnoreCase(@Param("queryName") String queryName);
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.title = :title, b.author = :author, b.releaseDate = :releaseDate, b.publisher = :publisher, b.description = :description WHERE b.id = :id")
    void updateBookById(@Param("id") Integer id,
                       @Param("title") String title,
                       @Param("author") String author,
                        @Param("publisher") String publisher,
                       @Param("releaseDate") LocalDate releaseDate,
                       @Param("description") String description);
}

// SELECT * FROM Book WHERE title LIKE LOWER 'crimen%';
// SELECT * FROM Book;
