<%@ page import="DTO.StockDTO" %>
<%@ page import="modul.NhaCungCap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modul.User" %><%--
    Document   : stock
    Created on : 06-Dec-2019, 21:25:37
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock Home</title>
    <link rel="stylesheet" href="../Css/stock.css">
</head>
<body>

<%!
    StockDTO stockDTO = null;
    User user = null;
    ArrayList<NhaCungCap> nhaCungCaps = null;
%>

<%
    if(request.getAttribute("stock") != null) {
        stockDTO = (StockDTO) request.getAttribute("stock");
        nhaCungCaps = stockDTO.getNhaCungCaps();
        user = stockDTO.getUser();
    }
%>

<div class="choose-supplier">
    <div class="sub">
        <div class="sub2">
            <div class="text">Chọn nhà cung cấp</div>
            <div class="drop-down">
                <select class="name-supplier">

                    <%
                        for(int i = 0; i < nhaCungCaps.size(); i++) {
                    %>
                        <option value="<%= nhaCungCaps.get(i).getId()%>"> <%= nhaCungCaps.get(i).getTen()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <button class="load" onclick="ChooseSupplier()">Lấy dữ liệu</button>
        </div>
    </div>

</div>
<div class="show-content">
    <div class="listnguyenlieu">
        <div class="title">
            <div class="title-name">Tên nguyên liệu</div>
            <div class="title-unit">Đơn vị tính</div>
            <div class="title-price">Giá thành</div>
            <div class="title-des">Mô tả</div>
        </div>
        <div class="noidung">
<%--            <div class="nguyenlieu" onclick="ChonNL(this)">--%>
<%--                <div class="id" style="display:none"></div>--%>
<%--                <div class="name">Hanh kho</div>--%>
<%--                <div class="unit">kg</div>--%>
<%--                <div class="price">100000</div>--%>
<%--                <div class="des">hanh sieu kho</div>--%>
<%--            </div>--%>



        </div>
    </div>
    <div class="choosed">

        <div class="content-chon">


        </div>
        <div class="title-chon">
            <div style="display: flex">
                <div class="text-tong">Tổng tiền: </div>
                <div class="tongtien">0</div>
            </div>
        </div>
        <div class="button-chon">
            <button class="nhapkho">Nhập kho</button>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="../Script/stock.js"></script>
</body>
</html>
