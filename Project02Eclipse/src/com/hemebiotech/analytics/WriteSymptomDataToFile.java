package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

/**
 * Writes counted symptoms to a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String outputFilePath;

    /**
     * Constructor
     * 
     * @param outputFilePath path to the file where symptoms will be written
     */
    public WriteSymptomDataToFile(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter(outputFilePath);
            
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
