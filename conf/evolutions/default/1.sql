# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table surfer (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  home                      varchar(255),
  awards                    varchar(255),
  carousel_url              varchar(255),
  bio_url                   varchar(255),
  bio                       varchar(255),
  slug                      varchar(255),
  type                      varchar(255),
  style                     varchar(255),
  constraint pk_surfer primary key (id))
;

create table updating (
  id                        bigint auto_increment not null,
  date                      varchar(255),
  action                    varchar(255),
  name                      varchar(255),
  user_info_id              bigint,
  constraint pk_updating primary key (id))
;

create table user_info (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  admin                     tinyint(1) default 0,
  constraint pk_user_info primary key (id))
;

alter table updating add constraint fk_updating_userInfo_1 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_updating_userInfo_1 on updating (user_info_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table surfer;

drop table updating;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;

