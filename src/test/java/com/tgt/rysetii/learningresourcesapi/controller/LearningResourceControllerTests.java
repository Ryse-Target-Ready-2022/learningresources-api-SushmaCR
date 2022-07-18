package com.tgt.rysetii.learningresourcesapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.rysetii.learningresourcesapi.controllers.LearningResourceController;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;

@WebMvcTest(LearningResourceController.class)
public class LearningResourceControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private LearningResourceService lrs;
	
	@Test
	public void getAllLearningResources() throws Exception
	{
		List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);

        String expectedResponse = objectMapper.writeValueAsString(learningResources);

        when(lrs.getLearningResources()).thenReturn(learningResources);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/Resources/"))
                                            .andExpect(status().isOk())
                                            .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
	}
	@Test
    public void saveTheGivenLearningResources() throws Exception {
        List<LearningResource> inputLearningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        inputLearningResources.add(learningResource1);
        inputLearningResources.add(learningResource2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/Resources/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(inputLearningResources)))
        .andExpect(status().isCreated());
    }

    @Test
    public void deleteTheRequestedLearningResource() throws Exception {
        int inputLearningResourceId = 1234;

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/Resources/learningresource/" + inputLearningResourceId))
                    .andExpect(status().isOk());
    }

}
