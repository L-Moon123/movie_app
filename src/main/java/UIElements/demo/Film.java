package UIElements.demo;

import jakarta.persistence.*;

@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;

    @Column(name="title")
    String film_title;
    
}
