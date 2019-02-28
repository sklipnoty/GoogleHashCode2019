package utils;

import java.util.ArrayList;
import java.util.List;

import domain.Photo;

public class Copier {
	
	public static List<Photo> duplicate(List<Photo> photos) {
		
		List<Photo> newList = new ArrayList<>();
		
		for(Photo photo : photos) {
			Photo p = new Photo();
			p.numberOfTags = photo.numberOfTags;
			p.tags = photo.tags;
			p.vertical = photo.vertical;
			
			newList.add(p);
		}
		
		return newList;
	}
}
