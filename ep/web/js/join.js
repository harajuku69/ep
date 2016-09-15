/**
 * Join : Regex + id/pw check 
 */
function chkId(){
	var url="staff.do?cmd=chk_id&empid="+document.frm.empid.value;
	window.open(url, "_black_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=350, height=180");
}

function idok(){
	opener.frm.empid.value = document.frm.empid.value;
	opener.frm.reid.value = document.frm.empid.value;
	self.close();
}

function chkJoin(){
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.reid.value == ""){
		alert("중복 체크 안하냐? 빨리 해라");
		frm.userid.focus();
		return false;
	}
}
