USE ecommerce;

IF NOT EXISTS(select prodid from Product where name like 'LOS PILARES DE LA TIERRA') 
begin
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'LOS PILARES DE LA TIERRA', 25, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);
end;

IF NOT EXISTS(select prodid from Product where name like 'UN MUNDO SIN FIN')  
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'UN MUNDO SIN FIN', 30, 100, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like 'THE JAVA PROGRAMMING LANGUAGE')  
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'THE JAVA PROGRAMMING LANGUAGE', 80, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like 'LA SOMBRA DEL VIENTO') 
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'LA SOMBRA DEL VIENTO', 20, 100, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like 'PINK - FUNHOUSE')  
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'PINK - FUNHOUSE', 20, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like 'JUEGO DE TRONOS') 
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'JUEGO DE TRONOS', 20, 100, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like  'FUEGO Y SANGRE') 
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'FUEGO Y SANGRE', 20, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like 'JURASSIC PARK')  
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'JURASSIC PARK', 20, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like'DEFINITELY, MAYBE')
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
( 'DEFINITELY, MAYBE', 18, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like 'DUMBO (2019)') 
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'DUMBO (2019)', 18, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);

IF NOT EXISTS(select prodid from Product where name like  'ÉRASE UNA VEZ... EN HOLLYWOOD')  
INSERT INTO PRODUCT (  NAME, PRICE, STOCK, CRTDATE, VERSION)
VALUES
(  'ÉRASE UNA VEZ... EN HOLLYWOOD', 18, 10, dateadd(month, -1 * (select  count(*) from Product ), getdate()), 0);