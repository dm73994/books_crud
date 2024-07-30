package com.library_test.library_test.services;

import com.library_test.library_test.Validators.BookValidator;
import com.library_test.library_test.models.Book;
import com.library_test.library_test.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class BookService {
    private final BookRepository repo;
    @PersistenceContext
    private EntityManager entityManager;

    public BookService(BookRepository repo){
        this.repo = repo;
    }

    public List<Book> getAllBooks(){
        return this.repo.findAll();
    }

    public Book createBook(BookValidator newBook){
        Book book = new Book();
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setPublisher(newBook.getPublisher());
        book.setDescription(newBook.getDescription());
        book.setReleaseDate(newBook.getReleaseDate());


        return this.repo.save(book);
    }

    public void updateBookData(BookValidator newBookData, Integer id){
        Book book = new Book();
        book.setTitle(newBookData.getTitle());
        book.setAuthor(newBookData.getAuthor());
        book.setPublisher(newBookData.getPublisher());
        book.setDescription(newBookData.getDescription());
        book.setReleaseDate(newBookData.getReleaseDate());
        this.repo.updateBookById(id, book.getTitle(), book.getAuthor(), book.getPublisher(), book.getReleaseDate(), book.getDescription());
    }

    public void deleteBook(Integer bookId){
        this.repo.deleteById(bookId);
    }

    public List<Book> findBooksByCriteria(String title, String author, String publisher){
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> bookQuery = criteria.createQuery(Book.class);

        Root<Book> book = bookQuery.from(Book.class);
        List<Predicate> predicates = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            predicates.add(criteria.like(criteria.lower(book.get("title")), STR."%\{title.toLowerCase()}%"));
        }

        if (author != null && !author.isEmpty()) {
            predicates.add(criteria.like(criteria.lower(book.get("author")), STR."%\{author.toLowerCase()}%"));
        }

        if (publisher != null && !publisher.isEmpty()) {
            predicates.add(criteria.like(criteria.lower(book.get("publisher")), STR."%\{publisher.toLowerCase()}%"));
        }

        //if (releaseYear != null) {
            //predicates.add(criteria.equal(criteria.function("year", Integer.class, book.get("releaseDate")), releaseYear));
        //}

        bookQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(bookQuery).getResultList();
    }
}
