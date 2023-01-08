package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entities.Author;
import com.example.MyBookShopApp.entities.BookFile;

import java.sql.Date;
import java.util.List;

public class BookDto {

    private Integer id;

    private Date pubDate;

    private Author author;

    private Integer isBestseller;

    private String slug;

    private String title;

    private String image;

    private List<BookFile> bookFileList;

    private String description;

    private Integer priceOld;

    private Double price;

    public BookDto() {
    }

    public BookDto(Integer id, Date pubDate, Author author, Integer isBestseller, String slug, String title, String image, List<BookFile> bookFileList, String description, Integer priceOld, Double price) {
        this.id = id;
        this.pubDate = pubDate;
        this.author = author;
        this.isBestseller = isBestseller;
        this.slug = slug;
        this.title = title;
        this.image = image;
        this.bookFileList = bookFileList;
        this.description = description;
        this.priceOld = priceOld;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BookFile> getBookFileList() {
        return bookFileList;
    }

    public void setBookFileList(List<BookFile> bookFileList) {
        this.bookFileList = bookFileList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(Integer priceOld) {
        this.priceOld = priceOld;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
