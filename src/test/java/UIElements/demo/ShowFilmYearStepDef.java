package UIElements.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class ShowFilmYearStepDef {
    @Autowired
    Film_Repository film_repo;

    int filmID;
    Film chosenFilm;

    @Given("a film exists with the id {int}")
    public void aFilmExistsWithTheId(int id) {
        filmID = id;
        film_repo.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

    @When("I request a film year")
    public void i_request_a_film_year() {
        chosenFilm = film_repo.findById(filmID).orElseThrow(() -> new FilmNotFoundException(filmID));
        Assertions.assertNotEquals(null, chosenFilm, "Film not retrieved");

    }

    @Then("the webpage should show the film release year {int}")
    public void the_webpage_should_show_the_film_release_year(int release_year) {
        int correctDetails = release_year;
        int testDetails = chosenFilm.getRelease_year();
        Assertions.assertEquals(correctDetails, testDetails, "Film details do not match");


    }

}
