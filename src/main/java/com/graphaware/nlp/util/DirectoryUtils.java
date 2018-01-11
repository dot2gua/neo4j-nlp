package com.graphaware.nlp.util;

import java.io.File;

public class DirectoryUtils {

    public static String getFileOutputNameBasedOnSourceFilePathAndOutputName(String sourceFilePath, String outputFile) {
        String[] dirPathSplit = sourceFilePath.split(File.separator);
        String fileOutToUse;
        if (dirPathSplit.length > 2) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < dirPathSplit.length - 1; ++i) {
                sb.append(dirPathSplit[i]).append(File.separator);
            }
            fileOutToUse = sb.toString() + outputFile;
        } else {
            fileOutToUse = outputFile;
        }

        return fileOutToUse;
    }

}
