package com.ckm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class MemberFunction {
    Connection conn = ConnectJDBC.getConnection();

    public void selectMembers() { // 회원 조회
        String selectSql = "SELECT * FROM SCOTT.MEMBER ORDER BY ID";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getString("ID") + "   " + rs.getString("NAME") + "   "
                        + rs.getDate("BIRTHDAY") + "   " + rs.getString("ADDRESS") + "   "
                        + rs.getString("PHONENUMBER") + "   " + rs.getDate("STARTDATE") + "   "
                        + rs.getInt("AGE"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void addMembers(Member member) { // 회원 등록

        String insertSql =
                "INSERT INTO SCOTT.MEMBER(ID,NAME,ADDRESS,PHONENUMBER,BIRTHDAY)"
                + " VALUES(LPAD(MEMBER_SEQ.NEXTVAL,3,'0'),?,?,?,?)";
        

        String idSql = "SELECT MAX(ID) FROM SCOTT.MEMBER";


        try (PreparedStatement pstmt = conn.prepareStatement(insertSql)){
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getAddress());
            pstmt.setString(3, member.getPhoneNumber());
            pstmt.setString(4, member.getBirthday());

            int result = pstmt.executeUpdate();
            System.out.println(result + " rows inserted.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void editMembers(int updateNumber, String id, String updateContent) { // 회원 수정

        if (updateNumber == 1) { // 이름 수정
            String updateNameSQL = "UPDATE SCOTT.MEMBER SET NAME = ? WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateNameSQL)) {
                pstmt.setString(1, updateContent);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (updateNumber == 2) { // 주소 수정
            String updateAddressSQL = "UPDATE SCOTT.MEMBER SET ADDRESS = ? WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateAddressSQL)) {
                pstmt.setString(1, updateContent);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (updateNumber == 3) { //전화 번호 수정
            String updatePhoneNumberSQL = "UPDATE SCOTT.MEMBER SET PHONENUMBER = ? WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updatePhoneNumberSQL)) {
                pstmt.setString(1, updateContent);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (updateNumber == 4) { //생일 수정
            String updateBirthdaySQL = "UPDATE SCOTT.MEMBER SET BIRTHDAY = ? WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateBirthdaySQL)) {
                pstmt.setString(1, updateContent);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }


    public void deleteMembers(String id) { // 회원 삭제
        // boolean check = false;

        String deleteMembersSQL = "DELETE FROM SCOTT.MEMBER WHERE ID = ?";
        String backUpInsertSql =
                "INSERT INTO SCOTT.BACKUP_MEMBER(ID,NAME,BIRTHDAY,ADDRESS,PHONENUMBER,STARTDATE,AGE) \r\n"
                        + "            VALUES(?,?,?,?,?,?,?)";
        String selectSql = "SELECT * FROM SCOTT.MEMBER WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteMembersSQL);
                PreparedStatement pstmt2 = conn.prepareStatement(backUpInsertSql);
                PreparedStatement pstmt3 = conn.prepareStatement(selectSql)) {

            pstmt3.setString(1, id);


            ResultSet rs = pstmt3.executeQuery(); // 컬럼들 조회
            while (rs.next()) {
                pstmt2.setString(1, rs.getString("ID")); // 조회된 컬럼들 백업용 테이블에 넣기

                pstmt2.setString(2, rs.getString("NAME"));
                pstmt2.setDate(3, rs.getDate("BIRTHDAY"));
                pstmt2.setString(4, rs.getString("ADDRESS"));
                pstmt2.setString(5, rs.getString("PHONENUMBER"));
                pstmt2.setDate(6, rs.getDate("STARTDATE"));
                pstmt2.setInt(7, rs.getInt("AGE"));
                pstmt2.executeUpdate();

            }
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void returnMembers() {

        String selectDeletedMember = "SELECT * FROM SCOTT.BACKUP_MEMBER";
        String returnMember =
                "INSERT INTO SCOTT.MEMBER(ID,NAME,BIRTHDAY,ADDRESS,PHONENUMBER,STARTDATE,AGE)\r\n"
                        + "VALUES(?,?,?,?,?,?,?)";
        String clearBackUp = "DELETE FROM SCOTT.BACKUP_MEMBER";
        try (PreparedStatement pstmt = conn.prepareStatement(selectDeletedMember);
                PreparedStatement pstmt2 = conn.prepareStatement(returnMember);
                PreparedStatement pstmt3 = conn.prepareStatement(clearBackUp)) {
            ResultSet rs = pstmt.executeQuery(); // 컬럼들 조회

            // 삭제 취소시키기
            while (rs.next()) {
                pstmt2.setString(1, rs.getString("ID"));
                pstmt2.setString(2, rs.getString("NAME"));
                pstmt2.setDate(3, rs.getDate("BIRTHDAY"));
                pstmt2.setString(4, rs.getString("ADDRESS"));
                pstmt2.setString(5, rs.getString("PHONENUMBER"));
                pstmt2.setDate(6, rs.getDate("STARTDATE"));
                pstmt2.setInt(7, rs.getInt("AGE"));
                pstmt2.executeUpdate();


            }
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
