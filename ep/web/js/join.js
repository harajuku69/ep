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

/*$(function(){
	var empnm = $("#empnm"),
	empid = $("#empid"),
	pwd	  = $("#pwd"),
	mustFields = $([]).add(empnm).add(empid).add(pwd);
	tips = $(".validateTips");
	
	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");//하일라이트 주는 것
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500 );//하일라이트 없어지는 것
		}, 500 );
	}
	
	function chkLng(o, nm, min, max) {
		if (o.val().length > max || o.val().length < min ) {
			o.addClass("ui-state-error");
			updateTips(nm + "은(는) " + min + "에서 " + max + "까지 입력해주세요.");
//			alert(nm + "은(는) " + min + "에서 " + max + "까지 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}
	
	function chkExp(o, regexp, nm) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(nm);
//			alert(nm);
			return false;
		} else {
			return true;
		}
	}
	
	function chkJoin(){
		var valid = true;
		mustFields.removeClass("ui-state-error");
		valid = chklng(empnm, "이름", 2, 15);
		valid = valid && chklng(empid, "아이디", 2, 15);
		valid = valid && chklng(pwd, "비밀번호", 2, 15);
		
		valid = valid && chkExp(empnm, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "이름은 2~15자로 작성해주세요.");
		valid = valid && chkExp(empid, /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+$/,"아이디는 영문, 숫자 2~15자로 작성해주세요.");
		valid = valid && chkExp(pwd, /^([0-9a-zA-Z])+$/,"비밀번호는 영문, 숫자 2~15자로 작성해주세요.");
		
		
		return valid;	
	}
});*/

