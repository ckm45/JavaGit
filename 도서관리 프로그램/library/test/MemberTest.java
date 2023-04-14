package com.ckm.library.test;

import java.util.List;
import com.ckm.library.Member;
import com.ckm.library.MemberFunction;
import com.ckm.library.csv.Exportlist;
import com.ckm.library.csv.MakeList;

public class MemberTest {
    public static void main(String[] args) {
        //MakeList makelist = new MakeList();
        
        //List<Member> members = makelist.memberlist();
        
        MemberFunction function = new MemberFunction();


        function.selectMembers(); // 출력
//
        System.out.println();
//
//        function.deleteMembers(1);
//        function.selectMembers(); // 출력
////
//        System.out.println();
//
        function.editMembers(2, "태환", "광명", "010", "1999/01/23");
        function.selectMembers(); // 출력
//        function.deleteMembers(2);
//        System.out.println();
////        
//        function.selectMembers(); // 출력
//
//        function.returnMembers();
//        System.out.println();
//        function.selectMembers(); // 출력
//
//        function.deleteMembers(3);
//
//        Exportlist el = new Exportlist();
//        // el.exportMember(function.getMembers());
    }

}
