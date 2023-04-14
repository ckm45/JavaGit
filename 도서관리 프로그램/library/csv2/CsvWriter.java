package com.ckm.library.csv2;

import java.util.List;

public interface CsvWriter {
    String getHeader();
    List<String[]> getData();

}
