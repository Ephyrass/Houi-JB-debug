package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main application class to run the symptom analytics process
 */
public class Main {
    
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("src/resources/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("src/resources/result.out");
        
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        
        List<String> symptoms = analyticsCounter.getSymptoms();
        
        Map<String, Integer> symptomCount = analyticsCounter.countSymptoms(symptoms);
        
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCount);
        
        analyticsCounter.writeSymptoms(sortedSymptoms);

    }
}