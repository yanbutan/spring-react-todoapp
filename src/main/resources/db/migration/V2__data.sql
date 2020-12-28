INSERT INTO person (id, name, username, email)
VALUES (1, 'Bob Dylan', 'bobby', 'bobby@gmail.com'),
       (2, 'Jacky Chang', 'jackie', 'jackie@gmail.com'),
       (3, 'James Bond', 'bondy', 'bondy@gmail.com'),
       (4, 'Robin Tan', 'robin', 'robin@gmail.com'),
       (5, 'Tan Ah Kau', 'tak', 'tak@gmail.com');

INSERT INTO task (id, name, description, taskType, dateCreated, dateToComplete, dateCompleted, status, user_id)
VALUES (1, 'Do homework', 'Do homework lah bodoh', 'SCHOOL WORK', '2016-06-22 19:10:25-07', '2016-06-24 19:10:25-07', '2016-06-23 19:10:25-07', 'COMPLETED', 1),
       (2, 'Finish assignment', 'Default description', 'SCHOOL WORK', '2016-06-23 19:10:25-07', '2016-06-27 19:10:25-07', null, 'ONGOING', 1),
       (3, 'Document code', 'Default description', 'PART TIME', '2016-06-24 19:10:25-07', '2016-06-28 19:10:25-07', null, 'ONGOING', 2),
       (4, 'Finish frontend css', 'Default description', 'INTERN', '2016-06-25 19:10:25-07', '2016-06-28 19:10:25-07', '2016-06-27 19:10:25-07', 'COMPLETED', 2),
       (5, 'Prepare presentation', 'Default description', 'WORK', '2016-06-26 19:10:25-07', '2016-06-29 19:10:25-07', null, 'OVERDUE', 3),
       (6, 'Run intervals', 'Default description', 'FITNESS', '2016-06-27 19:10:25-07', '2016-06-27 21:10:25-07', null, 'PAUSED', 3),
       (7, 'Cook clean tmr', 'Default description', 'HEALTH', '2016-06-28 19:10:25-07', '2016-06-29 19:10:25-07', null, 'ONGOING', 4),
       (8, 'Stare at birds', 'Default description', 'HEALTH', '2016-06-29 19:10:25-07', '2016-06-29 21:10:25-07', null, 'ONGOING', 4),
       (9, 'Clean room', 'Default description', 'HOUSE CHORES', '2016-06-30 19:10:25-07', '2016-06-30 20:10:25-07', '2016-06-30 19:45:25-07', 'COMPLETED', 5),
       (10, 'Take out trash', 'Default description', 'HOUSE CHORES', '2016-06-30 20:10:25-07', '2016-06-30 22:10:25-07', null, 'ONGOING', 5);

INSERT INTO location(name, address, postalCode, task_id)
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
