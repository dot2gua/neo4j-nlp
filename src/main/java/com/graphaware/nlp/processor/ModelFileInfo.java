package com.graphaware.nlp.processor;

import com.graphaware.nlp.util.FileUtils;

public class ModelFileInfo {

    private final String workingDirectory;

    private final String inputFile;

    private final String outputFile;

    public ModelFileInfo(String workingDirectory, String inputFile, String outputFile) {
        this.workingDirectory = workingDirectory;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public String getInputFile() {
        return FileUtils.resolveFilePath(workingDirectory, inputFile);
    }

    public String getOutputFile() {
        return FileUtils.resolveFilePath(workingDirectory, outputFile);
    }
}
