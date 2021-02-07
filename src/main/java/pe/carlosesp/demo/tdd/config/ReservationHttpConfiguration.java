package pe.carlosesp.demo.tdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.carlosesp.demo.tdd.domain.Reservation;
import pe.carlosesp.demo.tdd.repository.ReservationRepository;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ReservationHttpConfiguration {

    @Bean
    RouterFunction<ServerResponse> responseRouterFunction(ReservationRepository reservationRepository) {
        return route()
                .GET("/reservations", serverRequest ->
                        ServerResponse.ok().body(reservationRepository.findAll(), Reservation.class))
                .build();
    }

}
