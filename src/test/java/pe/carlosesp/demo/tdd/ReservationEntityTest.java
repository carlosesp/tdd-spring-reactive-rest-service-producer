package pe.carlosesp.demo.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import pe.carlosesp.demo.tdd.domain.Reservation;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class ReservationEntityTest {

    @Autowired
    private ReactiveMongoTemplate template;

    @Test
    void persist() throws Exception {
        Reservation r = new Reservation(null, "Jane");
        Mono<Reservation> save = this.template.save(r);
        StepVerifier
                .create(save)
                .expectNextMatches(reservation -> reservation.getName().equalsIgnoreCase("Jane")
                        && reservation.getId() != null)
                .verifyComplete();
    }

}
