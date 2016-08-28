function loginCheck(){
	if(document.frm.userid.value == ""){
		alert("아이디를 입력해주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("암호 입력 안하고 들어갈려고 그랬어?ㅋㅋㅋ");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck(){
	/*if(document.frm.userid.value ==""){
		alert("아이디를 입력하여 주세요.");
		document.frm.userid.focus();
		return;		
	}*/
	var url="idCheck.do?userid="+document.frm.userid.value;
	window.open(url, "_black_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=180");
}

function idok(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}
function joinCheck(){
	if(document.frm.name.value.length == 0){
		alert("이름을 입력해주세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력해주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value.length == 0){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.reid.value.length == 0){
		alert("중복 체크 안하냐? 빨리 해라");
		frm.userid.focus();
		return false;
	}
	return true;	
}