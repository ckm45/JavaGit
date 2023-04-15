package com.ckm.library;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import com.ckm.library.csv.Exportlist;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberFunction memberFunction = new MemberFunction();
        BookFunction bookFunction = new BookFunction();
        LoanFunction loanFunction = new LoanFunction();
        while (true) {
            System.out.println("=========== 도서 관리 프로그램 =============");
            System.out.println("1.회원관리    2.도서관리    3.대출관리    4.종료");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("0.뒤로   1.회원조회   2.회원등록   3.회원수정   4.회원삭제   5.삭제취소");
                    int number2 = scanner.nextInt();
                    switch (number2) {
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
                            int memberId = scanner.nextInt();

                            System.out.println("바꾸고 싶은 정보를 고르시오");
                            System.out.println("1.이름    2.주소    3.연락처   4.생일 ");
                            int updateNumber = scanner.nextInt();;
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
                            int id = scanner.nextInt();
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
                    int number3 = scanner.nextInt();
                    switch (number3) {
                        case 0:
                            System.out.println("뒤로 가겠습니다.");
                            break;
                        case 1:
                            System.out.println("회원들을 조회하겠습니다");
                            bookFunction.selectBooks();
                            break;

                        case 2:

                            System.out.println("책 이름: ");
                            String name = scanner.next();

                            System.out.println("출판일: (년/월/일 형식으로 써주세요.");
                            String publishDate = scanner.next();

                            System.out.println("대출 가능 여부:  true(대출 가능)/ false(대출 불가능)");
                            boolean status = scanner.nextBoolean();

                            BookInfo bookInfo = new BookInfo(0, name, publishDate, status);
                            bookFunction.addBooks(bookInfo);
                            System.out.println("등록이 완료되었습니다.");
                            break;

                        case 3:
                            System.out.println("해당 책의 ID를 입력하세요: ");
                            int memberId = scanner.nextInt();

                            System.out.println("바꾸고 싶은 정보를 고르시오");
                            System.out.println("1.책 이름    2.출판일");
                            int updateNumber1 = scanner.nextInt();;
                            switch (updateNumber1) {
                                case 1:
                                    System.out.println("책 이름: ");
                                    String name1 = scanner.next();
                                    memberFunction.editMembers(updateNumber1, memberId, name1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                                case 2:
                                    System.out.println("출판일: (년/월/일 형식으로 써주세요.)");
                                    String publishDate1 = scanner.next();
                                    memberFunction.editMembers(updateNumber1, memberId,
                                            publishDate1);
                                    System.out.println("수정이 완료되었습니다.");
                                    break;
                            }
                            break;



                        case 4:
                            System.out.println("삭제하고 싶은 책ID: ");
                            int id = scanner.nextInt();
                            bookFunction.deleteBooks(id);
                            System.out.println("삭제가 완료되었습니다.");
                            break;
                        case 5:
                            bookFunction.returnBooks();
                            System.out.println("삭제를 취소하겠습니다.");
                            break;
                    }
                    System.out.println("======================================");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("0.뒤로   1.대출가능도서   2.대출이력조회   3.대출신청   4.연장신청   5.반납");
                    int number4 = scanner.nextInt();
                    switch (number4) {
                        case 0:
                            System.out.println("뒤로 가겠습니다.");
                            break;
                        case 1:
                            System.out.println("대출가능한 도서를 조회합니다.");
                           
                            bookFunction.selectLoanableBook();
                            break;
                        case 2:
                            System.out.println("대출 이력을 확인하고 싶은 회원을 입력하시오.");
                            String memberName = scanner.next();
                            loanFunction.selectLoanStatus(memberName);
                            break;
                        case 3:
                            System.out.println("도서 대출을 신청합니다.");
                            System.out.println("대출할 회원의 이름을 입력하시오. ");
                            String loanMemberName = scanner.next();
                            System.out.println("대출가능한 책 목록입니다. ");
                            bookFunction.selectLoanableBook();
                                                        
                            System.out.println("대출할 도서 제목을 입력하시오. ");
                            String loanBookName = scanner.next();
                            
                            LocalDateTime currentDateTime = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                            String loanDate = currentDateTime.format(formatter);
                            
                            LocalDate date = LocalDate.parse(loanDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                            date = date.plusDays(14);
                            String returnDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                            
                            
                            Loan newloan = new Loan(0,loanMemberName,loanBookName,loanDate,returnDate,false);
                            loanFunction.laonBook(newloan);
                            bookFunction.loanBook(loanBookName);
                            System.out.println("대출이 완료되었습니다.");
                                    
                            
                            break;
                        case 4:
                            System.out.println("도서 연장을 신청합니다.");
                            System.out.println("대출한 회원의 이름을 입력하시오. ");
                            String loanedMemberName = scanner.next();
                            
                            if(loanFunction.loanStatus(loanedMemberName)) {
                                System.out.println("책 이름을 입력하시오.");
                                System.out.println("연장 가능한 책 목록입니다.");
                                System.out.println("대출한 도서 제목을 입력하시오. ");
                                String loanedBookName = scanner.next();
                                if(loanFunction.loanExtention(loanedMemberName, loanedBookName)) {
                                    System.out.println("연장이 완료되었습니다.");
                                    
                                }else {
                                    System.out.println("연장 가능한 책이 없습니다.");
                                }
                            }else {
                                System.out.println("연장 신청 가능한 목록이 없습니다.");
                            }
                            
                           
                            break;
                        case 5:
                            System.out.println("도서 반납를 반납합니다.");
                            System.out.println("반납할 도서 제목을 입력하시오. ");
                            String ReturnBookName = scanner.next();
                            System.out.println("반납이 완료되었습니다.");
                            break;
                    }
                    System.out.println("======================================");
                    System.out.println();
                    break;
                    
                default:
                    Exportlist el = new Exportlist();
                    el.exportMember(memberFunction.getMemberList());
                    el.exportBook(bookFunction.getBookList());
                    el.exportLoan(loanFunction.getLoanList());  

                    return;

            }
        }

    }

}
