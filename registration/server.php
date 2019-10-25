<?php
session_start();

// Variables
$username = "";
$email    = "";
$errors = array(); 

// Conectar a Base de datos
$db = mysqli_connect('localhost', 'root', '', 'Prueba Selenium');

// REGISTER USER
if (isset($_POST['reg_user'])) {
  // Recibir todos los campos
  $username = mysqli_real_escape_string($db, $_POST['username']);
  $email = mysqli_real_escape_string($db, $_POST['email']);
  $password_1 = mysqli_real_escape_string($db, $_POST['password_1']);
  $password_2 = mysqli_real_escape_string($db, $_POST['password_2']);

  // Validación de llenado
  // en caso de error hacer push al arreglo de errores
  if (empty($username)) { 
      array_push($errors, "Username requerido"); 
    }

  if (empty($email)) { 
      array_push($errors, "Email requerido"); 
    }

  if (empty($password_1)) { 
      array_push($errors, "Password requerido"); 
    }

  if ($password_1 != $password_2) {
	array_push($errors, "Las contraseñas no coinciden");
  }

  // Validar que el usuario o email no existen
  $user_check_query = "SELECT * FROM Usuarios WHERE username='$username' OR email='$email' LIMIT 1";
  $result = mysqli_query($db, $user_check_query);
  $user = mysqli_fetch_assoc($result);
  
  if ($user) { // Si username existe 
    if ($user['username'] === $username) {
      array_push($errors, "El usuario ya existe");
    }

    if ($user['email'] === $email) {
      array_push($errors, "El email ya existe");
    }
  }

  // Registrar usuario si no hay errores
  if (count($errors) == 0) {
  	$password = md5($password_1);//Encriptar contraseña

  	$query = "INSERT INTO Usuarios (username, email, password) 
  			  VALUES('$username', '$email', '$password')";
  	mysqli_query($db, $query);
  	$_SESSION['username'] = $username;
  	$_SESSION['success'] = "Inició sesión!";
  	header('location: index.php');
  }
}

// LOGIN USER
if (isset($_POST['login_user'])) {
    $username = mysqli_real_escape_string($db, $_POST['username']);
    $password = mysqli_real_escape_string($db, $_POST['password']);
  
    if (empty($username)) {
        array_push($errors, "Username requerido");
    }
    if (empty($password)) {
        array_push($errors, "Password requerida");
    }
  
    if (count($errors) == 0) {
        $password = md5($password);
        $query = "SELECT * FROM Usuarios WHERE username='$username' AND password='$password'";
        $results = mysqli_query($db, $query);
        if (mysqli_num_rows($results) == 1) {
          $_SESSION['username'] = $username;
          $_SESSION['success'] = "Has iniciado sesión";
          header('location: index.php');
        }else {
            array_push($errors, "Username o Password incorrecta");
        }
    }
  }
  
?>