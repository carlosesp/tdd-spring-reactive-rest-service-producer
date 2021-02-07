package pe.carlosesp.demo.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import pe.carlosesp.demo.tdd.domain.Reservation;
import pe.carlosesp.demo.tdd.repository.ReservationRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    void query() throws Exception {
        // delete everything in the DB
        // write 4 records
        // then query by name and assert count
        Flux<Reservation> reservationFlux = this.repository.deleteAll()
                .thenMany(
                        Flux.just("A", "B", "C", "C")
                                .map(name -> new Reservation(null, name))
                                .flatMap(r -> this.repository.save(r))
                )
                .thenMany(this.repository.findByName("C"));

        StepVerifier
                .create(reservationFlux)
                .expectNextCount(2)
                .verifyComplete();
    }

}
