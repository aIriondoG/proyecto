<?xml version="1.0" encoding='utf-8' ?>
<!DOCTYPE helpset
PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
"http://java.sun.com/products/javahelp/helpset_1_0.dtd">
<helpset version="1.0">
	<title>Ayuda</title>
	<maps>
		<homeID>principal</homeID> <!-- Página por defecto al mostrar la ayuda -->
		<mapref location="mapa.jhm"/> <!-- Que mapa deseamos -->
	</maps>
	<!-- Las Vistas que deseamos mostrar en la ayuda -->
	<!-- La tabla de contenidos -->
	<view>
		<name>Tabla Contenidos</name>
		<label>Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>tablacontenidos.xml</data>
	</view>
	<!-- El indice -->
	<view>
		<name>Indice</name>
		<label>El indice</label>
		<type>javax.help.IndexView</type>
		<data>indice.xml</data>
	</view>
	<!-- La pestana de busqueda -->
</helpset>
