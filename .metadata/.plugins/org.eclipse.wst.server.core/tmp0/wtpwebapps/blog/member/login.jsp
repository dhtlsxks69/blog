<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<br />
<br />
<!--================Contact Area =================-->

<section class="contact_area p_120">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form class="row contact_form" action="/blog/member?cmd=loginProc" method="post" id="contactForm" novalidate="novalidate" onsubmit="return validateCheck()">
					<div class="col-md-12">
						<div class="form-group">
							<c:choose>
								<c:when test="${empty rememberMe}">
									<input type="text" class="form-control" id="username" name="username" placeholder="아이디를 입력하세요." required="required" maxlength="20">
								</c:when>
								<c:otherwise>
									<input type="text" class="form-control" id="username" name="username" placeholder="아이디를 입력하세요." required="required" maxlength="20" value="${rememberMe}">
								</c:otherwise>
							</c:choose>


						</div>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요." required="required" maxlength="20">
						</div>
					</div>

					<div class="col-md-12 text-right">
						<div class="custom-control custom-switch">
							<input type="checkbox" class="custom-control-input" id="switch1" name="rememberMe"> <label class="custom-control-label" for="switch1">Remember me</label>
						</div>
					</div>

					<div class="col-md-12 text-right">
						<button type="submit" value="submit" class="btn submit_btn">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<script>
	function KoCheck(username) {
		var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		if (check.test(username)) {
			return true;
		} else {
			return false;
		}
	}

	function validateCheck() { //자바스크립트 5
		//아이디 길이체크
		var username = document.querySelector('#username').value;
		if (username.length == 0) {
			alert("아이디가 입력되지 않았습니다.");
			return false;
		}
		//아이디 한글체크
		if (KoCheck(username)) {
			alert("아이디에 한글을 적을 수 없습니다.");
			return false;
		}

		//패스워드 길이체크	
		var password = document.querySelector('#password').value;
		if (password.length == 0) {
			alert("패스워드가 입력되지 않았습니다.");
			return false;
		}
	}
</script>
<!--================Contact Area =================-->
<%@ include file="/include/footer.jsp"%>