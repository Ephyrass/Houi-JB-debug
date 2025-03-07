package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class handles the analytics process for symptom data:
 * - Reading symptoms from a data source
 * - Counting symptom occurrences
 * - Sorting symptoms alphabetically
 * - Writing results to an output destination
 */
public class AnalyticsCounter {
    
    // Reader interface for getting symptom data from source
    private final ISymptomReader reader;
    // Writer interface for outputting processed symptom data
    private final ISymptomWriter writer;
    
    /**
     * Constructor that initializes the symptom reader and writer
     * 
     * @param reader Object that implements the ISymptomReader interface
     * @param writer Object that implements the ISymptomWriter interface
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Retrieves the list of symptoms from the data source
     * 
     * @return List of symptoms
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }
    
    /**
     * Counts occurrences of each symptom in the provided list
     * 
     * @param symptoms List of symptoms to analyze
     * @return Map with symptoms as keys and occurrence counts as values
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsCount = new HashMap<>();
        
        for (String symptom : symptoms) {
            if (symptomsCount.containsKey(symptom)) {
                symptomsCount.put(symptom, symptomsCount.get(symptom) + 1);
            } else {
                symptomsCount.put(symptom, 1);
            }
        }
        
        return symptomsCount;
    }
    
    /**
     * Sorts symptoms alphabetically by name
     * 
     * @param symptoms Map of symptoms with their occurrence counts
     * @return Map sorted alphabetically by keys
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }
    
    /**
     * Writes the result to an output file
     * 
     * @param symptoms Map of symptoms with their occurrence counts
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

}
