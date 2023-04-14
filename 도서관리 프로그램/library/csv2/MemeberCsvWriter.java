package com.ckm.library.csv2;

import java.io.*;
import java.util.List;

public class MemeberCsvWriter implements CsvWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_HEADER = "id,name,address,startDay,phoneNumber,birthday";
    private List<String[]> members;

    public MemeberCsvWriter(List<String[]> members) {
        this.members = members;
    }

    @Override
    public String getHeader() {
        return FILE_HEADER;
    }

    @Override
    public List<String[]> getData() {
        return members;
    }

    public void writeCsvFile(String fileName) {
        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        boolean headerExists = false; // 파일에 header가 이미 있는지 여부

        try {
            // 파일 읽기
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                // 파일에 header가 존재하는지 확인
                if (line.equals(FILE_HEADER)) {
                    headerExists = true;
                    break;
                }
            }
            br.close();
            osw = new OutputStreamWriter(new FileOutputStream(fileName), "EUC-KR");
            bw = new BufferedWriter(osw);

            if (!headerExists) {
                // 파일 헤더 쓰기
                bw.write(FILE_HEADER);
                bw.newLine();
            }

            // List 데이터 쓰기
            for (String[] userData : members) {
                bw.write(userData[0]);
                bw.write(COMMA_DELIMITER);
                bw.write(userData[1]);
                bw.write(COMMA_DELIMITER);
                bw.write(userData[2]);
                bw.write(COMMA_DELIMITER);
                bw.write(userData[3]);
                bw.write(COMMA_DELIMITER);
                bw.write(userData[4]);
                bw.write(COMMA_DELIMITER);
                bw.write(userData[5]);
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("실패" + e.getMessage());
        } finally {
            try {
                bw.flush();
                bw.close();
                osw.close();
            } catch (IOException e) {
                System.out.println("실패" + e.getMessage());
            }
        }
    }
}