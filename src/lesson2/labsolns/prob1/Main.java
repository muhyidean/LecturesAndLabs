package lesson2.labsolns.prob1;
import java.time.LocalDate;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		ProjectManager pm = new ProjectManager();
		Project p1 = new Project("01");
		Project p2 = new Project("02");
		
		//Project 1 Developers
		Developer d1 = new Developer("001");
		Developer d2 = new Developer("002");
		
		//Project 2 Developers
		Developer d3 = new Developer("003");
		Developer d4 = new Developer("004");
		
		pm.addDeveloper(d1);pm.addDeveloper(d2);pm.addDeveloper(d3);pm.addDeveloper(d4);
		
		//load up projects
		for(int i = 0; i < 6; ++i) {
			pm.updateProject(p1);
		}
		for(int i = 0; i < 6; ++i) {
			pm.updateProject(p2);
		}
		String[] featureIds = pm.getAllFeatureIds().toArray(new String[0]);
		pm.addRelease(p1, LocalDate.of(2017, 12, 10), featureIds[0]);
		pm.addRelease(p1, LocalDate.of(2017, 12, 10), featureIds[1]);
		pm.addRelease(p1, LocalDate.of(2017, 12, 20), featureIds[2]);
		pm.addRelease(p1, LocalDate.of(2017, 12, 20), featureIds[3]);
		pm.addRelease(p1, LocalDate.of(2017, 12, 30), featureIds[4]);
		pm.addRelease(p1, LocalDate.of(2017, 12, 30), featureIds[5]);
		
		pm.addRelease(p2, LocalDate.of(2017, 12, 5), featureIds[6]);
		pm.addRelease(p2, LocalDate.of(2017, 12, 5), featureIds[7]);
		pm.addRelease(p2, LocalDate.of(2017, 12, 15), featureIds[8]);
		pm.addRelease(p2, LocalDate.of(2017, 12, 15), featureIds[9]);
		pm.addRelease(p2, LocalDate.of(2017, 12, 28), featureIds[10]);
		pm.addRelease(p2, LocalDate.of(2017, 12, 28), featureIds[11]);
		
		//load up Developers for Project 1
		pm.assignFeature(p1.lookupFeature(featureIds[0]), d1);
		pm.assignFeature(p1.lookupFeature(featureIds[2]), d1);
		pm.assignFeature(p1.lookupFeature(featureIds[4]), d1);
		
		pm.assignFeature(p1.lookupFeature(featureIds[1]), d2);
		pm.assignFeature(p1.lookupFeature(featureIds[3]), d2);
		pm.assignFeature(p1.lookupFeature(featureIds[5]), d2);
		
		
		//load up Developers for Project 2
		pm.assignFeature(p2.lookupFeature(featureIds[6]), d3);
		pm.assignFeature(p2.lookupFeature(featureIds[8]), d3);
		pm.assignFeature(p2.lookupFeature(featureIds[10]), d3);
		
		pm.assignFeature(p2.lookupFeature(featureIds[7]), d4);
		pm.assignFeature(p2.lookupFeature(featureIds[9]), d4);
		pm.assignFeature(p2.lookupFeature(featureIds[11]), d4);
		
		//expected output: [123, 123, 101, 629]
		System.out.println(featuresTwoDaysOrLessRemaining(pm));
		

	}
	//Returns a list of features across all projects for which the time remaining (starting from
	//now ( = LocalDate.now()) ) 
	//to complete development of the feature (according to the
	//developer in charge) is 2 days or less
	static List<Feature> featuresTwoDaysOrLessRemaining(ProjectManager pm) {
		List<Developer> devs = pm.getDevelopers();
		List<Feature> retval = new ArrayList<>();
		for(Developer d: devs) {
			List<Feature> assignedFeatures = d.getAssignedFeatures();
			for(Feature f: assignedFeatures) {
				double daysLeft = d.timeRemaining(f, LocalDate.now());
				if(daysLeft <= 2.0 && !retval.contains(f)) {
					retval.add(f);
				}
			}
		}
		return retval;
	}

}
