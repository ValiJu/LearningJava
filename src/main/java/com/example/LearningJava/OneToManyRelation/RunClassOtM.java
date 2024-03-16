package com.example.LearningJava.OneToManyRelation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RunClassOtM {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    //@PostConstruct
    public void run() {
        AuthorEntity authorEntity1 = AuthorEntity.builder().name("Eminescu").build();
        BookEntity bookEntity1 = BookEntity.builder().title("EmBook1").author(authorEntity1).build();
        BookEntity bookEntity2 = BookEntity.builder().title("EmBook2").author(authorEntity1).build();
        BookEntity bookEntity3 = BookEntity.builder().title("EmBook3").author(authorEntity1).build();
        List<BookEntity> bookEntities = Arrays.asList(bookEntity1, bookEntity2, bookEntity3);
        authorEntity1.setBooks(bookEntities);

        //authorRepository.save(authorEntity);

        AuthorEntity authorEntity2 = AuthorEntity.builder().name("Bacovia").build();
        BookEntity bookEntity4 = BookEntity.builder().title("Corola").build();
        //authorRepository.save(authorEntity2);
        bookEntity4.setAuthor(authorEntity2);
        //bookRepository.save(bookEntity4);

        List<BookEntity> allBooks = bookRepository.findAll();
        List<AuthorEntity> allAuthors = authorRepository.findAll();
        List<BookEntity> booksByAuthorId = bookRepository.findByAuthorId(allAuthors.get(0).getId());
        Optional<AuthorEntity> authorEntity = authorRepository.findByBooksId(allBooks.get(0).getId());

    }
}
