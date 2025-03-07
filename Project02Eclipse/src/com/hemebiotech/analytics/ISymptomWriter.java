package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Writes the symptom data to the output
     * 
     * @param symptoms Map containing symptoms and their counts
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
