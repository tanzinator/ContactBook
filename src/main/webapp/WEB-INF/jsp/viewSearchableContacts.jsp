    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Searchable Contacts</h1>
    <c:forEach var="contact" items="${contacts}"> 
    <tr>
    <td>${contact.id}</td>
    <td>${contact.name}</td>
    <td>${contact.email}</td>
    </tr>
    </c:forEach>
    <br/>
    <a href="contactform">Add New Contact</a>