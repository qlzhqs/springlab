package kz.narhoz.springlab.model;


import kz.narhoz.springlab.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    private String title;

    private String author;

    private String category;

    private int year;

    @ManyToOne
    private User owner;
}
