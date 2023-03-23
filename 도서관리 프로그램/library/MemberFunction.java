package com.ckm.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberFunction {
    Integer backUpId = null;
    Member backUpMember = null;

    Map<Integer, Member> members = new HashMap<>();

    public void selectMembers() { // 회원 조회
        Set<Integer> keySet = members.keySet();
        for (Integer key : keySet) {
            System.out.println(members.get(key));
        }
    }

    public void addMembers(Member member) { // 회원 등록
        members.put(member.getMemberId(), member);
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
        backUpId = id;
        backUpMember = members.get(id);

        Set<Integer> keySet = members.keySet();
        for (Integer key : keySet) {

            if (key == id) {
                members.remove(key);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("삭제할 회원이 없습니다.");
        }

    }

    public void returnMembers() {
        if (backUpId == null) {
            System.out.println("복구할 회원이 없습니다.");
        } else {
            members.put(backUpId, backUpMember);
            backUpId = null;
            backUpMember = null;
        }
    }
}
