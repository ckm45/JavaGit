package com.ckm.main;

enum KeyType {
    PADLOCK, BUTTON, DIAL, FINGER
}


public class StrongBox<E> {
    private E data; // 4-1 (1) (2) 인스턴스 담으려고 만들었다
    private int count; // 사용 횟수를 카운트 할 변수

    private KeyType keytype; // 열쇠 종류를 나타내는 필드 변수

    public StrongBox(KeyType keytype) {
        this.keytype = keytype; // 열쇠 종류를 받는 생성자
    }

    public StrongBox(int count) {

        this.count = count;
    }


    public void put(E data) {
        this.data = data;
    }

    public E get() {
        count++;
        E result = null;
        switch (keytype) {
            case PADLOCK:
                if (count > 1024) {
                    result = this.data;
                }
                break;
            case BUTTON:
                if (count > 10000) {
                    result = this.data;
                }
                break;
            case DIAL:
                if (count > 30000) {
                    result = this.data;
                }
                break;
            default:
                if (count > 1000000) {
                    result = this.data;
                }
        }
        return result;
    }

    public StrongBox() {
        super();
    }
}
