package org.smecalculus.bezmen.config.data;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataConfigImpl implements DataConfig {

    private final CmMapper cmMapper;

    @Override
    public PostgresProps getPostgresProps() {
        PostgresPropsCm postgresPropsCm = new PostgresPropsCm();
        return cmMapper.map(postgresPropsCm);
    }
}
