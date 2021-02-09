# TDD Spring Reactive REST Service Producer

Spring Boot project created with Inside-out TDD approach 
and Spring Cloud Contract.

## Steps

- Create Entity
    - **ReservationPojoTest** with **TestRestTemplate**


- Persist Entity
    - **ReservationEntityTest** with **@DataMongoTest**


- Create Custom Query
    - **ReservationRepositoryTest** with **@DataMongoTest**


- Web Tier
    - **ReservationHttpTest** with **@WebFluxTest**, **WebTestClient**, and **@MockBean**
    

- Cloud Contract
    - Configure **spring-cloud-contract-maven-plugin** in **pom.xml**.
    - Create **BaseClass** for contracts with **@Import**, **@SpringBootTest**, and **@MockBean**.
    - Create contract file **shouldReturnAllReservations.groovy**