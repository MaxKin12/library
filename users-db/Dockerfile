FROM mysql:latest
WORKDIR /app
COPY ./scripts /docker-entrypoint-initdb.d
USER mysql
EXPOSE 6000
CMD ["mysqld"]