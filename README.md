# Bases-de-datos-Selenium
Creación de base de datos utilizando la herramienta de Selenium para la automatización de registros

## Antes de comenzar
Antes de ejecutar el .exe “CreaciónDeRegistroEnBD” es necesario tener listo algunos requisitos, el primero de ellos es tener encendido los servidores de Apache y MySQL además de haber ingresado con un usuario y contraseña a PhpMyAdmin. Es necesario tener a la mano el usuario y contraseña de PhpMyAdmin para los siguientes pasos.

## HTDOCS o WWW
Para el correcto manejo de este proyecto es necesario, primeramente, asegurarse de contar con la carpeta ‘registration’ dentro de htdocs, en caso de trabajar con Xamp o en su defecto dentro de ‘www’ si está utilizando Wampp server.

## Registration
‘Registration’, contiene los archivos necesarios para mostrar un Login, un registro, validar el llenado de los campos, encriptado de contraseña, muestra de errores al momento del llenado de formulario y la configuración de la base de datos.

## Configurar base de datos
Dentro del archivo server.php se encuentra un apartado que se encarga de conectar con la base de datos, el cual contiene la ruta del ‘localhost’, ‘usuario’, ‘contraseña’, ‘nombre_base_de_datos’. Estos últimos 3 campos pueden ser modificados dependiendo la configuración de cada usuario sin embargo en este ejercicio el único que debe conservar su nombre tal cual es el campo de Prueba Selenium ya que el instalador creara una BD con ese nombre a la cual accederá.

Al tener todas estas configuraciones antes de ejecutar el proyecto se podrá ver la forma en la que Selenium llena campo por campo la configuración desde la base de datos hasta el registro de un formulario creado con Bootstrap y php.
