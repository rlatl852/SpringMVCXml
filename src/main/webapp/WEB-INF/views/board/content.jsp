<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<style>
table {
	border: 1px solid #444444;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<h1>content.jsp</h1>
	<form id="boardFrom" method="post" action="remove">
		<table>
			<thead>
				<tr>
					<td>번호 : ${board.bno }</td>
					<td colspan='2'>
						제목 : ${board.title }
						<input type="hidden" value="${board.bno }" name="bno" id="bno">
					</td>
				</tr>
				<tr>
					<td>등록일 : <fmt:formatDate value="${board.regdate}"
							pattern="yyyy-MM-dd" /></td>
					<td>작성자 : ${board.writer }</td>
					<td>조회수 : ${board.readCount }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan='3'>${board.content }</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan='3'>
						<div>첨부파일</div>
					</td>
				</tr>
			</tfoot>
		</table>
		<button type="button"	onclick="location.href='${contextPath }/Board/list?pageNum=${param.pageNum}'">목록</button>
		<button type="button" onclick="location.href='${contextPath }/Board/modify?bno=${param.bno }&pageNum=${param.pageNum}'">수정</button>
		<button type="submit">삭제</button>
	</form>
</body>
</html>