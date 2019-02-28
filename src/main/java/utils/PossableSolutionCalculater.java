package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Photo;
import domain.Slide;

public class PossableSolutionCalculater {
	
	public static void doSolution (List<Photo>  photos)
	{

		List<Slide> slideSolution =  new ArrayList<>(); 
		
		// add random photo, remo
		Slide firstSlide = new Slide();
		
		int randomPhoto = 2;
		
		Photo firstPhoto = photos.get(randomPhoto);
		photos.remove(randomPhoto);
		
		firstSlide.photos.add(firstPhoto);
		
		
		int bestScore = 0;
		List<Slide> currentBest = new ArrayList<Slide>() ;
		
		
		// this needs to be a set calculated number.
		// max size is number of horizontal + (number of vertical /2)
		
		
		for (int i = 0; i < photos.size(); i++)
		{
			
			for (Photo currPhoto : photos) 
			{
				Slide currentTestingSlide = new Slide();
				int score = -1; // to make sure at least one 0 score is added.
				// create slide
				if(	currPhoto.vertical)
				{
					
					
					
					int tempScore = -1;
					
					List<Photo> photosWithoutCurrent =  photos;
					photosWithoutCurrent.remove(currPhoto);
					
					
					List<Slide> currBestSlides = new ArrayList<Slide>();
					
					for (Photo photoCurrTest : photosWithoutCurrent) 
					{
						
						Slide currentTestingTempSlide = new Slide();
						currentTestingTempSlide.photos.add(photoCurrTest);
						currentTestingTempSlide.photos.add(currPhoto);
						
						int tempcurrScore =  CalculateIntrest.calculateIntrest(slideSolution.get(slideSolution.size() - 1), currentTestingTempSlide) ;
						
						if(tempScore > tempcurrScore)
						{
							currBestSlides = new ArrayList<Slide>();
							currBestSlides.add(currentTestingTempSlide);
							tempScore = tempcurrScore;
						}
						
						if(tempScore == tempcurrScore)
						{
							currBestSlides.add(currentTestingTempSlide);
							tempScore = tempcurrScore;
						}
					}
					// select best one of slides
					
					if(tempScore >= score )
					{
						if(currBestSlides.size() > 1)
						{
							Random random = new Random();
							int randomSelect = random.nextInt(currBestSlides.size()-1);
							currentTestingSlide= currBestSlides.get(randomSelect);
						}
						else
						{
							currentTestingSlide = currBestSlides.get(0);
						}
						
						score = tempScore;
					}
					
				}
				else
				{
					currentTestingSlide.photos.add(currPhoto);
					score = CalculateIntrest.calculateIntrest(slideSolution.get(slideSolution.size() - 1), currentTestingSlide) ;
				}
				
				if(score > bestScore)
				{
					currentBest = new ArrayList<Slide>();
					currentBest.add(currentTestingSlide);
				}
				
				if(score == bestScore)
				{
					currentBest.add(currentTestingSlide);
				}
			}
			
			if(currentBest.size() == 1)
			{
				// ADD CHECK for 0 score here, maybe...
				
				slideSolution.add(currentBest.get(0));
				System.out.println(currentBest.get(0));
				
				for (Photo photo : currentBest.get(0).photos) {
					// this might not work
					photos.remove(photo);
					
				}
			}
			else
			{
				// select random
				// CHANGE TO INDEX 
				Random random = new Random();
				int randomSelect = random.nextInt(currentBest.size()-1);
				
				slideSolution.add(currentBest.get(randomSelect));
				System.out.println(currentBest.get(randomSelect));
				
				for (Photo photo : currentBest.get(randomSelect).photos) {
					// this might not work
					// CHANGE TO INDEX 
					photos.remove(photo);
				}
			}
		}
		
		// SOLUTION TO PROBLEM:
		
		// !!!!!!!!!!!! slideSolution

			
	}

}
