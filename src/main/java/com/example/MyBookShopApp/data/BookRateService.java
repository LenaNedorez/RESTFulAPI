package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRateService {

    private BookRateRepository bookRateRepository;

    @Autowired
    public BookRateService(BookRateRepository bookRateRepository) {
        this.bookRateRepository = bookRateRepository;
    }

    public BookRate postBookRate(BookRate bookRate){
        return bookRateRepository.save(bookRate);
    }

    public List<BookRate> getAllRates() {
        return bookRateRepository.findAll();
    }

    public Integer getRating(){
        return Math.round( bookRateRepository.sumOfBookRates() / bookRateRepository.count());
    }
}
