function $(id){
	return document.getElementById(id);
}
function checknull(){
	if($("user_name").value == ""){
		alert("用户名不能为空");
	}
	if($("user_password").value == ""){
		alert("密码不能为空");
	}
}