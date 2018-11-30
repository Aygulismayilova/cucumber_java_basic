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
      // tags = {"@test7",},
       // tags = {"  @Test,@test",},
      //  tags = {" @test2",},
     //   tags = {" @test3, @test4",},
       // tags = {" @test5",},
       // tags = {" @test, @test2",},
        //tags = {" @test10, @test11",},
        glue = {"stepDefinitions"}
)
public class CucumberRunner {//

}
