package lesson2.labsolns.prob1;
import java.time.LocalDate;
import java.util.*;
public class Release {
	private LocalDate releaseDate;
	private List<Feature> featureList = new ArrayList<>();
	public Release(LocalDate relDate, Feature feature) {
		releaseDate = relDate;
		addFeature(feature);
	}
	
	public void addFeature(Feature f) {
		featureList.add(f);
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	
	
	
}
