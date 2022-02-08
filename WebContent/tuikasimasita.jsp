<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
	 追加しました。
	 <input name="counter" type="text" size="10">
	 <script>
    setTimeout(function(){
  window.location.href = 'http://localhost:8080/R03Team06/list';
}, 5*1000);
    <!--
    count = 0; //カウントの初期値
    timerID = setInterval('countup()',1000); //1秒毎にcountup()を呼び出し

    function countup() {
    	count++;
    	document.form_count.counter.value = count;
    }
    -->
	</script>
</body>
</html>