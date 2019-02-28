import java.util.List;

import domain.Photo;
import domain.Slide;
import domain.SlideShow;
import io.InputReader;
import io.OutputWriter;
import utils.CalculateIntrest;

public class StartUp {
	public static void main(String args[]) {
		String a = "resources/a_example.txt";
		String b = "resources/b_lovely_landscapes.txt";
		String c = "resources/c_memorable_moments.txt";
		String d = "resources/d_pet_pictures.txt";
		String e = "resources/e_shiny_selfies.txt";

		List<Photo> photos = InputReader.readInputFile(b);
		System.out.println("Read " + photos.size() + " photos.");
		SlideShow sl = new SlideShow();
		List<Slide> slides = sl.findAGoodRandomSolution(photos, 50);
		OutputWriter.writeOutput("resources/bsolution.txt", photos, slides);
	}
}
