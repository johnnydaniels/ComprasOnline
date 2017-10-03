package ComprasOnline.app.interfaces;

public class Publisher {
	private Subscriber subscribers[] = new Subscriber[10];
	private int numSubscribers = 0;
	
	public void subscribe(Subscriber s) {
		if (numSubscribers < subscribers.length) {
			subscribers[numSubscribers] = s;
			numSubscribers++;
		}
	}
	
	protected void generateEvent(Object sender) {
		for (int i = 0; i < numSubscribers; i++) {
			subscribers[i].eventOcurred(sender);
		}
	}
}
