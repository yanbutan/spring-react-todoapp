CREATE TABLE IF NOT EXISTS person (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    username VARCHAR (255) UNIQUE NOT NULL,
    email VARCHAR (255) UNIQUE NOT NULL,
    profileImgPath VARCHAR (65535) UNIQUE,
    PRIMARY KEY (id)
);

CREATE TYPE taskType AS ENUM ('HOUSE CHORES', 'SCHOOL WORK', 'PART TIME', 'INTERN', 'WORK', 'FITNESS', 'HEALTH');
CREATE TYPE status AS ENUM ('ONGOING', 'PAUSED', 'OVERDUE', 'COMPLETED');
CREATE TABLE IF NOT EXISTS task (
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    description VARCHAR (65535),
    taskType taskType,
    dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dateToComplete TIMESTAMP,
    dateCompleted TIMESTAMP,
    status status,
    PRIMARY KEY (id),
    user_id INT NOT NULL REFERENCES person(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS location (
    id SERIAL,
    name VARCHAR (255) NOT NULL,
    address VARCHAR (65535),
    postalCode INTEGER CHECK (postalCode < 1000000),
    PRIMARY KEY (id),
    task_id INT NOT NULL REFERENCES task(id) ON DELETE CASCADE
);