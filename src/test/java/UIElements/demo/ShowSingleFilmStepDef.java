package UIElements.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class ShowSingleFilmStepDef {

    @Autowired
    Film_Repository film_repo;

    int filmID;
    Film chosenFilm;

    @Given("a film exists with id {int}")
    public void aFilmExistsWithId(int id) {
        filmID = id;
        film_repo.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

    @When("I request a film's details")
    public void i_request_a_films_details() {
        chosenFilm = film_repo.findById(filmID).orElseThrow(() -> new FilmNotFoundException(filmID));
        Assertions.assertNotEquals(null, chosenFilm, "Film not retrieved");

    }

    @Then("the webpage should show the film {string}")
    public void the_webpage_should_show_the_film(String film_title) {
        String correctDetails = film_title;
        String testDetails = chosenFilm.getFilm_title();
        Assertions.assertEquals(correctDetails, testDetails, "Film details do not match");


    }
}
