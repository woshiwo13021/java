function $(str){
		if(str.charAt(0)=="#"){
			return document.getElementById(str.substring(1,str.length));
		}else if(str.charAt(0)=="."){
			return document.getElementsByClassName(str.substring(1,str.length));
		} else{
			return document.getElementsByTagName();
		}
	}

var marginT = 0;
function login(){
	var tbl = $("#tbl");
	tbl.style.top = marginT +"px";
	marginT+=4;
	if(marginT>=250){
		clearInterval(timer);
	}
}
var timer = setInterval("login()",8);

var uname = $("#uname");
var upass = $("#upass");
var unameValue = uname.value;
var upassValue = upass.value;
var nameReg = /^[a-zA-Z_][\w.-]{2,16}[\w]$/;
var passReg = /^.{6,16}$/;

uname.onblur = function(){
	if(uname.value==""){
		uname.className = "error";
	}else
	if(nameReg.test(uname.value)==false){
		uname.className = "error";
	}else{
		uname.className = "suc";
	}
}

uname.onfocus = function(){
	uname.className = "";
	uname.style.border = "1px solid darkorange";
}

upass.onblur = function(){
	if(upass.value==""){
		upass.className = "error";
	}else
	if(passReg.test(upass.value)==false){
		upass.className = "error";
	}else{
		upass.className = "suc";
	}
}

upass.onfocus = function(){
	upass.className = "";
	upass.style.border = "1px solid darkorange";
}


function doLogin(){
	var login = $("#login");
}
