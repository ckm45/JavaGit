package com.subway.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.subway.entity.Bread;
import com.subway.entity.Source;
import com.subway.entity.Vegetable;

public class Run {
    
    public static void main(String[] args) {        
        List<Bread> breadList = new ArrayList<>();
        breadList.add(new Bread("화이트",200));
        breadList.add(new Bread("위트",150));
        breadList.add(new Bread("하티",100));
        breadList.add(new Bread("플랫브레드",300));
        
        List<Vegetable> vegetableList = new ArrayList<>();
        vegetableList.add(new Vegetable("양상추",20,500));
        vegetableList.add(new Vegetable("올리브",10,700));
        vegetableList.add(new Vegetable("오이",30,400));
        vegetableList.add(new Vegetable("피망",40,300));
        vegetableList.add(new Vegetable("양파",25,800));
        
        List<Source> sourceList = new ArrayList<>();
        sourceList.add(new Source("머스타드",100));
        sourceList.add(new Source("후추",20));
        sourceList.add(new Source("스위트어니언",50));
        sourceList.add(new Source("스위트칠리",40));
        sourceList.add(new Source("렌치",80));
        sourceList.add(new Source("트러플마요",60));
        
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("서브웨이에 오신 것을 환영합니다.");
            System.out.println("원하시는 빵을 알려주세요.");
            // 빵 조회 메소드
            for(Bread bread : breadList) {
                System.out.println(bread);
            }
            String breadName = scanner.nextLine();
            //Bread bread = new Bread(breadName);
            // 야채 조회 메소드

            System.out.println("원하시는 야채들을 알려세요");
            boolean isExit = false;
            while (!isExit) {
                for(Vegetable vegetable : vegetableList) {
                    System.out.println(vegetable);
                }
                String vegetableName = scanner.nextLine();
                
                System.out.println("그만 넣으시겠습니까? yes(1) no(2)");
                int loopexit = Integer.parseInt(scanner.nextLine());
                if (loopexit == 1) {
                    isExit = true;
                }
            }


            // 소스 조회 메소드
            System.out.println("원하시는 소스를 알려주세요.");
            for(Source source : sourceList) {
                System.out.println(source);
            }
            String sourceName = scanner.nextLine();


            System.out.println("다 합쳐서 총 ~~ 입니다.");
            break;09


        }
    }

}
