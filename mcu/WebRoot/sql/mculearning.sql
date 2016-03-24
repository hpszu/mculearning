drop table if exists account;

/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
create table account
(
   id                             integer                        not null,
   account                        varchar,
   password                       varchar,
   primary key (id)
)