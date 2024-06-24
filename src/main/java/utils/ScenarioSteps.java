package utils;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ScenarioSteps {
    private ScenarioSteps() {
    }

    private static List<String> steps = new ArrayList<>();

    @SneakyThrows
    public static List<String> getSteps(Scenario scenario) {
        steps.removeAll(steps);
        Field f = scenario.getClass().getDeclaredField("delegate");
        f.setAccessible(true);
        io.cucumber.core.backend.TestCaseState sc = (io.cucumber.core.backend.TestCaseState) f.get(scenario);
        Field f1 = sc.getClass().getDeclaredField("testCase");
        f1.setAccessible(true);
        io.cucumber.plugin.event.TestCase testCase = (io.cucumber.plugin.event.TestCase) f1.get(sc);
        List<PickleStepTestStep> testSteps = testCase.getTestSteps().stream().filter(x -> x instanceof PickleStepTestStep).map(x -> (PickleStepTestStep) x).collect(Collectors.toList());
        for (PickleStepTestStep ts : testSteps) {
            //steps = Collections.singletonList(ts.getStep().getKeyword() + ts.getStep().getText());
            steps.add((ts.getStep().getKeyword() + ts.getStep().getText()).toString());
        }
        return steps;
    }
}

