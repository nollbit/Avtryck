package se.tidensavtryck;

public class Record {

	private int type;
	
	private String representation;

	public Record(int type, String representation) {
		super();
		this.type = type;
		this.representation = representation;
	}

	public int getType() {
		return type;
	}

	public String getRepresentation() {
		return representation;
	}

	
}
