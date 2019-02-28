package domain;

import java.util.ArrayList;
import java.util.List;

public class Slide {
	public List<Photo> photos = new ArrayList<>();

	@Override
	public String toString() {
		return "Slide [photos=" + photos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((photos == null) ? 0 : photos.hashCode());
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
		Slide other = (Slide) obj;
		if (photos == null) {
			if (other.photos != null)
				return false;
		} else if (!photos.equals(other.photos))
			return false;
		return true;
	}

	
	
	
}
