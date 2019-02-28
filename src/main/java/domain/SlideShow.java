package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

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

		List<Slide> currentSlides = potentialGoodCouples(photos, false);
		
		for(Slide slide : currentSlides) {
			for(Photo photo : slide.photos) {
				photos.remove(photo);
			}
		}
		
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
	
	public List<Slide> potentialGoodCouples(List<Photo> photos, boolean vertical) {
		
		TreeMap<Integer, List<Slide>> treeMapping = makeMapping(photos, vertical);
		
		List<Slide> currentSolution = new ArrayList<>();
		
		while(!treeMapping.isEmpty()) {
			Integer currentHighest = treeMapping.lastKey();
			List<Slide> possibleSolution = treeMapping.get(currentHighest);
			
			for(Slide slide : possibleSolution) {
				if(currentSolution.contains(slide)) {
					treeMapping.pollLastEntry();
					break;
				}
			}
			
			currentSolution.addAll(possibleSolution);
		}
		
		System.out.println(currentSolution.size());
		
		return currentSolution;
		
	}
	
	
	private TreeMap<Integer, List<Slide>> makeMapping(List<Photo> photos, boolean vertical) {
		TreeMap<Integer, List<Slide>> mapping = new TreeMap<>();
		Random random = new Random();
		
		for(int i = 0; i < photos.size(); i++) {
			
			Photo hPhoto = photos.get(i);
			Slide s1 = new Slide();
			
			if(vertical) {
				s1.photos.add(hPhoto);
				s1.photos.add(photos.get(random.nextInt(photos.size())));
			} else {
				s1.photos.add(hPhoto);
			}
			
			int bestScore = 0;
			List<Slide> currentBest = new ArrayList<>();
			
			for(Photo photo2 : photos) {
				Slide s2 = new Slide();
				
				if(vertical) {
					s2.photos.add(photo2);
					s2.photos.add(photos.get(random.nextInt(photos.size())));
				} else {
					s2.photos.add(photo2);
				}
				
				
				int score = CalculateIntrest.calculateIntrest(s1, s2);
				if(score > bestScore || score >= hPhoto.numberOfTags/2) {
					bestScore = score;
					currentBest = new ArrayList<>();
					currentBest.add(s1);
					currentBest.add(s2);
					mapping.put(bestScore, currentBest);
					break;
				}
			}
		}
		
		return mapping;
	}
}
