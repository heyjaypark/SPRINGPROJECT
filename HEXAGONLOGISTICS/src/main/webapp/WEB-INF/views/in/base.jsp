<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
    <div class="banner">
        <div class="banner-logo">
            <a href="/"><img src="/resources/images/logo.png" alt="이미지"></a>
        </div>
        <div class="top">
        <h1>HEXAGON LOGISTICS</h1>
        <div class="banner-login">
            <u:notLogin>
                <a href="/in/loginForm">［ログイン］</a>
            </u:notLogin>
            <u:isLogin>
                ${authUser.name}様ようこそ。
                <a href="/in/logout">[ログアウト]</a>
            </u:isLogin>
            </div>
        </div>
    </div>
    <div class="dashboard">
        <ul>
            <li><a href="/in/ProductList">在庫状況</a>
                <ul>
                    <li><a href="/in/ProductList">在庫目録</a></li>
                    <li><a href="/in/ProductLogList">入庫記録</a></li>
                </ul>
            </li>
            <li><a href="/in/Productregi">在庫管理</a>
                <ul>
                    <li><a href="/in/Productregi">新規登録</a></li>
                    <li><a href="/in/Productupdates">入庫処理</a></li>
                </ul>
            </li>
            <li><a href="/in/RegistSales">販売(出庫)</a>
                <ul>
                    <li><a href="/in/RegistSales">販売登録</a></li>
                    <li><a href="/in/ListSales_overview">出庫履歴</a></li>
                </ul>
            </li>
            <li><a href="/in/listArticle">お知らせ</a>
                <ul>
                    <li><a href="/in/listArticle">投稿目録</a></li>
                    <li><a href="/in/newArticleForm">投稿書き込み</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <script>
    window.onload = function() {
        var currentPath = window.location.pathname;
        var menuItems = document.querySelectorAll('.dashboard ul li ul li a');
        menuItems.forEach(function(item) {
            if (item.href.includes(currentPath)) {
                // 현재 페이지와 일치하는 하위 메뉴 항목에 'active' 클래스 추가
                item.classList.add('active');

                // 해당 하위 메뉴의 상위 메뉴 항목에 'active-parent' 클래스 추가
                var parentLi = item.closest('li').parentNode.closest('li');
                parentLi.classList.add('active-parent');
            }
        });
    };
    </script>