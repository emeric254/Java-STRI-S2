CREATE TABLE local 
(
	serialized_id serial PRIMARY KEY,
	object_name varchar(1024) default NULL,
	serialized_object bytea
);