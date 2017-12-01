	
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
	
	
	//根据传入的字符串返回相应的对象
	var contr = $("#contr");
	contr.onclick = function(){
		check();	
	}
	//购物车全选效果
	function check(){
		var contr = $("#contr");
		var ctrList = $("!check");
			for(var i = 0;i<ctrList.length;i++){
				ctrList[i].checked = contr.checked;
			}
			var moneyList = $(".money");
			var total = $("#total");
			var sum = 0;
			if(contr.checked){
				for(var i = 0;i<moneyList.length;i++){
					sum = sum + parseInt(moneyList[i].textContent);
				}
				total.innerHTML = sum;
			}else{
				total.innerHTML = 0;
			}
			
	}
		
	var tb = $("#tb");
	
	tb.addEventListener("click",function(e) {
	  if(e.target && e.target.className=="addNum") {
	    var list = $(".num");
	    var cidList = $(".cid");
	    for(var i = 0;i<list.length;i++){
	    	if(e.target.parentNode == list[i].parentNode){
	    		list[i].value = parseInt(list[i].value) + 1;
	    		getMoney();
	    		getTotalMoney();
	    		location.href = "ShoppingCartServlet?op=update&commodityId=" +
    			cidList[i].textContent + "&commodityQutity=" +  list[i].value;
	    		break;
	    	}
	    }
	  }
	});
	
	
	tb.addEventListener("click",function(e) {
	  if(e.target && e.target.className=="deleteNum") {
		var cidList = $(".cid");
	    var numList = $(".num");
	    for(var i = 0;i<numList.length;i++){
	    	if(e.target.parentNode == numList[i].parentNode){
	    		if(numList[i].value>0){
	    			numList[i].value = parseInt(numList[i].value) - 1;
	    			getMoney();
	    			getTotalMoney()
	    			location.href = "ShoppingCartServlet?op=update&commodityId=" +
	    			cidList[i].textContent + "&commodityQutity=" +  numList[i].value;
	    			break;
	    		}
	    	}
	    }
	  }
	});
	//num失去焦点的时候更新价钱
	var numReg = /^[0-9]*$/;
	tb.addEventListener("change",function(e) {
	  if(e.target && e.target.className=="num") {
	    var priceList = $(".price");
	    var moneyList = $(".money");
	    var cidList = $(".cid");
	    var num = e.target.value;
	    var total = $("#total");
	    var ctrList = $(".ctr");
	    var sum = 0;
	    for(var i = 0;i<priceList.length;i++){
	    	if(e.target.parentNode.parentNode == priceList[i].parentNode){
	    		if(numReg.test(e.target.value)){
	    			moneyList[i].innerHTML = parseInt(e.target.value) * parseInt(priceList[i].textContent);
	    			e.target.style.borderColor = "#4169E1";
	    			location.href = "ShoppingCartServlet?op=update&commodityId=" +
	    			cidList[i].textContent + "&commodityQutity=" +  e.target.value;
	    		}else{
	    			e.target.style.borderColor = "red";
	    			e.target.value = 0;
	    		}
	    		
	    	}
	    	if(ctrList[i].checked){
	    		sum = sum + parseInt(moneyList[i].textContent);
	    	}
	    }
	    total.innerHTML = sum;
	  }
	});
	
	/**
	 * 计算单个商品的总价
	 */
	function getMoney(){
		var money = $(".money");
		var price = $(".price");
		var numList = $(".num");
		for(var i = 0;i<numList.length;i++){
			if(money[i].parentNode==price[i].parentNode){
				money[i].innerHTML = parseInt(price[i].textContent) * parseInt(numList[i].value);
			}
		}
	}
	/**
	 * 计算订单总金额
	 */
	function getTotalMoney(){
		var total = $("#total");
		var moneyList = $(".money");
		var ctrList = $(".ctr");
		var sum = 0;
		for(var i = 0;i<moneyList.length;i++){
			if(ctrList[i].checked){
				sum = sum + parseInt(moneyList[i].textContent);
			}
		}
		total.innerHTML = sum;
	}
	
	tb.addEventListener("click",function(e) {
	  if(e.target && e.target.className=="ctr") {
	    var list = $(".money");
	    var total = $("#total");
	    for(var i = 0;i<list.length;i++){
	    	if(e.target.parentNode.parentNode == list[i].parentNode){
	    		if(e.target.checked){
	    			total.innerHTML = parseInt(total.textContent) + parseInt(list[i].textContent);
	    		}else{
	    			total.innerHTML = parseInt(total.textContent) - parseInt(list[i].textContent);
	    		}
	    	}
	    }
	  }
	});
	
	
	
	
