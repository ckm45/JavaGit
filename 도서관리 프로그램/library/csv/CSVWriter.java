package com.ckm.library.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class CSVWriter {

    public void writeCSV(List<String[]> dataList, String fileName) {
        File csv = new File(fileName);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csv, false), "UTF-8"));
            for (int i = 0; i < dataList.size(); i++) {
                String[] data = dataList.get(i);
                String aData = "";
                for(int j = 0; j<data.length; j++ ) {
                    if(j == data.length-1) {
                        aData += data[j];           
                    } else {
                        aData += (data[j] + ",");                                           
                    }
                }
                bw.write(aData);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}