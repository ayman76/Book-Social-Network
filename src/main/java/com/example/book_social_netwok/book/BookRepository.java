package com.example.book_social_netwok.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("""
        SELECT book
        FROM Book book
        WHERE book.archived = false
        AND book.owner.id != :userId
        """)
    Page<Book> findAllDisplayableBooks(Pageable pageable, Integer userId);
}
