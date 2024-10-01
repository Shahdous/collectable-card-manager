/**
This class represents a doubly linked list of collectable cards. 
*/
public class CollectableCardList {
 
	/**
    The first node in the list.
	*/
	private CardNode firstNode;
	
	/**
    The last node in the list.
	*/
	private CardNode lastNode;

	/**
    The number of cards in the list.
	*/
	private int numCards;

	/**
	Creates an empty list.
	*/
	public CollectableCardList () {
	
		firstNode = null;
		lastNode = null;
		numCards = 0;
	}

	/**
    Adds a new node representing the specified card at
    the appropriate position in the list; proper ordering of the
    cards must be maintained.
    @param cardIn The collectable card to be included in the new node.
	*/
	public void add (CollectableCard cardIn) {

		CardNode newNode = new CardNode(cardIn);
		
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } 
        else {
        
        	CardNode current = firstNode;
        	
        	while (current != null && current.card.compareTo(cardIn) < 0) {
        		current = current.next;
        	}
        	if (current == null) {
         		lastNode.next = newNode;
         		newNode.prev = lastNode;
         		lastNode = newNode;
         	} 		
        	else if (current == firstNode) {
        		newNode.next = firstNode;
        		firstNode.prev = newNode;
        		firstNode = newNode;
         	} 	
         	
         	else {
         		newNode.prev = current.prev;
         		newNode.next = current;
         		current.prev.next = newNode;
         		current.prev = newNode;
         	}
        }
        numCards++;
	}

	/**
	Remove from this list a node containing the specified card.
	@param cardIn The card to be removed.
	@return The card removed from the list.
	@throws ???(you decide on the Exception) if not found.
	*/
	public CollectableCard remove (CollectableCard cardIn) throws Exception{
		
		if (firstNode == null) {
			throw new Exception("List is empty");
		}
		
		CardNode current = firstNode;
			
		while (current != null && !current.card.equals(cardIn)) {
			current = current.next;
		}
			
		if (current == null) {
			throw new Exception("Card not found");
		}
		
		if (current == lastNode) {
			lastNode = current.prev;
			lastNode.next = null;
		} 
		else if (current == firstNode) {
			firstNode = current.next;
			
			if (firstNode != null) {
				firstNode.prev = null;
			}
		} 	
		
		else {
			current.prev.next = current.next;
			
			if(current.next != null) {
			current.next.prev = current.prev;
			}
		}
		numCards--;
		return current.card;	
	}
	
	/**
	Returns the number of cards currently stored in the list.
	@return The number of cards.
	*/
	public int getNumCards () {
	
		return numCards;
	}
	
	/**
	Creates and returns an array containing all of the collectable cards 
	in this list, in correct order.
	@return The list as an array.
	*/
	public CollectableCard[] getListAsArray () {
	
		CollectableCard[] cards = new CollectableCard[numCards];
        int index = 0;
        CardNode current = firstNode;
        
        while (current != null) {
        
            cards[index] = current.card;
            index++;
            current = current.next;

        }
        return cards;
	
	}
	
	/**
	Creates and returns an array containing all of the collectable cards 
	in this list, in reverse order.
	@return The list (in reverse order) as an array.
	*/
	public CollectableCard[] getReversedListAsArray () {
		
        CollectableCard[] cards = new CollectableCard[numCards];
        int index = 0;
        CardNode current = lastNode;
        
        while (current != null) {
        
            cards[index] = current.card;
            current = current.prev;
            index++;
        }
        return cards;
	}
	
	/**
	An inner class that represents a node in the collectable card list;
	the public variables are accessed by the CollectableCardList class.
    */
	private class CardNode {
		/**
		The CollectableCard referenced by this node.
		*/
		public CollectableCard card;

		/**
		The next node in the list.
		*/
		public CardNode next;
		
		/**
		The previous node in the list.
		*/
		public CardNode prev;

		/**
		Creates a node.
		@param cardIn The collectable card to be represented by this node.
		*/
		public CardNode (CollectableCard cardIn) {
			
			card = cardIn;
			next = null;
			prev = null;
		}
	}
  
}
