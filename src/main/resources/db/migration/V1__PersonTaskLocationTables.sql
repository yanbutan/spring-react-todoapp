CREATE TABLE IF NOT EXISTS person (
    id UUID NOT NULL,
    name VARCHAR (100) NOT NULL,
    username VARCHAR (255) UNIQUE NOT NULL,
    email VARCHAR (255) UNIQUE NOT NULL,
    profileImgPath VARCHAR (65535) UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS task (
    id UUID NOT NULL,
    name VARCHAR (100) NOT NULL,
    description VARCHAR (65535),
    dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dateToComplete TIMESTAMP,
    dateCompleted TIMESTAMP,
    PRIMARY KEY (id),
    user_id UUID NOT NULL REFERENCES person(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS location (
    id UUID NOT NULL,
    name VARCHAR (255) NOT NULL,
    address VARCHAR (65535),
    postalCode INTEGER CHECK (postalCode <= 6),
    PRIMARY KEY (id),
    location_id NOT NULL UUID REFERENCES task(id) ON DELETE CASCADE
);