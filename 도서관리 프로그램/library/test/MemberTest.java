package com.ckm.library.test;

import com.ckm.library.Member;
import com.ckm.library.MemberFunction;
import com.ckm.library.csv.Exportlist;
import com.ckm.library.csv.MakeList;

public class MemberTest {
    public static void main(String[] args) {
        Member member1 = new Member("최경민", "광명", "010", "1999/01/23");
        Member member2 = new Member("경민", "광명", "010", "19999/01/23");
        Member member3 = new Member("민", "광명", "010", "1999/01/23");


        MemberFunction function = new MemberFunction();

        function.addMembers(member1);
        function.addMembers(member2);
        function.addMembers(member3);
        function.selectMembers();  //출력

        System.out.println();

        function.deleteMembers(1);
        function.selectMembers(); //출력

        System.out.println();

        function.editMembers(0, "태환", "광명", "010", "1999/01/23");
        function.selectMembers();  //출력
        function.deleteMembers(2);
        System.out.println();

        function.selectMembers();  //출력
        
        function.returnMembers();
        System.out.println();
        function.selectMembers();  //출력
        
        function.deleteMembers(3);
                
        Exportlist el = new Exportlist();
        el.exportMember(function.getMembers());
    }

}
