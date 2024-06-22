CREATE TABLE IF NOT EXISTS departments (
    id UUID PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL
);

INSERT INTO departments (id, "name") VALUES (gen_random_uuid(), 'HR');
INSERT INTO departments (id, "name") VALUES (gen_random_uuid(), 'IT');
INSERT INTO departments (id, "name") VALUES (gen_random_uuid(), 'FINANCE');
INSERT INTO departments (id, "name") VALUES (gen_random_uuid(), 'MARKETING');