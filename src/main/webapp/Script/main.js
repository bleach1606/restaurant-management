function TapMenu(){
    var tapMenu=document.getElementsByClassName("tap-menu");
    var tapTable=document.getElementsByClassName("tap-table");
    var textTable=document.getElementsByClassName("text-table");
    var textMenu=document.getElementsByClassName("text-menu");
    var contentTable=document.getElementsByClassName("content-table");
    var contentMenu=document.getElementsByClassName("content-menu");
    textMenu[0].style.color="black";
    textTable[0].style.color="rgba(255,255,255,.6)";
    tapMenu[0].classList.add("color");
    tapMenu[0].classList.remove("hover");
    tapTable[0].classList.add("hover");
    tapTable[0].classList.remove("color");
    contentMenu[0].classList.remove("display");
    contentTable[0].classList.add("display");
}
function TapTable(){
    var contentTable=document.getElementsByClassName("content-table");
    var contentMenu=document.getElementsByClassName("content-menu");
    var tapMenu=document.getElementsByClassName("tap-menu");
    var tapTable=document.getElementsByClassName("tap-table");
    var textTable=document.getElementsByClassName("text-table");
    var textMenu=document.getElementsByClassName("text-menu");

    textTable[0].style.color="black";
    textMenu[0].style.color="rgba(255,255,255,.6)";
    tapTable[0].classList.add("color");
    tapTable[0].classList.remove("hover");
    tapMenu[0].classList.add("hover");
    tapMenu[0].classList.remove("color");
    contentTable[0].classList.remove("display");
    contentMenu[0].classList.add("display");

}
function clickAll(){
    var btnAll=document.getElementsByClassName("all");
    var btnFloor1=document.getElementsByClassName("floor1");
    var btnFloor2=document.getElementsByClassName("floor2");
    var btnVip=document.getElementsByClassName("roomVip");
    var tableAll=document.getElementsByClassName("table-all");
    var tableFloor1=document.getElementsByClassName("table-floor1");
    var tableFloor2=document.getElementsByClassName("table-floor2");
    var tableVip=document.getElementsByClassName("table-vip");
    btnAll[0].classList.add("bgButton");
    btnAll[0].classList.remove("hoverButton");
    btnFloor1[0].classList.add("hoverButton");
    btnFloor1[0].classList.remove("bgButton");
    btnFloor2[0].classList.add("hoverButton");
    btnFloor2[0].classList.remove("bgButton");
    btnVip[0].classList.add("hoverButton");
    btnVip[0].classList.remove("bgButton");
    tableAll[0].classList.remove("display");
    tableFloor1[0].classList.add("display");
    tableFloor2[0].classList.add("display");
    tableVip[0].classList.add("display");
}
function clickFloor1(){
    var btnAll=document.getElementsByClassName("all");
    var btnFloor1=document.getElementsByClassName("floor1");
    var btnFloor2=document.getElementsByClassName("floor2");
    var btnVip=document.getElementsByClassName("roomVip");
    var tableAll=document.getElementsByClassName("table-all");
    var tableFloor1=document.getElementsByClassName("table-floor1");
    var tableFloor2=document.getElementsByClassName("table-floor2");
    var tableVip=document.getElementsByClassName("table-vip");
    btnFloor1[0].classList.add("bgButton");
    btnFloor1[0].classList.remove("hoverButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    btnFloor2[0].classList.add("hoverButton");
    btnFloor2[0].classList.remove("bgButton");
    btnVip[0].classList.add("hoverButton");
    btnVip[0].classList.remove("bgButton");
    tableFloor1[0].classList.remove("display");
    tableAll[0].classList.add("display");
    tableFloor2[0].classList.add("display");
    tableVip[0].classList.add("display");
}
function clickFloor2(){
    var btnAll=document.getElementsByClassName("all");
    var btnFloor1=document.getElementsByClassName("floor1");
    var btnFloor2=document.getElementsByClassName("floor2");
    var btnVip=document.getElementsByClassName("roomVip");
    var tableAll=document.getElementsByClassName("table-all");
    var tableFloor1=document.getElementsByClassName("table-floor1");
    var tableFloor2=document.getElementsByClassName("table-floor2");
    var tableVip=document.getElementsByClassName("table-vip");
    btnFloor2[0].classList.add("bgButton");
    btnFloor2[0].classList.remove("hoverButton");
    btnFloor1[0].classList.add("hoverButton");
    btnFloor1[0].classList.remove("bgButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    btnVip[0].classList.add("hoverButton");
    btnVip[0].classList.remove("bgButton");
    tableFloor2[0].classList.remove("display");
    tableFloor1[0].classList.add("display");
    tableAll[0].classList.add("display");
    tableVip[0].classList.add("display");
}
function clickVip(){
    var btnAll=document.getElementsByClassName("all");
    var btnFloor1=document.getElementsByClassName("floor1");
    var btnFloor2=document.getElementsByClassName("floor2");
    var btnVip=document.getElementsByClassName("roomVip");
    var tableAll=document.getElementsByClassName("table-all");
    var tableFloor1=document.getElementsByClassName("table-floor1");
    var tableFloor2=document.getElementsByClassName("table-floor2");
    var tableVip=document.getElementsByClassName("table-vip");
    btnVip[0].classList.add("bgButton");
    btnVip[0].classList.remove("hoverButton");
    btnFloor1[0].classList.add("hoverButton");
    btnFloor1[0].classList.remove("bgButton");
    btnFloor2[0].classList.add("hoverButton");
    btnFloor2[0].classList.remove("bgButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    tableVip[0].classList.remove("display");
    tableFloor1[0].classList.add("display");
    tableFloor2[0].classList.add("display");
    tableAll[0].classList.add("display");
}
function clickAllMenu(){
    var btnAll=document.getElementsByClassName("allMenu");
    var btnBeer=document.getElementsByClassName("beer");
    var btnCocktail=document.getElementsByClassName("cocktail");
    var btnAppetizer=document.getElementsByClassName("appetizer");
    var btnSoup=document.getElementsByClassName("soup");
    var btnTea=document.getElementsByClassName("tea");
    var tableAllMenu=document.getElementsByClassName("table-allMenu");
    var tableBeer=document.getElementsByClassName("table-beer");
    var tableCocktail=document.getElementsByClassName("table-cocktail");
    var tableAppetizer=document.getElementsByClassName("table-appetizer");
    var tableSoup=document.getElementsByClassName("table-soup");
    var tableTea=document.getElementsByClassName("table-tea");
    btnAll[0].classList.add("bgButton");
    btnAll[0].classList.remove("hoverButton");
    btnBeer[0].classList.add("hoverButton");
    btnBeer[0].classList.remove("bgButton");
    btnCocktail[0].classList.add("hoverButton");
    btnCocktail[0].classList.remove("bgButton");
    btnAppetizer[0].classList.add("hoverButton");
    btnAppetizer[0].classList.remove("bgButton");
    btnSoup[0].classList.add("hoverButton");
    btnSoup[0].classList.remove("bgButton");
    btnTea[0].classList.add("hoverButton");
    btnTea[0].classList.remove("bgButton");
    tableAllMenu[0].classList.remove("display");
    tableBeer[0].classList.add("display");
    tableCocktail[0].classList.add("display");
    tableAppetizer[0].classList.add("display");
    tableSoup[0].classList.add("display");
    tableTea[0].classList.add("display");
}
function clickBeer(){
    var btnAll=document.getElementsByClassName("allMenu");
    var btnBeer=document.getElementsByClassName("beer");
    var btnCocktail=document.getElementsByClassName("cocktail");
    var btnAppetizer=document.getElementsByClassName("appetizer");
    var btnSoup=document.getElementsByClassName("soup");
    var btnTea=document.getElementsByClassName("tea");
    var tableAllMenu=document.getElementsByClassName("table-allMenu");
    var tableBeer=document.getElementsByClassName("table-beer");
    var tableCocktail=document.getElementsByClassName("table-cocktail");
    var tableAppetizer=document.getElementsByClassName("table-appetizer");
    var tableSoup=document.getElementsByClassName("table-soup");
    var tableTea=document.getElementsByClassName("table-tea");
    btnBeer[0].classList.add("bgButton");
    btnBeer[0].classList.remove("hoverButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    btnCocktail[0].classList.add("hoverButton");
    btnCocktail[0].classList.remove("bgButton");
    btnAppetizer[0].classList.add("hoverButton");
    btnAppetizer[0].classList.remove("bgButton");
    btnSoup[0].classList.add("hoverButton");
    btnSoup[0].classList.remove("bgButton");
    btnTea[0].classList.add("hoverButton");
    btnTea[0].classList.remove("bgButton");
    tableBeer[0].classList.remove("display");
    tableAllMenu[0].classList.add("display");
    tableCocktail[0].classList.add("display");
    tableAppetizer[0].classList.add("display");
    tableSoup[0].classList.add("display");
    tableTea[0].classList.add("display");
}
function clickCocktail(){
    var btnAll=document.getElementsByClassName("allMenu");
    var btnBeer=document.getElementsByClassName("beer");
    var btnCocktail=document.getElementsByClassName("cocktail");
    var btnAppetizer=document.getElementsByClassName("appetizer");
    var btnSoup=document.getElementsByClassName("soup");
    var btnTea=document.getElementsByClassName("tea");
    var tableAllMenu=document.getElementsByClassName("table-allMenu");
    var tableBeer=document.getElementsByClassName("table-beer");
    var tableCocktail=document.getElementsByClassName("table-cocktail");
    var tableAppetizer=document.getElementsByClassName("table-appetizer");
    var tableSoup=document.getElementsByClassName("table-soup");
    var tableTea=document.getElementsByClassName("table-tea");
    btnCocktail[0].classList.add("bgButton");
    btnCocktail[0].classList.remove("hoverButton");
    btnBeer[0].classList.add("hoverButton");
    btnBeer[0].classList.remove("bgButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    btnAppetizer[0].classList.add("hoverButton");
    btnAppetizer[0].classList.remove("bgButton");
    btnSoup[0].classList.add("hoverButton");
    btnSoup[0].classList.remove("bgButton");
    btnTea[0].classList.add("hoverButton");
    btnTea[0].classList.remove("bgButton");
    tableCocktail[0].classList.remove("display");
    tableBeer[0].classList.add("display");
    tableAllMenu[0].classList.add("display");
    tableAppetizer[0].classList.add("display");
    tableSoup[0].classList.add("display");
    tableTea[0].classList.add("display");
}
function clickAppetizer(){
    var btnAll=document.getElementsByClassName("allMenu");
    var btnBeer=document.getElementsByClassName("beer");
    var btnCocktail=document.getElementsByClassName("cocktail");
    var btnAppetizer=document.getElementsByClassName("appetizer");
    var btnSoup=document.getElementsByClassName("soup");
    var btnTea=document.getElementsByClassName("tea");
    var tableAllMenu=document.getElementsByClassName("table-allMenu");
    var tableBeer=document.getElementsByClassName("table-beer");
    var tableCocktail=document.getElementsByClassName("table-cocktail");
    var tableAppetizer=document.getElementsByClassName("table-appetizer");
    var tableSoup=document.getElementsByClassName("table-soup");
    var tableTea=document.getElementsByClassName("table-tea");
    btnAppetizer[0].classList.add("bgButton");
    btnAppetizer[0].classList.remove("hoverButton");
    btnBeer[0].classList.add("hoverButton");
    btnBeer[0].classList.remove("bgButton");
    btnCocktail[0].classList.add("hoverButton");
    btnCocktail[0].classList.remove("bgButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    btnSoup[0].classList.add("hoverButton");
    btnSoup[0].classList.remove("bgButton");
    btnTea[0].classList.add("hoverButton");
    btnTea[0].classList.remove("bgButton");
    tableAppetizer[0].classList.remove("display");
    tableBeer[0].classList.add("display");
    tableCocktail[0].classList.add("display");
    tableAllMenu[0].classList.add("display");
    tableSoup[0].classList.add("display");
    tableTea[0].classList.add("display");
}
function clickSoup(){
    var btnAll=document.getElementsByClassName("allMenu");
    var btnBeer=document.getElementsByClassName("beer");
    var btnCocktail=document.getElementsByClassName("cocktail");
    var btnAppetizer=document.getElementsByClassName("appetizer");
    var btnSoup=document.getElementsByClassName("soup");
    var btnTea=document.getElementsByClassName("tea");
    var tableAllMenu=document.getElementsByClassName("table-allMenu");
    var tableBeer=document.getElementsByClassName("table-beer");
    var tableCocktail=document.getElementsByClassName("table-cocktail");
    var tableAppetizer=document.getElementsByClassName("table-appetizer");
    var tableSoup=document.getElementsByClassName("table-soup");
    var tableTea=document.getElementsByClassName("table-tea");
    btnSoup[0].classList.add("bgButton");
    btnSoup[0].classList.remove("hoverButton");
    btnBeer[0].classList.add("hoverButton");
    btnBeer[0].classList.remove("bgButton");
    btnCocktail[0].classList.add("hoverButton");
    btnCocktail[0].classList.remove("bgButton");
    btnAppetizer[0].classList.add("hoverButton");
    btnAppetizer[0].classList.remove("bgButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    btnTea[0].classList.add("hoverButton");
    btnTea[0].classList.remove("bgButton");
    tableSoup[0].classList.remove("display");
    tableBeer[0].classList.add("display");
    tableCocktail[0].classList.add("display");
    tableAppetizer[0].classList.add("display");
    tableAllMenu[0].classList.add("display");
    tableTea[0].classList.add("display");
}
function clickTea(){
    var btnAll=document.getElementsByClassName("allMenu");
    var btnBeer=document.getElementsByClassName("beer");
    var btnCocktail=document.getElementsByClassName("cocktail");
    var btnAppetizer=document.getElementsByClassName("appetizer");
    var btnSoup=document.getElementsByClassName("soup");
    var btnTea=document.getElementsByClassName("tea");
    var tableAllMenu=document.getElementsByClassName("table-allMenu");
    var tableBeer=document.getElementsByClassName("table-beer");
    var tableCocktail=document.getElementsByClassName("table-cocktail");
    var tableAppetizer=document.getElementsByClassName("table-appetizer");
    var tableSoup=document.getElementsByClassName("table-soup");
    var tableTea=document.getElementsByClassName("table-tea");
    btnTea[0].classList.add("bgButton");
    btnTea[0].classList.remove("hoverButton");
    btnBeer[0].classList.add("hoverButton");
    btnBeer[0].classList.remove("bgButton");
    btnCocktail[0].classList.add("hoverButton");
    btnCocktail[0].classList.remove("bgButton");
    btnAppetizer[0].classList.add("hoverButton");
    btnAppetizer[0].classList.remove("bgButton");
    btnSoup[0].classList.add("hoverButton");
    btnSoup[0].classList.remove("bgButton");
    btnAll[0].classList.add("hoverButton");
    btnAll[0].classList.remove("bgButton");
    tableTea[0].classList.remove("display");
    tableBeer[0].classList.add("display");
    tableCocktail[0].classList.add("display");
    tableAppetizer[0].classList.add("display");
    tableSoup[0].classList.add("display");
    tableAllMenu[0].classList.add("display");
}
function ChooseTable(ok){
    var destable=document.getElementsByClassName("description-table");
    var green=document.getElementsByClassName("bgGreen");
    var tableicon=document.getElementsByClassName("icon-table");
    var table=document.getElementsByClassName("table");
    var index=0;
    var i=0;
    var j=0;
    var len=table.length;
    var lenicon=tableicon.length;
    for(i=0;i<len;i++){
        table[i].classList.remove("table-click");

        if(table[i]===ok){
            index=i;
        }
    }
    var idname=destable[index].innerHTML;
    var transname=document.getElementsByClassName("idname");
    transname[0].innerHTML=idname;
    for(j=0;j<lenicon;j++){
        if(tableicon[j].style.backgroundImage!=='url("Images/table-green.png")'){
            tableicon[j].style.backgroundImage="url(Images/table-black.png)";
        }
    }
    for (var m = 0; m < green.length; m++) {
        if(green[m].parentNode!==ok){
            var notify= document.getElementsByClassName("button-notify");
            notify[0].setAttribute("disabled","disabled");
            notify[0].style.cursor="not-allowed";
            notify[0].style.opacity="0.7";
        }else{
            var notify= document.getElementsByClassName("button-notify");
            notify[0].removeAttribute("disabled");
            notify[0].style.cursor="pointer";
            notify[0].style.opacity="1";
            break;
        }
    }

    ok.classList.add("table-click");
    tableicon[index].style.backgroundImage="url(Images/table-red.png)";
    var voucher=document.getElementsByClassName("info-main-voucher");
    for (var j = 0; j < len; j++) {
        voucher[j].style.display="none";
    }
    voucher[index].style.display="block";
    calTotal();
}
function ShowMenu(){
    var detailMenu=document.getElementsByClassName("detail-menu");
    var hideMenu=document.getElementsByClassName("hide-menu");
    detailMenu[0].classList.toggle("display-detail-menu");
    hideMenu[0].classList.toggle("display-detail-menu");
}
function Notify(){

    var voucher=document.getElementsByClassName("info-main-voucher");
    var table= document.getElementsByClassName("icon-table");
    var itable=0;
    for (var k = 0; k < table.length; k++) {
        if(table[k].style.backgroundImage==='url("Images/table-red.png")'){
            itable=k;
        }
    }
    var listFood = [];
    var listCombo = [];
    var Food = {
        id  : "",
        amount : ""
    };
    var id=voucher[itable].getElementsByClassName("id");
    var name=voucher[itable].getElementsByClassName("name-food");
    var gia=voucher[itable].getElementsByClassName("gia");
    var length=id.length;
    for (var j = 0; j < length; j++) {
        Food.id= id[j].innerHTML;
        Food.amount=gia[j].value.toString();
        if(name[j].innerHTML.indexOf("Combo")>=0){
            listCombo.push(Food);
        }else{
            listFood.push(Food);
        }
    }
    var idtable=(itable+1).toString();
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/order",
        "method": "POST",
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded",
            "cache-control": "no-cache",
            "Postman-Token": "4d21710b-63d8-45f6-bda7-7d1ff089bb90"
        },
        "data": {
            "table_id": idtable,
            "number_client": "4",
            "receptionist_id": "1",
            "listFood": JSON.stringify(listFood),
            "listCombo": JSON.stringify(listCombo)
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        alert("Gửi thành công !!!")
    });
}
function Payment(){
    var bg=document.getElementsByClassName("payment-content");
    var bill=document.getElementsByClassName("bill");
    bg[0].classList.add("show-payment");
    bill[0].classList.add("show-payment");
    // var dm=document.getElementsByClassName("detail-list-food");
    // var sub=document.getElementsByClassName("sub-food");
    //  for (var i = 0; i < sub.length; i++) {
    //     sub[0].parentNode.removeChild(sub[0]);
    // }
    var dm=document.getElementsByClassName("detail-list-food");
    dm[0].parentNode.removeChild(dm[0]);
    CopyFood();
    var d=new Date();
    var string=d.getDate().toString()+"/"+(d.getMonth()+1).toString()+"/"+d.getFullYear().toString()+" "+d.getHours().toString()+":"+d.getMinutes().toString();
    var date=document.getElementsByClassName("date");
    date[0].innerHTML=string;
    var totalmoney=document.getElementsByClassName("bold-total-money");
    var tongnumber=document.getElementsByClassName("tong-number");
    tongnumber[0].innerHTML=totalmoney[0].innerHTML;
    MoneyNeed();
}
function EndPayment(){
    var tableicon=document.getElementsByClassName("icon-table");
    var table=document.getElementsByClassName("table");
    var index=0;
    var i=0;
    var j=0;
    var len=table.length;
    var lenicon=tableicon.length;
    for(i=0;i<lenicon;i++){

        if(tableicon[i].style.backgroundImage==='url("Images/table-red.png")') {
            tableicon[i].style.backgroundImage="url(Images/table-black.png)";
            table[i].classList.remove("table-click");
            tableicon[i].classList.remove("bgGreen");
        }
    }
    var bg=document.getElementsByClassName("payment-content");
    var bill=document.getElementsByClassName("bill");
    bg[0].classList.remove("show-payment");
    bill[0].classList.remove("show-payment");

    var voucher=document.getElementsByClassName("info-main-voucher");
    var table= document.getElementsByClassName("icon-table");
    var itable=0;
    for (var k = 0; k < table.length; k++) {
        if(table[k].style.backgroundImage==='url("Images/table-red.png")'){
            itable=k;
        }
    }
    var remove=voucher[itable].getElementsByClassName("food-voucher");
    var l=remove.length;
    for (var i = 0; i < l; i++) {
        voucher[itable].removeChild(remove[0]);
    }

    var id =document.getElementsByClassName("input-discount");
    var btm =document.getElementsByClassName("bold-total-money");
    var ip =document.getElementsByClassName("input-pay");
    var bc =document.getElementsByClassName("bold-cash");
    btm[0].innerHTML="0";

    bc[0].innerHTML="0";
    id[0].value=0;
    ip[0].value=0;



}
function KeyUpDiscount(){
    MoneyNeed();
    KeyUpPay();
}
function KeyUpPay(){
    var inputpay=document.getElementsByClassName("input-pay");
    var moneyneednumber=document.getElementsByClassName("money-need-number");
    var boldcash=document.getElementsByClassName("bold-cash");
    var ok=(parseInt(inputpay[0].value,10)-parseInt(moneyneednumber[0].innerHTML,10)).toString();
    if(ok==="NaN"){
        ok="0";
    }
    boldcash[0].innerHTML=ok;
}
function MoneyNeed(){
    var moneyneednumber=document.getElementsByClassName("money-need-number");
    var tongnumber=document.getElementsByClassName("tong-number");
    var inputdiscount=document.getElementsByClassName("input-discount");
    var ok=(parseInt(tongnumber[0].innerHTML,10)-parseInt(inputdiscount[0].value,10)).toString();
    if(ok==="NaN"){
        ok=tongnumber[0].innerHTML;
    }
    moneyneednumber[0].innerHTML=ok;
}
function HidePayment(){
    var bg=document.getElementsByClassName("payment-content");
    var bill=document.getElementsByClassName("bill");
    bg[0].classList.remove("show-payment");
    bill[0].classList.remove("show-payment");
}
function ChooseFood(food){
    var voucher=document.getElementsByClassName("info-main-voucher");
    var table= document.getElementsByClassName("icon-table");
    var itable=0;
    for (var k = 0; k < table.length; k++) {
        if(table[k].style.backgroundImage==='url("Images/table-red.png")'){
            itable=k;
        }
    }
    var notify= document.getElementsByClassName("button-notify");
    notify[0].removeAttribute("disabled");
    notify[0].style.cursor="pointer";
    notify[0].style.opacity="1";
    var nameFood=document.getElementsByClassName("description-food");
    var idfood=document.getElementsByClassName("id-food");
    var money=document.getElementsByClassName("bold");
    var Food=document.getElementsByClassName("food");
    var index=0;
    var i=0;
    var len=nameFood.length;
    for(i=0;i<len;i++){
        if(Food[i]===food) {
            index=i;
            break;
        }
    }
    var idf=idfood[index].innerHTML;
    var namef=nameFood[index].innerHTML;
    var pricef=money[index].innerHTML;
    var nameFood=voucher[itable].getElementsByClassName("name-food");
    var lenName=nameFood.length;
    var namefv="";
    var indexFood=0;
    var test=false;
    for(i=0;i<lenName;i++){
        namefv=nameFood[i].innerHTML;
        if(namef===namefv) {
            indexFood=i;
            test=true;
            break;
        }
    }
    if(test===true){
        var gia=voucher[itable].getElementsByClassName("gia");
        var numberGia=parseInt(gia[indexFood].value,10);
        var numberPrice=numberGia+1;
        gia[indexFood].value=numberPrice;
        var tong=voucher[itable].getElementsByClassName("bold-total");
        var numberTong=parseInt(tong[indexFood].innerHTML,10);
        var gia1sp=parseInt(pricef,10);
        var numberTotal=numberTong+gia1sp;
        var stringTotal=numberTotal.toString();
        tong[indexFood].innerHTML=stringTotal;
        calTotal();
    }else{

        var row = document.createElement("DIV");
        var id= document.createElement("DIV");
        var del = document.createElement("DIV");
        var name = document.createElement("DIV");
        var amount = document.createElement("DIV");
        var price = document.createElement("DIV");
        var total = document.createElement("DIV");
        var bold = document.createElement("B");
        var attr8= document.createAttribute("class");
        attr8.value = "bold-total";
        bold.setAttributeNode(attr8);
        var attr = document.createAttribute("class");
        attr.value = "food-voucher";
        row.setAttributeNode(attr);
        var attr11= document.createAttribute("class");
        attr11.value = "id";
        id.setAttributeNode(attr11);
        var attr12= document.createAttribute("style");
        attr12.value = "display:none";
        id.setAttributeNode(attr12);
        var attr1= document.createAttribute("class");
        attr1.value = "delete-food";
        del.setAttributeNode(attr1);
        var attr9= document.createAttribute("onclick");
        attr9.value = "RemoveFood(this)";
        del.setAttributeNode(attr9);
        var attr2= document.createAttribute("class");
        attr2.value = "name-food";
        name.setAttributeNode(attr2);
        name.innerHTML=namef;
        var attr3= document.createAttribute("class");
        attr3.value = "amount-food";
        amount.setAttributeNode(attr3);
        var input = document.createElement("INPUT");
        var attr6= document.createAttribute("value");
        attr6.value = "1";
        input.setAttributeNode(attr6);
        amount.appendChild(input);
        var attr7= document.createAttribute("class");
        attr7.value = "gia";
        input.setAttributeNode(attr7);
        var attr10= document.createAttribute("onfocusout");
        attr10.value = "UpAmount(this)";
        input.setAttributeNode(attr10);
        amount.appendChild(input);
        var attr4= document.createAttribute("class");
        attr4.value = "food-price";
        price.setAttributeNode(attr4);
        price.innerHTML=pricef;
        var attr5= document.createAttribute("class");
        attr5.value = "total-price-food";
        total.setAttributeNode(attr5);
        bold.innerHTML=pricef;
        id.innerHTML=idf;
        total.appendChild(bold);
        row.appendChild(id);
        row.appendChild(del);
        row.appendChild(name);
        row.appendChild(amount);
        row.appendChild(price);
        row.appendChild(total);
        voucher[itable].appendChild(row);
        calTotal();
        //Notify();
        var tableicon=document.getElementsByClassName("icon-table");
        var table=document.getElementsByClassName("table");
        var m=0;
        var lenicon=tableicon.length;
        for(m=0;m<lenicon;m++){
            if(tableicon[m].style.backgroundImage==='url("Images/table-red.png")') {
                tableicon[m].classList.add("bgGreen");
                table[m].classList.remove("table-click");
            }
        }
    }
}
function calTotal(){
    var voucher=document.getElementsByClassName("info-main-voucher");
    var table= document.getElementsByClassName("icon-table");
    var itable=0;
    for (var k = 0; k < table.length; k++) {
        if(table[k].style.backgroundImage==='url("Images/table-red.png")'){
            itable=k;
        }
    }
    var fvoucher=voucher[itable].getElementsByClassName("bold-total");
    var boldTotal=document.getElementsByClassName("bold-total-money");
    var length=fvoucher.length;
    var total=0;
    for(var i=0;i<length;i++){
        var numberTotal=parseInt(fvoucher[i].innerHTML,10);
        total=total+numberTotal;
    }
    var stringTotal=total.toString();
    boldTotal[0].innerHTML=stringTotal;
}
function RemoveFood(ok){
    var pa=ok.parentNode;
    pa.parentNode.removeChild(pa);
    calTotal();
}
function CopyFood(){
    var bill = document.createElement("DIV");
    var attr8= document.createAttribute("class");
    attr8.value = "detail-list-food";
    bill.setAttributeNode(attr8);
    var scroll=document.getElementsByClassName("scroll");
    scroll[0].appendChild(bill);
    var voucher=document.getElementsByClassName("info-main-voucher");
    var table= document.getElementsByClassName("icon-table");
    var itable=0;
    for (var k = 0; k < table.length; k++) {
        if(table[k].style.backgroundImage==='url("Images/table-red.png")'){
            itable=k;
        }
    }

    //  var bill=document.getElementsByClassName("detail-list-food");
    var nameFood=voucher[itable].getElementsByClassName("name-food");
    var amountFood=voucher[itable].getElementsByClassName("gia");
    var priceFood=voucher[itable].getElementsByClassName("food-price");
    var totalFood=voucher[itable].getElementsByClassName("bold-total");
    var length=nameFood.length;

    for(i=0;i<length;i++){
        var row = document.createElement("DIV");

        var index = document.createElement("DIV");
        var name = document.createElement("DIV");
        var amount = document.createElement("DIV");
        var textAmount = document.createElement("DIV");
        var price = document.createElement("DIV");
        var total = document.createElement("DIV");
        var attr1= document.createAttribute("class");
        attr1.value = "sub-food";
        row.setAttributeNode(attr1);
        var attr2= document.createAttribute("class");
        attr2.value = "index-food";
        index.setAttributeNode(attr2);
        var attr3= document.createAttribute("class");
        attr3.value = "copy-name-food";
        name.setAttributeNode(attr3);
        var attr4= document.createAttribute("class");
        attr4.value = "copy-amount-food";
        amount.setAttributeNode(attr4);
        var attr5= document.createAttribute("class");
        attr5.value = "copy-price-food";
        price.setAttributeNode(attr5);
        var attr6= document.createAttribute("class");
        attr6.value = "copy-total-food";
        total.setAttributeNode(attr6);
        var attr7= document.createAttribute("class");
        attr7.value = "text-amount";
        textAmount.setAttributeNode(attr7);

        index.innerHTML=i+1;
        name.innerHTML=nameFood[i].innerHTML;
        textAmount.innerHTML=amountFood[i].value;
        price.innerHTML=priceFood[i].innerHTML;
        total.innerHTML=totalFood[i].innerHTML;
        amount.appendChild(textAmount);
        row.appendChild(index);
        row.appendChild(name);
        row.appendChild(amount);
        row.appendChild(price);
        row.appendChild(total);
        bill.appendChild(row);
    }

}
function UpAmount(ok){
    var amount=ok.value;
    var numberAmount=parseInt(amount,10);
    var uk=ok.parentNode.parentNode;
    var price=parseInt(uk.childNodes[4].innerHTML,10);
    var tong=numberAmount*price;
    var stringTong=tong.toString();
    var total=uk.childNodes[5].childNodes[0];
    total.innerHTML=stringTong;
    calTotal();
}
function HideMenu(){
    var detailMenu=document.getElementsByClassName("detail-menu");
    var hideMenu=document.getElementsByClassName("hide-menu");
    detailMenu[0].classList.toggle("display-detail-menu");
    hideMenu[0].classList.toggle("display-detail-menu");
}