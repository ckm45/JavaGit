package com.ckm.library;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Loan {
	private int memberID;
	private int bookID;
	private boolean extensionAvailable; // 연장 가능여부
	private String returnDate; //반납일

	public Loan(int memberID, int bookID) {
		this.memberID = memberID;
		this.bookID = bookID;

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		this.returnDate = format.format(now);
		
		calendar.add(Calendar.DATE, 14);
		this.returnDate = calendar.getTime();
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
		return ExtensionAvailable;
	}

	public void setExtensionAvailable(boolean extensionAvailable) {
		ExtensionAvailable = extensionAvailable;
	}

	public int getReturnPeriod() {
		return returnPeriod;
	}

	public void setReturnPeriod(int returnPeriod) {
		this.returnPeriod = returnPeriod;
	}

	@Override
	public String toString() {
		return "Loan [memberID=" + memberID + ", bookID=" + bookID + ", ExtensionAvailable=" + ExtensionAvailable
				+ ", returnPeriod=" + returnPeriod + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ExtensionAvailable, bookID, memberID, returnPeriod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return ExtensionAvailable == other.ExtensionAvailable && bookID == other.bookID && memberID == other.memberID
				&& returnPeriod == other.returnPeriod;
	}

}
