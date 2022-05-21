# Create a brige network.
docker network create pg-net-tatawo3

# Run a new instance (or container) of the postgres image in a detached mode (-d) and remove on exit state (--rm),
# and expose its default port (5432:'5432') to the 5432 port ('5432':5432). Also, set envirenment variables
# and assign a docker network (--network=pg-net) to use it accross different containers (or instances).
docker run --rm --name psql-container-tatawo3 -p 5434:5432 -e POSTGRES_PASSWORD=pass -e POSTGRES_DB=tatawo3db --network=pg-net-tatawo3 -d postgres

# Run a new instance of the 'dpage/pgadmin4' image.
docker run --rm --name pgadmin4-container-tatawo3 -p 5052:80 -e PGADMIN_DEFAULT_EMAIL=test@test.com -e PGADMIN_DEFAULT_PASSWORD=password --network=pg-net-tatawo3 -d dpage/pgadmin4

# Show pg-net configuration such as containers' gateway ip addresses.
docker network inspect pg-net-tatawo3 | grep -i gateway