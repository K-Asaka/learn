FROM postgres:12.1-alpine

COPY --chown=postgres:postgres ./postgresql.conf /etc/postgresql.conf
CMD ["-c", "config_file=/etc/postgresql.conf"]
