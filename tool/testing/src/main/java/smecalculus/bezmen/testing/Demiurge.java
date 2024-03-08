package smecalculus.bezmen.testing;

import static org.awaitility.Awaitility.await;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.NotModifiedException;
import com.github.dockerjava.api.model.Container;
import java.time.Duration;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class Demiurge {

    private static final Logger LOG = LoggerFactory.getLogger(Demiurge.class);

    private static final Duration SERVICE_START_TIMEOUT = Duration.ofSeconds(20);

    @NonNull
    private DockerClient dockerClient;

    public void starts(@NonNull List<Container> containers) {
        try {
            containers.forEach(container -> dockerClient.startContainerCmd(container.getId()).exec());
        } catch (NotModifiedException e) {
            LOG.debug("Already started");
        }
        containers.forEach(container ->
                await(container.getNames()[0])
                        .atMost(SERVICE_START_TIMEOUT)
                        .until(() -> isStarted(container)));
    }

    public void kills(@NonNull Container container) {
        dockerClient.killContainerCmd(container.getId()).exec();
    }

    public void kills(@NonNull List<Container> containers) {
        containers.forEach(this::kills);
    }

    private boolean isStarted(@NonNull Container container) {
        var response = dockerClient.inspectContainerCmd(container.getId()).exec();
        if (response.getConfig().getHealthcheck() == null) {
            return Boolean.TRUE.equals(response.getState().getRunning());
        }
        var health = response.getState().getHealth();
        if (health == null) {
            return false;
        }
        return health.getStatus().equalsIgnoreCase("healthy");
    }
}
