package com.example.book_social_netwok.book;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> withOwnerId(Integer ownerId){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId));
    }
}
