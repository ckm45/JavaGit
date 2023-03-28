package com.ckm.library;

public class Loan {
    private Member member;
    private BookInfo bookInfo;
    boolean ExtensionAvailable;   //연장 가능여부
    private int returnPeriod;
    
    public Loan(Member member, BookInfo bookInfo, boolean extensionAvailable, int returnPeriod) {

        this.member = member;
        this.bookInfo = bookInfo;
        ExtensionAvailable = extensionAvailable;
        this.returnPeriod = returnPeriod;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
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
        return "Loan [member=" + member + ", bookInfo=" + bookInfo + ", ExtensionAvailable="
                + ExtensionAvailable + ", returnPeriod=" + returnPeriod + "]";
    }
        
    

}
