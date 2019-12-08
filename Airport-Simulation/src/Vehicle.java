
public class Vehicle {
	int seatSize = 0;
	int lastStopCode = -1; // Last time it made stop, uses codes, see EventLinkedList
	PersonLinkedList Passengers = new PersonLinkedList();

	Vehicle(int mySeatSize) {
		seatSize = mySeatSize;
	}

	boolean hasSpace() {
		if (Passengers.size < seatSize)
			return true;
		else
			return false;
	}

}
