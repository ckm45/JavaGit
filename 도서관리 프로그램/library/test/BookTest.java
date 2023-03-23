package com.ckm.library.test;

import java.util.Map;

import com.ckm.library.BookFunction;
import com.ckm.library.BookInfo;
import com.ckm.library.csv.Exportlist;

public class BookTest {
    public static void main(String[] args) {

        BookInfo bookInfo1 = new BookInfo("책이름", "2020/10/10", true);
        BookInfo bookInfo2 = new BookInfo("책이름1", "2020/10/10", false);
        BookInfo bookInfo3 = new BookInfo("책이름2", "2020/10/10", true);
        
        
        BookFunction bookFunction = new BookFunction();
        bookFunction.addBooks(bookInfo1);
        bookFunction.addBooks(bookInfo2);
        bookFunction.addBooks(bookInfo3);
        
        bookFunction.selectBooks();
        
        bookFunction.deleteBooks(1);
        
        System.out.println();
        bookFunction.selectBooks();
        
        System.out.println();
        bookFunction.returnBooks();
        bookFunction.selectBooks();
        

        System.out.println("자자~");
        bookFunction.borrowBooks();
        
        Exportlist el = new Exportlist();
        el.exportBook(bookFunction.getBooks());
        
        //el.exportLoan(lm.getList());
    }
}
