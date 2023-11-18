-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION johan;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP SEQUENCE public.addresses_id_address_seq;

CREATE SEQUENCE public.addresses_id_address_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.addresses_id_address_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.addresses_id_address_seq TO johan;

-- DROP SEQUENCE public.category_id_category_seq;

CREATE SEQUENCE public.category_id_category_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.category_id_category_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.category_id_category_seq TO johan;

-- DROP SEQUENCE public.comment_id_comment_seq;

CREATE SEQUENCE public.comment_id_comment_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.comment_id_comment_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.comment_id_comment_seq TO johan;

-- DROP SEQUENCE public.form_payment_id_form_payment_seq;

CREATE SEQUENCE public.form_payment_id_form_payment_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.form_payment_id_form_payment_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.form_payment_id_form_payment_seq TO johan;

-- DROP SEQUENCE public.products_id_product_seq;

CREATE SEQUENCE public.products_id_product_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.products_id_product_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.products_id_product_seq TO johan;

-- DROP SEQUENCE public.profile_maker_id_profile_maker_seq;

CREATE SEQUENCE public.profile_maker_id_profile_maker_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.profile_maker_id_profile_maker_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.profile_maker_id_profile_maker_seq TO johan;

-- DROP SEQUENCE public.review_id_review_seq;

CREATE SEQUENCE public.review_id_review_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.review_id_review_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.review_id_review_seq TO johan;

-- DROP SEQUENCE public.shopping_cart_id_shopping_cart_seq;

CREATE SEQUENCE public.shopping_cart_id_shopping_cart_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.shopping_cart_id_shopping_cart_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.shopping_cart_id_shopping_cart_seq TO johan;

-- DROP SEQUENCE public.sub_category_id_sub_category_seq;

CREATE SEQUENCE public.sub_category_id_sub_category_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.sub_category_id_sub_category_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.sub_category_id_sub_category_seq TO johan;

-- DROP SEQUENCE public.task_id_task_seq;

CREATE SEQUENCE public.task_id_task_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.task_id_task_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.task_id_task_seq TO johan;

-- DROP SEQUENCE public.transaction_id_transaction_seq;

CREATE SEQUENCE public.transaction_id_transaction_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.transaction_id_transaction_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.transaction_id_transaction_seq TO johan;

-- DROP SEQUENCE public.transaction_product_id_transaction_prodcut_seq;

CREATE SEQUENCE public.transaction_product_id_transaction_prodcut_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.transaction_product_id_transaction_prodcut_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.transaction_product_id_transaction_prodcut_seq TO johan;

-- DROP SEQUENCE public.users_id_user_seq;

CREATE SEQUENCE public.users_id_user_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.users_id_user_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.users_id_user_seq TO johan;

-- DROP SEQUENCE public.users_seq;

CREATE SEQUENCE public.users_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.users_seq OWNER TO johan;
GRANT ALL ON SEQUENCE public.users_seq TO johan;
-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	id_category serial4 NOT NULL,
	name_category varchar(255) NOT NULL,
	CONSTRAINT category_name_category_key UNIQUE (name_category),
	CONSTRAINT category_pkey PRIMARY KEY (id_category)
);

-- Permissions

ALTER TABLE public.category OWNER TO johan;
GRANT ALL ON TABLE public.category TO johan;


-- public.form_payment definition

-- Drop table

-- DROP TABLE public.form_payment;

CREATE TABLE public.form_payment (
	id_form_payment serial4 NOT NULL,
	"name" varchar(45) NOT NULL,
	description varchar(100) NOT NULL,
	CONSTRAINT form_payment_pkey PRIMARY KEY (id_form_payment)
);

-- Permissions

ALTER TABLE public.form_payment OWNER TO johan;
GRANT ALL ON TABLE public.form_payment TO johan;


-- public.task definition

-- Drop table

-- DROP TABLE public.task;

CREATE TABLE public.task (
	id_task bigserial NOT NULL,
	description varchar(255) NOT NULL,
	status varchar(255) NOT NULL,
	CONSTRAINT task_pkey PRIMARY KEY (id_task)
);

-- Permissions

ALTER TABLE public.task OWNER TO johan;
GRANT ALL ON TABLE public.task TO johan;


-- public.sub_category definition

-- Drop table

-- DROP TABLE public.sub_category;

CREATE TABLE public.sub_category (
	id_category int4 NULL,
	id_sub_category serial4 NOT NULL,
	name_sub_category varchar(150) NOT NULL,
	CONSTRAINT sub_category_name_sub_category_key UNIQUE (name_sub_category),
	CONSTRAINT sub_category_pkey PRIMARY KEY (id_sub_category),
	CONSTRAINT fkq5fr6mds6m78gvs09c812bj7l FOREIGN KEY (id_category) REFERENCES public.category(id_category)
);

-- Permissions

ALTER TABLE public.sub_category OWNER TO johan;
GRANT ALL ON TABLE public.sub_category TO johan;


-- public.addresses definition

-- Drop table

-- DROP TABLE public.addresses;

CREATE TABLE public.addresses (
	id_address serial4 NOT NULL,
	user_id int4 NULL,
	created_at timestamp(6) NOT NULL,
	phone int8 NOT NULL,
	postal_code varchar(10) NOT NULL,
	city varchar(100) NOT NULL,
	country varchar(100) NOT NULL,
	estate varchar(100) NOT NULL,
	street varchar(100) NOT NULL,
	address_references varchar(200) NOT NULL,
	full_name varchar(300) NOT NULL,
	CONSTRAINT addresses_pkey PRIMARY KEY (id_address)
);

-- Permissions

ALTER TABLE public.addresses OWNER TO johan;
GRANT ALL ON TABLE public.addresses TO johan;


-- public."comment" definition

-- Drop table

-- DROP TABLE public."comment";

CREATE TABLE public."comment" (
	id_comment serial4 NOT NULL,
	id_product int4 NULL,
	description varchar(500) NULL,
	img varchar(1000) NULL,
	CONSTRAINT comment_pkey PRIMARY KEY (id_comment)
);

-- Permissions

ALTER TABLE public."comment" OWNER TO johan;
GRANT ALL ON TABLE public."comment" TO johan;


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id_category int4 NOT NULL,
	id_product serial4 NOT NULL,
	id_shopping_cart int4 NULL,
	price numeric(38, 2) NOT NULL,
	stock int4 NOT NULL,
	created_at timestamp(6) NOT NULL,
	status varchar(12) NOT NULL,
	serial varchar(100) NOT NULL,
	name_product varchar(200) NOT NULL,
	description varchar(500) NOT NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id_product),
	CONSTRAINT products_serial_key UNIQUE (serial)
);

-- Permissions

ALTER TABLE public.products OWNER TO johan;
GRANT ALL ON TABLE public.products TO johan;


-- public.profile_maker definition

-- Drop table

-- DROP TABLE public.profile_maker;

CREATE TABLE public.profile_maker (
	id_profile_maker serial4 NOT NULL,
	id_user int4 NOT NULL,
	created_at timestamp(6) NOT NULL,
	profile_maker varchar(200) NOT NULL,
	description varchar(500) NOT NULL,
	CONSTRAINT profile_maker_pkey PRIMARY KEY (id_profile_maker)
);

-- Permissions

ALTER TABLE public.profile_maker OWNER TO johan;
GRANT ALL ON TABLE public.profile_maker TO johan;


-- public.review definition

-- Drop table

-- DROP TABLE public.review;

CREATE TABLE public.review (
	id_product int4 NULL,
	id_review serial4 NOT NULL,
	id_user int4 NULL,
	description varchar(500) NOT NULL,
	img varchar(1000) NULL,
	CONSTRAINT review_pkey PRIMARY KEY (id_review)
);

-- Permissions

ALTER TABLE public.review OWNER TO johan;
GRANT ALL ON TABLE public.review TO johan;


-- public.shopping_cart definition

-- Drop table

-- DROP TABLE public.shopping_cart;

CREATE TABLE public.shopping_cart (
	id_shopping_cart serial4 NOT NULL,
	id_user int4 NOT NULL,
	subtotal numeric(38, 2) NOT NULL,
	created_at timestamp(6) NOT NULL,
	CONSTRAINT shopping_cart_pkey PRIMARY KEY (id_shopping_cart)
);

-- Permissions

ALTER TABLE public.shopping_cart OWNER TO johan;
GRANT ALL ON TABLE public.shopping_cart TO johan;


-- public."transaction" definition

-- Drop table

-- DROP TABLE public."transaction";

CREATE TABLE public."transaction" (
	amount numeric(38, 2) NOT NULL,
	amount_products int4 NOT NULL,
	id_form_payment int4 NULL,
	id_transaction serial4 NOT NULL,
	id_user int4 NULL,
	date_transaction timestamp(6) NOT NULL,
	CONSTRAINT transaction_pkey PRIMARY KEY (id_transaction)
);

-- Permissions

ALTER TABLE public."transaction" OWNER TO johan;
GRANT ALL ON TABLE public."transaction" TO johan;


-- public.transaction_product definition

-- Drop table

-- DROP TABLE public.transaction_product;

CREATE TABLE public.transaction_product (
	cantidad int4 NOT NULL,
	id_product int4 NOT NULL,
	id_transaction int4 NOT NULL,
	id_transaction_prodcut serial4 NOT NULL,
	precio_unitario numeric(38, 2) NOT NULL,
	CONSTRAINT transaction_product_pkey PRIMARY KEY (id_transaction_prodcut)
);

-- Permissions

ALTER TABLE public.transaction_product OWNER TO johan;
GRANT ALL ON TABLE public.transaction_product TO johan;


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id_shopping_cart int4 NULL,
	id_user serial4 NOT NULL,
	created_at timestamp(6) NOT NULL,
	phone int8 NULL,
	"role" varchar(10) NOT NULL,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	middle_name varchar(100) NOT NULL,
	second_last_name varchar(100) NOT NULL,
	avatar varchar(1000) NULL,
	email varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	CONSTRAINT users_email_key UNIQUE (email),
	CONSTRAINT users_pkey PRIMARY KEY (id_user)
);

-- Permissions

ALTER TABLE public.users OWNER TO johan;
GRANT ALL ON TABLE public.users TO johan;


-- public.addresses foreign keys

ALTER TABLE public.addresses ADD CONSTRAINT fk1fa36y2oqhao3wgg2rw1pi459 FOREIGN KEY (user_id) REFERENCES public.users(id_user);


-- public."comment" foreign keys

ALTER TABLE public."comment" ADD CONSTRAINT fk21ojaxp13gciqpej60nkr7d03 FOREIGN KEY (id_product) REFERENCES public.products(id_product);


-- public.products foreign keys

ALTER TABLE public.products ADD CONSTRAINT fkasih73m6q7t6gs9udyp5blisr FOREIGN KEY (id_category) REFERENCES public.category(id_category);
ALTER TABLE public.products ADD CONSTRAINT fkoggfs8mw5lj7dob13qou08vbo FOREIGN KEY (id_shopping_cart) REFERENCES public.shopping_cart(id_shopping_cart);


-- public.profile_maker foreign keys

ALTER TABLE public.profile_maker ADD CONSTRAINT fkrye8au49qyfvylhhvmcm8tvgi FOREIGN KEY (id_user) REFERENCES public.users(id_user);


-- public.review foreign keys

ALTER TABLE public.review ADD CONSTRAINT fk1kahqq7u7xs4mx4snpqmpyjhf FOREIGN KEY (id_user) REFERENCES public.users(id_user);
ALTER TABLE public.review ADD CONSTRAINT fkjk9snebw0h3gwwpu6grtkn3vb FOREIGN KEY (id_product) REFERENCES public.products(id_product);


-- public.shopping_cart foreign keys

ALTER TABLE public.shopping_cart ADD CONSTRAINT fkpp037be5woo3mss09qseigw10 FOREIGN KEY (id_user) REFERENCES public.users(id_user);


-- public."transaction" foreign keys

ALTER TABLE public."transaction" ADD CONSTRAINT fk45nqvchqqmxkvf9wn4r5s3vpi FOREIGN KEY (id_form_payment) REFERENCES public.form_payment(id_form_payment);
ALTER TABLE public."transaction" ADD CONSTRAINT fkflajr8557mg4japqaiknrptp3 FOREIGN KEY (id_user) REFERENCES public.users(id_user);


-- public.transaction_product foreign keys

ALTER TABLE public.transaction_product ADD CONSTRAINT fk6c5wfrx524xn0g5d3pbg6unnf FOREIGN KEY (id_transaction) REFERENCES public."transaction"(id_transaction);
ALTER TABLE public.transaction_product ADD CONSTRAINT fkgurivxdgti4sib6l7896rvv7g FOREIGN KEY (id_product) REFERENCES public.products(id_product);


-- public.users foreign keys

ALTER TABLE public.users ADD CONSTRAINT fk5bikrgvq5q1q429551uc15q6y FOREIGN KEY (id_shopping_cart) REFERENCES public.shopping_cart(id_shopping_cart);




-- Permissions;
