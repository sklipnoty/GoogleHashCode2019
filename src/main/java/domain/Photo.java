package domain;

import java.util.ArrayList;
import java.util.List;

public class Photo {
	public List<String> tags = new ArrayList<String>();	
	public boolean vertical;
	public int numberOfTags;
	@Override
	public String toString() {
		return "Photo [tags=" + tags + ", vertical=" + vertical + ", numberOfTags=" + numberOfTags + "]";
	}
	
	
}
