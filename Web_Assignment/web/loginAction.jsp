
<%@page import="uts.wsd.validator.LoginValidator"%>
<%@page import="uts.wsd.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
    <% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
    <jsp:useBean id="userApp" class="uts.wsd.UserApplication" scope="application">
        <jsp:setProperty name="userApp" property="filePath" value="<%=filePath%>"/>
    </jsp:useBean>
    
    <%
        userApp.LoadUsers();
        Users users = userApp.getUsers();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = users.login(email, password);
        LoginValidator val= new LoginValidator();
        if (val.checkEmpty(email, password)) {
                session.setAttribute("user", user);
                request.getSession().setAttribute("error", "Incorrect email and password");
                response.sendRedirect("login.jsp");
        } else if (!val.validatePassword(password)) {
                session.setAttribute("user", user);
                request.getSession().setAttribute("error", "Incorrect password");
                response.sendRedirect("login.jsp");
        } else if (!val.validateEmail(email)){
                session.setAttribute("user", user);
                request.getSession().setAttribute("error", "Incorrect email");
                response.sendRedirect("login.jsp");
        } else {
                session.setAttribute("user", user);
                response.sendRedirect("main.jsp");
        }
            %>
    </body>
</html>