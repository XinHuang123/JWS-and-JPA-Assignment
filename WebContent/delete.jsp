<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
<h1>Hello From JSP</h1>
<script>
    $(function(){
    	alert("Delete");
    	var site={
    			
    			
    	};
    	$.ajax({
    		url:"/JWS_and_JPA_Assignment/rest/api/site/ID/4",
    		type:"delete",
    		contentType:"application/json; charset=utf-8",
    		dataType:" json",
    		data:JSON.stringify(site),
    		success: function(response) {
    			console.log("yahoo");
    		}
    	});
    });

</script>
</body>
</html>