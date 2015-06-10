function $(id){
	return document.getElementById(id);
}
function checknull(){
	if($("add_title").value == ""){
		alert("标题不能为空");
		return false;
	}
	if($("add_contact").value == ""){
		alert("联系方式不能为空");
		return false;
	}
	if($("add_floorage").value == ""){
		alert("面积不能为空");
		return false;
	}
	if($("add_price").value == ""){
		alert("价格不能为空");
		return false;
	}
	if($("add_housedate").value == ""){
		alert("房产证日期不能为空");
		return false;
	}
	if($("add_description").value == ""){
		alert("详细信息不能为空");
		return false;
	}
}