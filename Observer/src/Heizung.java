import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Heizung {

	Map<Observer, Integer> v2 = new HashMap<>();
	int value;

	public void setValue(int v) {
		value = v;
		notifyAllObservers();
	}

	public void notifyAllObservers() {

		for (Entry<Observer, Integer> e : v2.entrySet()) {
			if (e.getValue() < value) {
				e.getKey().update(value);
			}
		}

	}

	public void register(Observer obs, int minTemp) {
		if (!v2.containsKey(obs)) {
			v2.put(obs, minTemp);
		}
	}

	public void unRegister(Observer obs) {
		v2.remove(obs);
	}
}
