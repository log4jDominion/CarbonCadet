CREATE TABLE user_info
(
    user_id character varying(100) NOT NULL,
    user_name character varying(100) ,
    user_role character varying(100) ,
    last_footprint character varying(100) ,
    pledge character varying(100) ,
    CONSTRAINT user_info_pkey PRIMARY KEY (user_id)
);