package UIElements.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class DemoApplication {

	@Autowired
	private Actor_Repository actor_repository;

	@Autowired
	private Film_Repository film_repository;

	@Autowired
	public DemoApplication(Actor_Repository a, Film_Repository f) {
		this.actor_repository = a;
		this.film_repository = f;

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actor_repository.findAll();
	}

	//get mapping for single actor
	@GetMapping("/getActor/{actorid}")
	public @ResponseBody Actor getActor(@PathVariable int actorid) {
		return actor_repository.findById(actorid).orElseThrow(() -> new ActorNotFoundException(actorid));

	}


	//put mapping for changing actor details using "put"
	@PutMapping("/updateActor/{actorid}")
	public Actor updateActor(@RequestBody Actor newActor, @PathVariable int actorid) {
		return actor_repository.findById(actorid)
				.map(actor ->
				{actor.setFirstname(newActor.getFirstname());
				 actor.setLastname(newActor.getLastname());
				 return actor_repository.save(actor);
				}).orElseGet(() -> {
					newActor.setActorid(actorid);
					return actor_repository.save(newActor);
				})
				;

	}

	//post mapping to add actor
	@PostMapping("/newActor")
	public Actor newActor(@RequestBody Actor newActor) {
		return actor_repository.save(newActor);

	}

	//delete mapping to delete actor
	@DeleteMapping("/deleteActor/{actorid}")
	public void deleteActor(@PathVariable int actorid) {
		actor_repository.deleteById(actorid);

	}


	//get mapping to get all films
	@GetMapping("/allFilms")
	public @ResponseBody Iterable<Film> getAllFilms() {
		return film_repository.findAll();
	}

	//get mapping for single film
	@GetMapping("/getFilm/{filmid}")
	public @ResponseBody Film getFilm(@PathVariable int filmid) {
		return film_repository.findById(filmid).orElseThrow(() -> new FilmNotFoundException(filmid));

	}


}
