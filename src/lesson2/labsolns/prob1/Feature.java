package lesson2.labsolns.prob1;

/** 
 * Details about this class are not specified,
 * other than the fact that every Feature has
 * an id.
 
 */
public class Feature {
	private String featureId;
	
	public Feature(String id) {
		featureId = id;
	}

	public String getFeatureId() {
		return featureId;
	}
	
	@Override
	public String toString() {
		return featureId;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Feature)) return false;
		Feature f = (Feature)ob;
		return f.featureId.equals(featureId);
	}
	
}
