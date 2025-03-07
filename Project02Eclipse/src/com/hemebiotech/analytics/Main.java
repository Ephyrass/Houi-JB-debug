package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main application class to run the symptom analytics process
 */
public class Main {
    
    public static void main(String[] args) {
        // Initialize reader and writer with file paths
        ISymptomReader reader = new ReadSymptomDataFromFile("src/resources/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        
        // Create the analytics counter with our reader and writer
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        
        // Get the list of symptoms from the file
        List<String> symptoms = analyticsCounter.getSymptoms();
        
        // Count occurrences of each symptom
        Map<String, Integer> symptomCount = analyticsCounter.countSymptoms(symptoms);
        
        // Sort the symptoms alphabetically
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCount);
        
        // Write results to output file
        analyticsCounter.writeSymptoms(sortedSymptoms);
        
    }
}