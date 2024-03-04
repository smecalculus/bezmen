package smecalculus.bezmen.resilience;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.StandBeans;
import smecalculus.bezmen.testing.Demiurge;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StandBeans.class)
public abstract class AbstractResilienceTest {

    @Autowired
    protected DockerClient dockerClient;

    @Autowired
    protected Demiurge demiurge;

    protected Container postgresPrimary;
    protected Container postgresSecondary;

    @BeforeAll
    void abstractBeforeAll() {
        var containers = dockerClient.listContainersCmd().withShowAll(true).exec().stream()
                .collect(toMap(container -> container.getNames()[0], identity()));
        containers.values().forEach(demiurge::starts);
        postgresPrimary = containers.get("/bezmen-postgres-primary");
        postgresSecondary = containers.get("/bezmen-postgres-secondary");
    }
}
