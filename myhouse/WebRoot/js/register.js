function $(id){
	return document.getElementById(id);
}
function checknull(){
	if($("name").value ==""){
		alert("用户名不能为空");
		return false;
	}
	if($("password").value ==""){
		alert("密码不能为空");
		return false;
	}
	if($("password").value !=$("repassword").value){
		alert("两次密码不一致。");
		return false;
	}
	if($("telephone").value ==""){
		alert("联系方式必须填写。");
		return false;
	}
	if($("username").value ==""){
		alert("真实姓名必须填写。");
		return false;
	}
	
	
}

var xmlHttp;
function getXmlHttpRequest(){

	if(xmlHttp!=null){
		return xmlHttp;
	}else{
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					return false;
				}
			}
		}
	}
}
function  doajax(){
	  if (xmlHttp.readyState==4 && xmlHttp.status==200){
		  var result = xmlHttp.responseText;
		  if(result ==true){
			  $("myerror").innerHTML="用户名已经注册过了！";
		  }else{
			 $("myerror").innerHTML="用户名可以注册！";
		  }
	  }
}
function checkname(){
	getXmlHttpRequest();
	var name = $("name").value;
	if(name==""){
		return;
	}
	var url = "RegisterServlet?name="+name;
	xmlHttp.open("get",url,true);
	xmlHttp.onreadystatechange=doajax;
	xmlHttp.send(null);
}

