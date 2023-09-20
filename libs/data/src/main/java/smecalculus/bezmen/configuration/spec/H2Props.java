package smecalculus.bezmen.configuration.spec;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
public record H2Props(@NonNull String url, @NonNull String username, @NonNull @ToString.Exclude String password) {}