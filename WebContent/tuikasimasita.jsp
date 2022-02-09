<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=Windows-31J"%>
<%
String url = "http://localhost:8080/R03Team06/list";
int timer = 5;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=Shift_JIS">
<meta http-equiv="refresh" content="<%=timer%>;URL=<%=url%>">
<script language="JavaScript">
	num =
<%=timer%>
	+ 1;
	function countdown(counter) {
		if (counter < 1) {
			return;
		}
		counter--;
		num = counter;
		document.getElementById("SET_COUNT").innerHTML = counter;
		setTimeout("countdown(num)", 1000);
	}
	

</script>
</head>
<body onLoad="countdown(num)" style="text-align: center">
	追加しました
	<br>
	<br>
	<span><DIV id="SET_COUNT" ><%=timer%></DIV>秒後に自動的にジャンプします・・・</span>
	<br>
	追加購入画面へ
	<br>
	<button type=“button” onclick="location.href='http://localhost:8080/R03Team06/tuika.jsp'">ページリンク</button>

</body>
</html>