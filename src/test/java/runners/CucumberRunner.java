package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
 //       tags = {"@test1, @test2, @test3, @test4"},  for Task 1
 //      tags = {"@testOut, @ @testOutEx"}, for Task 1
//          tags = {"@test2"},
        tags = {"@testA, @testB, @testC, @testD, @testE, @testF, @testG"}, //2nd Task tests
  //         tags = {"@working"},
//        tags = {"~@not_working", "~@bug"},
//        tags = {"@test", "~@bug"},
//        tags = {"~@not_working", "@part1", "~@bug"}, // => NOT @not_working AND @part1 AND NOT @bug
//        tags = {"@part3", "@regression"}, //=> @part3 AND @regression
//        tags = {"@part3, @regression"}, //=> @part3 OR @regressionn
//        tags = {"@debug1, @smoke1"},
       glue = {"stepDefinitions"}
)
public class CucumberRunner {
}
