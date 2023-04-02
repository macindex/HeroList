FROM postgres

EXPOSE 5432
COPY init_schema.sql /docker-entrypoint-initdb.d/
docker run --name hero-list -e POSTGRES_PASSWORD=619302$5847 -d postgres
