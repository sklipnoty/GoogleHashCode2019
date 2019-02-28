package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Photo;

public class InputReader {
	
	/* 
	           
	            String[] constraints = lines.get(0).split(" ");
	            lines.remove(0);
	            
	            int row = Integer.valueOf(constraints[0]);
	            int col = Integer.valueOf(constraints[1]);
	            int numberOfIngredients = Integer.valueOf(constraints[2]);
	            int maxNumberCells = Integer.valueOf(constraints[3]);*/
	
	public static List<Photo> readInputFile(String fileName) {
        try {
         List<Photo> photos = new ArrayList<Photo>();
		 Path path = Paths.get(fileName);
         Path absolutePath = path.toAbsolutePath();
		 List<String> lines = Files.readAllLines(absolutePath);
		 
		 int numberOfPhotosInCollection = Integer.valueOf(lines.get(0));
		 lines.remove(0);
		 int index = 0;

		 for(String photoLine : lines) {
			  
			  Photo photo = new Photo();	
			  String[] fields = photoLine.split(" ");
			  boolean vertical = false;
			  
			 // System.out.println(Arrays.deepToString(fields));
			  
			  if(fields[0].charAt(0) == 'H') {
				  vertical = false;
			  } else {
				  vertical = true;
			  }
			  
			  int numberOfTags = Integer.valueOf(fields[1]);
			  
			  for(int i  = 2; i < fields.length; i++) {
				  photo.tags.add(fields[i]);
			  }
			  
			  photo.vertical = vertical;
			  photo.numberOfTags = numberOfTags;
			  photo.index = index;
			  index += 1;
			  
			  photos.add(photo);
		 }
		 
			return photos;
		 
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;
		
	}

}
