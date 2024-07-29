CREATE TABLE book(
    id INT AUTO_INCREMENT UNIQUE PRIMARY KEY NOT NULL,
    title VARCHAR2(255) NOT NULL,
    author VARCHAR2(255),
    publisher VARCHAR2(255) NOT NULL ,
    description VARCHAR2(255),
    release_date DATE NOT NULL
);

CREATE TABLE library_user(
    id INT AUTO_INCREMENT UNIQUE PRIMARY KEY NOT NULL,
    username VARCHAR2(100) UNIQUE NOT NULL,
    password VARCHAR2(255) NOT NULL
);

INSERT INTO book (title, author, publisher, description, release_date) VALUES
('Crimen y Castigo', 'Fiódor Dostoyevski', 'SKA', 'Novela que explora las complejidades morales y psicológicas del crimen y sus consecuencias', '2001-10-16'),
('Cien Años de Soledad', 'Gabriel García Márquez', 'Harper & Row', 'Crónica épica de la vida de la familia Buendía en Macondo', '1967-06-05'),
('El Principito', 'Antoine de Saint-Exupéry', 'Reynal & Hitchcock', 'Cuento poético sobre la vida y la naturaleza humana', '1943-04-06'),
('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Francisco de Robles', 'Historia de un caballero loco y su escudero en sus aventuras', '1605-01-16'),
('1984', 'George Orwell', 'Secker & Warburg', 'Distopía que aborda temas de totalitarismo y vigilancia', '1949-06-08');