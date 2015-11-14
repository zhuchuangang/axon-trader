CREATE TABLE t_sys_user (
	id int NOT NULL AUTO_INCREMENT,
	user_id nvarchar(100),
	name nvarchar(100),
	username nvarchar(100),
	password nvarchar(100),
	PRIMARY KEY (id)
)