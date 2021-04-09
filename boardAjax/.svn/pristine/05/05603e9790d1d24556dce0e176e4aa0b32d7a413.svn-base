<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
/* 	$(document).ready(function(){ */

		//유효성 검사

		   var idValidity = RegExp(/^[a-z0-9_-]{6,16}$/);
		   var pwdValidity = RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,16}$/);
		   var nameValidity = RegExp(/^[가-힣]+$/);
		   
		   $(function(){

			   $("#sendForm").submit(function(){
		         
		         console.log("Asdasdasdada");
		         
		         if($("#user_id").val()==""){
		            alert("아이디를 입력해주세요");
		            $("#user_id").focus();
		            return false;
		         }
		         
		         if(!idValidity.test($("#user_id").val())){
		             alert("최소 6글자 이상 입력해주세요");
		             $("#user_id").val("");
		             $("#user_id").focus();
		             return false;
		           }
		         
		         
		         if($("#pwd").val()==""){
		            alert("패스워드를 입력해주세요");
		            $("#pwd").focus();
		            return false;
		         }
		         
		         if(!pwdValidity.test($("#pwd").val())) {
		             alert("6글자 이상 , 영문+숫자+특수문자 각 1개씩 이상 포함되어야합니다.");
		             $("#pwd").val("");
		             $("#pwd").focus();
		             return false;
		         }
		         
		         if($("#pwdck").val()==""){
		            alert("패스워드 확인을 입력해주세요");
		            $("#pwdck").focus();
		            return false;
		         }
		         if($("#pwd").val() != $("#pwdck").val()){
		            alert("비밀번호가 같지않습니다 다시확인해주세요");
		            $("#pwdck").val(""); 
		            $("#pwdck").focus();
		            return false;
		            }   
		         if($("#user_name").val()==""){
		            alert("이름을 입력해주세요");
		            $("#user_name").val(""); 
		            $("#user_name").focus(); 
		            return false; 
		            } 
		         
		         if (!nameValidity.test($("#user_name").val())) {
		             alert("정확히 작성해주세요");
		             $("#user_name").val("");
		             $("#user_name").focus();
		             return false;
		           }
		         return true;
		         
		      });
			   
			   $("#remove").click(function() {			   
				   alert ("로그인 화면으로 돌아갑니다.");
				   return false;
			   });
			   
			   
			   
			   //중복검사 체크 
			   
			   $("#idcked").click(function(){
				
				   var user_id = $('#user_id').val();
				   var url = 'http://localhost:9090<%=request.getContextPath()%>/user/userInsertCheck.do';
				   console.log(user_id);
				   
				   $.ajax({
					   type:'GET',
					   data:"user_id=" + user_id,
					   url: url,
					   dataType:"json",
					   contentType:"application/json; charset=UTF-8",
					   
					   success : function(data){
						   console.log("1 = 중복  , 1 != 중복아님"+ data);
						   if( data > 0 ){
							   alert ( " 해당 아이디가 존재합니다. ")
						   }
						   else{
							   alert ( " 사용 가능한 아이디 입니다. ")
						   }
					   },error: function(data){
						   alert("통신장애");
						
					   }
				   });
			   });

		   });
		
		
/* 	}); */

</script>

<div class="container" style="margin-top: 50px">
	<form class="form-horizontal" id="sendForm" method="post" action="./userInsertPro.do" >
	    <div class="form-group">
	      <label class="col-sm-2 control-label">ID</label>
	      <div class="col-sm-4">
	        <input class="form-control" id="user_id" name="user_id" type="text" value="" title="ID">
	      </div>

	      <div class="container">
	      	<button type="button" id="idcked" class="btn btn-default" style="display: block;">ID 중복 체크</button>
	      </div>

	    </div>

	    <div class="form-group">
	      <label for="disabledInput " class="col-sm-2 control-label">패스워드</label>
	      <div class="col-sm-4">
	        <input class="form-control" id="pwd" name="pwd" type="password" title="패스워드" >
	      </div>
	      <label for="disabledInput " class="col-sm-2 control-label">패스워드 확인</label>
	      <div class="col-sm-4">
	        <input class="form-control" id="pwdck" name="pwdck" type="password" title="패스워드 확인">
	      </div>
	    </div>

	    <div class="form-group">
	      <label for="disabledInput" class="col-sm-2 control-label">이름</label>
	      <div class="col-sm-4">
	        <input class="form-control" id="user_name" name="user_name" type="text" value="" title="이름" >
	      </div>
	    </div>


	    <div class="col-md-offset-4">
			<button type="submit" id="saveBtn" class="btn btn-primary" >저장</button>
			<button type="button" id="remove"class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/login/login.do'">취소</button>
	    </div>
	</form>
</div>


