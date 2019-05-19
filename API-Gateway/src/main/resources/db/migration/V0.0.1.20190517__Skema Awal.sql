CREATE TABLE master_zuul_routes (
    id VARCHAR(50),
    path VARCHAR(500),
    service_id VARCHAR(50),
    url VARCHAR(500),
    strip_prefix SMALLINT,
    retryable SMALLINT,
    sensitive_headers VARCHAR(500),
    PRIMARY KEY(id)
);