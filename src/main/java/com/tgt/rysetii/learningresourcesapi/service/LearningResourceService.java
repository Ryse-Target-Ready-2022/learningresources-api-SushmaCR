package com.tgt.rysetii.learningresourcesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;

@Service
public class LearningResourceService {
	
	@Autowired
    private LearningResourceRepository learningResourcesRepo;
    public void saveLearningResources(List<LearningResource> learningResources){
        for (LearningResource learningResource:learningResources){
            learningResourcesRepo.save(learningResource);
        }
    }
    public List<LearningResource> getLearningResources(){
        return learningResourcesRepo.findAll();
    }
    public List<Double> getProfitMargins(){
        List<LearningResource> learningResources = getLearningResources();
        List<Double> profitMargins = new ArrayList<>();
        for (LearningResource learningResource:learningResources) {
            profitMargins.add((learningResource.getSellingPrice()-learningResource.getCostPrice())/learningResource.getSellingPrice());
        }
        return profitMargins;
    }
    public List<LearningResource> sortResouceByProfitMargin(){
        List<LearningResource> learningResources = getLearningResources();
        learningResources.sort((lr1,lr2)->{
            Double pf11 = (lr1.getSellingPrice()- lr1.getCostPrice())/lr1.getSellingPrice();
            Double pf22 = (lr2.getSellingPrice()- lr2.getCostPrice())/lr2.getSellingPrice();
            return pf22.compareTo(pf11);
        });
        return learningResources;
    }
    public String deleteLearningResource(int id)
    {
        if(learningResourcesRepo.existsById(id))
        {
        	learningResourcesRepo.deleteById(id);
            return "Deleted the Learning Resource Successfully...!";
        }
        else
        {
            return "Sorry, Learning Resource Doesn't Exist!";
        }
    }

}