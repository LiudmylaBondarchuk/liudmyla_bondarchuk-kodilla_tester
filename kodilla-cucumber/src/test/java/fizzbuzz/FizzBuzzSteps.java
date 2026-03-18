package fizzbuzz;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSteps {
    private int number;
    private String result;

    @Given("I have the number {int}")
    public void i_have_the_number(int number) {
        this.number = number;
    }

    @When("I check the FizzBuzz result")
    public void i_check_the_fizzbuzz_result() {
        this.result = FizzBuzz.check(this.number);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expected) {
        assertEquals(expected, this.result);
    }
}
