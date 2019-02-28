package domain;

import java.util.ArrayList;
import java.util.List;

public class Slide {
	public List<Photo> photos = new ArrayList<>();

	@Override
	public String toString() {
		return "Slide [photos=" + photos + "]";
	}
	
}
