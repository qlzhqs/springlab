package kz.narhoz.springlab.repository;

import kz.narhoz.springlab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
