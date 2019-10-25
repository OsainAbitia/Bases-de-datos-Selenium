import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.SubmitElement;

public class ManejoDB {
	
    public static WebDriver getChromeWebDriver() {
		
		System.setProperty(
			"webdriver.chrome.driver",
			File.separator+"Users"+File.separator+"Usuario"+File.separator+"Documents"
			+File.separator+"7o Cuatri"+File.separator+"Pruebas SW"+File.separator+"PruebaSelenium"
			+File.separator+"chromedriver.exe"
		);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1024,1024");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
	}
    
public static void main(String[] args)throws InterruptedException {
		
		WebDriver chrome = ManejoDB.getChromeWebDriver();
		chrome.get("http://localhost/phpmyadmin/server_databases.php");
		String actualTitle = chrome.getTitle();
		System.out.println("Actual title is: " + actualTitle);
		System.out.println("Creando Base de datos en Localhost, asegurese de haber iniciado"
				+ " con anterioridad con su usuario y contraseña en phpmyadmin");
		
		//Nombre para DB
		WebElement nombre = chrome.findElement(By.id("text_create_db"));
		nombre.sendKeys("Prueba Selenium");
		Thread.sleep(15000);
		
		//Crear DB
		WebElement boton = chrome.findElement(By.id("buttonGo"));
		boton.click();
		Thread.sleep(20000);
		
		//Nombre Tabla DB
		WebElement nombreTabla = chrome.findElement(By.name("table"));
		nombreTabla.sendKeys("Usuarios");
		Thread.sleep(1000);
		
		//Crear Tabla
		WebElement botonTablas = chrome.findElement(By.xpath("//input[@type='submit']"));
		botonTablas.click();
		Thread.sleep(20000);
		
		//Id col1
		WebElement tituloCol1 = chrome.findElement(By.name("field_name[0]"));
		tituloCol1.sendKeys("id");
		Thread.sleep(1000);
				
		       //Type col1
		       WebElement typeCol1 = chrome.findElement(By.name("field_type[0]"));
		       typeCol1.click();
		       Thread.sleep(1000);
		       WebElement varcharCol1 = chrome.findElement(By.name("field_type[0]"));
		       varcharCol1.sendKeys("i");
		       Thread.sleep(1000);
		       //Hacer Scroll
			   JavascriptExecutor jsx = (JavascriptExecutor)chrome;
			   jsx.executeScript("window.scrollBy(450,0)", "");
			   //Autoincrement
		       WebElement autoIncrement = chrome.findElement(By.name("field_extra[0]"));
		       autoIncrement.click();
		       Thread.sleep(5000);
		       //Primary Key ui-icon-closethick
		       WebElement primaryKey = chrome.findElement(By.xpath("//*[text()='Continuar']"));
		       primaryKey.click();
		       Thread.sleep(1000);
		       //Hacer Scroll
			   jsx.executeScript("window.scrollBy(-450,0)", "");
		       
		//Nombre col2
		WebElement tituloCol2 = chrome.findElement(By.name("field_name[1]"));
		tituloCol2.sendKeys("username");
		Thread.sleep(1000);
		
		       //Type col2
				WebElement typeCol2 = chrome.findElement(By.name("field_type[1]"));
				typeCol2.click();
				Thread.sleep(1000);
				WebElement varcharCol2 = chrome.findElement(By.name("field_type[1]"));
				varcharCol2.sendKeys("v");
				Thread.sleep(1000);
				WebElement lenghtCol2 = chrome.findElement(By.name("field_length[1]"));
				lenghtCol2.sendKeys("100");
				Thread.sleep(1000);
		
		//Nombre col3
		WebElement tituloCol3 = chrome.findElement(By.name("field_name[2]"));
		tituloCol3.sendKeys("email");
		Thread.sleep(1000);
		
		       //Type col3
		       WebElement typeCol3 = chrome.findElement(By.name("field_type[2]"));
		       typeCol3.click();
		       Thread.sleep(1000);
		       WebElement varcharCol3 = chrome.findElement(By.name("field_type[2]"));
		       varcharCol3.sendKeys("v");
		       Thread.sleep(1000);
		       WebElement lenghtCol3 = chrome.findElement(By.name("field_length[2]"));
		       lenghtCol3.sendKeys("100");
		       Thread.sleep(1000);
		 
		//Nombre col4
		WebElement tituloCol4 = chrome.findElement(By.name("field_name[3]"));
		tituloCol4.sendKeys("password");
		Thread.sleep(1000);
				
		       //Type col4
		       WebElement typeCol4 = chrome.findElement(By.name("field_type[3]"));
		       typeCol4.click();
		       Thread.sleep(1000);
		       WebElement varcharCol4 = chrome.findElement(By.name("field_type[3]"));
		       varcharCol4.sendKeys("v");
		       Thread.sleep(1000);
		       WebElement lenghtCol4 = chrome.findElement(By.name("field_length[3]"));
		       lenghtCol4.sendKeys("100");
		       Thread.sleep(1000);   
		
        //Hacer Scroll
		jsx.executeScript("window.scrollBy(0,450)", "");

		//Guardar Tabla do_save_data
		WebElement guardar = chrome.findElement(By.xpath("//input[@type='submit']"));
		guardar.click();
		Thread.sleep(20000);
		
		System.out.println("Base de Datos creada exitosamente :)");
		
		/*      Proceso de registro y Login          */
		
		System.out.println("Iniciando creacion de Usuario por defecto: \n"
				+ "Username: root \n Email: root@hotmail.com \n Password: admin123");
		
		//Sign up
		chrome.get("http://localhost/registration/login.php");
		WebElement crearUsuario = chrome.findElement(By.name("signup"));
		crearUsuario.click();
		Thread.sleep(2000);
		
		//Llenar campos username
		WebElement enterUsername = chrome.findElement(By.name("username"));
		enterUsername.sendKeys("osain_aa");
		Thread.sleep(1000);
		
		//Llenar campos email
		WebElement enteremail = chrome.findElement(By.name("email"));
		enteremail.sendKeys("osain@gmail.com");
		Thread.sleep(1000);
		
		//Llenar campos password_1
		WebElement password_1 = chrome.findElement(By.name("password_1"));
		password_1.sendKeys("admin123");
		Thread.sleep(1000);
		//Llenar campos password_2
		WebElement password_2 = chrome.findElement(By.name("password_2"));
		password_2.sendKeys("admin123");
		Thread.sleep(1000);
		
		//Registrar
		WebElement registar = chrome.findElement(By.name("reg_user"));
		registar.click();
		Thread.sleep(3000);
		
		System.out.println("Usuario creado exitosamente, no puedo creer que llegamos tan lejos");
		
		/*              Comprobar registro            */
		
		//logout
		WebElement logOut = chrome.findElement(By.name("logout"));
		logOut.click();
		Thread.sleep(2000);
		
		//Username
		WebElement enterUsernameAgain = chrome.findElement(By.name("username"));
		enterUsernameAgain.sendKeys("osain_aa");
		Thread.sleep(1000);
		
		//Password
		WebElement password_1_Again = chrome.findElement(By.name("password"));
		password_1_Again.sendKeys("admin123");
		Thread.sleep(1000);
		
		//Login
		WebElement login = chrome.findElement(By.name("login_user"));
		login.click();
		Thread.sleep(3000);
		
		System.out.println("Usuario guardado en base de datos");
		
		//Ver Usuarios
		chrome.get("http://localhost/phpmyadmin/sql.php?db=prueba+selenium&table=usuarios&pos=0");
		
	}

}
