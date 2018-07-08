
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head
    <body>
        <h1>Register</h1>
        <form action = "welcome.jsp" method="post">
            <table>
            <tr><td>Email       </td><td><input type="text" name="email"></td></tr>
            <tr><td>Full name   </td><td><input type="text" name="name"></td></tr>
            <tr><td>Password    </td><td><input type="password" name="password"></td></tr>
            <tr><td>Gender      </td><td><input type="radio" name="gender" value="Male"> Male</td></tr>
            <tr><td>            </td><td><input type="radio" name="gender" value ="Female"> Female</td></tr>
            <tr><td>DOB         </td><td><input type="date" name="dob"></td></tr>
            <tr><td>            </td><td><input type="submit" value="Register"></td></tr>
            </table>
        </form>
    </body>
</html>

