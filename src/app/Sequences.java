package app;

public class Sequences {
	private Tile[] sequences;
	
	public Sequences(Tile... tiles){
		this.sequences = tiles;
	}
	
	public boolean isSequenceComplete(){
		if(sequences[0].getValue().isEmpty()){
			return false;
		}
		return sequences[0].getValue().equals(sequences[1].getValue())
				&& sequences[0].getValue().equals(sequences[2].getValue());
	}
}
