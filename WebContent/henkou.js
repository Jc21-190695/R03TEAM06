
	if (window.matchMedia('(min-width:768px)').matches) {
  	var head = document.head;
  	var linkElement = document.createElement("link");
 
  	linkElement.type = "text/css";
  	linkElement.rel = "stylesheet";
  	linkElement.href = "tuikaPC.css";
 
  	head.appendChild(linkElement);
	} else if(window.matchMedia('(max-width:767px)').matches){
  	var head = document.head;
  	var linkElement = document.createElement("link");
 
  	linkElement.type = "text/css";
	  linkElement.rel = "stylesheet";
  	linkElement.href = "tuika.css";
 
  	head.appendChild(linkElement);
	}
