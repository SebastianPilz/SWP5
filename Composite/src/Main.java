
public class Main {

	public static void main(String[] args) {
		Composite building = new Composite();
		Composite corridor = new Composite();
		Composite room = new Composite();
		Leaf chair = new Leaf();
		Leaf table = new Leaf();
		Leaf window = new Leaf();
		
		building.add(room);
		building.add(corridor);
		building.add(chair);
		room.add(chair);
		room.add(table);
		room.add(window);	
	}

}
