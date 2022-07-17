package com.tgt.rysetii.learningresourcesapi.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;

public class LearningResourceService {
	public List<LearningResource> getLearningResource(){
        File learningResourceFile = new File("learningResources.csv");
        return readLearningResourcesFromCSV(learningResourceFile);
    }
	private List<LearningResource> readLearningResourcesFromCSV(File csv){
        List<LearningResource> learningResources = new ArrayList<>();
        try {
            FileReader fr1 = new FileReader(csv);
            try (BufferedReader br1 = new BufferedReader(fr1)) {
				String line = null;
				line = br1.readLine();
				while(line!=null) {
				    String[] attributes = line.split(",");
				    LearningResource learningResource = createLearningResource(attributes);
				    learningResources.add(learningResource);
				    line = br1.readLine();
				}
			}
        } catch(Exception e) {
            System.out.println(e);
        }
        return learningResources;
    }
    private LearningResource createLearningResource(String[] attributes){
        Integer id = Integer.parseInt(attributes[0].replaceAll("\\D+",""));
        String name = attributes[1];
        Double costPrice = Double.parseDouble(attributes[2]);
        Double sellingPrice = Double.parseDouble(attributes[3]);
        LearningResourceStatus learningResourcestatus = LearningResourceStatus.valueOf(attributes[4]);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate createdDate = LocalDate.parse(attributes[5],dtf1);
        LocalDate publishedDate = LocalDate.parse(attributes[6],dtf1);
        LocalDate retiredDate = LocalDate.parse(attributes[7],dtf1);
        LearningResource learningResource = new LearningResource(id, name, costPrice, sellingPrice, learningResourcestatus, createdDate, publishedDate, retiredDate);
        return learningResource;
    }


}
