 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    
</head>
<title>Forum</title>
<body>
<%@include file="HeaderLogged.jsp" %>

  <div class="formContainer">
        <table class="tableForm" >
            <tr class="top_table">
                <th scope="col" colspan="3">Forum</th>
                <th scope="col" colspan="2">Topics</th>
                <th scope="col" colspan="2">Posts</th>
            </tr>
            <c:forEach items="${listQuestions}" var="l">
            <tr >
                <td rowspan="2" colspan="3"><p><a href="Reponse.org?idQuestion=${l.id}">${l.categorie}</a> </p><p>${l.question}</p></td>
              
                <td rowspan="2" colspan="2"><p>2</p></td>
                <td rowspan="2" colspan="2"><p>3</p></td>
                
            </tr>
            <tr></tr>
             </c:forEach>
           
    
    
        </table>

    </div>
     
    <div>
     <p style="text-align:center;font-size:27px;">Poser une question ?</p>
    </div>
    
    <div class="formReponse">
        <form action="PoserQuestion.org" method="post">
            <table class="tableForm"   >
                
                    <tr>
                        <th colspan="2" rowspan="2">
                            <p>${Utilisateur.nom}</p>
                            <p>${Utilisateur.prenom}</p>
    
                        </th>
                        <td colspan="2" rowspan="2">
                            <select name="categorie" class="categorie" id="">
                                <option value="Chien">Chien</option>
                                <option value="Chat">Chat</option>
                                <option value="Oiseau">Oiseau</option>
                            
                            </select>
                           
                        </td>
                        <td colspan="3" rowspan="2">
                            <textarea name="questionUtilisateur" id="" cols="70" rows="10"></textarea>
                        </td>
                        <td>
                            <button name=""><i class="fas fa-paper-plane"></i></button>
                        </td>

                    </tr>

                   
             

            </table>

        </form>

    </div>
    



</body>
</html>