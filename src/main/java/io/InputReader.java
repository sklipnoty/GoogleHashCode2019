package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InputReader {
	
	/* 
	           
	            String[] constraints = lines.get(0).split(" ");
	            lines.remove(0);
	            
	            int row = Integer.valueOf(constraints[0]);
	            int col = Integer.valueOf(constraints[1]);
	            int numberOfIngredients = Integer.valueOf(constraints[2]);
	            int maxNumberCells = Integer.valueOf(constraints[3]);*/
	
	public static void readInputFile(String fileName) {
        try {
		 Path path = Paths.get(fileName);
         Path absolutePath = path.toAbsolutePath();
			List<String> lines = Files.readAllLines(absolutePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
