package UIElements.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Actor_Repository extends JpaRepository<Actor,Integer>  {
/*
    @Query("SELECT a.first_name FROM Actor a where a.actor_id = :id")
    String findActorById(@Param("id") Integer id);
*/


}
