package com.ckm.logics;

public class Book extends TangibleAsset {
    private String isbn;

    public Book(String name, int price, String color, String isbn) {
        super(name, price, color); // 자식 클래스의 생성자가 부모 클래스의 생성자를 호출한다.
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
