package pe.carlosesp.demo.tdd;

import org.assertj.core.api.Assertions;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import pe.carlosesp.demo.tdd.domain.Reservation;

public class ReservationPojoTest {

    @Test
    void create() throws Exception {
        Reservation r = new Reservation("1", "Jane");

        Assertions.assertThat(r.getName()).isEqualTo("Jane");
        MatcherAssert.assertThat(r.getName(), Matchers.equalToIgnoringCase("jane"));
        MatcherAssert.assertThat(r.getName(), new BaseMatcher<String>() {
            @Override
            public boolean matches(Object item) {
                return Character.isUpperCase(((String) item).charAt(0));
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("the name should be valid uppercase");
            }
        });
        Assertions.assertThat(r.getName()).isEqualToIgnoringCase("jane");
    }

}
