<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1>modify.jsp</h1>
	<form id="modifyForm" method="post" action="modify">
		<table>
			<thead>
				<tr>
					<td>번호 : ${board.bno }</td>
					<td colspan='2'>제목 : <input type="text" name="title"
						value="${board.title }">
					</td>
				</tr>
				<tr>
					<td>등록일 : <fmt:formatDate value="${board.regdate}"
							pattern="yyyy-MM-dd" /></td>
					<td>작성자 : <input type="text" name="writer"
						value="${board.writer }">
					</td>
					<td>조회수 : ${board.readCount }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan='3'>
						<textarea name="content" rows="8" cols="22" style="resize: none; right: none;">${board.content }</textarea>
					</td>
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
		<button onclick="location.href='${contextPath }/Board/content?bno=${param.bno}&pageNum=${param.pageNum}'">취소</button>
		<button id="modify">수정</button>
	</form>
	<script type="text/javascript">
		$(function() {
			//수정처리
			$('#modify').on('click', function(e) {
				e.preventDefault();
				let bnoTag = $("<input/>", {type : 'hidden', name : 'bno', value : "${param.bno}"})
				let pageNum = $("<input/>", {type : 'hidden', name : 'pageNum', value : "${param.pageNum}"})
				if (bnoTag.val() != '') {$('#modifyForm').append(bnoTag);}
				if (pageNum.val() != '') {$('#modifyForm').append(pageNum);}
				$('#modifyForm').attr("method", "post");
				$('#modifyForm').attr("action", "modify");
				$('#modifyForm').submit();
			})
		})
	</script>
</body>
</html>