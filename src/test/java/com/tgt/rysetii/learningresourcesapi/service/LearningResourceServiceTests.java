package com.tgt.rysetii.learningresourcesapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;

@ExtendWith(MockitoExtension.class)
public class LearningResourceServiceTests {
	
	@Mock
	LearningResourceRepository lrr;
	
	@InjectMocks
	LearningResourceService lrs;
	
	@Test
	public void getProfiMarginsOfALL() {
		List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);
        
        List<Double> expectedProfitMargins = new ArrayList<>();
        for (LearningResource learningResource:learningResources) {
            expectedProfitMargins.add((learningResource.getSellingPrice()-learningResource.getCostPrice())/learningResource.getSellingPrice());
        }
        
        when(lrr.findAll()).thenReturn(learningResources);

        List<Double> actualProfitMargins = lrs.getProfitMargins();
        assertEquals(expectedProfitMargins, actualProfitMargins, "Wrong profit margins");
	}
	@Test
    public void sortTheLearningResourceBasedOnProfitMarginInNonIncreasingOrder(){
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);

        learningResources.sort((lr1, lr2) -> {
            Double profitMargin1 = (lr1.getSellingPrice() - lr1.getCostPrice())/lr1.getSellingPrice();
            Double profitMargin2 = (lr2.getSellingPrice() - lr2.getCostPrice())/lr2.getSellingPrice();

            return profitMargin2.compareTo(profitMargin1) ;
        });

        when(lrr.findAll()).thenReturn(learningResources);

        List<LearningResource> learningResourcesSorted = lrs.sortResouceByProfitMargin();

        assertEquals(learningResources, learningResourcesSorted, "The learning resources are not sorted by profit margin");
    }
	 @Test
	public void saveTheLearningResources(){
	        List<LearningResource> learningResources = new ArrayList<>();
	        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
	        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
	        LearningResource learningResource3 = new LearningResource(1313, "Test Name 3", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
	        learningResources.add(learningResource1);
	        learningResources.add(learningResource2);
	        learningResources.add(learningResource3);

	        lrs.saveLearningResources(learningResources);

	        verify(lrr, times(learningResources.size())).save(any(LearningResource.class));
	    }
	 @Test
	 public void deleteLearningResourceById(){
	        int id = 1234;
	        lrs.deleteLearningResource(id);
	        verify(lrr, times(1)).deleteById(id);
	    }
	    


}
