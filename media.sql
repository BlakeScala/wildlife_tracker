--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE animals OWNER TO "Blake";

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: Blake
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO "Blake";

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Blake
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE categories (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE categories OWNER TO "Blake";

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: Blake
--

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categories_id_seq OWNER TO "Blake";

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Blake
--

ALTER SEQUENCE categories_id_seq OWNED BY categories.id;


--
-- Name: comments; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE comments (
    id integer NOT NULL,
    comment character varying,
    "time" timestamp without time zone,
    post_id integer
);


ALTER TABLE comments OWNER TO "Blake";

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: Blake
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO "Blake";

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Blake
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- Name: posts; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE posts (
    id integer NOT NULL,
    information character varying,
    title character varying,
    "time" timestamp without time zone,
    category_id integer
);


ALTER TABLE posts OWNER TO "Blake";

--
-- Name: posts_categories; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE posts_categories (
    id integer NOT NULL,
    post_id integer,
    category_id integer
);


ALTER TABLE posts_categories OWNER TO "Blake";

--
-- Name: posts_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: Blake
--

CREATE SEQUENCE posts_categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE posts_categories_id_seq OWNER TO "Blake";

--
-- Name: posts_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Blake
--

ALTER SEQUENCE posts_categories_id_seq OWNED BY posts_categories.id;


--
-- Name: posts_id_seq; Type: SEQUENCE; Schema: public; Owner: Blake
--

CREATE SEQUENCE posts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE posts_id_seq OWNER TO "Blake";

--
-- Name: posts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Blake
--

ALTER SEQUENCE posts_id_seq OWNED BY posts.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE sightings (
    id integer NOT NULL,
    location character varying,
    rangername character varying,
    animal_id integer
);


ALTER TABLE sightings OWNER TO "Blake";

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: Blake
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO "Blake";

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Blake
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY posts ALTER COLUMN id SET DEFAULT nextval('posts_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY posts_categories ALTER COLUMN id SET DEFAULT nextval('posts_categories_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY animals (id, name) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('animals_id_seq', 1, false);


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY categories (id, name) FROM stdin;
\.


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('categories_id_seq', 1, false);


--
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY comments (id, comment, "time", post_id) FROM stdin;
\.


--
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('comments_id_seq', 1, false);


--
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY posts (id, information, title, "time", category_id) FROM stdin;
\.


--
-- Data for Name: posts_categories; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY posts_categories (id, post_id, category_id) FROM stdin;
\.


--
-- Name: posts_categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('posts_categories_id_seq', 1, false);


--
-- Name: posts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('posts_id_seq', 1, false);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY sightings (id, location, rangername, animal_id) FROM stdin;
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('sightings_id_seq', 1, false);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: categories_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: comments_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- Name: posts_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY posts_categories
    ADD CONSTRAINT posts_categories_pkey PRIMARY KEY (id);


--
-- Name: posts_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: Blake
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "Blake";
GRANT ALL ON SCHEMA public TO "Blake";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

