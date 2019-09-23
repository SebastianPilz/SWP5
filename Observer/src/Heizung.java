import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Heizung {

	Map<Observer, Integer> o = new HashMap<>();
	int value;

	public void setValue(int v) {
		value = v;
		notifyAllObservers();
	}

	public void notifyAllObservers() {

		for (Entry<Observer, Integer> e : o.entrySet()) {
			if (e.getValue() < value) {
				e.getKey().update(value);
			}
		}

	}

	public void register(Observer obs, int minTemp) {
		if (!o.containsKey(obs)) {
			o.put(obs, minTemp);
		}
	}

	public void unRegister(Observer obs) {
		o.remove(obs);
	}
}
