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
			
			printWriter.print(numSlides);
			printWriter.flush();
			
			for(Slide slide : slideshow) {
				String line = "";
				if (slide.photos.size() == 2) {
					int i = slide.photos.get(0).index;
					int j = slide.photos.get(1).index;
					line = String.valueOf(i) + " " + String.valueOf(j);
					printWriter.print("\n" + line );
					printWriter.flush();

				} else {
					int i = slide.photos.get(0).index;
					printWriter.print("\n" + String.valueOf(i));
					printWriter.flush();
				}
			}
			
			
			
			printWriter.flush();
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
