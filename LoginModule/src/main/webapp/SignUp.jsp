<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <style>
body {
  background-image: url("https://wallpaperheart.com/wp-content/uploads/2018/03/background-design-hd_live.jpg");
}
#home {
  width: 46px;
  height: 44px;
  background: url(img_navsprites.gif) 0 0;
}
#prev {
  width: 43px;
  height: 44px;
  background: url(img_navsprites.gif) -91px 0;
}
#next {
  width: 43px;
  height: 44px;
  background: url(img_navsprites.gif) -91px 0;
}

.button {border-radius: 100%;
 background-color: DodgerBlue; }
</style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark justify-content-center ">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link " href="Welcome.jsp">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="SignIn.jsp">SignIn</a>
    </li>
   
  </ul>
</nav>
<br>
<img id="home" src="https://img.icons8.com/cute-clipart/2x/home.png" width="1" height="1"><br><br>
<img id="next" src="https://img.icons8.com/flat_round/2x/circled-left-2.png" width="1" height="1">
<img id="next" src="https://img.icons8.com/flat_round/2x/circled-right.png" width="1" height="1">
<div class="container">
  
  <form action="SignUp.do" class="was-validated" method="post" >
  <div class="col-sm-6">
    <div class="form-group">
      <label for="uname">Username:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    </div>
    <div class="col-sm-6 ">
    <div class="form-group" >
      <label for="uname">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
      <label for="uname">Mobile:</label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter Mobile no." name="mobile" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    </div>
    <div class="col-sm-6">
    <div class="form-group">
      <label for="pwd">Confirm Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter confirm password" name="confirmpswd" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    </div>
    <button type="submit" class="button button">SignUp</button>
  </form>
</div>

</body>
</html>
