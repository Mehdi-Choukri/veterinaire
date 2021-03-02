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
<title>Réponse</title>
<body>
<%@include file="HeaderLogged.jsp" %>

     <div class="formContainer">
        <table class="tableForm" >
            <tr class="top_table">
                <th scope="col" colspan="3">Question</th>
                <th scope="col" colspan="2">Posé par</th>
                <th scope="col" colspan="2">Date</th>
                
            </tr>
            <tr class="">
                <th scope="col" colspan="3"><p>${Question.question}</p></th>
                <th scope="col" colspan="2"><p>${UtilisateurposeurQuestion.nom}</p><p>${UtilisateurposeurQuestion.prenom}</p></th>
                <th scope="col" colspan="2"><p>${Question.date}</p</th>
                
            </tr>
            <tr class="top_table">
                <th scope="col" colspan="3">Réponses </th>
                <th scope="col" colspan="2">Repondu par</th>
                <th scope="col" colspan="2">Date</th>
              
                
            </tr>
            
            <tr></tr>
              <c:forEach items="${listReponse}" var="l" varStatus="status">
              <tr> <td rowspan="2" colspan="3"><p>${l.reponse}</p></td> <td rowspan="2" colspan="2"><p>${listUtilisateur[status.index].nom}</p></td> <td rowspan="2" colspan="2"><p>${l.date}</p></td></tr>
               
              
               <tr></tr>
                  </c:forEach>
           
           
           
    
    
        </table>

    </div>
    
    <div class="formReponse">
        <form action="PoserReponse.org?idQuestion=${Question.id}" method="post">
            <table class="tableForm"  border="1">
                <tr class="top_table">
                    <th colspan="2" rowspan="2">
                        <p>${UtilisateurVisiteur.nom}</p>
                        <p>${UtilisateurVisiteur.prenom}</p>

                    </th>
                    <td>
                       <textarea name="reponseUtilisateur" id="" cols="70" rows="10"></textarea>
                    </td>
                    <td>
                        <button name="reponseUtilisateur"><i class="fas fa-paper-plane"></i></button>
                    </td>
                </tr>

            </table>

        </form>

    </div>
    



</body>
</html>