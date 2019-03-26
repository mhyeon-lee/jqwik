package net.jqwik.engine.properties;

import java.util.*;

import net.jqwik.api.configurators.*;
import net.jqwik.api.providers.*;
import net.jqwik.engine.properties.configurators.*;
import net.jqwik.engine.providers.*;

/**
 * Default providers are available even if the global domain context is not loaded
 */
public class DefaultArbitraries {

	public static List<ArbitraryProvider> getDefaultProviders() {
		ArrayList<ArbitraryProvider> providers = new ArrayList<>();
		providers.add(new EnumArbitraryProvider());
		providers.add(new WildcardArbitraryProvider());
		providers.add(new ListArbitraryProvider());
		providers.add(new SetArbitraryProvider());
		providers.add(new StreamArbitraryProvider());
		providers.add(new OptionalArbitraryProvider());
		providers.add(new ArrayArbitraryProvider());
		providers.add(new IteratorArbitraryProvider());
		providers.add(new UseTypeArbitraryProvider());
		return providers;
	}

	public static List<ArbitraryConfigurator> getDefaultConfigurators() {
		ArrayList<ArbitraryConfigurator> configurators = new ArrayList<>();
		configurators.add(new SizeConfigurator());
		configurators.add(new WithNullConfigurator());
		configurators.add(new UniqueConfigurator());
		return configurators;
	}
}