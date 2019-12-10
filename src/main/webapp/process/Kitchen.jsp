<%@ page import="DTO.KitchenDTO" %>
<%@ page import="modul.User" %>
<%@ page import="modul.FoodOrder" %>
<%@ page import="modul.ComboOrder" %>
<%@ page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/Kitchen.css">
    <title>Kitchen</title>
</head>
<body >


<%!
    KitchenDTO kitchenDTO = new KitchenDTO();
    ArrayList<FoodOrder> foodOrders = new ArrayList<>();
    ArrayList<ComboOrder> comboOrders = new ArrayList<>();
    User user = null;
    String token = null;
%>

<%
    if(request.getAttribute("kitchen") != null) {
        kitchenDTO = (KitchenDTO) request.getAttribute("kitchen");
        foodOrders = kitchenDTO.getFoodOrders();
        comboOrders = kitchenDTO.getComboOrders();
        user = kitchenDTO.getUser();
        token = kitchenDTO.getToken();
    }
%>

<div class="root">
    <div class="content-left">
        <div class="content-left-header">
            <span>Chờ chế biến</span>
        </div>
        <div class="content-left-body" id="food">
            <%
                for(int i = 0; i < 10; i++) {
                    if (foodOrders.get(i).getTrangThai() == FoodOrder.StatusFood.CHO) {
            %>
            <article class="food" id="<%= foodOrders.get(i).getId()%>" >
                <div class="id-food" style="display: none"> </div>
                <p class="food-name"> <%= foodOrders.get(i).getFood().getName()%> </p>
                <div class="food-count"><p>Số lượng: </p><span> <%=foodOrders.get(i).getSoLuong()%></span></div>
                <div class="groud-button">
                    <img src="../Images/right-one.svg" width="20" height="20" onclick="oneclick(this)" >
                    <img src="../Images/right-all.svg" width="20" height="20" onclick="allclick(this)" >
                </div>
            </article>
            <% }} %>

            <%
                for(int i = 0; i < 10; i++) {
                    if (comboOrders.get(i).getTrangThai() == ComboOrder.StatusCombo.CHO) {
            %>
            <article class="food" id="<%= comboOrders.get(i).getId()%>" >
                <div class="id-food" style="display: none"> </div>
                <p class="food-name"> <%= comboOrders.get(i).getCombo().getName()%> </p>
                <div class="food-count"><p>Số lượng: </p><span> <%=comboOrders.get(i).getSoLuong()%></span></div>
                <div class="groud-button">
                    <img src="../Images/right-one.svg" width="20" height="20" onclick="oneclick(this)" >
                    <img src="../Images/right-all.svg" width="20" height="20" onclick="allclick(this)" >
                </div>
            </article>
            <% }} %>

        </div>
    </div>
    <div class="content-right">
        <div class="content-right-header">
            <span>Đã song/Chờ cung ứng</span>
            <div class="menu" onclick="ShowMenu()"></div>
            <div class="detail-menu" >
                <div class="sub-menu kitchen">
                    <div class="sub-text" onclick="quanliClick()">Quản lý</div>
                </div>
                <div class="sub-menu log-out">
                    <div class="sub-text" onclick="dangxuatClick()">Đăng xuất</div>
                </div>
            </div>
        </div>
        <div class="content-right-body" id="waitfood">

        </div>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../Script/Kitchen.js"> </script>
</html>