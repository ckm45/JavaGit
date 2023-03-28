package com.ckm.library.csv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.ckm.library.BookInfo;
import com.ckm.library.Member;

// import entity.Book;
// import entity.Loan;
// import entity.Member;

public class Exportlist {

	CSVWriter csvwriter = new CSVWriter();

	public void exportMember(List<Member> members) {
		List<String[]> export = new ArrayList<>();
		String[] index = { "id", "name", "startDay", "address", "phoneNumber", "birthday", "age" };
		export.add(index);

		for (int i = 0; i < members.size(); i++) {
			String[] member = new String[7];
			member[0] = String.valueOf(members.get(i).getMemberId());
			member[1] = members.get(i).getName();
			member[2] = members.get(i).getStartDay();
			member[3] = members.get(i).getAddress();
			member[4] = members.get(i).getPhoneNumber();
			member[5] = members.get(i).getBirthday();
			member[6] = String.valueOf(members.get(i).getAge());
			export.add(member);
		}
		csvwriter.writeCSV(export, "member.csv");
	}

	public void exportBook(List<BookInfo> books) {
        List<String[]> export = new ArrayList<>();
        String[] index = {"bookId", "bookName", "publishDate", "status"};
        export.add(index);
        

        for (int j = 0; j < books.size(); j++) {
            String[] book = new String[4];
            book[0] = String.valueOf(books.get(j).getBookId());
            book[1] = books.get(j).getBookName();
            book[2] = books.get(j).getPublishDate();
            book[3] = String.valueOf(books.get(j).isStatus());
            export.add(book);
        }
        csvwriter.writeCSV(export, "book.csv");
    }

//    public void exportLoan(List<Loan> loanlist) {
//        List<String[]> export = new ArrayList<>();
//        String[] index = {"id", "memberName", "bookTitle", "renewStatus", "loanDate", "deadline",
//                "extension"};
//        export.add(index);
//        for (int i = 0; i < loanlist.size(); i++) {
//            String[] loan = new String[7];
//            loan[0] = String.valueOf(loanlist.get(i).getId());
//            loan[1] = loanlist.get(i).getMemberName();
//            loan[2] = loanlist.get(i).getBookTitle();
//            loan[3] = String.valueOf(loanlist.get(i).isRenewStatus());
//            loan[4] = loanlist.get(i).getLoanDate();
//            loan[5] = String.valueOf(loanlist.get(i).getDeadline());
//            loan[6] = String.valueOf(loanlist.get(i).isExtension());
//            export.add(loan);
//        }
//        csvwriter.writeCSV(export, "loan.csv");
//    }

}
