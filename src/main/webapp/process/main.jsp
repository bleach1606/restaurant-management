<%@ page import="DTO.Reception" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modul.Table" %>
<%@ page import="modul.Food" %>
<%@ page import="modul.Combo" %>
<%@ page import="DTO.ii" %><%--
    Document   : main
    Cated on : 20-Nov-2019, 21:48:55
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="../Css/main.css">
</head>
<body>


<%!
    Reception reception = null;
    ArrayList<Table> tables = null;
    ArrayList<Food> foods = null;
    ArrayList<Combo> combos = null;
    ArrayList<ii> usedFloos = null;
    ArrayList<ii> usedCombos = null;
%>

<%
    if(request.getAttribute("reception") != null) {
        reception = (Reception) request.getAttribute("reception");
        tables = reception.getTables();
        foods = reception.getFoods();
        combos = reception.getCombos();
    }
%>


<div class="common">
    <div class="header">
        <div class="header-left">
            <div class="taps">
                <div class="tap-table tap color" onclick="TapTable()" ><span class="text-table">PHÒNG BÀN</span></div>
                <div class="tap-menu tap hover" onclick="TapMenu()"><span class="text-menu">THỰC ĐƠN</span></div>
            </div>
            <div class="search">
                <div class="wrap-search">
                    <div class="icon-search"></div>
                    <div class="input-search">
                        <input placeholder="Tìm sản phẩm">
                    </div>
                </div>
            </div>
        </div>
        <div class="header-right">
            <div class="header-right-left">
                <div class="voucher">
                    <div class="text-voucher">Hóa đơn</div>
                    <!--<div class="icon-voucher"></div>-->
                </div>
                <!--                        <div class="add-voucher"></div>-->
            </div>
            <div class="header-right-right">
                <div class="name-account"></div>
                <div class="menu" onclick="ShowMenu()"></div>

                <div class="detail-menu" >
                    <div class="sub-menu kitchen">
                        <div class="sub-text">Nhà bếp</div>
                    </div>
                    <div class="sub-menu log-out">
                        <div class="sub-text">Đăng xuất</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="content-left">
            <div class="content-table">
                <div class="button-table">
                    <div class="list-button">
                        <button class="btnTable all bgButton" onclick="clickAll()">
                            Tất cả
                        </button>
                        <button class="btnTable floor1 hoverButton" onclick="clickFloor1()">
                            Tầng 1
                        </button>
                        <button class="btnTable floor2 hoverButton" onclick="clickFloor2()">
                            Tầng 2
                        </button>
                        <button class="btnTable roomVip hoverButton" onclick="clickVip()">
                            Phòng VIP
                        </button>
                    </div>
                </div>
                <div class="content-table-main">
                    <div class="table-all">
                        <% for(int i = 0; i < reception.getTables().size(); i++) { %>
                        <div class="table table-hover" onclick="ChooseTable(this)">
                            <div class="icon-table"></div>
                            <div class="description-table"><%= tables.get(i).getNameTable()%></div>
                        </div>
                        <% } %>
                    </div>
                    <div class="table-floor1 display"></div>
                    <div class="table-floor2 display"></div>
                    <div class="table-vip display"></div>
                </div>

                <div class="content-table-footer"></div>
            </div>
            <div class="content-menu display">
                <div class="button-menu">
                    <div class="list-button">
                        <button class="btnTable allMenu bgButton" onclick="clickAllMenu()">
                            Tất cả
                        </button>
                        <button class="btnTable beer hoverButton" onclick="clickBeer()">
                            BIA & THUỐC LÁ
                        </button>
                        <button class="btnTable cocktail hoverButton" onclick="clickCocktail()">
                            CLASSIC COCKTAILS
                        </button>
                        <button class="btnTable appetizer hoverButton" onclick="clickAppetizer()">
                            MÓN KHAI VỊ
                        </button>
                        <button class="btnTable soup hoverButton" onclick="clickSoup()">
                            SÚP
                        </button>
                        <button class="btnTable tea hoverButton" onclick="clickTea()">
                            TEA
                        </button>
                    </div>
                </div>
                <div class="content-table-main">
                    <div class="table-allMenu">

                        <% for(int i = 0; i < foods.size(); i++) { %>
                        <div class="food food-hover" onclick="ChooseFood(this)">
                            <div class="id-food" style="display:none"> <%= foods.get(i).getId()%></div>
                            <div class="icon-food"></div>
                            <div class="description-food"> <%= foods.get(i).getName()%> </div>
                            <div class="price-food"><b class="bold"><%= foods.get(i).getValue()%></b></div>
                        </div>
                        <% } %>

                        <% for(int i = 0; i < combos.size(); i++) { %>
                        <div class="food food-hover" onclick="ChooseFood(this)">
                            <div class="id-food" style="display:none"> <%= foods.get(i).getId()%></div>
                            <div class="icon-food"></div>
                            <div class="description-food"> <%= combos.get(i).getName()%> </div>
                            <div class="price-food"><b class="bold"><%= combos.get(i).getValue()%></b></div>
                        </div>
                        <% } %>

                    </div>
                    <div class="table-beer display"></div>
                    <div class="table-cocktail display"></div>
                    <div class="table-appetizer display"></div>
                    <div class="table-soup display"></div>
                    <div class="table-tea display"></div>
                </div>
                <div class="content-table-footer"></div>
            </div>
        </div>
        <div class="content-right">
            <div class="voucher-common">
                <div class="info-voucher">
                    <div class="info-table"><span class="idname">Bàn 1</span></div>
                    <div class="search-voucher">
                        <div class="icon-search"></div>
                        <div class="search-customer">
                            <input placeholder="Tìm khách hàng">
                        </div>
                        <div class="add-customer"></div>
                    </div>
                    <div class="amount">
                        <div class="icon-amount"></div>
                        <div class="input-amount"><input></div>
                    </div>
                </div>
                <div class="scroll-voucher">
                    <div class="info-main-voucher" style="display:block"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                    <div class="info-main-voucher"></div>
                </div>

                <div class="payment-voucher">
                    <div class="payment-voucher-left"></div>
                    <div class="payment-voucher-right">
                        <span class="text-total">Tổng tiền:</span>
                        <span class="total-money"><b class="bold-total-money">0</b></span>
                    </div>
                </div>
                <div class="button-voucher">
                    <button class="button-pay" onclick="Payment()">Thanh toán</button>
                    <button class="button-notify" onclick="Notify()" disabled>Thông báo</button>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="hide-menu" onclick="HideMenu()"></div>
<div class="payment-content" onclick="HidePayment()"></div>
<div class="bill">
    <div class="title-bill"><span class="title-text">Phiếu thanh toán</span></div>
    <div class="list-food-bill">
        <div class="name-table">Bàn 1</div>
        <div class="scroll">
            <div class="detail-list-food">

            </div>
        </div>

    </div>
    <div class="money-bill">
        <div class="date"></div>
        <div class="content-payment">
            <div class="tong">
                <div class="tong-text">Tổng tiền hàng</div>
                <div class="tong-number"></div>
            </div>
            <div class="discount">
                <div class="discount-text">Giảm giá</div>
                <div class="discount-number"><input class="input-discount" value="0" onkeyup="KeyUpDiscount()" ></div>
            </div>
            <div class="money-need">
                <div class="money-need-text"><b class="bold-need">Khách cần trả</b></div>
                <div class="money-need-number"></div>
            </div>
            <div class="customer-pay">
                <div class="customer-pay-text">Khách thanh toán</div>
                <div class="customer-pay-number"><input class="input-pay" value="0" onkeyup="KeyUpPay()"></div>
            </div>
            <div class="cash">
                <div class="cash-text">Tiền thừa trả khách</div>
                <div class="cash-number"><b class="bold-cash">0</b></div>
            </div>
        </div>
        <div class="button-payment"><button class="buttonP" onclick="EndPayment()">Thanh toán</button></div>

    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="../Script/main.js"></script>
</body>
</html>
