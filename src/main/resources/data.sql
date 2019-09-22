INSERT INTO border(name) VALUES ('TODO')
INSERT INTO border(name) VALUES ('DONE')

INSERT INTO task(name, description, is_important, border_id) VALUES ('A123', 'SUPER TASK', false)
INSERT INTO task(name, description, is_important, border_id) VALUES ('B123', 'EXTRA TASK', false)
INSERT INTO task(name, description, is_important, border_id) VALUES ('C123', 'DUMB TASK', false)

INSERT INTO task_email(task_id, email_id) VALUES (1, 1)
INSERT INTO task_email(task_id, email_id) VALUES (1, 2)
INSERT INTO task_email(task_id, email_id) VALUES (2, 3)
INSERT INTO task_email(task_id, email_id) VALUES (3, 1)
INSERT INTO task_email(task_id, email_id) VALUES (3, 2)

