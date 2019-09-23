package com.easygov.StepDefs;

import org.junit.runner.RunWith;

import com.imemories.test.ExtendedCucumberRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json" }, features = "src/test/resources/features/Scheme.feature")
@RunWith(ExtendedCucumberRunner.class)
public class RunFeatureFile {
}