FROM mysql:8.0

EXPOSE 3306

COPY ./my.cnf /etc/mysql/my.cnf

RUN chmod 644 /etc/mysql/my.cnf

COPY ./sql /docker-entrypoint-initdb.d