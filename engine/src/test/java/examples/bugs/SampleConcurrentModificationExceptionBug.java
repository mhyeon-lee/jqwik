package examples.bugs;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;

class SampleConcurrentModificationExceptionBug {
    @Property(tries = 10)
    void doNotThrowConcurrentModificationException() {
        Assertions.assertDoesNotThrow(() ->
            Arbitraries.strings()
                .map(it -> it + Arbitraries.strings().alpha().sample())
                .filter(StringUtils::isNotBlank)
                .sample()
        );
    }
}
