package com.ckm.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.ckm.library.csv.MakeList;

public class BookFunction {
    MakeList makelist = new MakeList();

    List<BookInfo> books = makelist.booklist();

    List<BookInfo> backUpBook = new ArrayList<>(1);
    List<BookInfo> loanableBooks = new ArrayList<>();



    public void selectBooks() { // 도서 조회
        Collections.sort(books); // 출간일 기준으로 정렬
        for (BookInfo book : books) {
            System.out.println(book.toString());
        }

    }

    public void selectLoanableBook() { // 대출 가능한 책 조회
        for (BookInfo book : books) {
            if (book.isStatus() == true) {
                loanableBooks.add(book);
            }
        }
        for (BookInfo book : loanableBooks) {
            System.out.println(book.toString());
        }
    }

    public void loanBook(String name) {           //반납 여부를 false로 바꾼다
        for (BookInfo book : books) {
            if (book.getBookName().equals(name)) {
                book.setStatus(false);
            }
        }
    }



    public void addBooks(BookInfo bookInfo) { // 책 등록
        books.add(bookInfo);
    }

    public void editBooks(int updateNumber, int id, String updateContent) { // 책 정보 수정
        for (BookInfo book : books) {
            if (book.getBookId() == id) {
                if (updateNumber == 1) {
                    book.setBookName(updateContent);
                } else if (updateNumber == 2) {
                    book.setPublishDate(updateContent);


                }
            }
        }
    }

    public void deleteBooks(int id) { // 책 삭제
        boolean check = false;

        for (BookInfo bookInfo : books) {
            if (id == bookInfo.getBookId()) {
                if (backUpBook.size() != 0) {
                    backUpBook.set(0, bookInfo);
                    books.remove(bookInfo);
                    check = true;
                    break;
                } else {
                    backUpBook.add(bookInfo);
                    books.remove(bookInfo);
                    check = true;
                    break;

                }
            }

        }
    }

    public void returnBooks() {
        if (backUpBook == null) {
            System.out.println("복구할 책이 없습니다.");
        } else {
            books.add(backUpBook.get(0));
            backUpBook.remove(0);
        }

    }

    public List<BookInfo> getBookList() {
        return books;
    }
    // 대출 가능한 책만 볼 수 있다
    // 최근 출간된 순서대로 볼 수 있다

}
