create database game_platform;
use game_platform;
create table user (
	user_id smallint unsigned not null auto_increment, 
	user_email varchar(320),
	user_name varchar(20) not null,
	user_password varchar(20) not null,
	user_picture varchar(1024),
	constraint pk_example primary key (user_id) );
create table game (
	game_id smallint unsigned not null auto_increment, 
	game_name varchar(20) not null,
	game_picture varchar(1024),
	constraint pk_example primary key (game_id) );
create table player_info (
	game_id smallint unsigned not null, 
	user_id smallint unsigned not null,
	player_score integer,
	player_rank integer,  
	constraint fk_player foreign key (user_id) references user(user_id), 
	constraint fk_party foreign key (game_id) references game(game_id));	
