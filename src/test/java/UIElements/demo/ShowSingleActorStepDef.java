package UIElements.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class ShowSingleActorStepDef {
    @Autowired
    Actor_Repository actor_repo;

    int actorID;
    Actor chosenActor;

    @Given("an actor exists with id {int}")
    public void anActorExistsWithId(int id) {
        actorID = id;
        actor_repo.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

    @When("I request an actors details")
    public void i_request_an_actors_details() {
        chosenActor = actor_repo.findById(actorID).orElseThrow(() -> new ActorNotFoundException(actorID));
        Assertions.assertNotEquals(null, chosenActor, "Actor not retrieved");

    }

    @Then("the webpage should show the actors {string} and {string}")
    public void the_webpage_should_show_the_actors_firstname_and_lastname(String firstname, String lastname) {
        String correctDetails = firstname + " " + lastname;
        String testDetails = chosenActor.getFirstname() + " " + chosenActor.getLastname();
        Assertions.assertEquals(correctDetails, testDetails, "Actor details do not match");


    }

}
