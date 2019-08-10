package com.zhukov.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataProvider {
    private String filePath;

    public DataProvider(String fp) {
        filePath = fp;
    }

    public List<String> getListOfEntriesFromFile() throws IOException {
        Scanner sc = new Scanner(new File(filePath));

        List<String> entries = new ArrayList<>();

        while(sc.hasNextLine()) {
            entries.add(sc.nextLine());
        }

        return entries;
    }




}
