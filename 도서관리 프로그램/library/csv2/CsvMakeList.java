package com.ckm.library.csv2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CsvMakeList {
    public static List<String[]> readCSV(String filename) {
        List<String[]> rows = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "EUC-KR"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String[] row = new String[st.countTokens()];
                int i = 0;
                while (st.hasMoreTokens()) {
                    row[i++] = st.nextToken();
                }
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
}