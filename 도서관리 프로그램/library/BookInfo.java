package com.ckm.library;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BookInfo implements Comparable<BookInfo> {

    private int bookId; // 책 id
    private String bookName; // 책이름
    private String publishDate; // 출판날짜
    private boolean status; // 대출 상태


    public BookInfo(int bookId, String bookName, String publishDate, boolean status) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.publishDate = publishDate;
        this.status = status;
    }



    public int getBookId() {
        return bookId;
    }



    public void setBookId(int bookId) {
        this.bookId = bookId;
    }



    public String getBookName() {
        return bookName;
    }



    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



    public String getPublishDate() {
        return publishDate;
    }



    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }



    public boolean isStatus() {
        return status;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, publishDate, status);
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookInfo other = (BookInfo) obj;
        return bookId == other.bookId && Objects.equals(bookName, other.bookName)
                && Objects.equals(publishDate, other.publishDate) && status == other.status;
    }



    @Override
    public String toString() {
        return "BookInfo [bookId=" + bookId + ", bookName=" + bookName + ", publishDate="
                + publishDate + ", status=" + status + "]";
    }

    @Override
    public int compareTo(BookInfo o) {
        return this.publishDate.compareTo(o.publishDate);
    }



}
