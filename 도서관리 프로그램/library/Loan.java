package com.ckm.library;

import java.util.List;
import java.util.Objects;

public class Loan {


    private int loanID;
    private String memberName;
    private String bookName;
    private String loanDate; // 대출일
    private String returnDate; // 반납일
    private boolean extensionAvailable; // 연장 가능여부
    private boolean renewStatus; // 반납 여부

    public Loan(int loanID, String memberName, String bookName, String loanDate, String returnDate,
            boolean extensionAvailable) {
        super();
        this.loanID = loanID;
        this.memberName = memberName;
        this.bookName = bookName;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.extensionAvailable = extensionAvailable;
    }



    public int getLoanID() {
        return loanID;
    }



    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }



    public String getMemberName() {
        return memberName;
    }



    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }



    public String getBookName() {
        return bookName;
    }



    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



    public String getLoanDate() {
        return loanDate;
    }



    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }



    public String getReturnDate() {
        return returnDate;
    }



    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }



    public boolean isExtensionAvailable() {
        return extensionAvailable;
    }



    public void setExtensionAvailable(boolean extensionAvailable) {
        this.extensionAvailable = extensionAvailable;
    }



    public boolean isRenewStatus() {
        return renewStatus;
    }



    public void setRenewStatus(boolean renewStatus) {
        this.renewStatus = renewStatus;
    }



    @Override
    public String toString() {
        return "Loan [loanID=" + loanID + ", memberName=" + memberName + ", bookName=" + bookName
                + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", extensionAvailable="
                + extensionAvailable + ", renewStatus=" + renewStatus + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, extensionAvailable, loanDate, loanID, memberName, renewStatus,
                returnDate);
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
        return Objects.equals(bookName, other.bookName)
                && extensionAvailable == other.extensionAvailable
                && Objects.equals(loanDate, other.loanDate) && loanID == other.loanID
                && Objects.equals(memberName, other.memberName) && renewStatus == other.renewStatus
                && Objects.equals(returnDate, other.returnDate);
    }



}
