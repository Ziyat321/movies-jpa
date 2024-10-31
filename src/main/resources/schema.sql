create table movies (
                        id serial8 primary key,
                        title varchar(100) not null,
                        release_year int2 not null,
                        rating float4 not null
);