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
		if(confirm("수정페이지로 이동하시겠습니까 ?")){
			location.href="<%=request.getContextPath()%>/fileBoardEdit.ino?num=${fileBoardDto.num}"
		}else {
			return false;
		}
	}
	function delete_confirm(){
		if(confirm("삭제하시겠습니까 ?")){
			return false;
		}
	}
/* 	 function fileDel(){
	    	if(confirm("파일을 삭제 하시겠습니까?")){
	    		location.href="creatorPictureDelete";
	    	}
	    }
 */
</script>

<body>

	<div>
		<h1>자료실</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./fileBoardMain.ino">리스트로</a>
	</div>
	<hr style="width: 600px">
	
	<form action="./fileBoardDelete.ino" onsubmit="delete_confirm()">
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="name" value="${fileBoardDto.name }" readonly/></div>
		
		<div style="width: 150px; float: left;">제목 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="title"  value="${fileBoardDto.title }"readonly/></div>
	
		<div style="width: 150px; float: left;">작성날짜</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" name="regdate"  value="${fileBoardDto.regdate }"readonly/></div>
	
		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left"><textarea name="content" rows="25" cols="65" readonly  >${fileBoardDto.content }</textarea></div>
		
		<div style="width: 150px; float: left;">파일  :</div>
		
		<div style="width: 300px; float: left;">
				<c:if test="${fileBoardDto.chgname eq null}"></c:if>
				<c:if test="${fileBoardDto.chgname ne null}">${fileBoardDto.chgname }
				<!-- <button type="button" onclick="fileDel();">삭제</button> -->
				<input type="hidden" name="chgname" value="${fileBoardDto.chgname }" />
				</c:if>
		</div>		
		<div align="right">
		
		<input type="hidden" name="num" value="${fileBoardDto.num }" />
		<input type="button" value="수정" onclick="edit_confirm()" />
		<input type="submit" value="삭제" />
		<input type="button" value="취소" onclick="cancel_confirm()" />
		&nbsp;&nbsp;&nbsp;
		</div>
	
	</form>
	
</body>
</html>