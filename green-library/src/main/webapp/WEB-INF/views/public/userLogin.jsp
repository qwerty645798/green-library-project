<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="/css/public/header.css" type="text/css" rel="stylesheet">
<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
<link href="/css/public/nav.css" type="text/css" rel="stylesheet">
<link href="/css/userLogin.css" type="text/css" rel="stylesheet">
<script>
	let error = "${param.error}";
	if(error == "true")
		alert("회원정보가 일치하지 않습니다.");
	let message = "${message}";
	if(message)
		alert(message);
	let auth = "${param.auth}";
	if(auth == "none")
		alert("인증된 사용자가 존재하지 않습니다.")
</script>
</head>
<body> 
	<jsp:include page="../index/header.jsp" />
	<nav class="bannerBgr">
		<div class="Banner">
			<div class="pageTitle">로그인</div>
			<div class="pageRoute">홈 > 로그인</div> 
		</div>
	</nav>
	
	<h1>Member Login<br>
	<span class="loginTop">로그인을 하시면 더 많은 도서관 서비스를 이용할 수 있습니다.</span>
	</h1>
	<br>
	<div class="loginConOut">
	<div class="loginCon1">

	
	<main style="display:flex; justify-content:center;">
		
		<form action="${pageContext.request.contextPath}/login" method="post" id="form">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="loginCon2">
			<div class="floor"><input type="text" placeholder="아이디" name="id" class="text" id="id"><br></div>
			<div class="floor"><input type="password" placeholder="비밀번호" name="pass" class="text" id="pw"><br></div>
			<div class="floor"><input type="checkbox" id="remember-me" name="remember-me">
			<label for="remember-me">아이디 저장</label> 
			<div style="width:120px; display:inline-block"> </div> <a href="userFinding">아이디 찾기</a> 
			/ <a href="userFinding">비밀번호 초기화</a></div>
			<div class="floor" style="text-align:center;">
			
			<input type="submit" value="로그인" >
			
			<sec:authorize access="!isAuthenticated()">
			<a href="userAgreement">
			<input type="button" value="회원가입" >
			</a>
			</sec:authorize>
			
			</div>
		</div>
		
		</form>
		
		<div class="attention">
		<ul>
			<li>아이디, 비밀번호를 모르거나 분실한 경우 
			아이디/비밀번호 찾기 서비스를 이용하시기 바랍니다.</li>
			<li>아직 그린도서관 회원이 아니라면 회원가입을 먼저 진행해주세요.</li>
			<li>개인정보보호를 위하여 도서관 홈페이지 서비스를 이용하신 후 반드시 [로그아웃]을 하시기 바랍니다.</li>
			<li>로그인을 하시면 더 많은 도서관 서비스를 이용할 수 있습니다.</li>
		</ul>
		
		</div>
	</main>
	</div>
	</div>
	
	
	<jsp:include page="../index/footer.jsp" />
	<script src="/js/userLogin.js"></script>
</body>
</html>