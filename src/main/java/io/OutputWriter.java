package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import domain.Photo;
import domain.Slide;
import domain.SlideShow;

public class OutputWriter {
    
	
	public void writeOutput(List<Slide> slideshow) throws IOException {
		filename = "output.txt"
		FileWriter fileWriter = new FileWriter(filename);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		int numSlides = slideshow.size();
		
		printWriter.print(numSlides + "");
		
		for(Slide slide : slideshow) {
			String line = "";
			if (slide.photos.size() == 2) {
				int i = photos.indexOf(slide.photos.get(0));
				int j = photos.indexOf(slide.photos.get(1));
				line = i.toString() + " " + j.toString();
				printWriter.print(line);
			} else {
				int i = photos.indexOf(slide.photos.get(0));
				printWriter.print(i.toString());
			}
		}
		
		printWriter.close();
		 
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return null;
	
	}

}
