<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>facemelt | Show One Member</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/resources/css/screen.css'/>"/>
    <c:choose>
      <c:when test="${empty member}">
	<!-- no member-specific stylesheet -->
      </c:when>
      <c:otherwise>
	<link rel="stylesheet" type="text/css" href="<c:url value='http://localhost/facemelt/${member.path}/style.css'/>"/>
      </c:otherwise>
    </c:choose>
  </head>
  <body>
    <div id="container">
      <div id="content">
	<h1>facemelt | Show One Member</h1>

	<c:choose>
	  <c:when test="${empty member}">
	    <h2>Unknown Member</h2>

	  </c:when>
	  <c:otherwise>
	    <h2>Member</h2>
	    <table class="simpletablestyle">
	      <thead>
		<tr>
		  <th>Id</th>
		  <th>Name</th>
		  <th>Email</th>
		  <th>Phone #</th>
		</tr>
	      </thead>
	      <tbody>
		<tr>
		  <td>${member.id}</td>
		  <td>${member.name}</td>
		  <td>${member.email}</td>
		  <td>${member.phoneNumber}</td>
		</tr>
	      </tbody>
	    </table>
	  </c:otherwise>
	</c:choose>
	<a href="<c:url value='/'/>">View all members</a>
      </div>
      <div id="footer">
	<p>
	  This project was generated from a Maven archetype from
	  JBoss.<br />
	</p>
      </div>
    </div>
  </body>
</html>
