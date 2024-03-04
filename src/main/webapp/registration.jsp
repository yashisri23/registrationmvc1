<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

</head>
<body>
<form  id="frm" method="post" action="login.jsp">  
<div class="container">
<center><h2> Registration </h2></center>
    
     <div class="form-group">
     <input type="text" class="form-control" name="fullname" placeholder="fulllname:">
      </div>
        <div class="form-group">
                <input type="email" class="form-control" name="email" placeholder="Email:">
            </div>
           
            <div class="form-group">
          <input type="password" class="form-control" name="password" placeholder="Password:">
            </div>
          
            <div class="form-group">
                <input type="password" class="form-control" name="repeat_password" placeholder="Repeat Password:">
            </div>
           
            <div class="form-group">
                <input type="textarea" class="form-control" name="address" placeholder="Please enter your address">
            </div>
           
            <div class="form-group">
            <input type="radio" id="Male" name="Gender" value="Male">
            <label for="Male">Male</label><br>
            </div>
            <div class="form-group">
            <input type="radio" id="Female" name="Gender" value="Female">
            <label for="Female">Female</label><br>
            </div>
            <div class="form-group">
                <input type="textarea" class="form-control" name="Comments" placeholder="Any comments">
            </div>
            
            <div class="form-group">

            <label for="image">Image : </label>
      <input type="file" name="image" id = "image" accept=".jpg, .jpeg, .png" value=""> <br> <br>

         
    </div>
           <div class="form-btn">
                <input type="submit" class="btn btn-primary" value="Register" name="submit">

            </div>
            
        </form>

        <div><p>Already Registered <a href="login.jsp">Login Here</a></p></div>
     
   
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script src= "script.js"></script>
</body>
</html>
