--
-- PostgreSQL database dump
--

-- Dumped from database version 15.5
-- Dumped by pg_dump version 15.3

-- Started on 2023-11-24 05:39:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3276 (class 1262 OID 16389)
-- Name: store_8c7x; Type: DATABASE; Schema: -; Owner: -
--

CREATE DATABASE store_8c7x WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF8';


\connect store_8c7x

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3277 (class 0 OID 0)
-- Name: store_8c7x; Type: DATABASE PROPERTIES; Schema: -; Owner: -
--

ALTER DATABASE store_8c7x SET "TimeZone" TO 'utc';


\connect store_8c7x

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3278 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16398)
-- Name: addresses; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.addresses (
    id_address integer NOT NULL,
    user_id integer,
    inner_number character varying(5),
    outer_number character varying(5) NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    phone bigint NOT NULL,
    postal_code character varying(10) NOT NULL,
    country character varying(100) NOT NULL,
    estate character varying(100) NOT NULL,
    street character varying(100) NOT NULL,
    city character varying(200) NOT NULL,
    full_name character varying(300) NOT NULL,
    address_references character varying(500) NOT NULL
);


--
-- TOC entry 214 (class 1259 OID 16397)
-- Name: addresses_id_address_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.addresses_id_address_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3279 (class 0 OID 0)
-- Dependencies: 214
-- Name: addresses_id_address_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.addresses_id_address_seq OWNED BY public.addresses.id_address;


--
-- TOC entry 217 (class 1259 OID 16407)
-- Name: category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.category (
    id_category integer NOT NULL,
    name_category character varying(255) NOT NULL
);


--
-- TOC entry 216 (class 1259 OID 16406)
-- Name: category_id_category_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.category_id_category_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3280 (class 0 OID 0)
-- Dependencies: 216
-- Name: category_id_category_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.category_id_category_seq OWNED BY public.category.id_category;


--
-- TOC entry 219 (class 1259 OID 16416)
-- Name: comment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.comment (
    id_comment integer NOT NULL,
    id_product integer,
    description character varying(500),
    img character varying(1000)
);


--
-- TOC entry 218 (class 1259 OID 16415)
-- Name: comment_id_comment_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.comment_id_comment_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3281 (class 0 OID 0)
-- Dependencies: 218
-- Name: comment_id_comment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.comment_id_comment_seq OWNED BY public.comment.id_comment;


--
-- TOC entry 221 (class 1259 OID 16425)
-- Name: form_payment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.form_payment (
    id_form_payment integer NOT NULL,
    name character varying(45) NOT NULL,
    description character varying(100) NOT NULL
);


--
-- TOC entry 220 (class 1259 OID 16424)
-- Name: form_payment_id_form_payment_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.form_payment_id_form_payment_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3282 (class 0 OID 0)
-- Dependencies: 220
-- Name: form_payment_id_form_payment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.form_payment_id_form_payment_seq OWNED BY public.form_payment.id_form_payment;


--
-- TOC entry 223 (class 1259 OID 16432)
-- Name: products; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.products (
    id_category integer NOT NULL,
    id_product integer NOT NULL,
    id_shopping_cart integer,
    id_sub_category integer NOT NULL,
    price numeric(38,2) NOT NULL,
    stock integer NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    status character varying(12) NOT NULL,
    serial character varying(100) NOT NULL,
    name_product character varying(200) NOT NULL,
    description character varying(5000) NOT NULL
);


--
-- TOC entry 222 (class 1259 OID 16431)
-- Name: products_id_product_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.products_id_product_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3283 (class 0 OID 0)
-- Dependencies: 222
-- Name: products_id_product_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.products_id_product_seq OWNED BY public.products.id_product;


--
-- TOC entry 225 (class 1259 OID 16443)
-- Name: profile_maker; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.profile_maker (
    id_profile_maker integer NOT NULL,
    id_user integer NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    profile_maker character varying(200) NOT NULL,
    description character varying(500) NOT NULL
);


--
-- TOC entry 224 (class 1259 OID 16442)
-- Name: profile_maker_id_profile_maker_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.profile_maker_id_profile_maker_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3284 (class 0 OID 0)
-- Dependencies: 224
-- Name: profile_maker_id_profile_maker_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.profile_maker_id_profile_maker_seq OWNED BY public.profile_maker.id_profile_maker;


--
-- TOC entry 227 (class 1259 OID 16452)
-- Name: review; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.review (
    id_product integer,
    id_review integer NOT NULL,
    id_user integer,
    description character varying(500) NOT NULL,
    img character varying(1000)
);


--
-- TOC entry 226 (class 1259 OID 16451)
-- Name: review_id_review_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.review_id_review_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3285 (class 0 OID 0)
-- Dependencies: 226
-- Name: review_id_review_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.review_id_review_seq OWNED BY public.review.id_review;


--
-- TOC entry 229 (class 1259 OID 16461)
-- Name: shopping_cart; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.shopping_cart (
    id_shopping_cart integer NOT NULL,
    id_user integer NOT NULL,
    subtotal numeric(38,2) NOT NULL,
    created_at timestamp(6) without time zone NOT NULL
);


--
-- TOC entry 228 (class 1259 OID 16460)
-- Name: shopping_cart_id_shopping_cart_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.shopping_cart_id_shopping_cart_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3286 (class 0 OID 0)
-- Dependencies: 228
-- Name: shopping_cart_id_shopping_cart_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.shopping_cart_id_shopping_cart_seq OWNED BY public.shopping_cart.id_shopping_cart;


--
-- TOC entry 231 (class 1259 OID 16468)
-- Name: sub_category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.sub_category (
    id_category integer,
    id_sub_category integer NOT NULL,
    name_sub_category character varying(150) NOT NULL
);


--
-- TOC entry 230 (class 1259 OID 16467)
-- Name: sub_category_id_sub_category_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.sub_category_id_sub_category_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3287 (class 0 OID 0)
-- Dependencies: 230
-- Name: sub_category_id_sub_category_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.sub_category_id_sub_category_seq OWNED BY public.sub_category.id_sub_category;


--
-- TOC entry 233 (class 1259 OID 16477)
-- Name: transaction; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.transaction (
    amount numeric(38,2) NOT NULL,
    amount_products integer NOT NULL,
    id_form_payment integer NOT NULL,
    id_transaction integer NOT NULL,
    id_user integer NOT NULL,
    date_transaction timestamp(6) without time zone NOT NULL
);


--
-- TOC entry 232 (class 1259 OID 16476)
-- Name: transaction_id_transaction_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.transaction_id_transaction_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3288 (class 0 OID 0)
-- Dependencies: 232
-- Name: transaction_id_transaction_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.transaction_id_transaction_seq OWNED BY public.transaction.id_transaction;


--
-- TOC entry 234 (class 1259 OID 16483)
-- Name: transaction_product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.transaction_product (
    id_product integer NOT NULL,
    id_transaction integer NOT NULL,
    quantity integer NOT NULL,
    total numeric(38,2) NOT NULL
);


--
-- TOC entry 236 (class 1259 OID 16489)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id_shopping_cart integer,
    id_user integer NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    phone bigint,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    middle_name character varying(100),
    second_last_name character varying(100) NOT NULL,
    avatar character varying(1000),
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


--
-- TOC entry 235 (class 1259 OID 16488)
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3289 (class 0 OID 0)
-- Dependencies: 235
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_user_seq OWNED BY public.users.id_user;


--
-- TOC entry 3046 (class 2604 OID 16401)
-- Name: addresses id_address; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.addresses ALTER COLUMN id_address SET DEFAULT nextval('public.addresses_id_address_seq'::regclass);


--
-- TOC entry 3047 (class 2604 OID 16410)
-- Name: category id_category; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category ALTER COLUMN id_category SET DEFAULT nextval('public.category_id_category_seq'::regclass);


--
-- TOC entry 3048 (class 2604 OID 16419)
-- Name: comment id_comment; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comment ALTER COLUMN id_comment SET DEFAULT nextval('public.comment_id_comment_seq'::regclass);


--
-- TOC entry 3049 (class 2604 OID 16428)
-- Name: form_payment id_form_payment; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.form_payment ALTER COLUMN id_form_payment SET DEFAULT nextval('public.form_payment_id_form_payment_seq'::regclass);


--
-- TOC entry 3050 (class 2604 OID 16435)
-- Name: products id_product; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.products ALTER COLUMN id_product SET DEFAULT nextval('public.products_id_product_seq'::regclass);


--
-- TOC entry 3051 (class 2604 OID 16446)
-- Name: profile_maker id_profile_maker; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profile_maker ALTER COLUMN id_profile_maker SET DEFAULT nextval('public.profile_maker_id_profile_maker_seq'::regclass);


--
-- TOC entry 3052 (class 2604 OID 16455)
-- Name: review id_review; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.review ALTER COLUMN id_review SET DEFAULT nextval('public.review_id_review_seq'::regclass);


--
-- TOC entry 3053 (class 2604 OID 16464)
-- Name: shopping_cart id_shopping_cart; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.shopping_cart ALTER COLUMN id_shopping_cart SET DEFAULT nextval('public.shopping_cart_id_shopping_cart_seq'::regclass);


--
-- TOC entry 3054 (class 2604 OID 16471)
-- Name: sub_category id_sub_category; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sub_category ALTER COLUMN id_sub_category SET DEFAULT nextval('public.sub_category_id_sub_category_seq'::regclass);


--
-- TOC entry 3055 (class 2604 OID 16480)
-- Name: transaction id_transaction; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction ALTER COLUMN id_transaction SET DEFAULT nextval('public.transaction_id_transaction_seq'::regclass);


--
-- TOC entry 3056 (class 2604 OID 16492)
-- Name: users id_user; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id_user SET DEFAULT nextval('public.users_id_user_seq'::regclass);


--
-- TOC entry 3249 (class 0 OID 16398)
-- Dependencies: 215
-- Data for Name: addresses; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3251 (class 0 OID 16407)
-- Dependencies: 217
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3253 (class 0 OID 16416)
-- Dependencies: 219
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3255 (class 0 OID 16425)
-- Dependencies: 221
-- Data for Name: form_payment; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3257 (class 0 OID 16432)
-- Dependencies: 223
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3259 (class 0 OID 16443)
-- Dependencies: 225
-- Data for Name: profile_maker; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3261 (class 0 OID 16452)
-- Dependencies: 227
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3263 (class 0 OID 16461)
-- Dependencies: 229
-- Data for Name: shopping_cart; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3265 (class 0 OID 16468)
-- Dependencies: 231
-- Data for Name: sub_category; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3267 (class 0 OID 16477)
-- Dependencies: 233
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3268 (class 0 OID 16483)
-- Dependencies: 234
-- Data for Name: transaction_product; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3270 (class 0 OID 16489)
-- Dependencies: 236
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES (NULL, 1, '2023-11-24 05:14:14.067', 4181343723, 'Julio', 'Jaramillo', 'Johan', 'Mejia', '', 'juliojohan@gmail.com', '$2a$10$Vsapz7xHZXiweNwnMSR9ReOiltyHx.bI641C08mN5yk7jgFMafIMa');


--
-- TOC entry 3290 (class 0 OID 0)
-- Dependencies: 214
-- Name: addresses_id_address_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.addresses_id_address_seq', 1, false);


--
-- TOC entry 3291 (class 0 OID 0)
-- Dependencies: 216
-- Name: category_id_category_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.category_id_category_seq', 1, false);


--
-- TOC entry 3292 (class 0 OID 0)
-- Dependencies: 218
-- Name: comment_id_comment_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.comment_id_comment_seq', 1, false);


--
-- TOC entry 3293 (class 0 OID 0)
-- Dependencies: 220
-- Name: form_payment_id_form_payment_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.form_payment_id_form_payment_seq', 1, false);


--
-- TOC entry 3294 (class 0 OID 0)
-- Dependencies: 222
-- Name: products_id_product_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.products_id_product_seq', 1, false);


--
-- TOC entry 3295 (class 0 OID 0)
-- Dependencies: 224
-- Name: profile_maker_id_profile_maker_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.profile_maker_id_profile_maker_seq', 1, false);


--
-- TOC entry 3296 (class 0 OID 0)
-- Dependencies: 226
-- Name: review_id_review_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.review_id_review_seq', 1, false);


--
-- TOC entry 3297 (class 0 OID 0)
-- Dependencies: 228
-- Name: shopping_cart_id_shopping_cart_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.shopping_cart_id_shopping_cart_seq', 1, false);


--
-- TOC entry 3298 (class 0 OID 0)
-- Dependencies: 230
-- Name: sub_category_id_sub_category_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.sub_category_id_sub_category_seq', 1, false);


--
-- TOC entry 3299 (class 0 OID 0)
-- Dependencies: 232
-- Name: transaction_id_transaction_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.transaction_id_transaction_seq', 1, false);


--
-- TOC entry 3300 (class 0 OID 0)
-- Dependencies: 235
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_user_seq', 1, true);


--
-- TOC entry 3058 (class 2606 OID 16405)
-- Name: addresses addresses_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (id_address);


--
-- TOC entry 3060 (class 2606 OID 16414)
-- Name: category category_name_category_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_name_category_key UNIQUE (name_category);


--
-- TOC entry 3062 (class 2606 OID 16412)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id_category);


--
-- TOC entry 3064 (class 2606 OID 16423)
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id_comment);


--
-- TOC entry 3066 (class 2606 OID 16430)
-- Name: form_payment form_payment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.form_payment
    ADD CONSTRAINT form_payment_pkey PRIMARY KEY (id_form_payment);


--
-- TOC entry 3068 (class 2606 OID 16439)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id_product);


--
-- TOC entry 3070 (class 2606 OID 16441)
-- Name: products products_serial_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_serial_key UNIQUE (serial);


--
-- TOC entry 3072 (class 2606 OID 16450)
-- Name: profile_maker profile_maker_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profile_maker
    ADD CONSTRAINT profile_maker_pkey PRIMARY KEY (id_profile_maker);


--
-- TOC entry 3074 (class 2606 OID 16459)
-- Name: review review_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT review_pkey PRIMARY KEY (id_review);


--
-- TOC entry 3076 (class 2606 OID 16466)
-- Name: shopping_cart shopping_cart_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.shopping_cart
    ADD CONSTRAINT shopping_cart_pkey PRIMARY KEY (id_shopping_cart);


--
-- TOC entry 3078 (class 2606 OID 16475)
-- Name: sub_category sub_category_name_sub_category_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sub_category
    ADD CONSTRAINT sub_category_name_sub_category_key UNIQUE (name_sub_category);


--
-- TOC entry 3080 (class 2606 OID 16473)
-- Name: sub_category sub_category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sub_category
    ADD CONSTRAINT sub_category_pkey PRIMARY KEY (id_sub_category);


--
-- TOC entry 3082 (class 2606 OID 16482)
-- Name: transaction transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id_transaction);


--
-- TOC entry 3084 (class 2606 OID 16487)
-- Name: transaction_product transaction_product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction_product
    ADD CONSTRAINT transaction_product_pkey PRIMARY KEY (id_product, id_transaction);


--
-- TOC entry 3086 (class 2606 OID 16500)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 3088 (class 2606 OID 16498)
-- Name: users users_phone_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_phone_key UNIQUE (phone);


--
-- TOC entry 3090 (class 2606 OID 16496)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- TOC entry 3091 (class 2606 OID 16501)
-- Name: addresses fk1fa36y2oqhao3wgg2rw1pi459; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT fk1fa36y2oqhao3wgg2rw1pi459 FOREIGN KEY (user_id) REFERENCES public.users(id_user);


--
-- TOC entry 3097 (class 2606 OID 16536)
-- Name: review fk1kahqq7u7xs4mx4snpqmpyjhf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT fk1kahqq7u7xs4mx4snpqmpyjhf FOREIGN KEY (id_user) REFERENCES public.users(id_user);


--
-- TOC entry 3092 (class 2606 OID 16506)
-- Name: comment fk21ojaxp13gciqpej60nkr7d03; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fk21ojaxp13gciqpej60nkr7d03 FOREIGN KEY (id_product) REFERENCES public.products(id_product);


--
-- TOC entry 3101 (class 2606 OID 16551)
-- Name: transaction fk45nqvchqqmxkvf9wn4r5s3vpi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fk45nqvchqqmxkvf9wn4r5s3vpi FOREIGN KEY (id_form_payment) REFERENCES public.form_payment(id_form_payment);


--
-- TOC entry 3093 (class 2606 OID 16521)
-- Name: products fk4te6jbsge985vt3ykoyg3pr0m; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk4te6jbsge985vt3ykoyg3pr0m FOREIGN KEY (id_sub_category) REFERENCES public.sub_category(id_sub_category);


--
-- TOC entry 3105 (class 2606 OID 16571)
-- Name: users fk5bikrgvq5q1q429551uc15q6y; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk5bikrgvq5q1q429551uc15q6y FOREIGN KEY (id_shopping_cart) REFERENCES public.shopping_cart(id_shopping_cart);


--
-- TOC entry 3103 (class 2606 OID 16566)
-- Name: transaction_product fk6c5wfrx524xn0g5d3pbg6unnf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction_product
    ADD CONSTRAINT fk6c5wfrx524xn0g5d3pbg6unnf FOREIGN KEY (id_transaction) REFERENCES public.transaction(id_transaction);


--
-- TOC entry 3094 (class 2606 OID 16511)
-- Name: products fkasih73m6q7t6gs9udyp5blisr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkasih73m6q7t6gs9udyp5blisr FOREIGN KEY (id_category) REFERENCES public.category(id_category);


--
-- TOC entry 3102 (class 2606 OID 16556)
-- Name: transaction fkflajr8557mg4japqaiknrptp3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fkflajr8557mg4japqaiknrptp3 FOREIGN KEY (id_user) REFERENCES public.users(id_user);


--
-- TOC entry 3104 (class 2606 OID 16561)
-- Name: transaction_product fkgurivxdgti4sib6l7896rvv7g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.transaction_product
    ADD CONSTRAINT fkgurivxdgti4sib6l7896rvv7g FOREIGN KEY (id_product) REFERENCES public.products(id_product);


--
-- TOC entry 3098 (class 2606 OID 16531)
-- Name: review fkjk9snebw0h3gwwpu6grtkn3vb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT fkjk9snebw0h3gwwpu6grtkn3vb FOREIGN KEY (id_product) REFERENCES public.products(id_product);


--
-- TOC entry 3095 (class 2606 OID 16516)
-- Name: products fkoggfs8mw5lj7dob13qou08vbo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkoggfs8mw5lj7dob13qou08vbo FOREIGN KEY (id_shopping_cart) REFERENCES public.shopping_cart(id_shopping_cart);


--
-- TOC entry 3099 (class 2606 OID 16541)
-- Name: shopping_cart fkpp037be5woo3mss09qseigw10; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.shopping_cart
    ADD CONSTRAINT fkpp037be5woo3mss09qseigw10 FOREIGN KEY (id_user) REFERENCES public.users(id_user);


--
-- TOC entry 3100 (class 2606 OID 16546)
-- Name: sub_category fkq5fr6mds6m78gvs09c812bj7l; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sub_category
    ADD CONSTRAINT fkq5fr6mds6m78gvs09c812bj7l FOREIGN KEY (id_category) REFERENCES public.category(id_category);


--
-- TOC entry 3096 (class 2606 OID 16526)
-- Name: profile_maker fkrye8au49qyfvylhhvmcm8tvgi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profile_maker
    ADD CONSTRAINT fkrye8au49qyfvylhhvmcm8tvgi FOREIGN KEY (id_user) REFERENCES public.users(id_user);


-- Completed on 2023-11-24 05:39:48

--
-- PostgreSQL database dump complete
--

