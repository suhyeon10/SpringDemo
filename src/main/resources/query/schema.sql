DROP TABLE IF EXISTS collect_history;
DROP TABLE IF EXISTS collect_image;
DROP TABLE IF EXISTS company;


create table company (
                         id bigint generated by default as identity,
                         company_name varchar(255),
                         company_region varchar(255),
                         contract_start_date date,
                         business_man varchar(255),

                         create_date timestamp,
                         modified_date timestamp,

                         primary key (id)
);
create table collect_history (
                      id bigint generated by default as identity,
                      company_id bigint,
                      collect_amount bigint,
                      collect_tub_count integer,
                      image_count integer,
                      collect_etc varchar(255),
                      real_collect_time timestamp,

                      create_date timestamp,
                      modified_date timestamp,

                      primary key (id),
                      foreign key (company_id) REFERENCES company(id)
);

create table collect_image (
                                id bigint generated by default as identity,
                                file_name varchar(255),
                                file_type varchar(255),
                                collect_history_id bigint,

                                create_date timestamp,
                                modified_date timestamp,

                                primary key (id),
                                foreign key (collect_history_id) REFERENCES collect_history(id)
);
