window.onload = function() {

/*var downlist =['down3','down7','down10'];
var uplist =['up3','up7','up10'];
var textlist =['text3','text7','text10'];*/

var downlist =[];
var uplist =[];
var textlist =[];
for (let i=1;i<=100;i++){
	let down = 'down'+i;
	downlist.push(down)
}
for (let i=1;i<=100;i++){
	let up = 'up'+i;
	uplist.push(up)
}
for (let i=1;i<=100;i++){
	let text = 'text'+i;
	textlist.push(text)
}


var downbutton =[];
var upbutton=[];
var text=[];

for(let q=0;q<=100;q++){	

	downbutton[q] = document.getElementById(downlist[q]);
	upbutton[q] = document.getElementById(uplist[q]);
	text[q] = document.getElementById(textlist[q]);


		//ボタンが押されたらカウント減
		if (downbutton[q] != null) {
			downbutton[q].addEventListener('click', (event) => {
		//0以下にはならないようにする
		if (text[q].value >= 1) {
			text[q].value--;
		}
	});
	
	
		//ボタンが押されたらカウント増
	upbutton[q].addEventListener('click', (event) => {
		text[q].value++;
	})
		}
	

}
}
	