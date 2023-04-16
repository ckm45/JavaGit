package com.ckm;

import java.util.Objects;


public class Loan {
    private int loanID;
    private String memberId;
    private String bookId;
    private String loanDate; // 대출일
    private String returnDate; // 반납일
    private boolean extensionAvailable; // 연장 가능여부



    public Loan(int loanID, String memberId, String bookId,boolean extensionAvailable) {

        this.loanID = loanID;
        this.memberId = memberId;
        this.bookId = bookId;
        this.extensionAvailable = extensionAvailable;
       
    }



    public int getLoanID() {
        return loanID;
    }



    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }



    public String getMemberId() {
        return memberId;
    }



    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }



    public String getBookId() {
        return bookId;
    }



    public void setBookId(String bookId) {
        this.bookId = bookId;
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



    @Override
    public int hashCode() {
        return Objects.hash(bookId, extensionAvailable, loanDate, loanID, memberId, returnDate);
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
        return Objects.equals(bookId, other.bookId)
                && extensionAvailable == other.extensionAvailable
                && Objects.equals(loanDate, other.loanDate) && loanID == other.loanID
                && Objects.equals(memberId, other.memberId)
                && Objects.equals(returnDate, other.returnDate);
    }



    @Override
    public String toString() {
        return "Loan [loanID=" + loanID + ", memberId=" + memberId + ", bookId=" + bookId
                + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", extensionAvailable="
                + extensionAvailable + "]";
    }





}
