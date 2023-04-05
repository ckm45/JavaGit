package com.ckm.library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Loan {
    
    
    
    
	private int memberID;
	//private String memberName;
	private int bookID;
	//private String bookName;
	private boolean extensionAvailable; // 연장 가능여부
	private String returnDate; //반납일

	public Loan(int memberID, int bookID) {
		this.memberID = memberID;
		this.bookID = bookID;

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, 14); // 2주(14일)를 더함
		this.returnDate = format.format(cal);
		this.extensionAvailable = true;
		
		
	}

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public boolean isExtensionAvailable() {
        return extensionAvailable;
    }

    public void setExtensionAvailable(boolean extensionAvailable) {
        this.extensionAvailable = extensionAvailable;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan [memberID=" + memberID + ", bookID=" + bookID + ", extensionAvailable="
                + extensionAvailable + ", returnDate=" + returnDate + "]";
    }

}
