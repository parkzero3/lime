<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script>
	var profit_cost = '';
	var big_group = '';
	var middle_group = '';
	var small_group = '';
	var detail_group = '';
/* $(document).ready(function(){ */
	$(function(){

		$('select').on('change',function(e){
		
			var target = e.target.id ;
			//console.log(target);

	   	 	var val = e.target.value;
	      	//console.log(val);
	      	
	      	if(target == 'profit_cost' && val == ''){
	         	location.reload();
	      	} else 
	      		if(val == '' || val == '0'){
		      		if(target == 'big_group') {
		      			$('#middle_group').children('option:not(:first)').remove();
		      			$('#middle_group').val('0');
		      			$('#small_group').children('option:not(:first)').remove();
		      			$('#small_group').val('0');
		      			$('#detail_group').children('option:not(:first)').remove();
		            	$('#detail_group').val('0');
		            } else if(target == 'middle_group') {
		            	$('#small_group').children('option:not(:first)').remove();
		      			$('#small_group').val('0');
		      			$('#detail_group').children('option:not(:first)').remove();
		            	$('#detail_group').val('0');
		            } else if(target == 'small_group') {
		            	$('#detail_group').children('option:not(:first)').remove();
		            	$('#detail_group').val('0');
		            }
	      	} else {
	      		chgCombo(target, val);
	      	}
	      	
		});
		
		$("#form").submit(function(){
			if($('#profit_cost').val() == '') {
				alert('카테고리를 선택해주세요.');
				$('#profit_cost').focus();
				return false;
			} else if($('#big_group').val() == '') {
				alert('카테고리를 선택해주세요.');
				$('#big_group').focus();
				return false;
			} else if($('#middle_group').children().length > 1 && $('#middle_group').val() == '0') {
				alert('카테고리를 선택해주세요.');
				$('#middle_group').focus();
				return false;
			} else if($('#small_group').children().length > 1 && $('#small_group').val() == '0') {
					alert('카테고리를 선택해주세요.');
					$('#small_group').focus();
					return false;
			} else if($('#detail_group').children().length > 1 && $('#detail_group').val() == '0') {
				alert('카테고리를 선택해주세요.');
				$('#detail_group').focus();
				return false;
			} else if($('#transaction_money').val() == '') {
				alert('금액을 입력해주세요.');
				$('#transaction_money').focus();
				return false;
			} else if($('#transaction_date').val() == '') {
				alert('거래일자를 입력해주세요.');
				$('#transaction_date').focus();
				return false;
			} else {
				//formSubmit('./accountInsert/saveAccount.do', $(this).attr('id'))
			}
		});
	})

   function onlyNumber(){
        if((event.keyCode<48)||(event.keyCode>57))
           event.returnValue=false;

	}
		
	function chgCombo(target, val) {
		$.ajax({
	         url : "./accountInsert/category.do"
	         ,type : "post"
	         ,data : {'category' : val}
	         ,success : function(result){
	            var plus = '';
	            $(result).each(function (index, item) {
	            	plus += '<option value="'+item.code+'">' + item.comKor + '</option>';
	            });
	
	            console.log(plus);
	            
	            if(target == 'profit_cost') {
	            	$('#big_group').append(plus);
	            	$('#middle_group').val('0');
	            	$('#small_group').val('0');
	            	$('#detail_group').val('0');
	            } else if(target == 'big_group') {
	            	$('#middle_group').append(plus);
	            	$('#small_group').val('0');
	            	$('#detail_group').val('0');
	            } else if(target == 'middle_group') {
	            	$('#small_group').append(plus);
	            	$('#detail_group').val('0');
	            } else if(target == 'small_group') {
	            	$('#detail_group').append(plus);
	            }
	         }
	         ,error : function(){
	        	 console.log('error');
	         }
	      })
	}

</script>

<!-- 비용 START -->
<div class="container" style="margin-top: 50px">
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>


	<form id="form" method="post" action="./accountInsert/saveAccount.do">
	<div class="col-sm-11" id="costDiv">
		<div>
			<div class="col-sm-11">
			 		<div class="col-sm-12">
				      <div class="col-sm-3">
						<select class="form-control" id="profit_cost" name="profit_cost" title="비용">
				        	<option value="">선택</option>
				        	<c:forEach var="list" items="${resultMap}" varStatus="cnt">
					        	<option value="${list.code}">${list.comKor}</option>
				        	</c:forEach>
				        </select>
				      </div>

				      <div class="col-sm-3">
						<select class="form-control" id="big_group"  name="big_group" title="관">
				        	<option value="">선택</option>
				        </select>
				      </div>

				      <div class="col-sm-3">
						<select class="form-control " id="middle_group"  name="middle_group"  title="항">
					        	<option value="0">해당없음</option>
				        </select>
				      </div>

				      <div class="col-sm-3">
						<select class="form-control "  id="small_group" name="small_group" title="목">
					        	<option value="0">해당없음</option>
				        </select>
				      </div>
			 		</div>

			 		<div class="col-sm-12">  <label for="disabledInput" class="col-sm-12 control-label"> </label></div>
			 		<div class="col-sm-12">
			 			  <div class="col-sm-3">
								<select class="form-control " id="detail_group" name="detail_group" title="과">
							        	<option value="0">해당없음</option>
						        </select>
					      </div>
				      <div class="col-sm-9">
				      		<input class="form-control " id="comments" name=comments type="text" value="" placeholder="비용 상세 입력" title="비용 상세">
				      </div>
			 		</div>

				<div class="col-sm-12">  <label for="disabledInput" class="col-sm-12 control-label"> </label></div>
			 		<div class="col-sm-12">
			 		  <label for="disabledInput" class="col-sm-1 control-label"><font size="1px">금액</font></label>
				      <div class="col-sm-3">
				        	<input class="form-contczrol" id="transaction_money" name="transaction_money" type="number" value="" title="금액" onKeypress="onlyNumber()"/>
				      </div>
			 		  <label for="disabledInput" class="col-sm-1 control-label"><font size="1px">거래일자</font></label>
				      <div class="col-sm-3">
				       	 <input class="form-contro col-sm-2 datepicker" id="transaction_date" name="transaction_date" type="text" value="" style="width: 80%" title="거래일자">
				      </div>
			 		</div>

					<div style="text-align: center; " class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label>
					<button type="submit" id="saveBtn" class="btn btn-primary">등록</button>
					<button type="button" id="remove"class="btn btn-danger" onclick="location.href='./accountList.do'">취소</button></div>
					
					<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
			 </div>
		</div>
	</div>
	</form>
</div>

<!-- 비용 END -->