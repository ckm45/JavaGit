package com.ckm.library.csv;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ckm.library.BookInfo;
import com.ckm.library.Member;

public class MakeList {

	CSVReader cr = new CSVReader();

	public List<Map<Integer, Member>> memberlist() {
        List<List<String>> list = cr.readCSV("member.csv");
        List<Map<Integer, Member>> memberlist = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            List<String> l = list.get(i);
            Map<Integer, Member> mem = new HashMap<>();
            mem.put(Integer.parseInt(l.get(0)),new Member(l.get(1), l.get(2), l.get(3), l.get(4)));
            memberlist.add(mem);
            
        }
        return memberlist;
    }

	public List<Map<Integer, BookInfo>> booklist() {
		List<List<String>> list = cr.readCSV("book.csv");
		List<Map<Integer, BookInfo>> booklist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			List<String> l = list.get(i);
			Map<Integer, BookInfo> mem2 = new HashMap<>();
			mem2.put(Integer.parseInt(l.get(0)), new BookInfo(l.get(1), l.get(2), Boolean.valueOf(l.get(3))));
			booklist.add(mem2);
		}
		return booklist;
	}
//
//	public List<Loan> loanlist() {
//		List<List<String>> list = cr.readCSV("loan.csv");
//		List<Loan> loanlist = new ArrayList<>();
//		for (int i = 1; i < list.size(); i++) {
//			List<String> l = list.get(i);
//			Loan loan = new Loan(Integer.parseInt(l.get(0)), l.get(1), l.get(2), Boolean.valueOf(l.get(3)), l.get(4),
//					Integer.parseInt(l.get(5)), Boolean.valueOf(l.get(6)));
//			loanlist.add(loan);
//		}
//		return loanlist;
//	}

}
