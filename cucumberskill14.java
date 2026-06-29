package step_definition;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;
public class cucumberskill14{

    private String today;
    private String actualAnswer;

    @Given("today is Sunday")
    public void today_is_sunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday")
    public void i_ask_whether_it_s_friday() {
        actualAnswer = today.equals("Friday") ? "Yes, it's Friday" : "No, it's not Friday";
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
