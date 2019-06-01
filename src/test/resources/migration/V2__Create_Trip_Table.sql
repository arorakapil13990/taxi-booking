create table user_detail
(
    user_id bigint not null,
    banned  varchar(255),
    role    varchar(255),
    primary key (user_id)
);

alter table trip_detail
    add constraint FKjlv5b2g690itb7uuj4nsrluvb
        foreign key (user_id)
            references user_detail
