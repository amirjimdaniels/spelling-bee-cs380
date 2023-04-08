package com.CS380.SpellingBee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/*File name getter class takes a file's directory path as input. The getALLFileNames function loops through all
 * listed files in the directory and retrieves their names from the directory. The names are then returned as a List of Strings to be passed into the 
 * getCompleteWords function in the reader class
 */
public class fileNameGetter {

    public List<String> getAllFileNames(String directoryPath) {
        List<String> fileNames = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getAbsolutePath());
                }
            }
        }
        return fileNames;
    }

}