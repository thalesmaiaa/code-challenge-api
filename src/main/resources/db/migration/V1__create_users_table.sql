CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    department_id UUID REFERENCES departments(id) ON DELETE CASCADE
    );