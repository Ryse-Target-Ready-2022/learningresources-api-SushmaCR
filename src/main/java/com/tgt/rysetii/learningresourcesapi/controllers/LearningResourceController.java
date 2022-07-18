package com.tgt.rysetii.learningresourcesapi.controllers;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LearningResourceController {

    private final LearningResourceService learningresourceservice;
    @Autowired
    LearningResourceRepository repo;
    
    public LearningResourceController(LearningResourceService learningresourceservice) {
        this.learningresourceservice = learningresourceservice;
    }

    @GetMapping("/Resources")
    public List<LearningResource> getResources()
    {
        return learningresourceservice.getLearningResources();
    }
    @PostMapping("/Resources")
    public String putResources(@RequestBody List<LearningResource> learningresource)
    {

    	learningresourceservice.saveLearningResources(learningresource);
        return "Successfully Added the Resources..!";
    }
    @DeleteMapping("/Resources/{id}")
    public String deleteResource(@PathVariable int id)
    {
    	if(repo.existsById(id))
    	{
        learningresourceservice.deleteLearningResource(id);
        return "Successfully Deleted...!";
    	}
    	else
    	{
    		return "Id doesn't exist!!";
    	}
    }


}