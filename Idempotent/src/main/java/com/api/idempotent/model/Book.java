package com.api.idempotent.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of={"id"})
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "book_name" ,nullable = false)
    private String book_name;
}
