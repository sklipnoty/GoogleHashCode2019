package domain;

import java.util.ArrayList;
import java.util.List;

public class Photo {
	public int index;
	public List<String> tags = new ArrayList<String>();	
	public boolean vertical;
	public int numberOfTags;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfTags;
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + (vertical ? 1231 : 1237);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photo other = (Photo) obj;
		if (numberOfTags != other.numberOfTags)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (vertical != other.vertical)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Photo [tags=" + tags + ", vertical=" + vertical + ", numberOfTags=" + numberOfTags + "]";
	}
	
	
}
