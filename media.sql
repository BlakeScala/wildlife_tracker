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
    name character varying,
    type character varying,
    health character varying,
    age character varying
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
-- Name: sightings; Type: TABLE; Schema: public; Owner: Blake
--

CREATE TABLE sightings (
    id integer NOT NULL,
    location character varying,
    rangername character varying,
    "time" timestamp without time zone,
    animalid integer
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

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY animals (id, name, type, health, age) FROM stdin;
1	Diamondback Rattlesnake	endangered	Healthy	Young
2	Bear	animal	\N	\N
3	Bear	animal	\N	\N
4	blah	animal	\N	\N
5	Blahahh	endangeredanimal	healthy	newborn
7	Try	endangered	1	1
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('animals_id_seq', 45, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: Blake
--

COPY sightings (id, location, rangername, "time", animalid) FROM stdin;
1	NE Quadrant	\N	2016-09-30 12:31:35.074	1
2	NE Quadrant	Joe	2016-10-02 19:23:42.599	6
3	NE Quadrant	Joe	2016-10-02 19:25:04.874	6
4	NE Quadrant	Joe	2016-10-03 07:40:32.557	32
5	NE Quadrant	blah	2016-10-03 07:41:39.065	20
6	NE Quadrant	Joe	2016-10-03 19:23:22.78	10
7	NE Quadrant	Joe	2016-10-03 19:23:56.706	8
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Blake
--

SELECT pg_catalog.setval('sightings_id_seq', 15, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Blake
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


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

