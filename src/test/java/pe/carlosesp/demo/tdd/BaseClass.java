package pe.carlosesp.demo.tdd;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import pe.carlosesp.demo.tdd.config.ReservationHttpConfiguration;
import pe.carlosesp.demo.tdd.domain.Reservation;
import pe.carlosesp.demo.tdd.repository.ReservationRepository;
import reactor.core.publisher.Flux;

@Import(ReservationHttpConfiguration.class)
@SpringBootTest(
        properties = "server.port=0",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class BaseClass {

    @MockBean
    private ReservationRepository repository;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void before() throws Exception {
        Mockito.when(this.repository.findAll())
                .thenReturn(Flux.just(new Reservation("1", "Jane"),
                        new Reservation("2", "Joe")));

        RestAssured.baseURI = "http://localhost:" + this.port;
    }

}
