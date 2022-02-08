<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
<script src="list.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

<link href="list.css" rel="stylesheet" type="text/css">

<title>一覧画面</title>

</head>
<%
Optional<List<String[]>>optList1 = Optional.ofNullable((List<String[]>)request.getAttribute("list1"));
List<String[]> list1=new ArrayList<>();
if(optList1.isPresent()){
	list1 = optList1.get();
}
%>
<%
Optional<List<String[]>>optList2 = Optional.ofNullable((List<String[]>)request.getAttribute("list2"));
List<String[]> list2=new ArrayList<>();
if(optList2.isPresent()){
	list2 = optList2.get();
}
%>
<%
Optional<List<String[]>>optList3 = Optional.ofNullable((List<String[]>)request.getAttribute("list3"));
List<String[]> list3=new ArrayList<>();
if(optList3.isPresent()){
	list3 = optList3.get();
}
%>
<%
Optional<List<String[]>>optList4 = Optional.ofNullable((List<String[]>)request.getAttribute("list4"));
List<String[]> list4=new ArrayList<>();
if(optList4.isPresent()){
	list4 = optList4.get();
}
%>


<body>
	<%--↓ハンバーガ目メニュー↓ --%>
	<div class="ham">
		<div class="nav_toggle">
			<i></i> <i></i> <i></i>
		</div>
		<nav class="nav">
			<ul class="nav_menu_ul">
				<li class="nav_menu_li"><a href="http://localhost:8080/R03Team06/list">リスト画面</a></li>
				<li class="nav_menu_li"><a href="http://localhost:8080/R03Team06/kaimono">買い物画面</a></li>
				<li class="nav_menu_li"><a href="http://localhost:8080/R03Team06/settei.html">設定画面</a></li>
			</ul>
		</nav>
	</div>

	<script>
	    $('.nav_toggle').on('click', function () {
	        $('.nav_toggle, .nav').toggleClass('show');
    	});
	</script>
	<%--↑↑↑↑↑↑↑↑↑ --%>


<table class="table">

  <tbody>
     
    <div class="title">食品</div>
    <br>
    
    <td><div class="title hyou">名前</div></td>
    <td><div class="title hyou">状態</div></td>
    <td></td>
    <td><div class="title hyou">個数</div></td>
    

   
  <% for (String[] s : list1){ %>
    <tr>
<form method="post" action="add">    
   
    <td><div class="list"><%=s[1] %></div></td>
	<td><button class="button" type="submit"value=<%=s[0]%> name="comm" ><div class="font">購入する</div></button></td>
	 <% String down = "down"+s[0]; %>
	 <% String text = "text"+s[0]; %>
	 <% String up = "up"+s[0]; %>
	 <td><a class="btn btn-border"id="<%=down %>" type="button"><span><div class="plmy">－</div></span></a></td>
	<td><input class="count" type="text" value=<%=s[3] %> id="<%=text%>" name="count"></td>
	<td><a class="btn btn-border"id="<%=up %>" type="button"><span><div class="plmy">＋</div></span></a></td>	
		<td><button class="button" type="submit" formaction="count"   ><div class="font">変更</div></button></td>
		<input type="hidden" value=<%=s[0]%> name="comm1" >
</form>

    </tr>
    <%} %>
 
  <% for (String[] s : list2){ %>
    <tr>
  <form method="post" action="add">      
    <td><div class="kaimono"><%=s[1] %></div></td>
	<td><div class="font2">登録済み</div></td>
	 <% String down = "down"+s[0]; %>
	 <% String text = "text"+s[0]; %>
	 <% String up = "up"+s[0]; %>
	 <td><a class="btn btn-border"id="<%=down %>" type="button"><span><div class="plmy">－</div></span></a></td>
	<td><input class="count" type="text" value=<%=s[3] %> id="<%=text%>" name="count"></td>
	<td><a class="btn btn-border"id="<%=up %>" type="button"><span><div class="plmy">＋</div></span></a></td>	
       		<td><button class="button" type="submit" formaction="count"   ><div class="font">変更</div></button></td>
		<input type="hidden" value=<%=s[0]%> name="comm1" >
        </form>
    </tr>
    <%} %>
    </table>
<table class="table">
	
    <div class="title">日用品</div>
    <br>
    
    <td><div class="title hyou">名前</div></td>
    <td><div class="title hyou">状態</div></td>
    <td></td>
    <td><div class="title hyou">個数</div></td>>
    
  <% for (String[] s : list3){ %>
    <tr>
      <form method="post" action="add">    
    <td><div class="list"><%=s[1] %></div></td>
	<td><button class="button" type="submit"value=<%=s[0]%> name="comm" ><div class="font">購入する</div></button></td>
	 <% String down = "down"+s[0]; %>
	 <% String text = "text"+s[0]; %>
	 <% String up = "up"+s[0]; %>
	 <td><a class="btn btn-border"id="<%=down %>" type="button"><span><div class="plmy">－</div></span></a></td>
	<td><input class="count" type="text" value=<%=s[3] %> id="<%=text%>" name="count"></td>
	<td><a class="btn btn-border"id="<%=up %>" type="button"><span><div class="plmy">＋</div></span></a></td>	
		<td><button class="button" type="submit" formaction="count"   ><div class="font">変更</div></button></td>
		<input type="hidden" value=<%=s[0]%> name="comm1" >
</form>

    </tr>
    <%} %>
 
  <% for (String[] s : list4){ %>
    <tr>
      <form method="post" action="add">    
    <td><div class="kaimono"><%=s[1] %></div></td>
	<td><div class="font2">登録済み</div></td>
	 <% String down = "down"+s[0]; %>
	 <% String text = "text"+s[0]; %>
	 <% String up = "up"+s[0]; %>
	 <td><a class="btn btn-border"id="<%=down %>" type="button"><span><div class="plmy">－</div></span></a></td>
	<td><input class="count" type="text" value=<%=s[3] %> id="<%=text%>" name="count"></td>
	<td><a class="btn btn-border"id="<%=up %>" type="button"><span><div class="plmy">＋</div></span></a></td>	
		<td><button class="button" type="submit" formaction="count"   ><div class="font">変更</div></button></td>
		<input type="hidden" value=<%=s[0]%> name="comm1" >
</form>

    </tr>
    <%} %>
    
  </tbody>
</table>


</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</html>