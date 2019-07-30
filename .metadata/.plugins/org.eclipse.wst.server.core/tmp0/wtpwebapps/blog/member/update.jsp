<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>
<br />
<br />

<!--================Contact Area =================-->
<section class="contact_area p_120">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form class="row contact_form" action="/blog/member?cmd=updateProc" method="post" id="contactForm" novalidate="novalidate" onsubmit="return validateCheck()">
					<div class="col-md-12">
						<div class="form-group">
							<input type="text" class="form-control" id="username" name="username" placeholder="아이디를 입력하세요." required="required" maxlength="20" readonly="readonly" value="${member.username}">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요." required="required" maxlength="20">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" placeholder="동일한 비밀번호를 입력하세요." required="required" maxlength="20">
						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="email" class="form-control" id="email" name="email" placeholder="이메일을 입력하세요." required="required" maxlength="40" value="${member.email}">
						</div>
					</div>
					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">MyPage</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<script>
	function validateCheck() { //자바스크립트 5 문법
		//아이디 체크
		var username = document.querySelector('#username').value;
		if (username.length == 0) {
			alert("아이디가 입력되지 않았습니다.");
			return false;
		}
		//패스워드 체크
		var password = document.querySelector('#password').value;
		var passwordCheck = document.querySelector('#passwordCheck').value;
		if (password === passwordCheck) { //값과 타입 비교 ===
			return true;
		} else {
			alert("비밀번호가 동일하지 않습니다.");
			return false;
		}
	}
</script>
<!--================Contact Area =================-->

<%@ include file="/include/footer.jsp"%>