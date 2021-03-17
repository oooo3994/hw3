<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
		<table class="formtable">
			<tr> <td class="label">교과목명</td> 
				<td> <sf:input class ="control" type="text" path="s_name"/>  <br/>
				<sf:errors path="s_name" class="error"/> </td> </tr>
			<tr> <td class="label">년도</td> 
				<td> <sf:input class ="control" type="text" path="year"/> <br/>
				<sf:errors path="year" class="error"/> </td> </tr>
			<tr> <td class="label">학기</td> 
				<td> <sf:input class ="control" type="text" path="semester"/> </td> </tr>
			<tr> <td class="label">교과 구분</td> 
				<td> <sf:input class ="control" type="text" path="s_type"/> </td> </tr>
			<tr> <td class="label">담당 교수</td> 
				<td> <sf:input class ="control" type="text" path="professor"/> </td> </tr>
			<tr> <td class="label">학점</td> 
				<td> <sf:input class ="control" type="text" path="grades"/> </td> </tr>
			<tr> <td></td> <td><input type="submit" value="새 제안"></td> </tr>
		</table>
	</sf:form>
</body>
</html>