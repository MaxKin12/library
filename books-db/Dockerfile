FROM mysql:latest
WORKDIR /app
COPY ./scripts /docker-entrypoint-initdb.d
USER mysql
EXPOSE 4000
CMD ["mysqld"]
