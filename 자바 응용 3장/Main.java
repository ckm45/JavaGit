package com.ckm.exam;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        List<Book> books = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        books.add(new Book("a", format.parse("2023/11/20"), "a"));
        books.add(new Book("b", format.parse("2023/11/20"), "b"));
        books.add(new Book("c", format.parse("2023/12/25"), "c"));
        Collections.sort(books);
        System.out.println(books);

        Book book = new Book("a", format.parse("2023/11/20"), "a");
        Book book1 = book.copy();
        System.out.println(book);
        System.out.println(book1);



    }

}
