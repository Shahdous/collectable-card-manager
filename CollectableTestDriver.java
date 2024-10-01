/**
	Driver Class
*/

public class CollectableTestDriver {
    public static void main(String[] args) {
        CollectableCardList myList = new CollectableCardList();

        // Initial population of the card list
        System.out.println("Initializing card collection:");
        myList.add(new CollectableCard("Zephyr", 200));
        myList.add(new CollectableCard("Boreal", 30));
        myList.add(new CollectableCard("Mystic", 90));
        myList.add(new CollectableCard("Eclipse", 170));
        
        displayCards(myList.getListAsArray());

        // Demonstrating removal of a card on the list
        System.out.println("\nRemoving 'Mystic, 90' from the collection:");
        
        try {
            myList.remove(new CollectableCard("Mystic", 90));
        } catch (Exception e) {
            System.out.println("Failed to remove: " + e.getMessage());
        }
        
        displayCards(myList.getListAsArray());

        // Adding additional cards to test sorting and insertion logic
        System.out.println("\nAdding additional cards into the collection:");
        
        myList.add(new CollectableCard("Celestial", 130));
        myList.add(new CollectableCard("Abyss", 45));
        
        displayCards(myList.getListAsArray());

        // Displaying the list in reverse
        System.out.println("\nDisplaying cards in reverse order to verify list integrity:");
        
        displayCards(myList.getReversedListAsArray());

        // Attempting to remove a card that does not exist to test error handling
        System.out.println("\nTrying to remove a card (Hello, 100) not present in the collection:");
        
        try {
            myList.remove(new CollectableCard("Hello", 100));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
		finally {
        // Final count of cards in the collection after all operations
        System.out.println("\nTotal cards in the collection: " + myList.getNumCards());
        }
    }

    private static void displayCards(CollectableCard[] cards) {
    
        for (CollectableCard temp : cards) {
            System.out.println(temp);
        }
    }
}
