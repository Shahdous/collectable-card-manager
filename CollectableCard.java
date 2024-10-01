/**
This class represents a collectable card. 
*/
public class CollectableCard implements Comparable<CollectableCard>{
	
	/**
    The name of the set the card is from.
	*/
	private String set;
	
	/**
    The number of hit points for the card.
	*/
	private int hp;
   
	/**
    Constructs a collectable card that is from a specific set
	and with a specific number of hit points.
	@param setIn The name of the set.
	@param hpIn The number of hit points.
	*/
	public CollectableCard (String setIn, int hpIn) {
		set = setIn;
		hp = hpIn;
	}
   
   public int compareTo(CollectableCard other) {
   	if(this.set.compareTo(other.set) == 0) {
   		if(this.hp - other.hp == 0) {
   			return other.hp - this.hp;
   		}
   	}
   	return this.set.compareTo(other.set);
   }
	/**
    Returns a textual string representing the collectable card.
	@return Textual string describing the card.
	*/
	public String toString () {
		return set + " [HP: " + hp + "]";
	}

 
}