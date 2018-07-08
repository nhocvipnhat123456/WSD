

<%@page import="uts.wsd.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--Get the session of 'user'--%>
<%  
    User user = (User)session.getAttribute("user"); 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>

    <body>
        <h1>Booking Main Page</h1>
        <%-- If statement to display navigation links--%>
       <% if (user != null) { %>
            <div style="text-align: left;"> 
                <a href="booking.jsp">Reservation Page</a> |  <a href="logout.jsp">Logout</a>
            </div>
            <p></p>
            <div style= "text-align: right;">
                You are logged in as: <%=user.getName()%> &lt; <%=user.getEmail()%> &gt;
            </div>
            <h2>Books Search
                    <select name="filter">
                        <option value="tutor">Tutor</option>
                        <option value="status">Status</option>
                        <option value="category">Category</option>
                        <option value="title">Title</option>
                    </select>
                    <input type="text" name="data">
                    <input type="submit" value="Search">
            </h2> 
        <% } else { %>
            <div style="text-align: left;">
                <a href="register.jsp">Register</a> | <a href="login.jsp">Login</a>
            </div> 
            <p></p>
            <div style= "text-align: right; border: solid 1px black;">
                Please login first in order to reserve books.
            </div>
            <h2>Books Search
                    <select name="filter">
                        <option value="tutor">Tutor</option>
                        <option value="status">Status</option>
                        <option value="category">Category</option>
                        <option value="title">Title</option>
                    </select>
                    <input type="text" name="data">
                    <input type="submit" value="Search">
            </h2> 
        <% } %>
         
        
    </body>
</html>
