<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$(".delBtn").on("click",function(){ //상품삭제버튼
		var num=$(this).attr("data-xxx"); //주문번호 받아오기
		location.href="CartDelServlet?num="+num; // ex)CartDelServlet?num=2
	});
	
	$(".updateBtn").on("click",function(){ //수량수정버튼
		var num=$(this).attr("data-xxx");//주문번호 받아오기
		var amount=$("#cartAmount"+num).val(); //수량받아오기
		var gprice=$(this).attr("data-price"); //가격받아오기
		$.ajax({
			url:"CartUpdateServlet",
			type:"get",
			dataType:"text",
			data:{
				num:num,
				gAmount:amount,
			},
			success:function(responseData,status,xhr){//정상응답인경우 실행
			var sum=amount*gprice;
			$("#sum"+num).text(sum);
			},
			error: function(xhr,status,error){//정상응답이아닌경우 실행
				console.log(error);
			}
			
		});	
	})
	$("#allCheck").on("click",function(){ //전체선택버튼 코드구현
		var result=this.checked;
		$(".check").each(function(idx,data) {
			this.checked=result;
		})
	})
	
	$("#delAllCart").on("click",function(){ //선택된 체크박스의 주문번호를 배열로 생성하는 코드
		var num=[];
	//$("input:checkbox[name='check']:checked").each(function(idx,ele)){
		$(".check:checked").each(function (idx,ele) {
			num[idx]=$(this).val();
			location.href="CartDelAllServlet?data="+num;
		});
	})
	
	
	$("#delAllCart2").on("click",function(){ //전체cart 삭제
		$("form").attr("action","CartDelAllServlet2");
		$("form").submit();
	});
	
	$(".orderBtn").on("click",function(){
		var num=$(this).attr("data-xxx");//주문번호 받아오기
		location.href="CartOrderConfirmServlet?num="+num;
	})
	
	$("#orderAllConfirm").on("click",function(){
	$("form").attr("action","CartOrderAllConfirmServlet");	
	$("form").submit();
	})
	
	
	
})

</script>
<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>


	<form name="myForm">	    
<%
   
List<CartDTO> list=(List<CartDTO>)request.getAttribute("cartList");
for(int i=0; i<list.size(); i++){
	CartDTO dto=list.get(i);
	int num=dto.getNum();
	String userid=dto.getUserid();
	String gcode=dto.getgCode();
	String gname=dto.getgName();
	int gprice=dto.getgPrice();
	String gsize=dto.getgSize();
	String gcolor=dto.getgColor();
	int gamount=dto.getgAmount();
	String gImage=dto.getgImage();

%>	    
	  		

		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check" class="check" value="<%=num%>"></td>
			<td class="td_default" width="80"><%=num %></td>
			<td class="td_default" width="80">
			<img src="images/items/<%=gImage%>.gif" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'><%=gname %>
			
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(<%=gsize %>)
					, 색상(<%=gcolor %>)]
			</font></td>
			<td class="td_default" align="center" width="110">
			<%=gprice %>
			</td>
			<td class="td_default" align="center" width="90">
			<input class="input_default" type="text" name="cartAmount"
				id="cartAmount<%=num%>" style="text-align: right" maxlength="3"
				size="2" value="<%=gamount%>"></input></td>
			<td><input type="button" value="수정" class="updateBtn" data-xxx="<%=num%>" data-price="<%=gprice %>" /></td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'><span id="sum<%=num%>"><%=gprice*gamount %>
				
				</span></td>
			<td><input type="button" value="주문" class="orderBtn" data-xxx="<%=num%>"></td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'>
			<input type="button" value="삭제" id="xx<%=i%>"
			class="delBtn" data-xxx="<%=num%>"></td> <!-- data-xxx 사용자 정의 속성 -->
			<td height="10"></td>
		</tr>

<%
}
%>

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			id="orderAllConfirm"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="#" id="delAllCart"> 전체 삭제하기1 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="delAllCart2"> 전체 삭제하기2 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="MainServlet"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
    