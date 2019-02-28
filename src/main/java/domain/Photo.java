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
		return index;
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
		if (index != other.index)
			return false;
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
