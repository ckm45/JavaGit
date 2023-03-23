package com.ckm.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookFunction {
    Integer backUpId = null;
    BookInfo backUpBook = null;

    Map<Integer, BookInfo> books = new HashMap<>();

    public void borrowBooks() {

        for (BookInfo bookinfo : books.values()) {
            if (bookinfo.isStatus() == true) {
                System.out.println(bookinfo);
            }
        }
    }

    public void selectBooks() { // 도서 조회
        Set<Integer> keySet = books.keySet();
        for (Integer key : keySet) {
            System.out.println(books.get(key));
        }
    }

    public void addBooks(BookInfo bookInfo) { // 책 등록
        books.put(bookInfo.getBookId(), bookInfo);
    }


    public void editBooks(int id, String bookName, String publishDate, boolean status) { // 책 정보 수정
        books.get(id).setBookName(bookName);
        books.get(id).setPublishDate(publishDate);
        books.get(id).setStatus(status);
    }

    public void deleteBooks(int id) { // 회원 삭제
        boolean check = false;
        backUpId = id;
        backUpBook = books.get(backUpId);
        Set<Integer> keySet = books.keySet();
        for (Integer key : keySet) {
            if (key == id) {
                books.remove(key);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("삭제할 책이 없습니다.");
        }

    }

    public void returnBooks() {
        if (backUpId == null) {
            System.out.println("복구할 책이 없습니다.");
        } else {
            books.put(backUpId, backUpBook);
            backUpId = null;
            backUpBook = null;
        }

    }

    // 대출 가능한 책만 볼 수 있다
    // 최근 출간된 순서대로 볼 수 있다



}
