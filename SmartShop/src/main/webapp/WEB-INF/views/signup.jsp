<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	
	function check_id_Sync() {
		const form = document.getElementById("signup_form");
		
		const xhr = new XMLHttpRequest();
		xhr.open("GET", "checkId?id=" + form.id.value, false);
		
		xhr.send();
		
		const result = xhr.responseText;
		
		if(result == "OK") {
				alert (`[Syn] \${result}, \ ${form.id.value}` );
				form.checkId.value = form.id.value;
				}
		else
				alert (`[동기]  \${form.id.value} 는 사용중` );
		
		alert(`[Sync] \${result}, \${form.id.value}`);
	}
	

	
	
	
	
	
	//비동기 순서가 위에서 부터 처리하지 않음  콜백 일이 끝나면 할일
 	function check_id_Async() {
		const form = document.getElementById("signup_form");
		const xhr = new XMLHttpRequest();
		
	//  onreadystatechange 속성 - 상태가 바뀌면  속성에 있는거 실행  DONE 완료된 상태이면 실행
	//	아니면 무시   200정상이면 출력
		xhr.onreadystatechange = function() {
			console.log(xhr.readyState);
			
			if(xhr.readyState == XMLHttpRequest.DONE) {
				if(xhr.status == 200) {
					const result = xhr.responseText;
					
					if(result == "OK") {
						alert (`[비동기] \${form.id.value} 는 사용가능 아이디` );
						form.checkId.value = form.id.value;
					}
					else
						alert (`[비동기]  \${form.id.value} 는 사용중` );
					
				}
			}
		}
		
		xhr.open("GET", `checkId?id=\${form.id.value}` , true);
		
		xhr.send();
		//send 일시작      콜백 상태가 바뀌면 시작
	}
	
	function signup() {
		const form = document.getElementById("signup_form");  //객체 얻어오기
		const regx = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

		//epthffh.tistory.com/entry/비밀번호-정규식 [물고기 개발자의 블로그]
		
		
		if(form.checkId.value != form.id.value) {
			alert("아이디 중복 검사를 해주세요");
			return;
		}
		
		
		if(form.id.value == "") {   //값이 없으면  
			alert("아이디를 입력 해 주세요");
			form.id.focus();   //입력해야 되는곳 으로
			return;
		}
		
		
		
		if(form.passwd.value == "") {   //값이 없으면  
			alert("비밀번호를 입력 해 주세요");
			form.passwd.focus();   //입력해야 되는곳 으로
			return;
		}
		
		
		if(!regx.test(form.passwd.value)) {   // 특수문자  
			alert("비밀번호를 확인 해 주세요");
			form.passwd.focus();   //입력해야 되는곳 으로
			return;
		}
		
		
		if(form.passwd_confirm.value == "") {   //값이 없으면  
			alert("비밀번호를 확인 해 주세요");
			form.passwd_confirm.focus();   //입력해야 되는곳 으로
			return;
		}
	
		
		
		
		if(form.passwd.value != form.passwd_confirm.value) {
			alert("비밀번호가 일치 하지 않습니다");
			form.passwd.value = "";
			form.passwd_confirm.value = "";
			form.passwd.focus();
			return;
		}
		
		if(form.address.value == "") {   //값이 없으면  
			alert("주소를 입력 해 주세요");
			form.address.focus();   //입력해야 되는곳 으로
			return;
		}
		
		if(form.tel.value == "") {   //값이 없으면  
			alert("전화번호를 입력 해 주세요");
			form.tel.focus();   //입력해야 되는곳 으로
			return;
		}
		
		form.submit();
	}
</script>
</head>
<body>
	<div class="container">
		<form id="signup_form" method="post">
			<input type="hidden" name="checkId"> 
			
			<div>
				<label>아이디:</label>               
				<input type="text" name="id"> <button type="button" onclick="check_id_Sync()">중복확인</button>
			</div>
			<div>
				<label>비밀번호:</label> 
				<input type="password" name="passwd">
			</div>
			<div>
				<label>비밀번호 확인:</label>
				<input type="password" name="passwd_confirm">
				<p>(특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식)</p>
			</div>
			<div>
				<label>주소:</label>
				<input type="text" name="address">
			</div>
			<div>
				<label>전화번호:</label>
				<input type="text" name="tel">
			</div>
			<div>
				<button type="button" onclick="signup()">회원가입</button>
			</div>
		</form>
		
	</div>

</body>
</html>