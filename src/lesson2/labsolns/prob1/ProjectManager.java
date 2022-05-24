package lesson2.labsolns.prob1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
	private List<Project> projects = new ArrayList<>();
	private List<Developer> developers = new ArrayList<>();
	private List<String> allFeatureIds = new ArrayList<>();
	public ProjectManager() {}
	
	public void addProject(Project p) {
		projects.add(p);
	}
	public void addFeatureId(String id) {
		allFeatureIds.add(id);
	}
	public void updateProject(Project p) {
		String id = Util.nextFeatureId();
		addFeatureId(id);
		Feature f = new Feature(id);
		p.addFeature(f);
	}
	public void addRelease(Project p, LocalDate releaseDate, String featureId) {
		p.addRelease(releaseDate, featureId);
	}
	
	public void addDeveloper(Developer d) {
		developers.add(d);
	}
	
	public void assignFeature(Feature f, Developer d) {
		d.addFeature(f);
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	public List<Developer> getDevelopers() {
		return developers;
	}
	public List<String> getAllFeatureIds() {
		return allFeatureIds;
	}

}
