import java.util.List;

import domain.Photo;
import io.InputReader;

public class StartUp {
	public static void main(String args[]) {
		System.out.println("Hello world");
		System.out.println("This is my test commit");
		
		List<Photo> photos = InputReader.readInputFile("resources/a_example.txt");
		
		for(Photo photo : photos) {
			System.out.println(photo);
		}
	}
}
