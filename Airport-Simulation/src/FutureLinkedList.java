public class FutureLinkedList {
		// head is dummy, tail is null
		public node head = new node();
		public node tail = null;
		public double lastArrival = 0;
		public int arrived = 0;

		public class node {
			String type = "";
			double time = 0f;
			public node next = null;
			int code=0;
			// Default Constructor
			public node() {
			}

			
			public node(String typeInput, double timeInput, node nextInput, int codeInput) {
				type = typeInput;
				time = timeInput;
				next = nextInput;
				code = codeInput;
			}
		}

		/**
		 * 
		 * @param type
		 *            Any string value to represent Arrival or Departure
		 * @param time
		 *            Clock value of event.
		 */
		public void insert(String type, double time, int codeInput) {
			node p1 = head;
			node p2 = head;
			node tempInsert = new node(type, time, tail, codeInput);
			if (type.substring(0, 1).equals("a"))
				arrived++;
			if (p1.next == tail) {
				head.next = tempInsert;
				return;
			}
			p2 = p2.next;
			while (p2 != null) {
				if (p2.time >= time) {
					p1.next = tempInsert;
					tempInsert.next = p2;
					return;
				} else {
					p1 = p1.next;
					p2 = p2.next;
				}
			}
			p1.next = tempInsert;
			tempInsert.next = tail;
		}

		/**
		 * Delete's node after linked list. Nothing is deleted if list is empty.
		 */
		public void deleteTOP() {
			node p = head.next;
			if (p != null) {
				head.next = p.next;
			} else
				throw new IllegalArgumentException("oof the list was empty, cant delete");
		}

		/**
		 * Print the list in the format of "type : time >|" to console. DEBUGGING ONLY.
		 */
		public void print() {
			node p = head;
			System.out.print("[Future Events List] ");
			while (p.next != null) {
				p = p.next;
				System.out.print("{" + p.type + " | " + String.format("%.8f", p.time) + "} -> ");
			}
			System.out.print("NULL\n");
		}
	}