# Troubleshooting

```bash
docker run --rm -it \
  --net host \
  --entrypoint bash \
  --volume $(pwd)/postgres:/liquibase/changelog \
  localhost/bezmen/schema:latest
```

```bash
liquibase \
  --defaultsFile=/liquibase/liquibase.docker.properties \
  --changelog-file=<role>/changelog.yml \
  --url=jdbc:postgresql://localhost:5432/<database>?currentSchema=<schema> \
  --username=<username> \
  --password=<password> \
  update
```

liquibase \
--defaultsFile=/liquibase/liquibase.docker.properties \
--changelog-file=postgres/dba/changelog.yml \
--output-file=liquibase.out \
--log-file=liquibase.log \
--log-level=fine \
--url=jdbc:postgresql://localhost:5432/postgres \
--username=postgres \
--password=password \
--labels=database \
update \
-Dbezmen.database=bezmen \
-Dbezmen.schema=bezmen \
-Dbezmen.username=bezmen \
-Dbezmen.password=bezmen
