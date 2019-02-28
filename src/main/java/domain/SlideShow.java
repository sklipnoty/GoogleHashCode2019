package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlideShow {
	
	public List<Slide> currentSlides = new ArrayList<>();
	
	
	public List<Slide> makeRandomSlideShow(List<Photo> photos) {
		
		Random random = new Random();
		int randomInitialPhoto = random.nextInt(photos.size()-1);
		Slide slide = new Slide();
		slide.photos.add(photos.get(randomInitialPhoto));
		currentSlides.add(slide);	
		photos.remove(randomInitialPhoto);
		
		for(Photo photo : photos) {
			// take 2 pictures
			if(random.nextBoolean()) {
				
			// take 1 picture
			} else {
				
			}
		}
		
		
		return currentSlides;
	}
}
