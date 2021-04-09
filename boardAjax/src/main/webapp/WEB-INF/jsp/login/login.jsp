<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">

var flag = 0;
flag = ${flag};

 $(function(){
		if(flag == '999') {
			 alert("이메일과 비밀번호를 확인해주세요."); 
		}
	});
	$('#sendForm').submit(function(){
		
		var userId = $('user_id').val();
		var pwd = $('pwd').val();

			console.log("subMit 입성");
			
			if(userId == ''){
				$('#user_id').focus();
				alert("아이디를 입력해주세요");
				return false;
			}if(userId != '' && pwd != '' ){
				$('#pwd').focus();
				alert("비밀번호를 입력해주세요");
				return false;
			}
			return true;

});
	

</script>


<form id="sendForm" action="./idCkedAjax.do" method="post">

	<input type="hidden" id="platform" name="platform" value="">
	<div class="container col-md-offset-2 col-sm-6" style="margin-top: 100px;">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input id="user_id" type="text" class="form-control valiChk" name="user_id" placeholder="id" title="ID">
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input id="pwd" type="password" class="form-control valiChk" name="pwd" placeholder="Password" title="Password">
			</div>
			<br />
		<br>
		<div class="col-md-offset-4">
			<button type="submit" id="#" class="btn btn-primary">로그인</button>
			<button type="button" id="#" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/login/login.do'">취소</button>
			<button type="button" id="#" class="btn btn-info" onclick="location.href='<%=request.getContextPath()%>/user/userInsert.do'">회원가입</button>
		</div>
	</div>
</form>

