<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
var flag = 0;
$(function(){
	flag = ${flag};
	if(flag == '999') {
		 alert("이메일과 비밀번호를 확인해주세요."); 
	}
	/*
	      $('#loginForm').on('submit',function(){
	         frmSubmit();
	         return false;
	      });//submit
	*/
});//ready
	
	function frmSubmit() {
		var id = $('#id').val();
		var pwd = $('#pwd').val();
		
		console.log("submit!");
		
		if(id == '') {
			$('#id').focus();
			alert('아이디를 입력하세요.');
			return false;
		}
		if(id != '' && pwd == '') {
			$('#pwd').focus();
			alert('비밀번호를 입력하세요.');
			return false;
		}
		var param = "id=" + $('#id').val() + "&pwd=" + $('#pwd').val();
	    var url = "http://localhost:9090/<%=request.getContextPath()%>/loginchk.ino";
	    console.log('url:' + url);
 	    console.log('param:' + param);
 	   	   $.ajax({
           type: "POST",
           url: url + "?" + param,
           //data: param,
           dataType:"json",
           success : function(data) {
           console.log(data);
            
            var fail = data.result;
             if(fail == "fail") {
                alert("아이디와 비밀번호를 확인해주세요."); 
             }else{ // success
           		 window.location.replace("http://localhost:9090/<%=request.getContextPath()%>/freeBoardLogin.ino");
              }
          	 },//success
	         error:function(){
	            alert('통신 장애');
	         }//error
   		});//ajax 
	
	}
</script>

<body>
<c:if test="${user eq null }">
<form method="post" id="loginForm" action="./loginchk.ino">
	<input type="text" id="id" name ="id" />
	<input type="password" id="pwd" name="pwd" />
	<input type="submit" value="로그인" />
</form>
</c:if>
<c:if test="${user ne null }">
<span>${user.name }님 로그인 하셨습니다.</span>
</c:if>
</body>
</html>