<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>

	function cancel_confirm(){
		if(confirm("취소하시겠습니까 ?")){
			location.href="<%=request.getContextPath()%>/main.ino"
		}else {
			return false;
		}
	}
	function edit_confirm(){
		if(confirm("수정하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/freeBoardEditPro.ino"
		}else {
			return false;
		}
	}

</script>

<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./main.ino">리스트로</a>
	</div>
	<hr style="width: 600px">
	
	<form method = "post" action="./freeBoardEditPro.ino">
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="name" value="${freeBoardDto.name }" readonly/></div>
		
		<div style="width: 150px; float: left;">제목 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="title"  value="${freeBoardDto.title }"/></div>
	
		<div style="width: 150px; float: left;">작성날짜</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="regdate"  value="${freeBoardDto.regdate }"readonly/></div>
	
		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left"><textarea name="content" rows="25" cols="65"  >${freeBoardDto.content }</textarea></div>
		<div align="right">
		
		<input type="hidden" name="num" value="${freeBoardDto.num}" />
		
		<input type="submit" value="수정" onsubmit="edit_confirm()" >
		<!-- <input type="button" value="삭제" > -->
		<input type="button" value="취소" onclick="cancel_confirm()">
		&nbsp;&nbsp;&nbsp;
		</div>
	</form>
	
</body>
</html>