package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Photo;
import domain.Slide;

public class CalculateIntrest {
	
	
	// Slide
	public static int calculateIntrest(Slide currentPhotoSlide, Slide nextPhotoSlide)
	{
		
		
		List<Photo> currentPhotoList = currentPhotoSlide.photos;
		Set<String> currentSlideTags = new HashSet<String>();
		
		// first slide
		for (Photo photo : currentPhotoList) 
		{
			for (String string : photo.tags) 
			{
				currentSlideTags.add(string);
			}
			
		}
		
		Photo currentPhoto = new Photo();
		currentPhoto.tags. addAll(currentSlideTags);
		
		
		// second slide
		

		List<Photo> nextPhotoList = nextPhotoSlide.photos;
		Set<String> nextSlideTags = new HashSet<String>();
		
		for (Photo photo : nextPhotoList) 
		{
			for (String string : photo.tags) 
			{
				nextSlideTags.add(string);
			}
			
		}
		
		Photo nextPhoto = new Photo();
		nextPhoto.tags. addAll(nextSlideTags);
		
		int numberOfCommonTags = 0;
		int numberOfTagsInCurrentButNotNext = 0;
		int numberOfTagsInNexbutNotCurrent = 0;
		
		
		List<String> currentPhotosTags = currentPhoto.tags;
		List<String> nextPhotoTags = nextPhoto.tags;
		
		// numberOfTagsInCurrentButNotNext = currentPhotosTags.size();
		
		
		// common tags
		for (String currentTag : currentPhotosTags) 
		{
			for (String nextPhotoTag : nextPhotoTags) 
			{
				if(currentTag.equals(nextPhotoTag))
				{
					++numberOfCommonTags;
				}
			}
			
		}
		
		
		numberOfTagsInCurrentButNotNext = currentPhoto.tags.size();
		for (String nextTag : nextPhotoTags) 
		{
			for (String currentTag : currentPhotosTags) 
			{
				if(nextTag.equals(currentTag))
				{
					--numberOfTagsInCurrentButNotNext;
				}
			}
		}
		
		
		numberOfTagsInNexbutNotCurrent = nextPhoto.tags.size();
		for (String currentTag : currentPhotosTags) 
		{
			for (String nextTag : nextPhotoTags) 
			{
				if(currentTag.equals(nextTag))
				{
					--numberOfTagsInNexbutNotCurrent;
				}
			}
		}
		
		
		/*System.out.println("IntrestCheck");
		System.out.println("numberOfCommonTags : " +numberOfCommonTags);
		System.out.println("numberOfTagsInCurrentButNotNext : " +numberOfTagsInCurrentButNotNext);
		System.out.println("numberOfTagsInNexbutNotCurrent : " +numberOfTagsInNexbutNotCurrent);
		System.out.println("Result : " +Math.min(numberOfCommonTags, Math.min(numberOfTagsInCurrentButNotNext,numberOfTagsInNexbutNotCurrent)) );
		*/
		
		return Math.min(numberOfCommonTags, Math.min(numberOfTagsInCurrentButNotNext,numberOfTagsInNexbutNotCurrent));
		
	}

	public static int calculateIntrest(List<Slide> solution) {
		int score = 0;
		
		for(int i = 0; i < solution.size()-1; i++) {
			score += calculateIntrest(solution.get(i), solution.get(i+1));
		}
		
		return score;
	}

}
