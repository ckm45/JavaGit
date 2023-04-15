package com.ckm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberFunction {
    Connection conn = ConnectJDBC.getConnection();
    Integer backUpId = null;
    Member backUpMember = null;


    public void selectMembers() { // 회원 조회
        String sql = "SELECT * FROM SCOTT.MEMBER";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getString("ID") + " " + rs.getString("NAME") + " " + rs.getString("ADDRESS" )+" "
                        + rs.getString("PHONENUMBER") + " " + rs.getDate("STARTDATE") + " " + rs.getInt("AGE"));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // 연결 닫기 중 예외가 발생한 경우 처리합니다.
                e.printStackTrace();
            }
        }

    }

//    public void addMembers(Member member) { // 회원 등록
//        int id = members.get(members.size() - 1).getMemberId() + 1;
//        member.setMemberId(id);
//        members.add(member);
//    }
//
//    public void editMembers(int updateNumber, int id, String updateContent) { // 회원 수정
//        for (Member member : members) {
//            if (member.getMemberId() == id) {
//                if (updateNumber == 1) {
//                    member.setName(updateContent);
//                } else if (updateNumber == 2) {
//                    member.setAddress(updateContent);
//                } else if (updateNumber == 3) {
//                    member.setPhoneNumber(updateContent);
//                } else if (updateNumber == 4) {
//                    member.setBirthday(updateContent);
//                }
//
//            }
//        }
//
//    }
//
//
//    public void deleteMembers(int id) { // 회원 삭제
//        boolean check = false;
//
//        for (Member member : members) {
//            if (id == member.getMemberId()) {
//                if (memberBackUp.size() != 0) {
//                    memberBackUp.set(0, member);
//                    members.remove(member);
//                    check = true;
//                    break;
//                } else {
//                    memberBackUp.add(member);
//                    members.remove(member);
//                    check = true;
//                    break;
//
//                }
//            }
//
//        }
//        if (check == false) {
//            System.out.println("삭제할 회원이 없습니다.");
//        }
//    }
//
//    public void returnMembers() {
//        if (memberBackUp.size() == 0) {
//            System.out.println("복구할 회원이 없습니다.");
//        } else {
//            members.add(memberBackUp.get(0));
//            memberBackUp.remove(0);
//        }
//    }
//
//    public List<Member> getMemberList() {
//        return members;
//    }

}
