DROP TABLE Technologies;
DROP TABLE Contacts;
DROP TABLE Person;

CREATE TABLE Person
(
    person_id  bigint  NOT NULL GENERATED ALWAYS AS IDENTITY,
    surname    text    NOT NULL,
    name       text    NOT NULL,
    patronymic text,
    birthday   date    NOT NULL,
    male       boolean NOT NULl,
    PRIMARY KEY (person_id)
);

INSERT INTO Person (surname, name, patronymic, birthday, male)
VALUES ('Петров', 'Петр', 'Петрович', '1986-12-12', true),
       ('Иванов', 'Иван', 'Иванович', '1997-4-4', true),
       ('Морская', 'Мария', 'Васильевна', '1999-11-7', false);

CREATE TABLE Contacts
(
    contact_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    person_id  bigint NOT NULL,
    phone      text,
    email      text,
    github     text,
    skype      text,
    linkedin   text,
    FOREIGN KEY (person_id) REFERENCES Person (person_id)
);

INSERT INTO Contacts (person_id, phone, email, github, skype, linkedin)
VALUES (1, '+375(29)123-45-67', 'petrovich@gmail.com', 'http://github.com/petya', null, null),
       (2, '+375(29)87-65-43', null, 'http://github.com/vanya', 'skype:ivanko', null),
       (3, '+375(29)999-99-99', null, null, null, 'https://www.linkedin.com/in/mariya/');

CREATE TABLE Technologies
(
    technology_id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    person_id     bigint NOT NULL,
    spring_boot   boolean,
    spring        boolean,
    java_core     boolean,
    java_ee       boolean,
    git           boolean,
    rest          boolean,
    html          boolean,
    maven         boolean,
    FOREIGN KEY (person_id) REFERENCES Person (person_id)
);

INSERT INTO Technologies (person_id, spring_boot, spring, java_core, java_ee, git, rest, html, maven)
VALUES (1, true, false, false, false, true, false, true, false),
       (2, false, false, true, true, true, false, false, false),
       (3, false, true, false, false, false, true, false, true);