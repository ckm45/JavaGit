package com.ckm.eee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Url {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://alimipro.com/favicon.ico");
        File newFile = new File("favicon.ico");
        InputStream is = url.openStream(); // InputStreamReader --> X
        FileOutputStream output = new FileOutputStream(newFile);

        byte[] buf = new byte[1024];

        int readData;
        while ((readData = is.read(buf)) > 0) {
            output.write(buf, 0, readData);
        }
        is.close();
        output.close();
    }

}
