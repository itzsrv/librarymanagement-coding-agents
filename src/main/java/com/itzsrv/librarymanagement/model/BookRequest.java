package com.itzsrv.librarymanagement.model;

import java.util.Date;

public class BookRequest {
    private String name;
    private String author;
    private String publisher;
    private Double price;
    private Date issueDate;
    private BookCategory category;
    private BookStatus status;

    public BookRequest(String name, String author, String publisher, Double price, BookCategory category, BookStatus status) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", issueDate=" + issueDate +
                ", category=" + category +
                ", status=" + status +
                '}';
    }
}
