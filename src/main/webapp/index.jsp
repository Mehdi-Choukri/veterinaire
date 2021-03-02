<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    
</head>

<body>
<%@include file="Header.jsp" %>
 
  <div class="contexte">
        <div class="contexte_text">
            <div class="contexte_text_title">
                <h1>Faite votre réservation
                    <br>en  ligne, en toute facilité</h1>

            </div>
            <div class="contexte_text_text">
                <p>
                    Lorem Ipsum is simply dummy text of the printing and <br>typesetting industry. <br>
                    Lorem Ipsum has been the industry's standard dummy <br> text ever since the 1500s, <br>
                    when an unknown printer took a galley of type and <br>scrambled it to make a type<br>
                    specimen book.
                </p>

            </div>
            <div class="contexte_text_btn">
                <p> <input type="button"  onclick="location.href='Register.org' " class="btn-register" value="S'enregistrer gratuitement"> 
                    <button class="btn-expore">Explorer</button></p>
                
            </div>

        </div>
        <div class="contexte_img">
            <p> <img src="Images/homeImage.png" alt="" srcset="" ></p>
           

        </div>

    </div>
    <div class="service">
        <div class="service_top">
            <p>Nos services </p>

        </div>
        <div class="service_bottom">
            <div class="service_bottom_left">
                <div class="service_title">
                    <p><i class="fas fa-user-check"></i></p>
                </div>
                <div class="service_text">
                   <p>Avoir votre espace personnelle et compte pour votre Pet</p>
                </div>

            </div>
            <div class="service_bottom_mid">
                <div class="service_title">
                    <p><i class="fas fa-calendar-day"></i></p>

                </div>
                <div class="service_text">
                    <p>Consulter les dates valables pour éviter toute collusion</p>
                </div>

            </div>
            <div class="service_bottom_right">
                <div class="service_title">
                    <p><i class="far fa-calendar-alt"></i>
                    <i class="fas fa-paw"></i></p>
                </div>
                <div class="service_text">
                    <p>Réserver votre rendez-vous selon votre disponibilité</p>

                </div>

            </div>

        </div>


    </div>
    
    
      

<%@include file="Footer.jsp" %>
 
</body>
</html>
