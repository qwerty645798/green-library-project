<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인기 도서</title>

<style>

.book_container {
    display: flex;
    width: 1600px;
    height: 300px;
    margin: 0 auto;
	margin-top: 10px;
}

.book_image {
    width: 200px;
    border: 2px solid red;
}

.book_table {
    width: 1400px;
}

table {
    border-collapse: collapse;
    width: 1200px;
	height: 300px;
    margin: 0 auto;
}

td {
    width: 300px;
}

th {
    width: 300px;
    text-align: center;
}

td, th{
    border: 1px solid gray;
}

</style>

</head>
<body>

<header id="header" class="header"></header>

<main><!-- 페이지내 들어갈 개수 / 현재(3개) -->

<!-- 개별 기본 폼 -->
<div class="book_container">
	<div class="book_image">
		<!-- 이미지 -->
	</div>
	<div class="book_table">
		<table>
			<tr>
				<th>책 제목</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>저자명</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
			</tr>
			<tr>
				<!-- form-submit? 아니면 그냥 button?  -->
				<th colspan="4"><a href="bookDetail.jsp">자세히 보기</a></th> 
			</tr>
		</table>
	</div>
</div>

<!-- 개별 기본 폼 -->
<div class="book_container">
	<div class="book_image">
		<!-- 이미지 -->
	</div>
	<div class="book_table">
		<table>
			<tr>
				<th>책 제목</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>저자명</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
			</tr>
			<tr>
				<th colspan="4"><a href="bookDetail.jsp">자세히 보기</a></th>
			</tr>
		</table>
	</div>
</div>

<!-- 개별 기본 폼 -->
<div class="book_container">
	<div class="book_image">
		<!-- 이미지 -->
	</div>
	<div class="book_table">
		<table>
			<tr>
				<th>책 제목</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>저자명</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4">대출 가능/불가<!-- 대출 가능/불가 여부 확인 후 출력되어있는 기능 --></td>
			</tr>
			<tr>
				<th colspan="4"><a href="bookDetail.jsp">자세히 보기</a></th>
			</tr>
		</table>
	</div>
</div>

</main>

<footer id="footer" class="footer"></footer>

</body>
</html>