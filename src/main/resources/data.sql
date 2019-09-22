INSERT INTO border(name) VALUES ('TODO')
INSERT INTO border(name) VALUES ('DONE')

INSERT INTO task(name, description, is_important, border_id) VALUES ('A123', 'SUPER TASK', false, 1)
INSERT INTO task(name, description, is_important, border_id) VALUES ('B123', 'EXTRA TASK', false, 2)
INSERT INTO task(name, description, is_important, border_id) VALUES ('C123', 'DUMB TASK', false, 1)

INSERT INTO task_email_list(task_id, email_list) VALUES (1, '{{aaa@wp.pl}, {bbb@bbb.pl}}')

