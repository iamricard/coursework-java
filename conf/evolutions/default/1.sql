# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table options (
  id                            bigserial not null,
  text                          varchar(255),
  question_id                   uuid,
  constraint pk_options primary key (id)
);

create table questions (
  id                            uuid not null,
  quiz_id                       uuid,
  text                          varchar(255),
  category                      varchar(255),
  type                          varchar(255),
  difficulty                    varchar(255),
  correct_answer                varchar(255),
  constraint pk_questions primary key (id)
);

create table quizzes (
  id                            uuid not null,
  difficulty                    varchar(255),
  constraint pk_quizzes primary key (id)
);

create table quiz_results (
  id                            uuid not null,
  quiz_id                       uuid,
  score                         integer,
  constraint pk_quiz_results primary key (id)
);

alter table options add constraint fk_options_question_id foreign key (question_id) references questions (id) on delete restrict on update restrict;
create index ix_options_question_id on options (question_id);

alter table questions add constraint fk_questions_quiz_id foreign key (quiz_id) references quizzes (id) on delete restrict on update restrict;
create index ix_questions_quiz_id on questions (quiz_id);

alter table quiz_results add constraint fk_quiz_results_quiz_id foreign key (quiz_id) references quizzes (id) on delete restrict on update restrict;
create index ix_quiz_results_quiz_id on quiz_results (quiz_id);


# --- !Downs

alter table if exists options drop constraint if exists fk_options_question_id;
drop index if exists ix_options_question_id;

alter table if exists questions drop constraint if exists fk_questions_quiz_id;
drop index if exists ix_questions_quiz_id;

alter table if exists quiz_results drop constraint if exists fk_quiz_results_quiz_id;
drop index if exists ix_quiz_results_quiz_id;

drop table if exists options cascade;

drop table if exists questions cascade;

drop table if exists quizzes cascade;

drop table if exists quiz_results cascade;

