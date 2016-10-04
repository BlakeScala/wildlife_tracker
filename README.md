# _WildLife Tracker_

#### By Blake Scala

## Description

_Application to record sightings of animals in an area of wilderness_

## Setup/Installation Requirements

* In PSQL:
* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar, type varchar, health varchar, age varchar);
* CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, rangerName varchar, time timestamp, int animalid);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

* _Clone the github repository_
* _Open in Atom_
* _Navigate to directory in Terminal_
* _Run 'gradle run' command and navigate to localhost:4567 in your browser._

## GitHub link

https://github.com/BlakeScala/wildlife_tracker

## Licensing

* This application is licensed under the MIT license.

## Specs

  **Animals can be created**

  * Example input: New Animal: "Bear"
  * Example output: Animal: Bear

  **EndangeredAnimals can be created**

  * Example input: New EndangeredAnimal: "Rattlesnake" Health: Healthy Age: Young
  * Example output: EndangeredAnimal: "Rattlesnake" Health: Healthy Age: Young

  **Sightings of animals can be created**

  * Example input: New Sighting: Location: NE Quadrant Ranger: Joe
  * Example output: Sighting -- Location: NE Quadrant Ranger: Joe Time: 2016-09-18 12:16:43.01925

  **One Animal or EndangeredAnimal can have multiple sightings**

  * Example input: New Animal: "Bear"
  * Example output: Animal: Bear
  * Example input: Select Bear
  * Example output: All sightings of Bear

Copyright (c) 2016 **Blake Scala**
