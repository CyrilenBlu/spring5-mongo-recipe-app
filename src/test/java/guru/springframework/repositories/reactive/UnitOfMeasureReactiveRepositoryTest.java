package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@DataMongoTest
@Slf4j
public class UnitOfMeasureReactiveRepositoryTest {

    UnitOfMeasure uom1 = new UnitOfMeasure();
    UnitOfMeasure uom2 = new UnitOfMeasure();
    UnitOfMeasure uom3 = new UnitOfMeasure();

    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Before
    public void setUp() throws Exception {
        uom1.setDescription("tea");
        uom2.setDescription("bob");
        uom3.setDescription("awesome");
    }

    @Test
    public void testMono() {


        Mono<UnitOfMeasure> unitOfMeasureMono = Mono.just(uom1);

        UnitOfMeasure uom = unitOfMeasureMono.block();

        log.info(uom.getDescription());
    }

    @Test
    public void testFlux(){

        Flux<UnitOfMeasure> unitOfMeasureFlux = Flux.just(uom1, uom2, uom3);

        unitOfMeasureFlux.subscribe(unitOfMeasure -> log.info(unitOfMeasure.getDescription()));
    }
}