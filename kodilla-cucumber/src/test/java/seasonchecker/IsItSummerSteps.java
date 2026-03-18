package seasonchecker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seasonchecker.SeasonChecker.checkIfSummer;

public class IsItSummerSteps {
    private MonthDay today;
    private String answer;

    @Given("today is day {int} of month {int}")
    public void today_is_day_of_month(int day, int month) {
        this.today = MonthDay.of(month, day);
    }

    @When("I ask whether it's Summer")
    public void i_ask_whether_it_s_summer() {
        this.answer = checkIfSummer(this.today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expected) {
        assertEquals(expected, this.answer);
    }
}
