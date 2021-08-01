create table if not exists communication_entity
(
    id bigserial not null
        constraint communication_entity_pkey
            primary key,
    create_date timestamp,
    modify_date timestamp,
    preferred boolean,
    type varchar(255),
    value varchar(255),
    contact_id bigint
        constraint fk8agflqi5ekbp1vada902f4s4t
            references contact_entity
            on delete cascade
);

create table if not exists contact_entity
(
    id bigserial not null
        constraint contact_entity_pkey
            primary key,
    create_date timestamp,
    modify_date timestamp,
    city varchar(255),
    date_of_birth varchar(255),
    first_name varchar(255),
    gender varchar(255),
    last_name varchar(255),
    number varchar(255),
    state varchar(255),
    street varchar(255),
    title varchar(255),
    type varchar(255),
    unit varchar(255),
    zip_code varchar(255)
);
