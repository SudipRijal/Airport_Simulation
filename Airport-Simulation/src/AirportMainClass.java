import java.util.Random;

public class AirportMainClass {
	public static Random rand = new Random();
	static double clock = 0f;
	Double randomVariable;

	static int getRandomLot() {
		return rand.nextInt() % 4;
	} 
	static int getRandomParking() {
		return rand.nextInt() % 3 + 1;

	}

	static int getRandomPassengerCount() {
		return rand.nextInt() % 7 + 1;
	}

	public static double getNext(double lambdaORmu) {
		return -Math.log(1 - rand.nextDouble()) / lambdaORmu;
		
	}

	public static void main(String args[]) {
		Terminal airportLocation[] = new Terminal[4];
		airportLocation[0] = new Terminal(0);
		airportLocation[1] = new Terminal(1);
		airportLocation[2] = new Terminal(2);
		airportLocation[3] = new Terminal(3);
		Vehicle myBus = new Vehicle(20);
		FutureLinkedList futures = new FutureLinkedList();
		double lastBusTime = 0;
		double lastCarTime = 0;
		futures.insert("BUS", clock, 0);

		while (clock < 1000) {
			String currentEventType = futures.head.type; // get next event
			int currentEventCode = futures.head.code;

			clock = futures.head.time;

			clock = futures.head.time; // update clock
			if (currentEventType.equals("BUS")) {
				// myBus.removeCode(currentEventCode);
				// while(myBus.hasSpace()&&airportLocation[currentCode].hasPeople())
				// 	myBus.insert.airportLocation[currentEventCode].head
				double tempTime = lastBusTime + getNext(100);
				futures.insert("BUS", tempTime, currentEventCode + 1 % 4);
				lastBusTime = tempTime;
			}

			else if (currentEventType.equals("CAR")) {
				int start = getRandomLot();
				int destination = 0;
				int passengerCount = getRandomPassengerCount();
				if (start == 0)
					destination = getRandomParking();
				// generate #of passengers
				// add those objects to terminal nextEvent
				for (int i = 0; i < passengerCount; i++)
					airportLocation[currentEventCode].insert(new Person(clock, start, destination));
				futures.insert("CAR", lastCarTime + getNext(25), -1);
			}
		}
	}
}