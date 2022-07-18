package com.tgt.rysetii.learningresourcesapi.controllers;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LearningResourceController {

    private final LearningResourceService learningresourceservice;

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
        return learningresourceservice.deleteLearningResource(id);
    }


}