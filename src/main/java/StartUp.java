import java.util.List;

import domain.Photo;
import domain.Slide;
import domain.SlideShow;
import io.InputReader;
import utils.CalculateIntrest;

public class StartUp {
	public static void main(String args[]) {
		
		List<Photo> photos = InputReader.readInputFile("resources/a_example.txt");
		System.out.println("Read " + photos.size() + " photos.");
		SlideShow sl = new SlideShow();
		List<Slide> slides = sl.makeRandomSlideShow(photos);
		
		for(Slide slide : slides) {
			System.out.println(slide);
		}
		
		
		// Calculate intrest testing
		/*
		Slide a = new Slide();
		Photo aa = new Photo();
		aa.tags.add("aaa");
		aa.tags.add("bbb");
		aa.tags.add("ccc");
		a.photos.add(aa );
		
		Slide b = new Slide();
		Photo bb = new Photo();
		bb.tags.add("ccc");
		bb.tags.add("dd");
		bb.tags.add("ee");
		b.photos.add(bb);
		
		int intrest = CalculateIntrest.CalculateIntrest(a, b);
		
		System.out.println( " intrest: " +  intrest);
		*/
		
		
	// Calculate intrest testing
		
		Slide a = new Slide();
		Photo aa = new Photo();
		aa.tags.add("aaa");
		aa.tags.add("bbb");
		aa.tags.add("eee");
		aa.tags.add("bbb");
		aa.tags.add("ccc");
		a.photos.add(aa );
		
		Slide b = new Slide();
		Photo bb = new Photo();
		bb.tags.add("ccc");
		bb.tags.add("bbb");
		bb.tags.add("eee");
		bb.tags.add("bbb");
		bb.tags.add("ee");
		b.photos.add(bb);
		
		int intrest = CalculateIntrest.CalculateIntrest(a, b);
		
		System.out.println( " intrest: " +  intrest);
		
	}
}
