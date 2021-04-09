<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script>
	
 $(document).ready(function(){ 
/*	$(function(){ */
		
		// 파라미터 세팅
		$('#profit_cost').val('${account.PROFIT_COST}');
		$('#comments').val('${account.COMMENTS}');
		$('#transaction_money').val('${account.TRANSACTION_MONEY}');
		$('#transaction_date').val('${account.TRANSACTION_DATE}');
		
		// 분류 값에 따른 옵션 리스트 불러오기 -> 값 설정 (재귀로 5단계까지 자동 설정)
		callSubList('profit_cost', $('#profit_cost').val());

		// select 값 변경 시 호출되는 펑션
		$('select').on('change',function(e){
		
			var target = e.target.id ;
			//console.log(target);

	   	 	var val = e.target.value;
	      	//console.log(val);
      		if(val == '' || val == '0'){
      			if(target == 'profit_cost') {
      				$('#big_group').children('option:not(:first)').remove();
	      			$('#big_group').val('');
   	      			$('#middle_group').children('option:not(:first)').remove();
   	      			$('#middle_group').val('0');
   	      			$('#small_group').children('option:not(:first)').remove();
   	      			$('#small_group').val('0');
   	      			$('#detail_group').children('option:not(:first)').remove();
   	            	$('#detail_group').val('0');
      			} else if(target == 'big_group') {
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
		
		// 수정 버튼 클릭
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
				if(confirm('정보를 수정하시겠습니까?')){
					return true;
				} else{
					return false;
				}
				//formSubmit('./accountInsert/saveAccount.do', $(this).attr('id'))
			}
		});
	});

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
	      });
	}

	function callSubList(target, val) {
		
		if(val != '' && val != '0') {
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
		            	$('#big_group').append('<option value="">선택</option>' + plus);
		            	if('${account.BIG_GROUP}' != '') {
		            		$('#big_group').val('${account.BIG_GROUP}');
		            		callSubList('big_group', $('#big_group').val());
		            	}
		            } else if(target == 'big_group') {
		            	$('#middle_group').append('<option value="0">해당없음</option>' + plus);
		            	if('${account.MIDDLE_GROUP}' != '0') {
		            		$('#middle_group').val('${account.MIDDLE_GROUP}');
		            		callSubList('middle_group', $('#middle_group').val())
		            	}
		            } else if(target == 'middle_group') {
		            	$('#small_group').append('<option value="0">해당없음</option>' + plus);
		            	if('${account.SMALL_GROUP}' != '0') {
		            		$('#small_group').val('${account.SMALL_GROUP}');
		            		callSubList('small_group', $('#small_group').val())
		            	}
		            } else if(target == 'small_group') {
		            	$('#detail_group').append('<option value="0">해당없음</option>' + plus);
		            	if('${account.DETAIL_GROUP}' != '0') {
		            		$('#detail_group').val('${account.DETAIL_GROUP}');
		            	}
		            }
		         }
		         ,error : function(){
		        	 console.log('error');
		         }
		      });
		} else{
			 if(target == 'profit_cost') {
	            	$('#big_group').append('<option value="">선택</option>');
	            	$('#middle_group').append('<option value="0">해당없음</option>');
	            	$('#small_group').append('<option value="0">해당없음</option>');
	            	$('#detail_group').append('<option value="0">해당없음</option>');
	            } else if(target == 'big_group') {
	            	$('#middle_group').append('<option value="0">해당없음</option>');
	            	$('#small_group').append('<option value="0">해당없음</option>');
	            	$('#detail_group').append('<option value="0">해당없음</option>');
	            } else if(target == 'middle_group') {
	            	$('#small_group').append('<option value="0">해당없음</option>');
	            	$('#detail_group').append('<option value="0">해당없음</option>');
	            } else if(target == 'small_group') {
	            	$('#detail_group').append('<option value="0">해당없음</option>');
	            }
		}
	}
</script>

<!-- 비용 START -->
<div class="container" style="margin-top: 50px">
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
	<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>


	<form id="form" method="post" action="./accountInsert/editAccount.do">
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
				        </select>
				      </div>

				      <div class="col-sm-3">
						<select class="form-control " id="middle_group"  name="middle_group"  title="항">
				        </select>
				      </div>

				      <div class="col-sm-3">
						<select class="form-control "  id="small_group" name="small_group" title="목">
				        </select>
				      </div>
			 		</div>

			 		<div class="col-sm-12">  <label for="disabledInput" class="col-sm-12 control-label"> </label></div>
			 		<div class="col-sm-12">
			 			  <div class="col-sm-3">
								<select class="form-control " id="detail_group" name="detail_group" title="과">
							        	<!--  <option value="0">해당없음</option>-->
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
				        	<input class="form-control" id="transaction_money" name="transaction_money" type="number" value="" title="금액" onKeypress="onlyNumber()"/>
				      </div>
			 		  <label for="disabledInput" class="col-sm-1 control-label"><font size="1px">거래일자</font></label>
				      <div class="col-sm-3">
				       	 <input class="form-contro col-sm-2 datepicker" id="transaction_date" name="transaction_date" type="text" value="" style="width: 80%" title="거래일자">
				      </div>
			 		</div>

					<input type="hidden" name="account_seq" id="account_seq" value="${account.ACCOUNT_SEQ }" />
					
					<div style="text-align: center; " class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label>
					<button type="submit" id="updateBtn" class="btn btn-primary">수정</button>
					<button type="button" id="remove"class="btn btn-danger" onclick="location.href='./accountList.do'">취소</button></div>
					
					<div class="col-sm-12"><label for="disabledInput" class="col-sm-12 control-label"></label></div>
			 </div>
		</div>
	</div>
	</form>
</div>

<!-- 비용 END -->