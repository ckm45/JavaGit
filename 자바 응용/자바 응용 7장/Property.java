package com.ckm.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Property {

    public static void main(String[] args) throws IOException {
        Reader fr = new FileReader("gradle.properties");
        Properties prop = new Properties();
        prop.load(fr);
        System.out.println(prop.getProperty("android.useAndroidX"));

    }

}
