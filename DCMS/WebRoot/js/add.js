
function $(str){
		if(str.charAt(0)=="#"){
			return document.getElementById(str.substring(1,str.length));
		}else if(str.charAt(0)=="."){
			return document.getElementsByClassName(str.substring(1,str.length));
		} if(str.charAt(0)=="!"){
			return document.getElementsByName(str.substring(1,str.length));
		}else{
			return document.getElementsByTagName();
		}
	}

//每个商品的名称
var cnameList = $(".cname");
//每个商品的编号
var cnoList = $(".cno");

var opriceList = $(".oprice");
//每个商品的价钱
var cpriceList = $(".cprice");	
//每个商品的评论
var pList = $(".pl");
//每个添加按钮
var addList = $(".add");
//获取容器
var box = $("#box");
//为每个a标签动态生成href属性
if(box!=null){
	box.addEventListener("click",function(e) {
	  if(e.target && e.target.className=="add") {
	  		for(var i = 0;i<cnoList.length;i++){
	  			if(e.target.parentNode==cnoList[i].parentNode.parentNode){
	  				var cno = cnoList[i].textContent;
	  				e.target.setAttribute("href","ShoppingCartServlet" + getURL(cno));
	  			}
	  		}
	  }
	});
}
//拼接url
function getURL(id){
	var url = "";
	for(var i = 0;i<cnoList.length;i++){
		if(id==cnoList[i].textContent){
			url = "?op=add&commodityId=" + cnoList[i].textContent + "&commodityQutity=1";
			break;
		}
	}
	return url;
}



























