<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

<link href="kaimono.css" rel="stylesheet" type="text/css">

<title>kaimono</title>
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

<body>

<form method="post" action="delete">
<table class="table">

  <tbody>
     <th>
   <div class="title"> 食品</div>
    <br>
    <div class="title">名前</div>
    </th>
    
   
  <% for (String[] s : list1){ %>
    <tr>
    <% String commid = s[0]; %>
    <td><div class="namae"><%=s[1] %></div></td>
	<td><button type="submit"style="width: 200px; height: 80px;"value=<%=commid%> name="comm"><div class="font">買い物済</div></button></td>
	<td><div class="font2"><%=s[3] %></div></td>

    </tr>
    <%} %>
 

    <th>
   <div class="title"> 日用品</div>
    </th>
      <% for (String[] s : list2){ %>
    <tr>
    <% String commid = s[0]; %>
    <td><div class="namae"><%=s[1] %></div></td>
	<td><button type="submit"style="width: 200px; height: 80px;"value=<%=commid%> name="comm"><div class="font">買い物済</div></button></td>
	<td><div class="font2"><%=s[3] %></div></td>

    </tr>
    <%} %>
    
    
  </tbody>
</table>
</form>

<a href="http://localhost:8080/R03Team06/list">リスト画面</a>
<a href="http://localhost:8080/R03Team06/tuika.jsp">商品追加画面</a>




</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</html>