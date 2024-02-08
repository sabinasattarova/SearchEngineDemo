package com.demo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt" //in case the failure this plugin will have report and in FailedTestRunner we will be able to run only Failed TC
        },
        features = "src/test/resources/feature",
        glue = "com/demo/stepDef",
        dryRun = false, // to retrieve snippets
        tags = "@us04",
        publish = true
)
public class CukesRunner {
}
