/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Jorda
 * Created: 25-11-2024
 */
DROP DATABASE st_library;
CREATE DATABASE st_library;
USE st_library;
CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(17),
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    fechaPublicacion DATE DEFAULT now(),
    descripcion TEXT
);
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    clave VARCHAR(100) NOT NULL,
    nivelAcceso INT NOT NULL,
    rut VARCHAR(20) NOT NULL
);
CREATE TABLE salas (
    numeroSala INT AUTO_INCREMENT PRIMARY KEY,
    disponible BOOLEAN NOT NULL,
    capacidad INT NOT NULL
);
CREATE TABLE usuario_libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    libro_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE
);
CREATE TABLE usuario_sala (
    id int AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    sala_numero INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (sala_numero) REFERENCES salas(numeroSala)
);

INSERT INTO libros (isbn, titulo, autor, categoria, stock, fechaPublicacion, descripcion) VALUES
('978-3-16-148410-0', 'La guerra de los mundos', 'H.G. Wells', 'Ciencia ficción', 15, '1902-01-01', 'Un relato sobre la invasión de la Tierra por seres de otro planeta.'),
('978-0-7432-7356-5', 'Los pilares de la Tierra', 'Ken Follett', 'Ficción', 10, '1989-09-01', 'Una novela histórica que transcurre en la Edad Media.'),
('978-1-56619-909-4', 'Cien años de soledad', 'Gabriel García Márquez', 'Ficción', 8, '1967-05-30', 'La historia de la familia Buendía en el pueblo de Macondo.'),
('978-0-452-28423-4', 'El gran Gatsby', 'F. Scott Fitzgerald', 'Literatura clásica', 12, '1925-04-10', 'Una novela sobre el amor y la desesperación en la década de 1920.'),
('978-0-06-112241-5', '1984', 'George Orwell', 'Ciencia ficción', 20, '1949-06-08', 'Una distopía sobre un régimen totalitario que vigila a cada ciudadano.'),
('978-0-671-02735-0', 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', 25, '1997-06-26', 'El comienzo de la saga de Harry Potter y sus aventuras en Hogwarts.'),
('978-0-06-093546-7', 'Orgullo y prejuicio', 'Jane Austen', 'Romántico', 18, '1813-01-28', 'Una novela sobre las relaciones y las clases sociales en el siglo XIX.'),
('978-1-5011-9071-4', 'La chica del tren', 'Paula Hawkins', 'Thriller', 22, '2015-01-13', 'Un thriller psicológico sobre obsesión y misterio.'),
('978-1-9821-4980-7', 'El código Da Vinci', 'Dan Brown', 'Misterio y suspense', 10, '2003-03-18', 'Un thriller sobre un asesinato en el Museo del Louvre y un misterio religioso.'),
('978-1-4391-5972-2', 'La sombra del viento', 'Carlos Ruiz Zafón', 'Misterio y suspense', 14, '2001-11-17', 'Una novela sobre libros perdidos y secretos oscuros en la Barcelona de la posguerra.'),
('978-0-452-28423-4', 'Frankenstein', 'Mary Shelley', 'Ficción', 30, '1818-01-01', 'La historia de un científico que crea un monstruo, solo para enfrentarse a las consecuencias.'),
('978-0-7432-7356-5', 'Los Miserables', 'Victor Hugo', 'Literatura clásica', 16, '1862-04-03', 'Una novela sobre la injusticia social y la lucha por la redención en Francia.'),
('978-0-06-112241-5', 'El extranjero', 'Albert Camus', 'Ficción', 12, '1942-06-01', 'Un hombre se enfrenta a la vida y la muerte con una indiferencia existencial.'),
('978-0-452-28423-4', 'Drácula', 'Bram Stoker', 'Misterio y suspense', 15, '1897-05-26', 'La historia del famoso vampiro que llega desde Transilvania a Inglaterra.'),
('978-0-671-02735-0', 'El Hobbit', 'J.R.R. Tolkien', 'Fantasía', 18, '1937-09-21', 'La aventura de Bilbo Bolsón en la Tierra Media.'),
('978-0-452-28423-4', 'Matar a un ruiseñor', 'Harper Lee', 'Ficción', 17, '1960-07-11', 'Una obra que aborda temas de racismo e injusticia en el sur de los EE.UU.'),
('978-0-06-112241-5', 'La metamorfosis', 'Franz Kafka', 'Ficción', 21, '1915-10-01', 'Un hombre se despierta transformado en un insecto y enfrenta el rechazo de su familia.'),
('978-1-5011-9071-4', 'El nombre del viento', 'Patrick Rothfuss', 'Fantasía', 13, '2007-03-27', 'La primera parte de la historia de Kvothe, un legendario mago y músico.'),
('978-0-671-02735-0', 'Don Quijote de la Mancha', 'Miguel de Cervantes', 'Literatura clásica', 10, '1605-01-16', 'Las aventuras de un caballero loco y su fiel escudero en la España medieval.'),
('978-0-7432-7356-5', 'El retrato de Dorian Gray', 'Oscar Wilde', 'Ficción', 19, '1890-06-01', 'La historia de un hombre que mantiene su juventud mientras su retrato envejece.'),
('978-0-452-28423-4', 'Cumbres borrascosas', 'Emily Brontë', 'Literatura clásica', 14, '1847-12-01', 'Una historia de amor apasionada y destructiva en los páramos de Inglaterra.'),
('978-1-5011-9071-4', 'Las aventuras de Sherlock Holmes', 'Arthur Conan Doyle', 'Misterio y suspense', 22, '1892-10-14', 'Un detective en Londres resuelve misteriosos casos junto a su fiel amigo Watson.'),
('978-0-452-28423-4', 'La odisea', 'Homero', 'Literatura clásica', 30, '800-01-01', 'La épica historia del regreso de Odiseo a su hogar tras la guerra de Troya.'),
('978-1-5011-9071-4', 'Crimen y castigo', 'Fyodor Dostoevsky', 'Ficción', 10, '1866-01-01', 'Un joven se enfrenta a las consecuencias de un asesinato en la Rusia zarista.'),
('978-1-4391-5972-2', 'Pride and Prejudice', 'Jane Austen', 'Romántico', 18, '1813-01-28', 'Una novela sobre el amor, el orgullo y la adaptación en la sociedad inglesa.'),
('978-0-7432-7356-5', '1984', 'George Orwell', 'Ficción', 12, '1949-06-08', 'Un mundo distópico de control totalitario donde la verdad es controlada por el gobierno.'),
('978-1-5011-9071-4', 'La casa de los espíritus', 'Isabel Allende', 'Ficción', 14, '1982-01-08', 'Una historia de amor y política en una familia chilena a lo largo de varias generaciones.'),
('978-0-452-28423-4', 'Fahrenheit 451', 'Ray Bradbury', 'Ciencia ficción', 18, '1953-10-19', 'Un futuro en el que los libros son quemados y el conocimiento es censurado.'),
('978-1-4391-5972-2', 'Matar a un ruiseñor', 'Harper Lee', 'Ficción', 17, '1960-07-11', 'La lucha por la justicia en un pueblo sureño durante la Gran Depresión.'),
('978-0-06-112241-5', 'El túnel', 'Ernesto Sabato', 'Ficción', 15, '1948-01-01', 'Una novela psicológica que narra la obsesión de un hombre por una mujer.'),
('978-1-56619-909-4', 'El hombre en el castillo', 'Philip K. Dick', 'Ciencia ficción', 13, '1962-11-01', 'Una novela que explora una realidad alternativa donde las Potencias del Eje ganaron la Segunda Guerra Mundial.'),
('978-0-452-28423-4', 'Viento en las velas', 'Jose Luis Sampedro', 'Ficción', 10, '1989-10-12', 'Una novela sobre el paso del tiempo y la naturaleza humana.'),
('978-0-7432-7356-5', 'Veinte mil leguas de viaje submarino', 'Jules Verne', 'Ciencia ficción', 12, '1870-03-01', 'La aventura de un capitán y su tripulación a bordo de un submarino.'),
('978-1-5011-9071-4', 'El nombre del viento', 'Patrick Rothfuss', 'Fantasía', 10, '2007-03-27', 'Un joven cuenta la historia de su vida llena de magia y misterio.'),
('978-1-4391-5972-2', 'El señor de los anillos', 'J.R.R. Tolkien', 'Fantasía', 15, '1954-07-29', 'La épica lucha por destruir el anillo y salvar la Tierra Media.'),
('978-0-452-28423-4', 'El retrato de Dorian Gray', 'Oscar Wilde', 'Ficción', 16, '1890-06-01', 'Un hombre que cambia su vida por la eterna juventud, pero a un gran costo.'),
('978-0-7432-7356-5', 'Drácula', 'Bram Stoker', 'Misterio y suspense', 20, '1897-05-26', 'La historia de un vampiro que intenta conquistar Londres.'),
('978-0-452-28423-4', 'La llamada de Cthulhu', 'H.P. Lovecraft', 'Misterio y suspense', 14, '1928-02-01', 'Un relato sobre un culto oscuro y la aparición de una entidad cósmica.'),
('978-0-452-28423-4', 'El Hobbit', 'J.R.R. Tolkien', 'Fantasía', 11, '1937-09-21', 'Un pequeño hobbit se embarca en una aventura épica para recuperar un tesoro.'),
('978-0-7432-7356-5', 'La odisea', 'Homero', 'Literatura clásica', 10, '800-01-01', 'El regreso de Odiseo a su hogar después de la guerra de Troya.'),
('978-0-452-28423-4', 'Cuentos de la abuela Amelia', 'María Cristina Ramos', 'Cuentos y relatos cortos', 13, '2015-10-10', 'Cuentos tradicionales de la abuela Amelia narrados a sus nietos.'),
('978-0-7432-7356-5', 'El alquimista', 'Paulo Coelho', 'Ficción', 12, '1988-11-01', 'Una novela sobre la búsqueda del destino y la realización personal.'),
('978-1-4391-5972-2', 'Mujer que mira al hombre que mira al hombre', 'Margarita Rivas', 'Biografía y memorias', 10, '2010-12-15', 'La historia de una mujer que busca respuestas en su vida cotidiana.'),
('978-0-452-28423-4', 'El psicoanalista', 'John Katzenbach', 'Thriller', 15, '2002-02-01', 'Un thriller psicológico donde un psicoanalista se enfrenta a un enigma mortal.');


INSERT INTO usuarios (nickname, nombre, apellido, clave, nivelAcceso, rut) 
VALUES 
('user', '','','1', 1, '11111111-1'),
('asmith', 'Alice', 'Smith', 'alicePass', 1, '98765432-1'),
('bwayne', 'Bruce', 'Wayne', 'batman2024', 1, '11223344-5'),
('ckent', 'Clark', 'Kent', 'superman2024', 1, '22334455-6'),
('dprince', 'Diana', 'Prince', 'wonderwoman', 1, '33445566-7'),
('pparker', 'Peter', 'Parker', 'spiderman', 1, '44556677-8'),
('srogers', 'Steve', 'Rogers', 'captainamerica', 1, '66778899-0'),
('nromanoff', 'Natasha', 'Romanoff', 'blackwidow', 1, '77889900-1'),
('banner', 'Bruce', 'Banner', 'hulk2024', 1, '88990011-2'), 
('thor', 'Thor', 'Odinson', 'godofthunder', 1, '99001122-3'),
('loki', 'Loki', 'Laufeyson', 'trickster', 1, '10111213-4'),
('scarlet', 'Wanda', 'Maximoff', 'scarletwitch', 1, '11121314-5'),
('vision', 'Vision', 'Synthozoid', 'mindstone', 1, '12131415-6'),
('hawkeye', 'Clint', 'Barton', 'archer2024', 1, '13141516-7'),
('antman', 'Scott', 'Lang', 'antman2024', 1, '14151617-8'),
('wasp', 'Hope', 'van Dyne', 'wasp2024', 1, '15161718-9'),
('strange', 'Stephen', 'Strange', 'doctorstrange', 1, '16171819-0'),
('tstark', 'Tony', 'Stark', 'ironman2024', 2, '55667788-9'),
('captainmarvel', 'Carol', 'Danvers', 'marvel2024', 2, '18192021-2'),
('jdoe', 'John', 'Doe', 'password123', 2, '12345678-9'),
('admin', '','','1', 3, '11111111-1');

INSERT INTO salas (disponible, capacidad) 
VALUES 
(true, 25),
(true, 20),
(true, 15),
(true, 30),
(true, 10),
(true, 28),
(true, 18),
(true, 22),
(true, 27),
(true, 12);

INSERT INTO usuario_libro (usuario_id, libro_id)
VALUES
(1, 5),
(2, 10),
(3, 15),
(4, 20), 
(5, 25),
(6, 30),
(7, 35),
(8, 1),
(9, 3),
(10, 8),
(11, 13),
(12, 18),
(13, 23),
(14, 28),
(15, 33),
(16, 38),
(17, 2),
(17, 7),
(1, 12),
(2, 17);


