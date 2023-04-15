package com.ckm.library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.ckm.library.csv.MakeList;

public class LoanFunction {

	MakeList makelist = new MakeList();
	List<Loan> loans = makelist.loanlist();

	// 대출이력 조회
	public void selectLoanStatus(String name) {
		for (Loan loan : loans) {
			if (loan.getMemberName().equals(name)) {
				System.out.println(loan.toString());
			}
		}

	}

	// 책을 대출합니다.
	public void laonBook(Loan loan) {
		int id = 0;
		for (Loan l : loans) {
			id = Math.max(id, l.getLoanID() + 1); // ??
		}
		loan.setLoanID(id);
		loans.add(loan);
	}

	// 연장가능한 책 조회

	public boolean loanStatus(String name) {
		boolean result = false;
		for (Loan loan : loans) {

			if (loan.isExtensionAvailable() && loan.getMemberName().equals(name)) {
				 //&& loan.isRenewStatus()
				result = true;
				System.out.println(loan.toString());
			}
		}
		return result;
	}

	// 대출 연장
	public boolean loanExtention(String memberName, String bookName) {
		boolean result = false;
		for (Loan loan : loans) {
			if (loan.getMemberName().equals(memberName) && loan.getBookName().equals(bookName)) {
				result = true;
				LocalDate date = LocalDate.parse(loan.getReturnDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				date = date.plusDays(7);
				String newDateString = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				loan.setExtensionAvailable(result);
				loan.setReturnDate(newDateString);
				break;
							
			}
		}
		return result;
	}
	
    public List<Loan> getLoanList() {
        return loans;
    }

}
