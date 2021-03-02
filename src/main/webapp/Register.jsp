<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
 
<!--  <link rel="stylesheet" type="text/css" href="css/bootstrap-4.3.1-dist"> --> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
  
</head>
<body>
<%@include file="Header.jsp" %>
		
	<div class="">
	 
		<div class="panel  panel-warning">
			<div class="panel-heading">Register</div>
			<div class="panel-body">
				<form action="saveUtilisateur.org" method="post">
					<div class="form-group">
						<label class="control-label">Nom</label>
						<input type="text" name="nom"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prénom</label>
						<input type="text" name="prenom"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Email</label>
						<input type="email" name="email"   class="form-control" required="required"/>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Password</label>
						<input type="password" id="id_Password" name="password"   class="form-control" required="required"/>
						<span id="id_confirm_pw_error" class="register_error"></span>
					</div>
					<div class="form-group">
						<label class="control-label">Confirm Password</label>
						<input type="password" id=id_ConfirmPw name="cpassword"  onkeyup="check_confirmPW()" class="form-control" required="required"/>
						<span></span>
					</div>
				 
					<div>
						<button type="submit" id="idRegisterBtn" class="btn btn-warning">Register</button>
					</div>
				</form>
		 
			 
			</div>
		
		
		</div>
	</div>
	 
<%@include file="Footer.jsp" %>

</body>
<script src="main.js" >
  </script>
</html>