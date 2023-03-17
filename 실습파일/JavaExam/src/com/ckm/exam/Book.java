package com.ckm.exam;

import java.util.Date;
import java.util.Objects;
import com.ckm.game.Student;

public class Book implements Comparable<Book> {
    private String title;
    private Date publishDate;
    private String comment;

    public Book(String title, Date publishDate, String comment) {

        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", publishDate=" + publishDate + ", comment=" + comment
                + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishDate, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(publishDate, other.publishDate) && Objects.equals(title, other.title);
    }

    @Override
    public int compareTo(Book book) {
        return this.publishDate.compareTo(book.publishDate); // 출판일 publishDate을 기준으로 정렬하겠다.
    }

    // Cloneable 인터페이스 사용하지 않는다. clone메서드 꼭 쓸 이유가 없다
    // 직접 copy 라는 복사하는 메소드를 만들어 사용하자
    public Book copy() {
        Book result = new Book(title, publishDate, comment);
        result.title = this.title;
        result.publishDate = (Date) this.publishDate.clone();
        result.comment = this.comment;
        return result;
    }



}
