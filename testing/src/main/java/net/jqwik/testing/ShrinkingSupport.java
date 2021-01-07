package net.jqwik.testing;

import java.util.*;

import org.apiguardian.api.*;

import net.jqwik.api.*;
import net.jqwik.api.facades.*;
import net.jqwik.api.lifecycle.*;

import static org.apiguardian.api.API.Status.*;

@API(status = EXPERIMENTAL, since = "1.4.0")
public class ShrinkingSupport {

	private ShrinkingSupport() {
	}

	public static <T> T shrinkToMinimal(Arbitrary<? extends T> arbitrary, Random random) {
		return shrinkToMinimal(arbitrary, random, ignore -> TryExecutionResult.falsified(null));
	}

	public static <T> T shrinkToMinimal(Arbitrary<? extends T> arbitrary, Random random, Falsifier<T> falsifier) {
		return TestingSupportFacade.implementation.falsifyThenShrink(arbitrary, random, falsifier);
	}
}