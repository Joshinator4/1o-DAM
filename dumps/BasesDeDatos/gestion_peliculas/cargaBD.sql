
-- Datos para tabla Peliculas
insert into peliculas values
(111,'El señor de los anillos: La comunidad del anillo','Frodo recibe el anillo de poder', '2001-12-19'),
(112,'El señor de los anillos: Las dos torres','Frodo pasa entre dos torres', '2002-12-18'),
(113,'El señor de los anillos: El retorno del rey','Frodo tira el anillo', '2003-12-17'),
(114,'Matrix','Neo descubre la verdad', '2003-12-04'),
(115,'Matrix Reloaded','Neo luchas contra las máquinas', '2005-12-05'),
(116,'Matrix Revollution','Neo acaba con las máquinas', '2006-12-04'),
(117,'Avenger civil war','Thanos va por las gemas y hace la purga', '2006-12-04'),
(118,'Avenger end game','Vuelven al pasado tras el multiverso para cambiar el presente', '2006-12-04');


-- Datos para tabla Plataformas
insert into plataformas values
('333','Netflix','https://images-na.ssl-images-amazon.com/images/I/51LGj5--KsL.png'),
('334','Movistar','https://www.tuexperto.com/wp-content/uploads/2018/09/80dd8ee71e2be472cf86ee124476966a.png'),
('335','Disney+','https://store-images.s-microsoft.com/image/apps.14187.14495311847124170.7646206e-bd82-4cf0-8b8c-d06a67bc302c.2e474878-acb7-4afb-a503-c2a1a32feaa8'),
('336','HBO max','https://yt3.googleusercontent.com/bjkwQJm7D-ynsH_4ySvk-sqM802R1RYuYDqTazAF-g3gupsidu981t-uA3FFzlkdkK5txkXsLjg=s900-c-k-c0x00ffffff-no-rj');

-- Datos para tabla Disponible_en 
insert into disponible_en values
(111, 333, '2018-01-12'),
(112, 333, '2018-02-13'),
(115, 333, '2018-03-14'),
(116, 333, '2018-04-15'),
(112, 334, '2020-05-02'),
(113, 334, '2020-06-02'),
(114, 334, '2020-07-02'),
(115, 334, '2021-08-02'),
(116, 334, '2021-09-02'),
(117, 335, '2022-01-10'),
(118, 335, '2022-05-02');