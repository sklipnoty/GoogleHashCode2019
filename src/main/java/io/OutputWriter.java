package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import domain.Photo;
import domain.Slide;
import domain.SlideShow;

public class OutputWriter {
    
	
	public static void writeOutput(String outputName, List<Photo> photos, List<Slide> slideshow) {
		try {
			String filename = outputName;
			FileWriter fileWriter = new FileWriter(filename);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			int numSlides = slideshow.size();
			
			printWriter.println(numSlides + "");
			
			for(Slide slide : slideshow) {
				String line = "";
				if (slide.photos.size() == 2) {
					int i = photos.indexOf(slide.photos.get(0));
					int j = photos.indexOf(slide.photos.get(1));
					line = String.valueOf(i) + " " + String.valueOf(j);
					printWriter.println(line);
				} else {
					int i = photos.indexOf(slide.photos.get(0));
					printWriter.println(String.valueOf(i));
				}
			}
			
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
