package com.ckm.sample;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main16_2 {

    public static void main(String[] args) {

        try {
            // 1. 원본 File, 복사할 File 준비
            File file = new File("data.txt");
            File newFile = new File("save.txt");

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
            // BufferedOutputStream output = new BufferedOutputStream(new
            // FileOutputStream(newFile));
            // FileInputStream input = new FileInputStream(file);
            // FileOutputStream output = new FileOutputStream(newFile);
            // 2. FileInputStream, FileOutputStream 준비



            // 3. 한번에 read하고, write할 사이즈 지정
            byte[] buf = new byte[1024];

            // 4. buf 사이즈만큼 input에서 데이터를 읽어서, output에 쓴다.
            // int readData;
            // while ((readData = input.read(buf)) > 0) {
            // output.write(buf, 0, readData);
            // }


            FileOutputStream fos = new FileOutputStream("save.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry zipEntry = new ZipEntry(newFile.getName());
            zipOut.putNextEntry(zipEntry);

            int length;
            while ((length = fis.read(buf)) >= 0) {
                zipOut.write(buf, 0, length);
            }
            fis.close();

            // 5. Stream close
            input.close();
            // output.close();

            zipOut.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
