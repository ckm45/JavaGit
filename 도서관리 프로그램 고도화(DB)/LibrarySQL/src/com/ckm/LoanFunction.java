package com.ckm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class LoanFunction {
    Connection conn = ConnectJDBC.getConnection();


    public void selectLoanStatus() {
        String selectSql = "SELECT * FROM "
                + "(SELECT LOAN.LOANID,LOAN.MEMBERID,LOAN.BOOKID,MEMBER.NAME ,BOOK.BOOKNAME, LOAN.LOANDATE,LOAN.RETURNDATE,LOAN.EXTENSIONAVAILABLE "
                + "FROM MEMBER,BOOK,LOAN "
                + "WHERE LOAN.MEMBERID=MEMBER.ID AND LOAN.BOOKID=BOOK.BOOKID)";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            ResultSet rs = pstmt.executeQuery(); // id 값
            ResultSetMetaData rsmd1 = rs.getMetaData();
            int columnCount = rsmd1.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd1.getColumnName(i) + " ");
            }
            System.out.println();

            while (rs.next()) {

                System.out.println(rs.getString("LOANID") + "\t" + rs.getString("MEMBERID") + "\t "
                        + rs.getString("BOOKID") + "\t" + rs.getString("NAME") + "\t"
                        + rs.getString("BOOKNAME") + "\t" + rs.getDate("LOANDATE") + "\t"
                        + rs.getDate("RETURNDATE") + "\t" + rs.getString("EXTENSIONAVAILABLE"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    // 대출이력 조회 (특정 사람)
    public void selectLoanStatus(String memberID) {
        String selectSql =
                "SELECT * FROM (SELECT LOAN.LOANID,LOAN.MEMBERID,LOAN.BOOKID,MEMBER.NAME ,BOOK.BOOKNAME, LOAN.LOANDATE,LOAN.RETURNDATE,LOAN.EXTENSIONAVAILABLE FROM MEMBER,BOOK,LOAN  WHERE LOAN.MEMBERID=MEMBER.ID AND LOAN.BOOKID=BOOK.BOOKID) WHERE MEMBERID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
            pstmt.setString(1, memberID);
            ResultSet rs = pstmt.executeQuery(); // id 값
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t ");
            }
            System.out.println();

            while (rs.next()) {
                if (rs.getString(2).equals(memberID)) {


                    System.out.println(rs.getString("LOANID") + "\t \t  " + rs.getString("MEMBERID")
                            + "\t\t\t" + rs.getString("BOOKID") + "\t\t" + rs.getString("NAME")
                            + "  \t\t" + rs.getString("BOOKNAME") + "\t" + rs.getDate("LOANDATE")
                            + "\t" + rs.getDate("RETURNDATE") + "\t"
                            + rs.getString("EXTENSIONAVAILABLE"));
                } else {
                    System.out.println("대출한 책이 없습니다.");

                }
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 책을 대출합니다.
    public void laonBook(Loan loan) {
        int id = 0;

        String insertLoan =
                "INSERT INTO LOAN(LOANID,MEMBERID,BOOKID,EXTENSIONAVAILABLE) VALUES(LPAD(LOAN_SEQ.NEXTVAL,3,'0'),?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(insertLoan)) {
            pstmt.setString(1, loan.getMemberId());
            pstmt.setString(2, loan.getBookId());
            pstmt.setString(3, loan.isExtensionAvailable() ? "T" : "F");


            int result = pstmt.executeUpdate();
            System.out.println(result + " rows inserted.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // 연장가능한 책 조회

    public boolean loanStatus(String loanedMemberID) {
        boolean result = false;
        String wholeLoan =
                "SELECT LOAN.LOANID,LOAN.MEMBERID,LOAN.BOOKID,MEMBER.NAME ,BOOK.BOOKNAME, LOAN.LOANDATE,LOAN.RETURNDATE,\r\n"
                        + " LOAN.EXTENSIONAVAILABLE FROM MEMBER,BOOK,LOAN\r\n"
                        + " WHERE LOAN.MEMBERID=MEMBER.ID AND LOAN.BOOKID=BOOK.BOOKID AND EXTENSIONAVAILABLE ='T' ";
        try (PreparedStatement pstmt = conn.prepareStatement(wholeLoan)) {
            ResultSet rs = pstmt.executeQuery(); // 이 중에 memberID가 있나 확인
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "  ");
            }
            System.out.println();
            while (rs.next()) {


                if (loanedMemberID.equals(rs.getString("MEMBERID"))) {
                    result = true;
                    System.out.println(rs.getString("LOANID") + "\t" + rs.getString("MEMBERID")
                            + "\t " + rs.getString("BOOKID") + "\t" + rs.getString("NAME") + "\t"
                            + rs.getString("BOOKNAME") + "\t" + rs.getDate("LOANDATE") + "\t"
                            + rs.getDate("RETURNDATE") + "\t" + rs.getString("EXTENSIONAVAILABLE"));

                }

            }
            return result;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    // 대출 연장
    public boolean loanExtension(String memberId, String bookId) {
        boolean result = false;
        String loanedSql =
                "SELECT LOAN.LOANID,LOAN.MEMBERID,LOAN.BOOKID,MEMBER.NAME ,BOOK.BOOKNAME, LOAN.LOANDATE,LOAN.RETURNDATE,\r\n"
                        + " LOAN.EXTENSIONAVAILABLE FROM MEMBER,BOOK,LOAN\r\n"
                        + " WHERE LOAN.MEMBERID=MEMBER.ID AND LOAN.BOOKID=BOOK.BOOKID AND EXTENSIONAVAILABLE ='F' ";
        String extensionSql =
                "UPDATE LOAN SET RETURNDATE=RETURNDATE+7 WHERE MEMBERID=? AND BOOKID=? AND EXTENSIONAVAILABLE='T'";
        String updateExtension =
                "UPDATE LOAN SET EXTENSIONAVAILABLE = 'F' WHERE MEMBERID=? AND BOOKID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(extensionSql);
                PreparedStatement pstmt2 = conn.prepareStatement(updateExtension);
                PreparedStatement pstmt3 = conn.prepareStatement(loanedSql)) {
            pstmt.setString(1, memberId);
            pstmt.setString(2, bookId);

            result = true;
            pstmt.setString(1, memberId);
            pstmt.setString(2, bookId);
            pstmt.executeUpdate();

            pstmt2.setString(1, memberId);
            pstmt2.setString(2, bookId);
            pstmt2.executeUpdate();

            ResultSet rs = pstmt3.executeQuery(); // id 값
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + "  ");
            }
            System.out.println();

            while (rs.next()) {
                System.out.println(rs.getString("LOANID") + "\t" + rs.getString("MEMBERID") + "\t "
                        + rs.getString("BOOKID") + "\t" + rs.getString("NAME") + "\t"
                        + rs.getString("BOOKNAME") + "\t" + rs.getDate("LOANDATE") + "\t"
                        + rs.getDate("RETURNDATE") + "\t" + rs.getString("EXTENSIONAVAILABLE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 반납할 책 있는지 확인
    public boolean returnBookStatus(String returnMemberId) {
        boolean result = false;
        String selectLoan = "SELECT * FROM LOAN";
        try (PreparedStatement pstmt = conn.prepareStatement(selectLoan)) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            // memberID != returnMemberId
            if (rs.getString("MEMBERID").equals(returnMemberId)) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return result;
    }


    // 반납
    public void returnBook(String returnBookId) {
        String selectAllLoan =
                "SELECT * FROM (SELECT LOAN.LOANID,LOAN.MEMBERID,LOAN.BOOKID,MEMBER.NAME ,BOOK.BOOKNAME, LOAN.LOANDATE,LOAN.RETURNDATE,LOAN.EXTENSIONAVAILABLE FROM MEMBER,BOOK,LOAN  WHERE LOAN.MEMBERID=MEMBER.ID AND LOAN.BOOKID=BOOK.BOOKID)";
        String selectLoan = "SELECT * FROM LOAN WHERE BOOKID = ?";
        String deleteLoan = "DELETE FROM LOAN WHERE  BOOKID = ?";
        String updateBookLoan = "UPDATE BOOK SET STATUS = 'T' WHERE BOOKID = ? ";

        try (PreparedStatement pstmt = conn.prepareStatement(selectLoan);
                PreparedStatement pstmt2 = conn.prepareStatement(deleteLoan);
                PreparedStatement pstmt3 = conn.prepareStatement(updateBookLoan)) {
            // 대여 목록에서 선택한 책 정보 조회
            pstmt.setString(1, returnBookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // 선택한 책이 대여 목록에 있으면 대출 정보 삭제
                pstmt2.setString(1, returnBookId);
                pstmt2.executeUpdate();

                // book table의 해당 행의 available을 True로 변경
                pstmt3.setString(1, returnBookId);
                pstmt3.executeUpdate();
                System.out.println("반납 완료되었습니다.");

            } else {
                // 선택한 책이 대출 목록에 없으면 메시지 출력
                System.out.println("선택하신 책이 대출 목록에 없습니다.");

            }

        } catch (

        SQLException e) {
            e.printStackTrace();
        }


    }
}
