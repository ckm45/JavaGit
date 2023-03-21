package com.ckm.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // 1. 원본 File, 복사할 File 준비
        File file = new File("data.txt");
        File newFile = new File("save.txt");

        // 2. FileInputStream, FileOutputStream 준비
        FileInputStream input = new FileInputStream(file);
        FileOutputStream output = new FileOutputStream(newFile);

        // 3. 한번에 read하고, write할 사이즈 지정
        byte[] buf = new byte[1024];

        // 4. buf 사이즈만큼 input에서 데이터를 읽어서, output에 쓴다.
        int readData;
        while ((readData = input.read(buf)) > 0) {
            output.write(buf, 0, readData);
        }

        // 5. Stream close
        input.close();
        output.close();

    }
}