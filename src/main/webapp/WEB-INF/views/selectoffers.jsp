<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>년도</th><th>학기</th><th>교과목명</th><th>교과구분</th><th>담당교수</th><th>학점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="selectoffer" items="${selectoffers }">
				<tr>
					<td><c:out value="${selectoffer.year}" /></td>
					<td><c:out value="${selectoffer.semester}" /></td>
					<td><c:out value="${selectoffer.s_name}" /></td>
					<td><c:out value="${selectoffer.s_type}" /></td>
					<td><c:out value="${selectoffer.professor}" /></td>
					<td><c:out value="${selectoffer.grades}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>