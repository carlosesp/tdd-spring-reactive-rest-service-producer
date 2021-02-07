package pe.carlosesp.demo.tdd.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.carlosesp.demo.tdd.domain.Reservation;
import reactor.core.publisher.Flux;

@Repository
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, String> {

    Flux<Reservation> findByName(String name);

}
