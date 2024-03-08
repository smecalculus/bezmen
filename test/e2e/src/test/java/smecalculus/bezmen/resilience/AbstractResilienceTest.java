package smecalculus.bezmen.resilience;

import static java.util.stream.Collectors.groupingBy;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.StandBeans;
import smecalculus.bezmen.messaging.BezmenClient;
import smecalculus.bezmen.testing.Demiurge;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StandBeans.class)
public abstract class AbstractResilienceTest {

    protected static final String POSTGRES_PRIMARY = "postgres-primary";
    protected static final String POSTGRES_SECONDARY = "postgres-secondary";

    @Autowired
    private DockerClient dockerClient;

    @Autowired
    protected BezmenClient bezmenClient;

    @Autowired
    protected Demiurge demiurge;

    protected Map<String, List<Container>> services;

    static {
        Awaitility.pollInSameThread();
        Awaitility.setDefaultPollInterval(Duration.ofSeconds(1));
    }

    @BeforeAll
    void abstractBeforeAll() {
        services = dockerClient.listContainersCmd().withShowAll(true).exec().stream()
                .collect(groupingBy(container -> container.getLabels().get("com.docker.compose.service")));
    }
}
