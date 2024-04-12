INSERT INTO users(username, password, confirm_password, full_name, email_address, delivery_address) VALUES ('keith', '{noop}keithpw','keithpw','LEE Lap Kei','lklee@hkmu.edu.hk','Hong Kong Metropolitan University');
INSERT INTO user_roles(username, role) VALUES ('keith', 'ROLE_USER');
INSERT INTO user_roles(username, role) VALUES ('keith', 'ROLE_ADMIN');
INSERT INTO users(username, password, confirm_password, full_name, email_address, delivery_address) VALUES ('john', '{noop}johnpw','johnpw', 'John Wong', 'johnwong@hkmu.edu.hk', 'Hong Kong Metropolitan University');
INSERT INTO user_roles(username, role) VALUES ('john', 'ROLE_ADMIN');
INSERT INTO users(username, password, confirm_password, full_name, email_address, delivery_address) VALUES ('mary', '{noop}marypw', 'marypw', 'Mary Chan', 'marychan@hkmu.edu.hk', 'Hong Kong Metropolitan University');
INSERT INTO user_roles(username, role) VALUES ('mary', 'ROLE_USER');