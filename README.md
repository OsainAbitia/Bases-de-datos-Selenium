# Bases-de-datos-Selenium
Creación de base de datos utilizando la herramienta de Selenium para la automatización de registros

## Antes de comenzar
Antes de ejecutar el .exe “CreaciónDeRegistroEnBD” es necesario tener listo algunos requisitos, el primero de ellos es tener encendido los servidores de Apache y MySQL además de haber ingresado con un usuario y contraseña a PhpMyAdmin. Es necesario tener a la mano el usuario y contraseña de PhpMyAdmin para los siguientes pasos.

## Chromedriver
Es necesario tener Chromedriver dentro de la ruta “C:\Users\Chromedriver.exe"
Si aún no tienes instalado <a href="https://chromedriver.chromium.org/" target="_blank">ChromeDriver</a>, asegurate de conocer tu versión de Chrome y descargar el Driver correcto para ti, de lo contrario el programa no funcionará.
En caso de que Chrome no sea tu navegador preestablecido, busca el WebDriver correspondiente ya que es necesario para que Selenium pueda realizar la automatización de pruebas.

## HTDOCS o WWW
Para el correcto manejo de este proyecto es necesario asegurarse de contar con la carpeta ‘<strong>registration</strong>’ dentro de htdocs, en caso de trabajar con Xamp o en su defecto dentro de ‘www’ si está utilizando Wampp server.

## Registration
Contenido de‘<strong>registration</strong>’, contiene los archivos necesarios para mostrar un Login, un registro, validar el llenado de los campos, encriptado de contraseña, muestra de errores al momento del llenado de formulario y la configuración de la base de datos.

## Configurar base de datos
Dentro del archivo <strong>server.php</strong> se encuentra un apartado que se encarga de conectar con la base de datos, el cual contiene la ruta del ‘localhost’, ‘usuario’, ‘contraseña’, ‘nombre_base_de_datos’. <strong>Estos últimos 3 campos pueden ser modificados dependiendo la configuración de cada base de datos</strong> sin embargo en este ejercicio el único que debe conservar su nombre tal cual es el campo de Prueba Selenium ya que el programa creara una BD con ese nombre a la cual accederá.

Al tener todas estas configuraciones antes de ejecutar el proyecto se podrá ver la forma en la que Selenium llena campo por campo la configuración desde la base de datos hasta el registro de un formulario creado con Bootstrap y php.
