package requester.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import requester.persistence.models.Counter;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {

    @Query("select c from counter c")
    Counter getCounter();

}
