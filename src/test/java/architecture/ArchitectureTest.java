package architecture;

import org.example.Main;
import org.junit.jupiter.api.Test;

import static io.jexxa.jexxatest.architecture.ArchitectureRules.aggregateRules;
import static io.jexxa.jexxatest.architecture.ArchitectureRules.patternLanguage;
import static io.jexxa.jexxatest.architecture.ArchitectureRules.portsAndAdapters;

/**
 * This test can be used in all your applications.
 * <p>
 * You have only to adjust test validatePortsAndAdapters. Here you have to add all your
 * packages containing the driven and driving adapters. This information is required to ensure
 * that there are no dependencies between these packages.
 */
class ArchitectureTest {

    @Test
    void validatePortsAndAdapters()
    {
        portsAndAdapters(Main.class)
                // Add all packages providing driven adapter
                .addDrivenAdapterPackage("persistence")
                .addDrivenAdapterPackage("messaging")

                // Add all packages providing driving adapter such as
                // .addDrivingAdapterPackage("messaging")

                .validate();
    }


    @Test
    void validatePatternLanguage()
    {
        patternLanguage(Main.class).validate();
    }

    @Test
    void validateAggregateRules()
    {
        aggregateRules(Main.class).validate();
    }
}