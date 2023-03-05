# Troubleshooting

```bash
docker run --rm -it \
--net host \
--entrypoint bash \
--volume $(pwd):/liquibase/changelog \
localhost/bezmen/schema:latest
```

```bash
liquibase \
--defaultsFile=/liquibase/liquibase.docker.properties \
--changelog-file=postgres/dba/changelog.yml \
--output-file=liquibase.out \
--log-file=liquibase.log \
--log-level=fine \
--url=jdbc:postgresql://localhost:5432/postgres?currentSchema=public \
--liquibase-schema-name=public \
--username=postgres \
--password=password \
--labels=database,user \
update \
-Dbezmen.database=bezmen \
-Dbezmen.schema=bezmen \
-Dbezmen.owner=bezmen \
-Dbezmen.password=bezmen
```

```bash
liquibase \
--defaultsFile=/liquibase/liquibase.docker.properties \
--changelog-file=postgres/owner/changelog.yml \
--output-file=liquibase.out \
--log-file=liquibase.log \
--log-level=fine \
--url=jdbc:postgresql://localhost:5432/bezmen?currentSchema=bezmen \
--liquibase-schema-name=bezmen \
--username=bezmen \
--password=bezmen \
update
```
