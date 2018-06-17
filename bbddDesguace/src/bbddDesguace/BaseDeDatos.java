/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbddDesguace;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adrián
 */
public class BaseDeDatos {

    /**
     *
     * @param args argumento pasado por linea de comandos o desde propiedades
     * @throws SQLException excepcion en SQL
     * @throws IOException excepcionIO
     */
    public static void main(String[] args) throws SQLException, IOException {
        try {
            //CREACION DE LA CONEXION , PARA PODER CONECTARSE A LA BASE DE DATOS
            Connection conexion = Conexion.conexionMySQL();
            Statement st = conexion.createStatement();
            //Creacion de la base de datos
            st.executeUpdate("DROP DATABASE IF EXISTS Desguaces");
            st.executeUpdate("CREATE DATABASE Desguaces");
            st.executeUpdate("USE Desguaces");
            //Creacion de las tablas
            String marca = "CREATE TABLE MARCA(\n"
                    + "P_Marca INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Nombre VARCHAR (50),\n"
                    + "Pais VARCHAR(50)\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(marca);
            System.out.println("Marca Creada");
            String modelo = "CREATE TABLE MODELO(\n"
                    + "P_Modelo INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Nombre VARCHAR(50),\n"
                    + "A_Marca INT(8),\n"
                    + "AnoSalida VARCHAR(4),\n"
                    + "AnoExtincion VARCHAR(12),\n"
                    + "FOREIGN KEY (A_Marca) \n"
                    + "REFERENCES MARCA (P_Marca) \n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(modelo);
            System.out.println("Modelo creado");
            String tipo = "CREATE TABLE TIPO(\n"
                    + "P_Tipo INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Nombre VARCHAR (50)"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(tipo);
            System.out.println("Tipo creado");
            String pieza = "CREATE TABLE PIEZA(\n"
                    + "P_Pieza INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Nombre VARCHAR (50),\n"
                    + "A_Tipo INT(8),"
                    + "FOREIGN KEY(A_Tipo)\n"
                    + "REFERENCES TIPO (P_Tipo)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(pieza);
            System.out.println("Pieza creada");
            String desguace = "CREATE TABLE DESGUACE(\n"
                    + "P_Desguace INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Nombre VARCHAR (50),\n"
                    + "Direccion VARCHAR(50),\n"
                    + "Contrasenia VARCHAR(50),\n"
                    + "Telefono VARCHAR(50),\n"
                    + "CIF VARCHAR(15)\n"
                    + ")ENGINE=InnoDB";

            st.executeUpdate(desguace);
            System.out.println("Desguace creado");
            String usuarios = "CREATE TABLE USUARIO(\n"
                    + "P_Usuario INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "A_Desguace INT(8),\n"
                    + "Nombre VARCHAR(50),\n"
                    + "Usuario VARCHAR(50) UNIQUE,\n"
                    + "Contrasena VARCHAR(50),\n"
                    + "Direccion VARCHAR(50),\n"
                    + "Telefono VARCHAR(9),\n"
                    + "CorreoElectronico VARCHAR(50),\n"
                    + "DNI VARCHAR(9),\n"
                    + "Apellidos VARCHAR(50)\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(usuarios);
            System.out.println("Usuarios creados");
            String cuenta = "CREATE TABLE CuentaBancaria(\n"
                    + "P_CB INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "A_Usuario INT(8),\n"
                    + "IBAN VARCHAR(34),\n"
                    + "FOREIGN KEY(A_Usuario)\n"
                    + "REFERENCES USUARIO (P_Usuario)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")Engine=InnoDB";
            st.executeUpdate(cuenta);
            System.out.println("Ya tenemos cuenta bancaria");
            String motor = "CREATE TABLE MOTOR("
                    + "P_Motor INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Codigo VARCHAR(20),\n"
                    + "Combustible VARCHAR(10)\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(motor);
            System.out.println("motor creado");
            String ModeloMotor = "CREATE TABLE ModeloMotor("
                    + "P_MM INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "A_Modelo INT(8),\n"
                    + "A_Motor INT(8),\n"
                    + "FOREIGN KEY(A_Modelo)\n"
                    + "REFERENCES MODELO (P_Modelo)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE,\n"
                    + "FOREIGN KEY(A_Motor)\n"
                    + "REFERENCES MOTOR (P_Motor)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(ModeloMotor);
            System.out.println("MM creado");
            String recambio = "CREATE TABLE RECAMBIO(\n"
                    + "P_Recambio INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "A_Motor INT(8),\n"
                    + "A_Pieza INT(8),\n"
                    + "A_Desguace INT(8),\n"
                    + "CantidadDisponible INT(2),\n"
                    + "Precio double(5,2),\n"
                    + "FOREIGN KEY(A_Motor)\n"
                    + "REFERENCES MOTOR (P_Motor)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE,\n"
                    + "FOREIGN KEY(A_Pieza)\n"
                    + "REFERENCES PIEZA (P_Pieza)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE,\n"
                    + "FOREIGN KEY(A_Desguace)\n"
                    + "REFERENCES DESGUACE (P_Desguace)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(recambio);
            System.out.println("Recambio creado");
            String carrito = "CREATE TABLE CARRITO("
                    + "P_Carrito INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "A_Usuario INT(8),\n"
                    + "FOREIGN KEY(A_Usuario)\n"
                    + "REFERENCES Usuario (P_Usuario)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(carrito);
            System.out.println("Carrito creado");
            String carre = "CREATE TABLE CAR_RE("
                    + "P_Carre INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "A_Carrito INT(8),\n"
                    + "A_Recambio INT(8),\n"
                    + "Cantidad INT(2),\n"
                    + "FOREIGN KEY(A_Recambio)\n"
                    + "REFERENCES RECAMBIO (P_Recambio)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE,\n"
                    + "FOREIGN KEY(A_Carrito)\n"
                    + "REFERENCES CARRITO (P_CARRITO)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(carre);
            System.out.println("Carre creado");
            String factura = "CREATE TABLE FACTURA("
                    + "P_Factura INT(8) PRIMARY KEY AUTO_INCREMENT,\n"
                    + "Fecha VARCHAR(10),\n"
                    + "A_Carrito INT(8),"
                    + "A_Desguace INT(8),\n"
                    + "FOREIGN KEY(A_Carrito)\n"
                    + "REFERENCES CARRITO (P_Carrito)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE,\n"
                    + "FOREIGN KEY(A_Desguace)\n"
                    + "REFERENCES DESGUACE (P_DESGUACE)\n"
                    + "ON DELETE CASCADE \n"
                    + "ON UPDATE CASCADE\n"
                    + ")ENGINE=InnoDB";
            st.executeUpdate(factura);
            System.out.println("Factura creado");
            /*SELECT
     car_re.`Cantidad` AS car_re_Cantidad,
     factura.`Fecha` AS factura_Fecha,
     usuario.`Nombre` AS usuario_Nombre,
     usuario.`Direccion` AS usuario_Direccion,
     usuario.`CorreoElectronico` AS usuario_CorreoElectronico,
     usuario.`Apellidos` AS usuario_Apellidos,
     recambio.`Precio` AS recambio_Precio,
     pieza.`Nombre` AS pieza_Nombre,
     modelo.`Nombre` AS modelo_Nombre,
     marca.`Nombre` AS marca_Nombre
FROM
     `carrito` carrito INNER JOIN `car_re` car_re ON carrito.`P_Carrito` = car_re.`A_Carrito`
     INNER JOIN `factura` factura ON car_re.`P_Carre` = factura.`A_Carre`
     INNER JOIN `recambio` recambio ON car_re.`A_Recambio` = recambio.`P_Recambio`
     INNER JOIN `pieza` pieza ON recambio.`A_Pieza` = pieza.`P_Pieza`
     INNER JOIN `motor` motor ON recambio.`A_Motor` = motor.`P_Motor`
     INNER JOIN `modelomotor` modelomotor ON motor.`P_Motor` = modelomotor.`A_Motor`
     INNER JOIN `modelo` modelo ON modelomotor.`A_Modelo` = modelo.`P_Modelo`
     INNER JOIN `marca` marca ON modelo.`A_Marca` = marca.`P_Marca`
     INNER JOIN `usuario` usuario ON carrito.`A_Usuario` = usuario.`P_Usuario`*/

 /*Introduccion de datos*/
            //Marcas
            introducir("MARCA", "1,'Audi','Alemania'");
            introducir("MARCA", "2,'Mercedes','Alemania'");
            introducir("MARCA", "3,'BMW','Alemania'");
            introducir("MARCA", "4,'Citroen','Francia'");
            introducir("MARCA", "5,'Fiat','Italia'");
            introducir("MARCA", "6,'Ford','Estados Unidos'");
            introducir("MARCA", "7,'Nissan','Japon'");
            introducir("MARCA", "8,'Opel','Alemania'");
            introducir("MARCA", "9,'Peugeot','Francia'");
            introducir("MARCA", "10,'Renault','Francia'");
            introducir("MARCA", "11,'Seat','España'");
            introducir("MARCA", "12,'Volkswagen','Alemania'");
            introducir("MARCA", "13,'Honda','Japon'");
            /*Modelos*/
            //Audi
            introducir("MODELO", "null,'A1',1,'2010','Actualmente'");
            introducir("MODELO", "null,'A2',1,'2000','2005'");
            introducir("MODELO", "null,'A3 I',1,'1996','2003'");
            introducir("MODELO", "null,'A3 II',1,'2003','2012'");
            introducir("MODELO", "null,'A3 III',1,'2012','Actualmente'");
            introducir("MODELO", "null,'A4 I',1,'1994','2000'");
            introducir("MODELO", "null,'A4 II',1,'2000','2004'");
            introducir("MODELO", "null,'A4 III',1,'2000','2004'");
            introducir("MODELO", "null,'A4 IV',1,'2004','2008'");
            introducir("MODELO", "null,'A4 V',1,'2008','2015'");
            introducir("MODELO", "null,'A4 VI',1,'2015','Actualmente'");
            introducir("MODELO", "null,'A5',1,'2007','Actualmente'");
            introducir("MODELO", "null,'A6 I',1,'1994','1997'");
            introducir("MODELO", "null,'A6 II',1,'1997','2005'");
            introducir("MODELO", "null,'A6 III',1,'2005','2011'");
            introducir("MODELO", "null,'A6 IV',1,'2011','Actualmente'");
            introducir("MODELO", "null,'A7',1,'2010','Actualmente'");
            //Mercedes
            introducir("MODELO", "null,'190E',2,1982,1993");
            introducir("MODELO", "null,'Clase A I',2,'1997','2004'");
            introducir("MODELO", "null,'Clase A II',2,'2004','2012'");
            introducir("MODELO", "null,'Clase A III',2,'2012','Actualmente'");
            introducir("MODELO", "null,'Clase B I',2,'2005','2011'");
            introducir("MODELO", "null,'Clase B II',2,'2011','Actualmente'");
            introducir("MODELO", "null,'Clase C I',2,'1993','2000'");
            introducir("MODELO", "null,'Clase C III',2,'2000','2007'");
            introducir("MODELO", "null,'Clase C IV',2,'2007','2014'");
            introducir("MODELO", "null,'Clase C V',2,'2014','Actualmente'");
            introducir("MODELO", "null,'Clase E I',2,'1993','1995'");
            introducir("MODELO", "null,'Clase E II',2,'1995','2003'");
            introducir("MODELO", "null,'Clase E III',2,'2002','2009'");
            introducir("MODELO", "null,'Clase E IV',2,'2009','Actualmete'");
            introducir("MODELO", "null,'Clase G I',2,'1979','1993'");
            introducir("MODELO", "null,'Clase G II',2,'1993','Actualmente'");
            introducir("MODELO", "null,'Clase M I',2,'1998','2005'");
            introducir("MODELO", "null,'Clase M II',2,'2005','2011'");
            introducir("MODELO", "null,'Clase M III',2,'2011','Actualmente'");
            introducir("MODELO", "null,'Clase E I',2,'1996','2003'");
            introducir("MODELO", "null,'Clase E II',2,'2003','Actualmente'");
            //BMW
            introducir("MODELO", "null,'Serie 1 I',3,'2004','2012'");
            introducir("MODELO", "null,'Serie 1 II',3,'2010','Actualmente'");
            introducir("MODELO", "null,'Serie 2(2002)',3,'1966','1977'");
            introducir("MODELO", "null,'Serie 2 Coupe',3,'2012','Actualmente'");
            introducir("MODELO", "null,'Serie 3(E21)',3,'1975','1984'");
            introducir("MODELO", "null,'Serie 3(E30)',3,'1982','1992'");
            introducir("MODELO", "null,'Serie 3(E36)',3,'1990','1998'");
            introducir("MODELO", "null,'Serie 3(E46)',3,'1998','2005'");
            introducir("MODELO", "null,'Serie 3(E90/E92)',3,'2005','2011'");
            introducir("MODELO", "null,'Serie 3(F30/F80)',3,'2011','Actualmente'");
            introducir("MODELO", "null,'Serie 4',3,'2012','Actualmente'");
            introducir("MODELO", "null,'Serie 5(E12)',3,'1972','1981'");
            introducir("MODELO", "null,'Serie 5(E28)',3,'1980','1987'");
            introducir("MODELO", "null,'Serie 5(E34)',3,'1987','1995'");
            introducir("MODELO", "null,'Serie 5(E39)',3,'1995','2003'");
            introducir("MODELO", "null,'Serie 5(E60)',3,'2003','2010'");
            introducir("MODELO", "null,'Serie 5(F10)',3,'2009','Actualmente'");
            introducir("MODELO", "null,'Serie 6(E24)',3,'1976','1990'");
            introducir("MODELO", "null,'Serie 6(E63)',3,'2004','2010'");
            introducir("MODELO", "null,'Serie 6(F13)',3,'2010','Actualmente'");
            //Citroen
            introducir("MODELO", "null,'C1',4,'2004','2014'");
            introducir("MODELO", "null,'C1 II',4,'2014','Actualmente'");
            introducir("MODELO", "null,'C2',4,'2003','2009'");
            introducir("MODELO", "null,'C3',4,'2002','Actualmente'");
            introducir("MODELO", "null,'C3 II',4,'2009','Actualmente'");
            introducir("MODELO", "null,'C3 III',4,'2017','Actualmente'");
            introducir("MODELO", "null,'C4',4,'2004','2011'");
            introducir("MODELO", "null,'C4 II',4,'2009','Hoy'");
            introducir("MODELO", "null,'C5',4,'2001','2004'");
            introducir("MODELO", "null,'C5 II',4,'2004','Actualmente'");
            introducir("MODELO", "null,'C5 III',4,'2008','Actualmente'");
            introducir("MODELO", "null,'C6',4,'2005','Actualmente'");
            introducir("MODELO", "null,'C8',4,'2002','Actualmente'");
            introducir("MODELO", "null,'DS3',4,'2009','2015'");
            introducir("MODELO", "null,'DS4',4,'2011','2015'");
            introducir("MODELO", "null,'DS5',4,'2011','2015'");
            //Fiat
            introducir("MODELO", "null,'Punto I',5,'1993','1999'");
            introducir("MODELO", "null,'Punto II',5,'1999','2012'");
            introducir("MODELO", "null,'Punto III',5,'2012','Actualmente'");
            introducir("MODELO", "null,'500',5,'2007','Actualmente'");
            introducir("MODELO", "null,'Panda I',5,'1980','2004'");
            introducir("MODELO", "null,'Panda II',5,'2003','Actualmente'");
            introducir("MODELO", "null,'Panda III',5,'2012','Actualmente'");
            //Ford
            introducir("MODELO", "null,'Focus MK',6,'1998','2007'");
            introducir("MODELO", "null,'Focus MK2',6,'2007','2012'");
            introducir("MODELO", "null,'Focus MK3',6,'2010','Actualmente'");

            introducir("MODELO", "null,'Fiesta I',6,'1976','1983'");
            introducir("MODELO", "null,'Fiesta II',6,'1983','1989'");
            introducir("MODELO", "null,'Fiesta III',6,'1989','1997'");
            introducir("MODELO", "null,'Fiesta IV',6,'1995','2002'");
            introducir("MODELO", "null,'Fiesta V',6,'2002','Actualmente'");
            introducir("MODELO", "null,'Fiesta VI',6,'2008','Actualmente'");

            introducir("MODELO", "null,'Escort I',6,'1968','1976'");
            introducir("MODELO", "null,'Escort II',6,'1973','1981'");
            introducir("MODELO", "null,'Escort III',6,'1980','1986'");
            introducir("MODELO", "null,'Escort IV',6,'1985','1990'");
            introducir("MODELO", "null,'Escort V',6,'1990','1992'");
            introducir("MODELO", "null,'Escort VI',6,'1992','1996'");
            introducir("MODELO", "null,'Escort VII',6,'1995','2002'");

            introducir("MODELO", "null,'Sierra',6,'1987','1993'");

            introducir("MODELO", "null,'Mondeo I',6,'1993','1996'");
            introducir("MODELO", "null,'Mondeo II',6,'1996','2000'");
            introducir("MODELO", "null,'Mondeo III',6,'2000','2007'");
            introducir("MODELO", "null,'Mondeo IV',6,'2007','Actualmente'");
            //Nissan
            introducir("MODELO", "null,'Datsun 240 ',7,'1978','1981'");
            introducir("MODELO", "null,'280Z',7,'1978','1984'");
            introducir("MODELO", "null,'350Z',7,'2002','Actualmente'");
            introducir("MODELO", "null,'370Z',7,'2009','Actualmente'");
            introducir("MODELO", "null,'GT-R',7,'2007','Actualmente'");
            introducir("MODELO", "null,'Almera',7,'1995','2000'");
            introducir("MODELO", "null,'Mondeo',7,'2000','Actualmente'");

            introducir("MODELO", "null,'Patrol I',7,'1979','1989'");
            introducir("MODELO", "null,'Patrol II',7,'1994','1998'");
            introducir("MODELO", "null,'Patrol III',7,'1998','Actualmente'");

            introducir("MODELO", "null,'Primera I',7,'1990','1996'");
            introducir("MODELO", "null,'Primera II',7,'1996','2002'");
            introducir("MODELO", "null,'Primera III',7,'2002','Actualmente'");

            introducir("MODELO", "null,'Skyline R32',7,'1989','1994'");
            introducir("MODELO", "null,'Skyline R33',7,'1993','1998'");
            introducir("MODELO", "null,'Skyline R34',7,'1998','2002'");

            introducir("MODELO", "null,'Silvia S12',7,'1984','1988'");
            introducir("MODELO", "null,'Silvia S13/240sx/200sx',7,'1988','1993'");
            introducir("MODELO", "null,'Silvia S14',7,'1993','1999'");
            introducir("MODELO", "null,'Silvia S15',7,'1999','1992'");
            //Opel
            introducir("MODELO", "null,'Astra F',8,'1991','1998'");
            introducir("MODELO", "null,'Astra G',8,'1998','2009'");
            introducir("MODELO", "null,'Astra H',8,'2004','Actualmente'");

            introducir("MODELO", "null,'Corsa I',8,'1982','1993'");
            introducir("MODELO", "null,'Corsa II',8,'1993','2002'");
            introducir("MODELO", "null,'Corsa III',8,'2000','2009'");
            introducir("MODELO", "null,'Corsa IV',8,'2006','Actualmente'");
            introducir("MODELO", "null,'Corsa V',8,'2014','Actualmente'");
            //Peugeot
            introducir("MODELO", "null,'106 I',9,'1991','1996'");
            introducir("MODELO", "null,'106 II',9,'1988','2003'");

            introducir("MODELO", "null,'205',9,'1983','1987'");

            introducir("MODELO", "null,'206',9,'1998','2013'");
            introducir("MODELO", "null,'206+',9,'2009','2013'");

            introducir("MODELO", "null,'208',9,'2012','Actualmente'");
            introducir("MODELO", "null,'305',9,'1982','1990'");
            introducir("MODELO", "null,'405',9,'1987','1993'");
            introducir("MODELO", "null,'405',9,'1992','1999'");

            introducir("MODELO", "null,'306',9,'1993','2001'");
            introducir("MODELO", "null,'307',9,'2002','Actualmente'");
            introducir("MODELO", "null,'308',9,'2007','Actualmente'");
            introducir("MODELO", "null,'308',9,'2013','Actualmente'");
            //Renault
            introducir("MODELO", "null,'Clio I',10,'1990','1998'");
            introducir("MODELO", "null,'Clio II',10,'1998','2005'");
            introducir("MODELO", "null,'Clio III',10,'2005','2012'");
            introducir("MODELO", "null,'Clio IV',10,'2012','Actualmente'");

            introducir("MODELO", "null,'Megane I',10,'1995','2004'");
            introducir("MODELO", "null,'Megane II',10,'2002','2011'");
            introducir("MODELO", "null,'Megane III',10,'2009','2013'");
            introducir("MODELO", "null,'Megane IV',10,'2015','Actualmente'");

            introducir("MODELO", "null,'Laguna I',10,'1993','2002'");
            introducir("MODELO", "null,'Laguna II',10,'2001','Actualmente'");
            introducir("MODELO", "null,'Laguna III',10,'2007','Actualmente'");

            introducir("MODELO", "null,'Modus',10,'2004','Actualmente'");

            introducir("MODELO", "null,'Megane Scenic',10,'1996','2001'");
            introducir("MODELO", "null,'Scenic I',10,'1999','2003'");
            introducir("MODELO", "null,'Scenic II',10,'2003','Actualmente'");
            introducir("MODELO", "null,'Scenic III',10,'2009','Actualmente'");
            //Seat
            introducir("MODELO", "null,'Cordoba I',11,'1993','1999'");
            introducir("MODELO", "null,'Cordoba II',11,'1999','2002'");
            introducir("MODELO", "null,'Cordoba III',11,'2002','2009'");

            introducir("MODELO", "null,'Ibiza I',11,'1984','1993'");
            introducir("MODELO", "null,'Ibiza II',11,'1993','1999'");
            introducir("MODELO", "null,'Ibiza III',11,'1999','2002'");
            introducir("MODELO", "null,'Ibiza IV',11,'2002','2009'");
            introducir("MODELO", "null,'Ibiza V',11,'2008','Actualmente'");

            introducir("MODELO", "null,'Leon I',11,'1999','2006'");
            introducir("MODELO", "null,'Leon II',11,'2005','2012'");
            introducir("MODELO", "null,'Leon III',11,'2012','Actualmente'");

            introducir("MODELO", "null,'Marbella',11,'1986','1998'");
            //Volkswagen
            introducir("MODELO", "null,'Golf MKI',12,'1974','1984'");
            introducir("MODELO", "null,'Golf MKII',12,'1983','1992'");
            introducir("MODELO", "null,'Golf MKIII',12,'1991','1997'");
            introducir("MODELO", "null,'Golf MKIV',12,'1997','2003'");
            introducir("MODELO", "null,'Golf MKV',12,'2003','2008'");
            introducir("MODELO", "null,'Golf MKVI',12,'2008','2012'");
            introducir("MODELO", "null,'Golf MKVII',12,'2012','Actualmente'");

            introducir("MODELO", "null,'Corrado',12,'1987','1995'");

            introducir("MODELO", "null,'Scirocco I',12,'1974','1980'");
            introducir("MODELO", "null,'Scirocco II',12,'1980','1992'");
            introducir("MODELO", "null,'Scirocco III',12,'2008','Actualmente'");

            introducir("MODELO", "null,'Passat B3',12,'1988','1993'");
            introducir("MODELO", "null,'Passat B4',12,'1993','1997'");
            introducir("MODELO", "null,'Passat B5',12,'1997','2005'");
            introducir("MODELO", "null,'Passat B6',12,'2005','2010'");
            introducir("MODELO", "null,'Passat B7',12,'2010','2014'");
            introducir("MODELO", "null,'Passat B8',12,'2014','Actualmente'");

            introducir("MODELO", "null,'Polo I',12,'1975','1981'");
            introducir("MODELO", "null,'Polo II',12,'1981','1994'");
            introducir("MODELO", "null,'Polo III',12,'1994','2002'");
            introducir("MODELO", "null,'Polo IV',12,'2002','2010'");
            introducir("MODELO", "null,'Polo V',12,'2009','Actualmente'");
            introducir("MODELO", "null,'Polo VI',12,'2017','Actualmente'");
            //Honda
            introducir("MODELO", "null,'Accord I',13,'1976','1981'");
            introducir("MODELO", "null,'Accord II',13,'1982','1985'");
            introducir("MODELO", "null,'Accord III',13,'1986','1989'");
            introducir("MODELO", "null,'Accord IV',13,'1990','1993'");
            introducir("MODELO", "null,'Accord V',13,'1994','1997'");
            introducir("MODELO", "null,'Accord VI',13,'1998','2002'");
            introducir("MODELO", "null,'Accord VII',13,'2003','2007'");
            introducir("MODELO", "null,'Accord VIII',13,'2013','Actualmente'");

            introducir("MODELO", "null,'Civic SB',13,'1973','1979'");
            introducir("MODELO", "null,'Civic SL',13,'1980','1983'");
            introducir("MODELO", "null,'Civic AH',13,'1984','1987'");
            introducir("MODELO", "null,'Civic EC',13,'1988','1991'");
            introducir("MODELO", "null,'Civic EG',13,'1992','1995'");
            introducir("MODELO", "null,'Civic EK',13,'1996','2000'");
            introducir("MODELO", "null,'Civic EP',13,'2000','2005'");
            introducir("MODELO", "null,'Civic FK',13,'2006','2011'");
            introducir("MODELO", "null,'Civic FB',13,'2012','2015'");
            introducir("MODELO", "null,'Civic X',13,'2016','Actualmente'");

            introducir("MODELO", "null,'S2000',13,'1999','Actualmente'");
            /*Tipo*/
            introducir("TIPO", "null,'Frenado'");
            introducir("TIPO", "null,'Filtracion'");
            introducir("TIPO", "null,'Suspension-Direccion'");
            introducir("TIPO", "null,'Embrague-Caja-Trasmision'");
            introducir("TIPO", "null,'Compartimento Motor'");
            introducir("TIPO", "null,'Equipamentos Exteriores'");
            introducir("TIPO", "null,'Escape'");
            introducir("TIPO", "null,'Electricidad'");
            introducir("TIPO", "null,'Refrigeracion Motor'");
            introducir("TIPO", "null,'Calefaccion-Climatizacion-Aire Acondicionado'");
            introducir("TIPO", "null,'Cerraduras-Cierres'");
            /*Pieza*/
            introducir("PIEZA", "null,'Pinza de Freno',1");
            introducir("PIEZA", "null,'Frenos de Disco',1");
            introducir("PIEZA", "null,'Frenos de Tambor(Kit)',1");
            introducir("PIEZA", "null,'Tubos/Latiguillos',1");
            introducir("PIEZA", "null,'Anillo sensor ABS',1");
            introducir("PIEZA", "null,'Liquido de Frenos',1");
            introducir("PIEZA", "null,'Cable de accionamiento(Freno de estacionamiento)',1");
            introducir("PIEZA", "null,'Regulador de fuerza de Frenado',1");
            introducir("PIEZA", "null,'Servofreno',1");
            introducir("PIEZA", "null,'Sensor ABS',1");
            introducir("PIEZA", "null,'Interruptor Luces de ferno',1");
            introducir("PIEZA", "null,'Zapatas de Freno',1");

            introducir("PIEZA", "null,'Filtro de aceite',2");
            introducir("PIEZA", "null,'Filtro de aire',2");
            introducir("PIEZA", "null,'Filtro de combustible',2");
            introducir("PIEZA", "null,'Filtro de aire del habitaculo',2");
            introducir("PIEZA", "null,'Filtro de aceite',2");
            introducir("PIEZA", "null,'Tapon de cambio de aceite',2");
            introducir("PIEZA", "null,'Tapón roscado de vaciado de aceite',2");

            introducir("PIEZA", "null,'Amortiguadores Delanteros',3");
            introducir("PIEZA", "null,'Amortiguadores Traseros',3");
            introducir("PIEZA", "null,'Muelle de chasis',3");
            introducir("PIEZA", "null,'Cojinete columna suspension',3");
            introducir("PIEZA", "null,'Kit de proteccion guardapolvos',3");
            introducir("PIEZA", "null,'Rodamiento soporte amortiguador',3");
            introducir("PIEZA", "null,'Cojinete de Rueda',3");
            introducir("PIEZA", "null,'Cubo de Rueda',3");
            introducir("PIEZA", "null,'Anillo Reten, Ciegüeñal',3");
            introducir("PIEZA", "null,'Perno de Rueda',3");
            introducir("PIEZA", "null,'Llanta de acero',3");
            introducir("PIEZA", "null,'Rotula barra de acoplamiento',3");
            introducir("PIEZA", "null,'Barra de acoplamiento',3");
            introducir("PIEZA", "null,'Articulacion axial(Barra de acoplamiento)',3");
            introducir("PIEZA", "null,'Bomba Hidarulica(Direccion)',3");
            introducir("PIEZA", "null,'Engranaje de direccion',3");
            introducir("PIEZA", "null,'Fuelle de direccion',3");
            introducir("PIEZA", "null,'Juego de fuelles de direccion',3");
            introducir("PIEZA", "null,'Fuelle de direccion(con accesorios)',3");
            introducir("PIEZA", "null,'Barra Oscilante',3");
            introducir("PIEZA", "null,'Rotula de suspension',3");
            introducir("PIEZA", "null,'Travesaños/barras-estabilizador',3");
            introducir("PIEZA", "null,'Suspension, Brazo Oscilante',3");
            introducir("PIEZA", "null,'Casquillo del cojinete',3");
            introducir("PIEZA", "null,'Suspension, cuerpo del eje',3");

            introducir("PIEZA", "null,'Kit de embrague',4");
            introducir("PIEZA", "null,'Cojinete de desembrague',4");
            introducir("PIEZA", "null,'Cable de accionamiento del embrague',4");
            introducir("PIEZA", "null,'Casquillo guia, embrague',4");
            introducir("PIEZA", "null,'Arbol de trasmision',4");
            introducir("PIEZA", "null,'Fuelle del arbol de transmision',4");
            introducir("PIEZA", "null,'Suspension, arbol de transmision',4");
            introducir("PIEZA", "null,'Fuelle de cardan',4");
            introducir("PIEZA", "null,'Juego de articulacion(arbol)',4");
            introducir("PIEZA", "null,'Anillo reten, brida caja',4");
            introducir("PIEZA", "null,'Juego reapacion palanca de cambios',4");
            introducir("PIEZA", "null,'Suspension caja de cambios',4");
            introducir("PIEZA", "null,'Sensor revolcuion de caja automatica',4");

            introducir("PIEZA", "null,'Bujia de encendido',5");
            introducir("PIEZA", "null,'Bobina de encendido(Pipa)',5");
            introducir("PIEZA", "null,'Correa dentada(distribucion)',5");
            introducir("PIEZA", "null,'Correa del alternador',5");
            introducir("PIEZA", "null,'Kit distribucion',5");
            introducir("PIEZA", "null,'Kit distribucion + Bomba',5");
            introducir("PIEZA", "null,'Polea del cigüeñal',5");
            introducir("PIEZA", "null,'Bomba de combustible',5");
            introducir("PIEZA", "null,'Suministro de aire',5");
            introducir("PIEZA", "null,'Regulador de la presion del combustible',5");
            introducir("PIEZA", "null,'Inyector',5");

            introducir("PIEZA", "null,'Escobillla del Limpiaparabrisas',6");
            introducir("PIEZA", "null,'Bomba de agua de lavado',6");
            introducir("PIEZA", "null,'Motor del limpiaparabrisas',6");
            introducir("PIEZA", "null,'Faro Principal',6");
            introducir("PIEZA", "null,'Faro antiniebla',6");
            introducir("PIEZA", "null,'Piloto posterior',6");
            introducir("PIEZA", "null,'Piloto intermitente',6");
            introducir("PIEZA", "null,'Elemento regulacion de faros',6");
            introducir("PIEZA", "null,'Faro freno',6");
            introducir("PIEZA", "null,'Enganche remolque',6");
            introducir("PIEZA", "null,'Retrovisor interior',6");
            introducir("PIEZA", "null,'Cristla retrovisor exterior',6");
            introducir("PIEZA", "null,'Cubierta retrovisor exterior',6");

            introducir("PIEZA", "null,'Soporte del escape',7");
            introducir("PIEZA", "null,'Silencioso posterior',7");
            introducir("PIEZA", "null,'Silencioso del medio',7");
            introducir("PIEZA", "null,'Cinta de foma de escape',7");
            introducir("PIEZA", "null,'Catalizador',7");
            introducir("PIEZA", "null,'Sonda Lmabda',7");
            introducir("PIEZA", "null,'Colector de escape',7");

            introducir("PIEZA", "null,'Alternador',8");
            introducir("PIEZA", "null,'Motor de arranque(Puesta en marcha)',8");
            introducir("PIEZA", "null,'Polea del alternador',8");
            introducir("PIEZA", "null,'Reagulador del alternador',8");
            introducir("PIEZA", "null,'Bocina',8");
            introducir("PIEZA", "null,'Tornillo corrector de inclinacion',8");
            introducir("PIEZA", "null,'Bateria de arranque',8");
            introducir("PIEZA", "null,'Cables de arranque',8");
            introducir("PIEZA", "null,'Interruptor de marcha atras',8");
            introducir("PIEZA", "null,'Interruptor de luz principal',8");
            introducir("PIEZA", "null,'Conmutador en la columna de direccion',8");

            introducir("PIEZA", "null,'Bomba de agua',9");
            introducir("PIEZA", "null,'Tapon de refirgerante',9");
            introducir("PIEZA", "null,'Deposito de compensacion refrigerante',9");
            introducir("PIEZA", "null,'Radiador de refrigeracion',9");
            introducir("PIEZA", "null,'Tubería de radiador',9");
            introducir("PIEZA", "null,'Ventilador de refrigeracion',9");
            introducir("PIEZA", "null,'Motor electrico, ventilador del radiador',9");
            introducir("PIEZA", "null,'Interruptor de temperatura',9");
            introducir("PIEZA", "null,'Termostato',9");
            introducir("PIEZA", "null,'Sensor temperatura refrigerante',9");
            introducir("PIEZA", "null,'Junta termostato',9");

            introducir("PIEZA", "null,'Radiador de calefaccion',10");
            introducir("PIEZA", "null,'Ventialdor habitaculo',10");
            introducir("PIEZA", "null,'Compresor Aire acondicionado',10");
            introducir("PIEZA", "null,'Condensador aire acondicionado',10");
            introducir("PIEZA", "null,'Valvula de expasion aire acondicionado',10");
            introducir("PIEZA", "null,'Filtro deshidratante de aire acondicionado',10");
            introducir("PIEZA", "null,'Evaporador aire acondicionado',10");
            introducir("PIEZA", "null,'Presostato aire acondicionado',10");
            introducir("PIEZA", "null,'Valvula mezcladora',10");
            introducir("PIEZA", "null,'Conducto refrigerante',10");
            introducir("PIEZA", "null,'Elemento control aire acondicionado',10");

            introducir("PIEZA", "null,'Tapa deposito de combustible',11");
            introducir("PIEZA", "null,'Carcasa de llave',11");
            introducir("PIEZA", "null,'Pila lithium',11");
            introducir("PIEZA", "null,'Juegpo de cilindros de cierre',11");
            introducir("PIEZA", "null,'Cerradura de puerta',11");
            introducir("PIEZA", "null,'Cerradura de la puerta de maletero',11");
            introducir("PIEZA", "null,'Cilindro de cierre, cerradura de encendido',11");
            introducir("PIEZA", "null,'Elevalunas delantero',11");
            introducir("PIEZA", "null,'Manecilla de apertura',11");
            introducir("PIEZA", "null,'Muelle nuematico del maletero',11");
            //Esto de a continuacion ser ira creando con el uso , solo son ejemplos actualmente
            /*Desguaces*/
            introducir("DESGUACE", "null,'','','','',''");
            introducir("DESGUACE", "null,'Desguace Becerril','Calle Inventada 7','1','942558789','123456789C'");
            /*Usuarios*/
            introducir("USUARIO", "null,null, 'Adrian' , 'adr1997' , '1234','San camilo 8','666123456','adrian@gmail.com','74859613A','Iriondo Gonzalez' ");
            introducir("USUARIO", "null,2, 'Rigoberto' , 'r' , '1','SanTiburcio 16','942568794','rigoberto@gmail.com','45698712K' ,'Di Sousa'");
            /*Cuenta bancaria*/
            introducir("CuentaBancaria", "null,1,'ES12 1234 1324 1234 2015'");
            introducir("CuentaBancaria", "null,2,'ES15 1234 1324 1234 2016'");
            /*
                            introducir("MARCA", "1,'Audi','Alemania'");
            introducir("MARCA", "2,'Mercedes','Alemania'");
            introducir("MARCA", "3,'BMW','Alemania'");
            introducir("MARCA", "4,'Citroen','Francia'");
            introducir("MARCA", "5,'Fiat','Italia'");
            introducir("MARCA", "6,'Ford','Estados Unidos'");
            introducir("MARCA", "7,'Nissan','Japon'");
            introducir("MARCA", "8,'Opel','Alemania'");
            introducir("MARCA", "9,'Peugeot','Francia'");
            introducir("MARCA", "10,'Renault','Francia'");
            introducir("MARCA", "11,'Seat','España'");
            introducir("MARCA", "12,'Volkswagen','Alemania'");
            introducir("MARCA", "13,'Honda','Japon'");
             */
            //Motores
            introducir("Motor", "null , '2JC','Gasolina'");//Audi
            introducir("Motor", "null , 'AMG','Gasolina'");//Mercedes
            introducir("Motor", "null , '326S4','Gasolina'");//BMW
            introducir("Motor", "null , '4KC','Gasolina'");//Citroen
            introducir("Motor", "null , '188A2000 ','Gasolina'");//Fiat
            introducir("Motor", "null , 'C307','Gasolina'");//Ford
            introducir("Motor", "null , 'GA-4','Gasolina'"); //Nissan
            introducir("Motor", "null , '17D','Gasolina'");//Opel
            introducir("Motor", "null , 'DV4TD','Gasolina'");//Peugeot
            introducir("Motor", "null , '2E1','Gasolina'");//Renault
            introducir("Motor", "null , 'AXX','Gasolina'");//Volkswagen & Seat
            introducir("Motor", "null , 'EK9','Gasolina'");//Honda
            //
            introducirMM();
            //Carritos
            System.out.println("Recambios");
            introducirRecambios();
            introducir("Carrito", "null, 1");
            introducir("Car_re", "null , 1 ,1 ,5");
            introducir("Factura", "null ,'20/05/2018',1,2");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void introducir(String tabla, String sentencias) throws SQLException {
        //METODO POR EL CUAL SE INTRODUCEN LOS DATOS DENTRO DE UNA BASE DE DATOS DETERMINADA
        Connection conexion = Conexion.conexionMySQL();
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate("USE Desguaces");
        String insertinto = "INSERT INTO " + tabla + " VALUES(" + sentencias + ");";
        System.out.println(insertinto);
        sentencia.executeUpdate(insertinto);
        sentencia.close();
        conexion.close();
    }

    public static void introducirRecambios() throws SQLException {
        Connection conexion = Conexion.conexionMySQL();
        Statement sentencia = conexion.createStatement();
        // introducir("Recambio", "null, 1,1,2,19,50");
        sentencia.executeUpdate("USE Desguaces");
        int numMotor = 0;
        int numPieza = 0;

        String consultaModelos = "SELECT  m.P_Motor "
                + "FROM motor m";

        ResultSet rs = sentencia.executeQuery(consultaModelos);
        while (rs.next()) {
            numMotor++;
        }
        int motores[] = new int[numMotor];

        int i = 0;
        ResultSet rs2 = sentencia.executeQuery(consultaModelos);
        while (rs2.next()) {
            motores[i] = rs2.getInt(1);
            i++;
        }

        i = 0;
        String consultaPieza = "SELECT  p.P_Pieza "
                + "FROM pieza p";
        ResultSet rs3 = sentencia.executeQuery(consultaPieza);
        while (rs3.next()) {
            numPieza++;
        }
        System.out.println("Numero de peizas: " + numPieza);
        int piezas[] = new int[numPieza];
        ResultSet rs4 = sentencia.executeQuery(consultaPieza);
        while (rs4.next()) {
            piezas[i] = rs4.getInt(1);
            i++;
        }
        System.out.println(numMotor);
        for (int j = 0; j < motores.length; j++) {
            for (int k = 0; k < piezas.length; k++) {
                introducir("Recambio", "null," + motores[j] + "," + piezas[k] + ",2," + Math.floor(Math.random() * 19 + 1) + "," + Math.floor(Math.random() * 999 + 1));

            }

        }

    }

    public static void introducirMM() throws SQLException {
        Connection conexion = Conexion.conexionMySQL();
        Statement sentencia = conexion.createStatement();
        String modelos[];
        sentencia.executeUpdate("USE Desguaces");
        String cModelo = "SELECT  m.P_Modelo, ma.`Nombre`\n"
                + "FROM modelo m, marca ma\n"
                + "WHERE m.`A_Marca`= ma.`P_Marca`";

        ResultSet rs = sentencia.executeQuery(cModelo);
        int x = 0;
        while (rs.next()) {
            switch (rs.getString(2)) {
                case "Audi":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 1");
                    break;
                case "Mercedes":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 2");
                    break;
                case "BMW":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 3");
                    break;
                case "Citroen":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 4");
                    break;
                case "Fiat":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 5");
                    break;
                case "Ford":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 6");
                    break;
                case "Nissan":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 7");
                    break;
                case "Opel":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 8");
                    break;
                case "Peugeot":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 9");
                    break;
                case "Renault":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 10");
                    break;
                case "Seat":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " ,11");
                    break;
                case "Volkswagen":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 11");
                    break;
                case "Honda":
                    introducir("ModeloMotor", "null ," + rs.getInt(1) + " , 12");
                    break;

            }

        }
    }

}
