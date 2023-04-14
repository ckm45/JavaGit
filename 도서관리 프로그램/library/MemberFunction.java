package com.ckm.library;

import java.util.ArrayList;
import java.util.List;
import com.ckm.library.csv.MakeList;

public class MemberFunction {
    MakeList makelist = new MakeList();

    List<Member> members = makelist.memberlist();

    Integer backUpId = null;
    Member backUpMember = null;

    // List<Member> members = new ArrayList<>();
    List<Member> memberBackUp = new ArrayList<>(1);

    public void selectMembers() { // 회원 조회

        for (Member member : members) {
            System.out.println(member.toString());
        }

    }

    public void addMembers(Member member) { // 회원 등록
        int id = members.get(members.size() - 1).getMemberId() + 1;
        member.setMemberId(id);
        members.add(member);
    }

    public void editMembers(int updateNumber, int id, String updateContent) { // 회원 수정
        for (Member member : members) {
            if (member.getMemberId() == id) {
                if (updateNumber == 1) {
                    member.setName(updateContent);
                } else if (updateNumber == 2) {
                    member.setAddress(updateContent);
                } else if (updateNumber == 3) {
                    member.setPhoneNumber(updateContent);
                } else if (updateNumber == 4) {
                    member.setBirthday(updateContent);
                }

            }
        }

    }


    public void deleteMembers(int id) { // 회원 삭제
        boolean check = false;

        for (Member member : members) {
            if (id == member.getMemberId()) {
                if (memberBackUp.size() != 0) {
                    memberBackUp.set(0, member);
                    members.remove(member);
                    check = true;
                    break;
                } else {
                    memberBackUp.add(member);
                    members.remove(member);
                    check = true;
                    break;

                }
            }

        }
        if (check == false) {
            System.out.println("삭제할 회원이 없습니다.");
        }
    }

    public void returnMembers() {
        if (memberBackUp.size() == 0) {
            System.out.println("복구할 회원이 없습니다.");
        } else {
            members.add(memberBackUp.get(0));
            memberBackUp.remove(0);
        }
    }
    
    public List<Member> getMemberList() {
        return members;
    }
    
    
}
