package com.ckm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BookFunction {
    Connection conn = ConnectJDBC.getConnection();
    Integer backUpId = null;
    Member backUpMember = null;



    public void selectBooks() { // 도서 조회
        String selectSql = "SELECT * FROM SCOTT.BOOK";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getString("BOOKID") + "   " + rs.getString("BOOKNAME") + "   "
                        + rs.getDate("PUBLISHDATE") + "   " + rs.getString("STATUS"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    //
    public void selectLoanableBook() { // 대출 가능한 책 조회
        String selectLoanable = "SELECT * FROM SCOTT.BOOK WHERE STATUS = 'T'";
        try (PreparedStatement pstmt = conn.prepareStatement(selectLoanable)) {
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getString("BOOKID") + "   " + rs.getString("BOOKNAME") + "   "
                        + rs.getDate("PUBLISHDATE") + "   " + rs.getString("STATUS"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void loanBook(String name) { // 반납 여부를 false로 바꾼다
        String updateStatus = "UPDATE SCOTT.BOOK SET STATUS = 'F' WHERE BOOKNAME = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateStatus)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBooks(BookInfo bookInfo) { // 책 등록
        String insertSql = "INSERT INTO SCOTT.BOOK(BOOKID,BOOKNAME,PUBLISHDATE,STATUS) \r\n"
                + "VALUES(?,?,?,?)";

        String idSql = "SELECT MAX(BOOKID) FROM SCOTT.BOOK";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSql);
                PreparedStatement pstmt2 = conn.prepareStatement(idSql)) {
            ResultSet rs = pstmt2.executeQuery(); // id 값
            int nextId = 1;
            if (rs.next()) {
                nextId = rs.getInt(1) + 1;
            }
            pstmt.setString(1,
                    String.format("%03d", Integer.parseInt(rs.getString("MAX(BOOKID)")) + 1));
            pstmt.setString(2, bookInfo.getBookName());
            pstmt.setString(3, bookInfo.getPublishDate());
            pstmt.setString(4, bookInfo.isStatus() ? "T" : "F");

            int result = pstmt.executeUpdate();
            System.out.println(result + " rows inserted.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //
    public void editBooks(int updateNumber, String id, String updateContent) { // 책 정보 수정

        if (updateNumber == 1) { // 이름 수정
            String updateName = "UPDATE SCOTT.BOOK SET BOOKNAME = ? WHERE BOOKID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateName)) {
                pstmt.setString(1, updateContent);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (updateNumber == 2) { // 출판일 수정
            String updateDate =
                    "UPDATE SCOTT.BOOK SET PUBLISHDATE = TO_DATE(?,'RRRR/MM/DD') WHERE BOOKID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateDate)) {
                pstmt.setString(1, updateContent);
                pstmt.setString(2, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    public void deleteBooks(String id) { // 책 삭제
        // boolean check = false;

        String deleteBookSQL = "DELETE FROM SCOTT.BOOK WHERE BOOKID = ?";
        String backUpInsertSql =
                "INSERT INTO SCOTT.BACKUP_BOOK(BOOKID,BOOKNAME,PUBLISHDATE,STATUS) \r\n"
                        + "VALUES(?,?,?,?)";
        String selectSql = "SELECT * FROM SCOTT.BOOK WHERE BOOKID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteBookSQL);
                PreparedStatement pstmt2 = conn.prepareStatement(backUpInsertSql);
                PreparedStatement pstmt3 = conn.prepareStatement(selectSql)) {

            pstmt3.setString(1, id);


            ResultSet rs = pstmt3.executeQuery(); // 컬럼들 조회
            while (rs.next()) {
                pstmt2.setString(1, rs.getString("BOOKID")); // 조회된 컬럼들 백업용 테이블에 넣기
                pstmt2.setString(2, rs.getString("BOOKNAME"));
                pstmt2.setDate(3, rs.getDate("PUBLISHDATE"));
                pstmt2.setString(4, rs.getString("STATUS"));
                pstmt2.executeUpdate();

            }
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void returnBooks() {
        String selectDeletedBook = "SELECT * FROM SCOTT.BACKUP_BOOK";
        String returnBook = "INSERT INTO SCOTT.BOOK(BOOKID,BOOKNAME,PUBLISHDATE,STATUS)\r\n"
                + "VALUES(?,?,?,?)";
        String clearBackUp = "DELETE FROM SCOTT.BACKUP_BOOK";
        try (PreparedStatement pstmt = conn.prepareStatement(selectDeletedBook);
                PreparedStatement pstmt2 = conn.prepareStatement(returnBook);
                PreparedStatement pstmt3 = conn.prepareStatement(clearBackUp)) {
            ResultSet rs = pstmt.executeQuery(); // 컬럼들 조회

            // 삭제 취소시키기
            while (rs.next()) {
                pstmt2.setString(1, rs.getString("BOOKID"));
                pstmt2.setString(2, rs.getString("BOOKNAME"));
                pstmt2.setDate(3, rs.getDate("PUBLISHDATE"));
                pstmt2.setString(4, rs.getString("STATUS"));
                pstmt2.executeUpdate();


            }
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
