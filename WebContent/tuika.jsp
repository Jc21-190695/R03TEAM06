<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>

<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
<script src="tuika.js"></script>
<script src="henkou.js"></script>

</head>
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

	<div class="content">
		<form method="post" action="tuika">
		
			<%--↓画像はじめ↓ --%>
			<div id="gazouwaku">
				<script type="text/javascript">
					function OnFileSelect(inputElement) {
						// ファイルリストを取得
						var fileList = inputElement.files;
						var loadCompleteCount = 0;
						var imageList = "";
						// FileReaderを生成
						var filereader = new FileReader();
						// ファイルを取得
						var file = fileList[0];
						// 読み込み完了時の処理を追加
						filereader.onload = function() {
							// <li>,<img>タグの生成
							imageList += "<li><img class='sizex' src=" + this.result + " /></li>";
							// <ul>タグに<li>,<img>を流し込む
							document.getElementById("ID001").innerHTML = imageList;
						};
						// ファイルの読み込み(Data URI Schemeの取得)
						filereader.readAsDataURL(file);
					}
				
				</script>
				<label class="upload-label">
					<div class="font">ファイルを選択</div>
					<input type="file"  name="file" onchange="OnFileSelect( this );" required />
				</label>
				<ul id="ID001"></ul>
			</div>
			<%--↑画像終わり↑--%>			
			<div class="font">
				<label for="name">名前</label>
				<input type="text" name="name"	maxlength="10"   class="pcHako mbHako mar">
				<br><br>
				<input type="text" value="0" id="textbox" name="count"class="pcHako mbHako mar">
				<br> <br>
				<div class="sentaku">
					<label><input class="radio" type="radio" name="comm"value="syoku">食材 </label>&emsp; 
					<label><input class="radio" type="radio" name="comm" value="niti">日用品 </label>
					<br> <br>
				</div>
			</div>
			<br>
			<button type="submit" class="tubo" >
				<div class="font">追加</div>
			</button>
			
		</form>

		<%--プラス,マイナス,リセットボタン --%>
		<div class="updown ">
			<button class="button zoge" id="down">
				<div class="font">－</div>
			</button>
			<button class="button zoge" id="up" >
				<div class="font">＋</div>
			</button>
			<button class="button resetbtn rese" id="reset">
				<div class="font">RESET</div>
			</button>
		</div>
	</div>
</body>
</html>