package smecalculus.bezmen.testing;

import static org.awaitility.Awaitility.await;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.NotModifiedException;
import com.github.dockerjava.api.model.Container;
import java.time.Duration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class Demiurge {

    private static final Logger LOG = LoggerFactory.getLogger(Demiurge.class);

    @NonNull
    private DockerClient dockerClient;

    public void starts(@NonNull Container container) {
        try {
            dockerClient.startContainerCmd(container.getId()).exec();
            await().atMost(Duration.ofSeconds(20)).until(() -> isStarted(container));
        } catch (NotModifiedException e) {
            LOG.debug("Already started");
        }
    }

    public void kills(@NonNull Container container) {
        dockerClient.killContainerCmd(container.getId()).exec();
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
