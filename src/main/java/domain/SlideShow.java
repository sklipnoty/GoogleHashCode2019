package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import utils.CalculateIntrest;
import utils.Copier;

public class SlideShow {
		
	public List<Slide> findAGoodRandomSolution(List<Photo> photos, int numberOfIterations) {
        List<Slide> currentSolution = null;
        int bestScore = 0;

        for(int i = 0; i < numberOfIterations; i++) {
        	
            List<Slide> solution = makeRandomSlideShow(Copier.duplicate(photos));
            int score = CalculateIntrest.calculateIntrest(solution);
            System.out.println("Iteration " + i + " CurrentScore " +score);

            if(score > bestScore) {
                bestScore = score;
                currentSolution = solution;
            }
        }

        return currentSolution;
    }
	
	public List<Slide> makeRandomSlideShow(List<Photo> photos) {

		List<Slide> currentSlides = new ArrayList<>();
		
		Random random = new Random();
		LinkedList<Photo> verticalPhotos = new LinkedList<>();
		LinkedList<Photo> horizontalPhotos = new LinkedList<>();
		
		for(Photo photo : photos) {
			if(photo.vertical) {
				verticalPhotos.add(photo);
			} else {
				horizontalPhotos.add(photo);
			}
		}
		
		Collections.shuffle(verticalPhotos);
		Collections.shuffle(horizontalPhotos);
		
		while(verticalPhotos.size() > 1 || horizontalPhotos.size() > 0) {		
			Slide newSlide = new Slide();
			
			if(random.nextBoolean() && !horizontalPhotos.isEmpty()) {
				newSlide.photos.add(horizontalPhotos.removeFirst());
				currentSlides.add(newSlide);
			}
			else if((verticalPhotos.size() > 1)) {
				newSlide.photos.add(verticalPhotos.removeFirst());
				newSlide.photos.add(verticalPhotos.removeFirst());
				currentSlides.add(newSlide);
			}
			
			
		}
		
		
		return currentSlides;
	}
}
