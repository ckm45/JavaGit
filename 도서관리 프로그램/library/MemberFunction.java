package com.ckm.library;

import java.util.ArrayList;
import java.util.List;

public class MemberFunction {
    Integer backUpId = null;
    Member backUpMember = null;

    List<Member> members = new ArrayList<>();
    List<Member> memberBackUp = new ArrayList<>(1);


    public void selectMembers() { // 회원 조회

        for (Member member : members) {
            System.out.println(member.toString());
        }

    }

    public void addMembers(Member member) { // 회원 등록
        members.add(member);
    }

    public void editMembers(int id, String name, String address, String phoneNumber,
            String birthday) { // 회원 수정
        members.get(id).setName(name);
        members.get(id).setAddress(address);
        members.get(id).setPhoneNumber(phoneNumber);
        members.get(id).setBirthday(birthday);
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
}
