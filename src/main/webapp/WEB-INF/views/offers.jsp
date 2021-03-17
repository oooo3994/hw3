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
				<th>년도</th><th>학기</th><th>취득 학점</th><th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="total" value="0" />
			<c:forEach var="offer" items="${offers }">
				<tr>
					<td><c:out value="${offer.year}" /></td>
					<td><c:out value="${offer.semester}" /></td>
					<td><c:out value="${offer.grades}" /></td>
					<td><a
						href="/helloSpringMVC/selectoffers/${offer.year}/${offer.semester}">링크</a></td>
				</tr>
				<c:set var="total" value="${total + offer.grades}" />
			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<th>총계</th><th></th><th><c:out value="${total}" /></th><th></th>
			</tr>
		</tfoot>
	</table>


</body>
</html>