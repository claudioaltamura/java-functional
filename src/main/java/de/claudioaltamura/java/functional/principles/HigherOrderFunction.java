package de.claudioaltamura.java.functional.principles;

public class HigherOrderFunction {

	public <T> Factory<T> createFactory(Producer<T> producer, Configurator<T> configurator) {
		return () -> {
			T instance = producer.produce();
			return configurator.configure(instance);
		};
	}
}
