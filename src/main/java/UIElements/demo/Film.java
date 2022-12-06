package UIElements.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;

    @Column(name="title")
    String film_title;

    @Column(name="description")
    String film_description;

    @Column(name="release_year")
    int release_year;

    @Column(name="language_id")
    int language_id;

    @ManyToMany(mappedBy = "films")
    private List<Actor> actors;


    public Film() {

    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_description() {
        return film_description;
    }

    public void setFilm_description(String film_description) {
        this.film_description = film_description;
    }

    public String getFilm_title() {
        return film_title;
    }

    public void setFilm_title(String film_title) {
        this.film_title = film_title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}
