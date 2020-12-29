INSERT INTO person (name, username, password, email)
VALUES ('Bob Dylan', 'bobby', 'password', 'bobby@gmail.com'),
       ('Jacky Chang', 'jackie', 'password', 'jackie@gmail.com'),
       ('James Bond', 'bondy', 'password', 'bondy@gmail.com'),
       ('Robin Tan', 'robin', 'password', 'robin@gmail.com'),
       ('Tan Ah Kau', 'tak', 'password', 'tak@gmail.com');

INSERT INTO task (name, description, taskType, dateCreated, dateToComplete, dateCompleted, status, userId)
VALUES ('Do homework', 'Do homework lah bodoh', 'SCHOOL_WORK', '2016-06-22 19:10:25-07', '2016-06-24 19:10:25-07', '2016-06-23 19:10:25-07', 'COMPLETED', 1),
       ('Finish assignment', 'Default description', 'SCHOOL_WORK', '2016-06-23 19:10:25-07', '2016-06-27 19:10:25-07', null, 'ONGOING', 1),
       ('Document code', 'Default description', 'PART_TIME', '2016-06-24 19:10:25-07', '2016-06-28 19:10:25-07', null, 'ONGOING', 2),
       ('Finish frontend css', 'Default description', 'INTERN', '2016-06-25 19:10:25-07', '2016-06-28 19:10:25-07', '2016-06-27 19:10:25-07', 'COMPLETED', 2),
       ('Prepare presentation', 'Default description', 'WORK', '2016-06-26 19:10:25-07', '2016-06-29 19:10:25-07', null, 'OVERDUE', 3),
       ('Run intervals', 'Default description', 'FITNESS', '2016-06-27 19:10:25-07', '2016-06-27 21:10:25-07', null, 'PAUSED', 3),
       ('Cook clean tmr', 'Default description', 'HEALTH', '2016-06-28 19:10:25-07', '2016-06-29 19:10:25-07', null, 'ONGOING', 4),
       ('Stare at birds', 'Default description', 'HEALTH', '2016-06-29 19:10:25-07', '2016-06-29 21:10:25-07', null, 'ONGOING', 4),
       ('Clean room', 'Default description', 'HOUSE_CHORES', '2016-06-30 19:10:25-07', '2016-06-30 20:10:25-07', '2016-06-30 19:45:25-07', 'COMPLETED', 5),
       ('Take out trash', 'Default description', 'HOUSE_CHORES', '2016-06-30 20:10:25-07', '2016-06-30 22:10:25-07', null, 'ONGOING', 5);

INSERT INTO location(name, address, postalCode, taskId)
VALUES ('Home', 'Home ave 1',666666, 1),
       ('Home2', 'Home ave 2',666667, 2),
       ('Home3', 'Home ave 3',666668, 3),
       ('Home4', 'Home ave 4',666669, 4),
       ('Home5', 'Home ave 5',666661, 5),
       ('Home6', 'Home ave 6',666662, 6),
       ('Home7', 'Home ave 7',666663, 7),
       ('Home8', 'Home ave 8',666664, 8),
       ('Home9', 'Home ave 9',666665, 9),
       ('Home10', 'Home ave 10',666656, 10);
