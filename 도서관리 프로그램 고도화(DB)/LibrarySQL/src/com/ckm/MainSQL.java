package com.ckm;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MainSQL {

    public static void main(String[] args) {
        MemberFunction memberFunction = new MemberFunction();
        BookFunction bookFunction = new BookFunction();
        LoanFunction loanFunction = new LoanFunction();
        Connection conn = ConnectJDBC.getConnection();
        while (true) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("=========== 도서 관리 프로그램 =============");
            System.out.println("1.회원관리    2.도서관리    3.대출관리    4.종료");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("0.뒤로   1.회원조회   2.회원등록   3.회원수정   4.회원삭제   5.삭제취소");
                    int number1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (number1) {
                        case 0:
                            System.out.println("뒤로 가겠습니다.");
                            break;
                        case 1:
                            System.out.println("회원들을 조회하겠습니다");
                            memberFunction.selectMembers();
                            break;
                        case 2:
                            System.out.println("이름: ");
                            String name = scanner.next();

                            System.out.println("주소: ");

                            String address = scanner.next();
                            String str = scanner.nextLine();
                            address = address + str;

                            System.out.println("연락처: ");
                            String phoneNumber = scanner.next();

                            System.out.println("생일: (년/월/일 형식으로 써주세요.)");
                            String birthday = scanner.next();

                            Date now = new Date();
                            String startDate = new SimpleDateFormat("yyyy/MM/dd").format(now);
                            Member member =
                                    new Member(0, name, address, phoneNumber, startDate, birthday);
                            memberFunction.addMembers(member);
                            System.out.println("등록이 완료되었습니다.");


                            break;
                        case 3:

                            System.out.println("본인의 ID를 입력하세요: ");
                            String memberId = scanner.next();
                            System.out.println("바꾸고 싶은 정보를 고르시오");
                            System.out.println("1.이름    2.주소    3.연락처   4.생일 ");
                            int updateNumber = scanner.nextInt();

                            switch (updateNumber) {
                                case 1:
                                    System.out.println("이름: ");
                                    String name1 = scanner.next();
                                    memberFunction.editMembers(updateNumber, memberId, name1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                                case 2:
                                    System.out.println("주소: ");
                                    String address1 = scanner.next();
                                    String str1 = scanner.nextLine();
                                    address1 = address1 + str1;
                                    memberFunction.editMembers(updateNumber, memberId, address1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                                case 3:
                                    System.out.println("연락처: ");
                                    String phoneNumber1 = scanner.next();
                                    memberFunction.editMembers(updateNumber, memberId,
                                            phoneNumber1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                                case 4:
                                    System.out.println("생일: (년/월/일 형식으로 써주세요.)");
                                    String birthday1 = scanner.next();
                                    memberFunction.editMembers(updateNumber, memberId, birthday1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                            }

                            break;

                        case 4:
                            System.out.println("삭제하고 싶은 회원ID: ");
                            String id = scanner.next();
                            memberFunction.deleteMembers(id);
                            System.out.println("삭제가 완료되었습니다.");
                            break;
                        case 5:
                            System.out.println("삭제를 취소하겠습니다.");
                            memberFunction.returnMembers();

                            break;

                    }
                    System.out.println("======================================");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("0.뒤로   1.책 조회   2.책 등록   3.책 정보 수정   4.삭제   5.삭제취소");
                    int number2 = scanner.nextInt();
                    switch (number2) {
                        case 0:
                            System.out.println("뒤로 가겠습니다.");
                            break;
                        case 1:
                            System.out.println("도서조회 화면입니다.");
                            bookFunction.selectBooks();

                            break;

                        case 2:

                            System.out.println("책 이름: ");
                            String name = scanner.next();

                            System.out.println("출판일: (년/월/일) 형식으로 써주세요.");
                            String publishDate = scanner.next();

                            System.out.println("대출 가능 여부:  true(대출 가능)/ false(대출 불가능)");
                            boolean status = scanner.nextBoolean();
                            BookInfo bookInfo = new BookInfo(0, name, publishDate, status);
                            bookFunction.addBooks(bookInfo);
                            System.out.println("등록이 완료되었습니다.");
                            break;

                        case 3:
                            System.out.println("책 ID를 입력하세요: ");
                            String bookId = scanner.next();
                            System.out.println("바꾸고 싶은 정보를 고르시오");
                            System.out.println("1.책 이름    2.출판일");
                            int updateBookNumber = scanner.nextInt();
                            switch (updateBookNumber) {
                                case 1:
                                    System.out.println("책 이름: ");
                                    String bookName1 = scanner.next();
                                    bookFunction.editBooks(updateBookNumber, bookId, bookName1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                                case 2:
                                    System.out.println("출판일: ");
                                    String publishDate1 = scanner.next();
                                    bookFunction.editBooks(updateBookNumber, bookId, publishDate1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                            }

                            break;

                        case 4:
                            System.out.println("삭제하고 싶은 책ID: ");
                            String id = scanner.next();
                            bookFunction.deleteBooks(id);
                            System.out.println("삭제가 완료되었습니다.");
                            break;
                        case 5:
                            System.out.println("삭제를 취소하겠습니다.");
                            bookFunction.returnBooks();
                            break;
                    }
                    System.out.println("======================================");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("0.뒤로   1.대출가능도서   2.대출이력조회   3.대출신청   4.연장신청   5.반납");
                    int number3 = scanner.nextInt();
                    switch (number3) {
                        case 0:
                            System.out.println("뒤로 가겠습니다.");
                            break;
                        case 1:
                            System.out.println("대출가능한 도서를 조회합니다.");
                            bookFunction.selectLoanableBook();
                            break;
                        case 2:
                            System.out.println("대출 이력을 확인하고 싶은 회원의 번호를 입력하시오.");
                            String memberID = scanner.next();
                            loanFunction.selectLoanStatus(memberID);
                            break;
                        case 3:
                            System.out.println("도서 대출을 신청합니다.");
                            System.out.println("대출할 회원의 번호를 입력하시오. ");
                            String loanMemberId = scanner.next();

                            System.out.println("대출가능한 책 목록입니다. ");
                            bookFunction.selectLoanableBook();
                            System.out.println("대출할 도서 번호를 입력하시오. ");
                            String loanBookId = scanner.next();

                            Loan newloan = new Loan(0, loanMemberId, loanBookId, false);
                            loanFunction.laonBook(newloan);
                            bookFunction.loanBook(loanBookId);
                            System.out.println("대출이 완료되었습니다.");

                            break;
                        case 4:
                            System.out.println("도서 연장을 신청합니다.");
                            System.out.println("대출한 회원의 ID를 입력하시오. ");
                            String loanedMemberID = scanner.next();
                            if (loanFunction.loanStatus(loanedMemberID)) {
                                System.out.println("연장 가능한 책 목록입니다.");
                                System.out.println("책 ID를 입력하시오.");
                                String loanedBookID = scanner.next();
                                if (loanFunction.loanExtension(loanedMemberID, loanedBookID)) {
                                    System.out.println("연장이 완료되었습니다.");

                                } else {
                                    System.out.println("연장 가능한 책이 없습니다.");
                                }
                            } else {
                                System.out.println("연장 신청 가능한 목록이 없습니다.");
                            }
                            break;
                        case 5:
                            System.out.println("도서 반납를 반납합니다.");
                            System.out.println("반납할 책 번호를 입력하시오. ");
                            String returnBookId = scanner.next();
                            loanFunction.returnBook(returnBookId);

                            System.out.println("반납이 완료되었습니다.");
                            break;
                    }
                    System.out.println("======================================");
                    System.out.println();
                    break;
                default:
                    System.out.println("종료하겠습니다.");
                    try {
                        conn.close();
                        System.out.println("DB 연결 종료");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
       
                    return;

            }
        }

    }

}
