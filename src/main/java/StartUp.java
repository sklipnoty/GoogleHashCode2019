import java.util.List;

import domain.Photo;
import domain.Slide;
import domain.SlideShow;
import io.InputReader;

public class StartUp {
	public static void main(String args[]) {
		
		List<Photo> photos = InputReader.readInputFile("resources/a_example.txt");
		System.out.println("Read " + photos.size() + " photos.");
		SlideShow sl = new SlideShow();
		List<Slide> slides = sl.makeRandomSlideShow(photos);
		
		for(Slide slide : slides) {
			System.out.println(slide);
		}
	}
}
