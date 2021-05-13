
drop table if exists spending_tracker CASCADE;
create table spending_tracker (
	id bigint auto_increment, 
	amount decimal(6,2) not null, 
	info varchar(100), 
	type varchar(255), 
	primary key (id))
	;