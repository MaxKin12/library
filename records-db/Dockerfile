FROM mysql:latest
WORKDIR /app
COPY ./scripts /docker-entrypoint-initdb.d
USER mysql
EXPOSE 5000
CMD ["mysqld"]