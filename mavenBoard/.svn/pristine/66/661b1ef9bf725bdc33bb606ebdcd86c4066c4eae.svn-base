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
			location.href="<%=request.getContextPath()%>/fileBoardMain.ino"
		}else {
			return false;
		}
	}
	function edit_confirm(){
		if(confirm("수정하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/fileDataUpdatePro.ino"
		}else {
			return false;
		}
	}
	
	function fileDel(){
		if(confirm("삭제하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/fileDataDeletePro.ino?boardNum= ${fileBoardDto.num}&fileName= ${fileBoardDto.chgname}"
		}else {
			return false;
		}
	}
</script>
<body>

	<div>
		<h1>자료실</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./fileBoardMain.ino">리스트로</a>
	</div>
	<hr style="width: 600px">
	
	<form method = "post" action="./fileBoardUpdatePro.ino" encType="multipart/form-data">
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="name" value="${fileBoardDto.name }" readonly/></div>
		
		<div style="width: 150px; float: left;">제목 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="title"  value="${fileBoardDto.title }"/></div>
	
		<div style="width: 150px; float: left;">작성날짜</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="regdate"  value="${fileBoardDto.regdate }"readonly/></div>
	
		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left"><textarea name="content" rows="25" cols="65"  >${fileBoardDto.content }</textarea></div>
		
		<c:if test="${fileBoardDto.chgname eq null}">
		<div style="width: 150px; float: left;">파일 추가 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="file" name="fileName"/></div>
		</c:if>
				<c:if test="${fileBoardDto.chgname ne null}">
				<div style="width: 150px; float: left;">파일  :</div>${fileBoardDto.chgname }
				<button type="button" onclick="fileDel();">삭제</button>
				<input type="hidden" name="chgname" value="${fileBoardDto.chgname }" />
				</c:if>
	
		
		<div align="right">

		<input type="hidden" name="num" value="${fileBoardDto.num}" />
		<input type="submit" value="수정" onsubmit="edit_confirm()" >
		<!-- <input type="button" value="삭제" > -->
		<input type="button" value="취소" onclick="cancel_confirm()">
		&nbsp;&nbsp;&nbsp;
		</div>
	</form>
	
</body>
</html>