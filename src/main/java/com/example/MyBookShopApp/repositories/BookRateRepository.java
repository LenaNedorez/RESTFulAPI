package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entities.BookRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRateRepository extends JpaRepository<BookRate, Integer> {

    @Query("SELECT SUM(bookRate.rate) FROM BookRate bookRate")
    Float sumOfBookRates();

    BookRate save(BookRate bookRate);
}
