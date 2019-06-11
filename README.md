# JavaBase
Projeto base Java com dependencias.

Configuração do postgres docker:

docker run --name java-base --hostname=base.java.postgres -e "POSTGRES_PASSWORD=java-base" -e "POSTGRES_USER=java-base" -p 5444:5444 -d postgres

ref: https://medium.com/@renato.groffe/postgresql-docker-executando-uma-inst%C3%A2ncia-e-o-pgadmin-4-a-partir-de-containers-ad783e85b1a4
