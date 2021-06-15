
	function check() {
           alert("登録しました!");
    }

 function checkForm(){
    if(document.form.email.value == "" || document.form.name.value == "" || document.form.password.value == ""|| document.form.password1.value == ""){
        window.alert("必須項目を入力して下さい。");
		return false;
    }
		else{
			window.alert("登録完了!");
		return true;
    }
}





 