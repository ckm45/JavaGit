package com.ckm.library;

import java.util.Scanner;
import com.ckm.library.csv.Exportlist;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberFunction memberFunction = new MemberFunction();
        BookFunction bookFunction = new BookFunction();
        while (true) {
            System.out.println("1.회원관리    2.도서관리    3.종료");
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
                            Member member = new Member(name, address, phoneNumber, birthday);
                            memberFunction.addMembers(member);
                            System.out.println("등록이 완료되었습니다.");
                            break;
                        case 3:
                            System.out.println("본인의 ID를 입력하세요: ");
                            int memberId = scanner.nextInt();

                            System.out.println("이름: ");
                            String name1 = scanner.next();

                            System.out.println("주소: ");
                            String address1 = scanner.next();

                            System.out.println("연락처: ");
                            String phoneNumber1 = scanner.next();

                            System.out.println("생일: (년/월/일 형식으로 써주세요.)");
                            String birthday1 = scanner.next();

                            System.out.println("수정이 완료되었습니다.");

                            // Member memberEdit = new Member(name1, address1, phoneNumber1,
                            // birthday1);
                            memberFunction.editMembers(memberId, name1, address1, phoneNumber1,
                                    birthday1);
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
                    break;
                case 2:
                    System.out.println("0.뒤로   1.책 조회   2.책 등록   3.책 정보 수정   4.삭제   5.삭제취소");
                    int number3 = scanner.nextInt();
                    switch (number3) {
                        case 0:
                            System.out.println("뒤로 가겠습니다.");
                            break;
                        case 1:
                            bookFunction.selectBooks();
                            break;

                        case 2:
                        	
                            System.out.println("책 이름: ");
                            String name = scanner.next();

                            System.out.println("출판일: (년/월/일 형식으로 써주세요.");
                            String publishDate = scanner.next();

                            System.out.println("대출 가능 여부:  true(대출 가능)/ false(대출 불가능)");
                            boolean status = scanner.nextBoolean();

                            BookInfo bookInfo = new BookInfo(name, publishDate, status);
                            bookFunction.addBooks(bookInfo);
                            System.out.println("등록이 완료되었습니다.");
                            break;

                        case 3:
                            System.out.println("해당 책의 ID를 입력하세요: ");
                            int memberId = scanner.nextInt();

                            System.out.println("책 이름: ");
                            String name1 = scanner.next();

                            System.out.println("출판일: (년/월/일 형식으로 써주세요.");
                            String publishDate1 = scanner.next();

                            System.out.println("대출 가능 여부:  true(대출 가능)/ false(대출 불가능)");
                            boolean status1 = scanner.nextBoolean();

                            bookFunction.editBooks(memberId, name1, publishDate1, status1);

                            System.out.println("수정이 완료되었습니다.");

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
                    break;
                default:
                    Exportlist el = new Exportlist();
                    el.exportMember(memberFunction.getMembers());
                    el.exportBook(bookFunction.getBooks());

                    return;

            }
        }

    }

}
