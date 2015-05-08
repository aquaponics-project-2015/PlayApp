# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table plant (
  id                        bigint not null,
  name                      varchar(255),
  type                      integer,
  planted_time              timestamp,
  expected_reap_time        timestamp,
  constraint pk_plant primary key (id))
;

create table pump (
  id                        bigint not null,
  status                    boolean,
  datetime                  timestamp,
  constraint pk_pump primary key (id))
;

create table system (
  id                        bigint not null,
  water_level               double,
  ph                        double,
  temperature               double,
  datetime                  timestamp,
  constraint pk_system primary key (id))
;

create sequence plant_seq;

create sequence pump_seq;

create sequence system_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists plant;

drop table if exists pump;

drop table if exists system;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists plant_seq;

drop sequence if exists pump_seq;

drop sequence if exists system_seq;

