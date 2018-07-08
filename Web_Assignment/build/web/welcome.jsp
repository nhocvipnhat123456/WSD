    
<%@page import="uts.wsd.Users"%>
<%@page import="uts.wsd.User" contentType="text/html" pageEncoding="UTF-8"%>
<%
    String Name = request.getParameter("name");
    String Email = request.getParameter("email");
    String Password = request.getParameter("password");
    String Gender = request.getParameter("gender");
    String DOB = request.getParameter("dob");
%>

<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
    <jsp:useBean id="userApp" class="uts.wsd.UserApplication" scope="application">
        <jsp:setProperty name="userApp" property="filePath" value="<%=filePath%>"/>
    </jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
        <%!User user; %>
        <% 
            Users users = userApp.getUsers();
            User user = new User(Email, Name, Password, Gender, DOB);
            users.addUser(user);
            userApp.updateXML(users, filePath);
        %>
        <body>
            <h1></h1>
                <p>Welcome, <%=Name%>!</p>
                <p>Your Email is <%=Email%>.</p>
                <p>Your Name is <%=Name%>.</p>
                <p>Click <a href ="main.jsp"> here</a> to proceed to the main page.</p>
        </body>        
   
</html>
