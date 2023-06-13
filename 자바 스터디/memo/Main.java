package com.memo;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        NotePad notePad = new NotePad();
        while(true) {
            System.out.println("=========메모장=========");
            System.out.println("1. 메모 전체 보기 2. 메모 상세 보기 3. 메모 작성하기 4. 메모 수정하기 5. 메모 삭제하기 6. 종료");
            Scanner scanner = new Scanner(System.in);
            int caseNum = Integer.parseInt(scanner.nextLine());
            switch(caseNum) {
                case 1:
                    notePad.selectAllNote();
                    break;
                case 2:
                    notePad.selectNote();
                    break;
                case 3:
                    notePad.addNote();
                    break;
                case 4:
                    notePad.updateNote();
                    break;
                case 5:
                    notePad.deleteNote();
                    break;
                default:
                    System.out.println("종료하겠습니다.");
                    return;
                    
            }
            
        }
    }

}
