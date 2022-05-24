package lesson2.labsolns.prob1;
import java.time.LocalDate;
import java.util.*;
public class Project {
	private String projectId;
	private List<Release> releases = new ArrayList<>();
	private List<Feature> features = new ArrayList<>();
	public Project(String id) {
		projectId = id;
	}
	
	public void addRelease(LocalDate relDate, String featureId) {
		Feature f = lookupFeature(featureId);
		releases.add(new Release(relDate, f));
	}
	
	public Feature lookupFeature(String featureId) {
		for(Feature f : features) {
			if(f.getFeatureId().equals(featureId)) {
				return f;
			}
		}
		return null;
	}
	public void addFeature(Feature f) {
		features.add(f);
	}
	public String getProjectId() {
		return projectId;
	}
	
	public List<Feature> getFeatures() {
		return features;
	}
	
	public List<Release> getReleases() {
		return releases;
	}
	

}
