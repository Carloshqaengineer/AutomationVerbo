package runners;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "steps")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-reports/report.html, json:target/cucumber-reports/report.json")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
public class TestRunner {
}
