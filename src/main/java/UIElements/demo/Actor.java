package UIElements.demo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorid;

    @Column(name="first_name")
    String firstname;

    @Column(name="last_name")
    String lastname;


    @ManyToMany
    @JoinTable(
            name="film_actor",
    joinColumns = @JoinColumn(name="actor_id", referencedColumnName="actor_id"),
    inverseJoinColumns = @JoinColumn(name="film_id", referencedColumnName = "film_id")
    )
    private List<Actor> films;



    public Actor() {

    }



    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
