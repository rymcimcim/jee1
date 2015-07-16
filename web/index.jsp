<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java 4 US!</title>
    </head>
    <body>
        <form action="FirstServlet" method="get">

            Imie:*<input type="text" name="imie" /><br />
            Nazwisko:*<input type="text" name="nazwisko" /><br />
            E-mail:*<input type="text" name="email1" /><br />
            Potwierdz e-mail:*<input type="text" name="email2" /><br />
            Firma:<input type="text" name="firma" /><br />
            Skąd dowiedziales się o konferencji?<br />
            <select name="from">
                <option value=""></option>
                <option value="praca">Ogloszenie w pracy</option>
                <option value="uczelnia">Ogloszenie na uczelni</option>
                <option value="facebook">Facebook</option>
                <option value="znajomi">Znajomi</option>
            </select>
            Inne (jakie?): <input type="text" name="other" /><br />
            Czym sie zajmujesz? <input type="text" name="pozycja" /><br />
            <input type="submit" value=" OK ">

        </form>
        <b>* - pola wymagane</b>
    </body>
</html>
