INSERT INTO email(name) VALUES ('aaaa@aaaa.pl')
INSERT INTO email( name) VALUES ('bbbb@bbbb.pl')
INSERT INTO email(name) VALUES ('cccc@cccc.pl')

INSERT INTO border(name) VALUES ('TODO')
INSERT INTO border(name) VALUES ('DONE')

INSERT INTO task(name, description, is_important, border_id) VALUES ('A123', 'SUPER TASK', false, 1)
INSERT INTO task(name, description, is_important, border_id) VALUES ('B123', 'EXTRA TASK', false, 1)
INSERT INTO task(name, description, is_important, border_id) VALUES ('C123', 'DUMB TASK', false, 2)

INSERT INTO task_email(task_id, email_id) VALUES (1, 1)
INSERT INTO task_email(task_id, email_id) VALUES (1, 2)
INSERT INTO task_email(task_id, email_id) VALUES (2, 3)
INSERT INTO task_email(task_id, email_id) VALUES (3, 1)
INSERT INTO task_email(task_id, email_id) VALUES (3, 2)

