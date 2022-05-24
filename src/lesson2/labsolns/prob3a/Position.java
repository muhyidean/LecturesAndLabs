package lesson2.labsolns.prob3a;
import java.util.*;
public class Position {
	String id; 
	ManagerPosition mp;
	Position(String id) {
		this(null,id);
	}
	Position(ManagerPosition position, String id) {
		mp = position;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public String toString() {
		boolean isManPos = this instanceof ManagerPosition;
		return "\nPosition " + id + " is: \n"
		+"1. A ManagerPosition? " + isManPos + "\n"
		+"2. If yes, does it manage anyone? If so how many? " + 
		     (isManPos ? ((ManagerPosition)this).positions.size() : 0) + "\n"
		+ "3. Does this position report to any ManagerPosition? " +
		     (mp == null ? "No" : "Yes, id = " + mp.getId() + "\n\n");
	}
	public static void main(String[] args) {
		ManagerPosition m3 = new ManagerPosition("3");
		ManagerPosition m4 = new ManagerPosition(m3, "4");
		ManagerPosition m7 = new ManagerPosition("7");
	
		Position[] noManagerPositions = 
			{new Position("1"), new Position("2"),  };
		Position[] managerPositions = {m3, m4};
		Position p5 = new Position(m3,"5");
		m3.addPosition(p5);
		Position p6 = new Position(m4,"6");
		m4.addPosition(p6);
		Position[] positionsWithManager = {p5, p6};
		Position[] managerPositionsNoOneReports = {m7};
		System.out.println(Arrays.toString(positionsWithManager));
		System.out.println(Arrays.toString(managerPositions));
		
	}
}

class ManagerPosition extends Position {
	List<Position> positions = new ArrayList<>();
	ManagerPosition(String id) {
		super(id);
	}
	ManagerPosition(ManagerPosition m, String id) {
		super(m,id);
	}
	public void addPosition(Position position) {
		positions.add(position);
	}
}
