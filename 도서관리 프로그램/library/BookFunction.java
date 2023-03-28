package com.ckm.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookFunction {

	List<BookInfo> books = new ArrayList<>();
	List<BookInfo> backUpBook = new ArrayList<>(1);
	List<BookInfo> loanableBooks = new ArrayList<>();
	

	public List<BookInfo> getBooks() {
		return books;
	}

	public void setBooks(List<BookInfo> books) {
		this.books = books;
	}

//	public void borrowBooks() {
//
//        for (BookInfo bookinfo : books.values()) {
//            if (bookinfo.isStatus() == true) {
//                System.out.println(bookinfo);
//            }
//        }
//    }

	public void selectBooks() { // 도서 조회
		for (BookInfo book : books) {
			System.out.println(book.toString());
		}
	}
	public void selectLoanableBook() {
		for (BookInfo book : books) {
			if(book.isStatus() == true) {
				loanableBooks.add(book);
			}			
		}
		for (BookInfo book : loanableBooks) {
			System.out.println(book.toString());
		}
	}
	

	public void addBooks(BookInfo bookInfo) { // 책 등록
		books.add(bookInfo);
	}

	public void editBooks(int id, String bookName, String publishDate, boolean status) { // 책 정보 수정
		books.get(id).setBookName(bookName);
		books.get(id).setPublishDate(publishDate);
		books.get(id).setStatus(status);
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

	// 대출 가능한 책만 볼 수 있다
	// 최근 출간된 순서대로 볼 수 있다

}
