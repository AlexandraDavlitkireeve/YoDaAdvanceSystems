package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/report.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "step_definitions",
        stepNotifications = true,
        dryRun = false
<<<<<<< HEAD
        ,tags = "@ASY-7"
=======

        ,tags = "@ASY-7"

        ,tags = "@ASY-6"
>>>>>>> 69e3dc6c230dd6fbd4bbbb3548c55238e0656968


)
        public class CukesRunner {

}
