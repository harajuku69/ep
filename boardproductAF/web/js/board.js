/**
 * 
 */
function boardCheck(){
	if(document.frm.name.value == ""){
		alert("작성자를 입력하세용");
		return false;		
	}
	if(document.frm.pass.value == ""){
		alert("비밀번호를 입력하세용");
		return false;		
	}
	if(document.frm.title.value == ""){
		alert("제목을 입력하세용");
		return false;		
	}
	return true;
}

function open_win(url, name){
	window.open(url, name, "width=500, height=230");
}

function passCheck(){
	if(document.frm.pass.value == ""){
		alert("비밀번호를 입력하세용");
		return false;		
	}
	return true;
}