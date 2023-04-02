package com.ckm.library;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Loan {
	private int memberID;
	private int bookID;
	private boolean ExtensionAvailable; // 연장 가능여부
	private int returnPeriod;
	private Date returnDate;

	public Loan(int memberID, int bookID, boolean extensionAvailable, int returnPeriod) {

		this.memberID = memberID;
		this.bookID = bookID;
		ExtensionAvailable = extensionAvailable;
		this.returnPeriod = returnPeriod;
	}

	public Loan(int memberID, int bookID) {
		this.memberID = memberID;
		this.bookID = bookID;

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, 14);
		this.returnDate = calendar.getTime();

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
