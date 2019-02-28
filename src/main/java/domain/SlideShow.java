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
			Slide newSlide = new Slide();
			int photoIndex = random.nextInt(photos.size()-1);
			
			// take 2 pictures
			if(photos.get(photoIndex).vertical) {
				newSlide.photos.add(photos.get(photoIndex))
				//get another vertical photo
				for (Photo vertPhoto : photos)
					int nextPhoto = random.nextInt(photos.size()-1);
					if(photos.get(nextPhoto).vertical) {
						slide.photos.add()
					
					}
			// take 1 picture
			} else {
				newSlide.photos.add(photos.get(photoIndex))
				
			}
		}
		
		
		return currentSlides;
	}
}
