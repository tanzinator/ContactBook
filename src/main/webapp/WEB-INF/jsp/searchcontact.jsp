%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<h1>Search Contact</h1>
       <form:form method="get" action="search">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
          <td>Email :</td>  
          <td><form:input path="email" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="search" value="search" /></td>  
         </tr>  
        </table>  
       </form:form>  