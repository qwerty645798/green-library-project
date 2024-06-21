<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>문의글 작성</title>

<link rel="stylesheet" type="text/css" href="css/public/nav.css">
<link rel="stylesheet" type="text/css" href="css/userInquiryCreate.css">

<script>
function validateForm() {
    var userIdInput = document.querySelector('input[name="user_id"]');
    var inquiryTitle = document.querySelector('input[name="inquiry_title"]');
    var contents = document.querySelector('textarea[name="contents"]');
    var hiddenUserId = document.querySelector('input[name="userId"]').value;

    if (userIdInput.value.trim() === '') {
        alert('아이디를 입력해주세요.');
        userIdInput.focus();
        return false;
    }
    if (inquiryTitle.value.trim() === '') {
        alert('제목을 입력해주세요.');
        inquiryTitle.focus();
        return false;
    }
    if (contents.value.trim() === '') {
        alert('내용을 입력해주세요.');
        contents.focus();
        return false;
    }
    if (userIdInput.value.trim() !== hiddenUserId.trim()) {
        alert('아이디가 일치하지 않습니다.');
        userIdInput.focus();
        return false;
    }
    return true;
}
	
	function lets_cancel(){
		if( confirm("취소하시겠습니까? 작성한 내용은 저장되지 않습니다.")){
			window.location.href="myWritten";			
		}
	}
</script>

</head>


<body>


<div class="bannerBgr">
    <div class="Banner">
        <div class="pageTitle">문의하기</div> <div class="pageRoute">홈 > 마이페이지 > 문의하기</div>
    </div>
</div>

<header id="header" class="header"></header>



<main>

<form action="inquiryCreate" method="post" onsubmit="return validateForm()">
<input type="hidden" name="userId" value="${userId}">

<div class="first_container">
	<div class="table_container">
		<table>
			<tr>
				<th class="con_table_top"></th>
				<td class="con_table_top"><p class="great_p">&nbsp;*&nbsp;</p>표시 항목은 필수 입력 항목입니다.</td>
			</tr>
			<tr>
				<th><p class="great_p">&nbsp;*&nbsp;</p> 아이디</th>
				<td><input type="text" size="10" style="height:20px;" name="user_id" value="${userId}"></td>
			</tr>
			<tr>
				<th><p class="great_p">&nbsp;*&nbsp;</p> 제목</th>
				<td><input type="text" style="height:20px;width:95%;" name="inquiry_title"></td>
			</tr>
			<tr>
				<th><p class="great_p">&nbsp;*&nbsp;</p> 내용</th>
				<td><textarea rows="20" style="width:95%; resize:none;" name="contents"></textarea></td> 
			</tr>
		</table>
	</div>
</div>

<div class="second_container">
	<div class="button_container">
		<input type="button" value="취소하기" onclick="lets_cancel()">
		<input type="submit" value="등록하기">
	</div>
</div>
	
</form>


</main>

<footer id="footer" class="footer"></footer>


</body>
</html>