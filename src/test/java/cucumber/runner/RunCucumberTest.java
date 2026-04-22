package cucumber.runner;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "cucumber")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class RunCucumberTest {

    /*
    Что здесь происходит (очень коротко)
@Suite → это JUnit 5 запуск
@IncludeEngines("cucumber") → говорим “используй Cucumber”
@SelectClasspathResource("features") → где искать .feature
GLUE → где искать step definitions
     */
}
