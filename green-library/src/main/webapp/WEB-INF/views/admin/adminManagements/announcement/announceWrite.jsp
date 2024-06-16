<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>announceWrite</title>
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/reset.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminHeader.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/adminFooter.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/public/style.css">
        <link rel="stylesheet" type="text/css" href="/resources/static/admin/css/announWrite.css">
    </head>

    <body>
        <header class="header" id="header"></header>
        <main>
            <section class="banner">
                <h3>공지 작성</h3>
                <p>home > management > announcement > write</p>
            </section>
            <section class="viewContainer">
                <table class="announcementInfo">
                    <tr>
                        <th>번호</th>
                        <td id="writdIdx"></td>
                    </tr>
                    <tr>
                        <th>제목 <span>*</span></th>
                        <td id="writdTitle"><input type="text" name="" id=""></td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td id="writerId">작성자 ID</td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td id="writeDate">작성일</td>
                    </tr>
                    <tr>
                        <th>내용 <span>*</span></th>
                        <td id="contents">
                            <textarea name="" id=""></textarea>
                        </td>
                    </tr>
                    <tr id="fileRow">
                        <th>첨부 파일</th>
                        <td>
                            <input type="file" name="" id="">
                        </td>
                    </tr>
                </table>
                <div class="btnWrap">
                    <input class="modiBtn" type="button" value="목록">
                    <input class="deleteBtn" type="button" value="등록">
                </div>
            </section>
        </main>
        <footer class="footer" id="footer"></footer>
    </body>

</html>