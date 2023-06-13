package com.memo;

import java.util.Scanner;;

public class NotePad {
    private int noteLength = 0;
    private final Note[] notes;
    private final int NOTE_SIZE = 20;
    Scanner scanner = new Scanner(System.in);

    public NotePad() {
        this.notes = new Note[NOTE_SIZE];
    }

    public void addNote() {
        if (NOTE_SIZE == this.noteLength) {
            System.out.println("메모가 꽉 찼습니다.");
            System.out.println("");
            return;
        }
        System.out.println("작성할 메모의 제목을 입력해주세요.");
        String title = scanner.nextLine();

        System.out.println("메모의 내용을 입력해주세요.");
        String content = scanner.nextLine();

        Note note = new Note(title, content);
        notes[noteLength] = note;

        noteLength++;

    }


    public void selectAllNote() {

        System.out.println("메모의 전체 내용입니다");
        int count = 0;
        if (noteLength == 0) {
            System.out.println("메모장에 메모가 없습니다.");
        } else {
            for (Note note : notes) {
                if (note != null) {
                    System.out.println(note);
                }
            }
        }
    }


    public void selectNote() {
        selectAllNote();
        if (noteLength == 0) {
        } else {
            System.out.println("보고싶은 메모를 선택해주세요.");
            int memoNum = Integer.parseInt(scanner.nextLine());
            if (notes[memoNum] != null) {
                System.out.println(notes[memoNum]);
            }
            else {
                System.out.println("해당 메모는 존재하지 않습니다.");
            }
        }

    }


    public void deleteNote() {
        selectAllNote();
        if (noteLength != 0) {
            System.out.println("삭제하고 싶은 메모를 선택해주세요.");
         
            int memoNum = Integer.parseInt(scanner.nextLine());
            if(notes[memoNum] == null) {
                System.out.println("존재하지 않는 메모입니다.");
            }
            else {
                Note note = new Note("", "");

                notes[memoNum] = note;
                System.out.println("삭제완료되었습니다.");
                
            }

        }
    }

    public void updateNote() {
        selectAllNote();
        if (noteLength == 0) {
            

        } else {

            System.out.println("수정하고 싶은 메모를 선택해주세요.");
            int memoNum = Integer.parseInt(scanner.nextLine());
            if(notes[memoNum]!= null) {
            System.out.println(notes[memoNum]);
            System.out.println("수정하고 싶은 제목을 입력해주세요.");
            String title = scanner.nextLine();
            System.out.println("수정하고 싶은 내용을 입력해주세요.");
            String content = scanner.nextLine();
            Note note = new Note(title, content);
            notes[memoNum] = note;
            System.out.println("수정이 완료되었습니다.");
            }
            else {
                System.out.println("해당 번호의 메모가 없습니다.");
            }
        }
    }
}

