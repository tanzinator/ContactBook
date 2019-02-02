    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Contacts List</h1>
	<tr><th>Id</th><th>Name</th>
	<th>Email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="contact" items="${list}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.email}</td>
    <td><a href="editcontact/${emp.id}">Edit</a></td>
    <td><a href="deletecontact/${emp.id}">Delete</a></td>
    </tr>
    </c:forEach>
    <br/>
    <a href="contactform">Add New Contact</a>