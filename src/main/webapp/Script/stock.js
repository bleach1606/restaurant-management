function ChooseSupplier(){
    var ok=document.getElementsByClassName("name-supplier");
    var name=ok[0].value;
    var url = "http://localhost:8080/rawmaterial?ncc_id="+name;

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": url,
        "method": "GET",
        "headers": {
        }
    };

    $.ajax(settings).done(function (response) {
        var k = response.length;
        for(var i = 0; i < k; i++) {
            var noidung=document.getElementsByClassName("noidung");
            var namef = response[i]['tenNL'];
            var unitf = response[i]['donVi'];
            var idf = response[i]['id'];
            var desf = response[i]['moTa'];
            var pricef = response[i]['donGia'];
            var row = document.createElement("DIV");
            var id = document.createElement("DIV");
            var name = document.createElement("DIV");
            var unit= document.createElement("DIV");
            var price = document.createElement("DIV");
            var des = document.createElement("DIV");

            var attr = document.createAttribute("class");
            attr.value = "nguyenlieu";
            row.setAttributeNode(attr);
            var attr1 = document.createAttribute("onclick");
            attr1.value = "ChonNL(this)";
            row.setAttributeNode(attr1);
            var attr2 = document.createAttribute("class");
            attr2.value = "id";
            id.setAttributeNode(attr2);
            var attr7 = document.createAttribute("style");
            attr7.value = "display:none";
            id.setAttributeNode(attr7);
            var attr3= document.createAttribute("class");
            attr3.value = "name";
            name.setAttributeNode(attr3);
            var attr4 = document.createAttribute("class");
            attr4.value = "unit";
            unit.setAttributeNode(attr4);
            var attr5 = document.createAttribute("class");
            attr5.value = "price";
            price.setAttributeNode(attr5);
            var attr6 = document.createAttribute("class");
            attr6.value = "des";
            des.setAttributeNode(attr6);
            id.innerHTML=idf;
            name.innerHTML=namef;
            unit.innerHTML=unitf;
            price.innerHTML=pricef;
            des.innerHTML=desf;
            row.appendChild(id);
            row.appendChild(name);
            row.appendChild(unit);
            row.appendChild(price);
            row.appendChild(des);
            noidung[0].appendChild(row);
        }


    }).fail(function(data) {
        console.log(data);
    });
}
function ChonNL(ok){
    var content=document.getElementsByClassName("content-chon");
    var name=document.getElementsByClassName("name");
    var price=document.getElementsByClassName("price");
    var id=document.getElementsByClassName("id");
    var nl=document.getElementsByClassName("nguyenlieu");
    var index=0;
    var i=0;
    var len=name.length;
    for(i=0;i<len;i++){
        if(nl[i]===ok) {
            index=i;
            break;
        }
    }
    var idf=id[index].innerHTML;
    var namef=name[index].innerHTML;
    var pricef=price[index].innerHTML;
    var nlchon=document.getElementsByClassName("ten");
    var lenName=nlchon.length;
    var namefv="";
    var indexFood=0;
    var test=false;
    for(i=0;i<lenName;i++){
        namefv=nlchon[i].innerHTML;
        if(namef===namefv) {
            indexFood=i;
            test=true;
            break;
        }
    }
    if(test===true){
        var soluong=document.getElementsByClassName("soluong");
        var numberSoluong=parseInt(soluong[indexFood].value,10);
        var numberPrice=numberSoluong+1;
        soluong[indexFood].value=numberPrice;
        var tong=document.getElementsByClassName("bold-tong");
        var numberTong=parseInt(tong[indexFood].innerHTML,10);
        var gia1sp=parseInt(pricef,10);
        var numberTotal=numberTong+gia1sp;
        var stringTotal=numberTotal.toString();
        tong[indexFood].innerHTML=stringTotal;
        calTotal();
    }else{
        var row = document.createElement("DIV");
        var id = document.createElement("DIV");
        var del = document.createElement("DIV");
        var name = document.createElement("DIV");
        var amount = document.createElement("DIV");
        var price = document.createElement("DIV");
        var total = document.createElement("DIV");
        var attr = document.createAttribute("class");
        attr.value = "nguyenlieu-choosed";
        row.setAttributeNode(attr);
        var attr1 = document.createAttribute("class");
        attr1.value = "id-nguyenlieu";
        id.setAttributeNode(attr1);
        var attr7 = document.createAttribute("style");
        attr7.value = "display:none";
        id.setAttributeNode(attr7);
        var attr2 = document.createAttribute("class");
        attr2.value = "delete-nguyenlieu";
        del.setAttributeNode(attr2);
        var attr8 = document.createAttribute("onclick");
        attr8.value = "XoaNL(this)";
        del.setAttributeNode(attr8);
        var attr3 = document.createAttribute("class");
        attr3.value = "ten";
        name.setAttributeNode(attr3);
        var attr4 = document.createAttribute("class");
        attr4.value = "donvi";
        amount.setAttributeNode(attr4);
        var input = document.createElement("INPUT");
        var attr9 = document.createAttribute("class");
        attr9.value = "soluong";
        input.setAttributeNode(attr9);
        var attr10= document.createAttribute("onfocusout");
        attr10.value = "TangSL(this)";
        input.setAttributeNode(attr10);
        var attr12= document.createAttribute("value");
        attr12.value = "1";
        input.setAttributeNode(attr12);
        amount.appendChild(input);
        var attr5 = document.createAttribute("class");
        attr5.value = "gia";
        price.setAttributeNode(attr5);
        var attr6 = document.createAttribute("class");
        attr6.value = "tong";
        total.setAttributeNode(attr6);
        var b = document.createElement("B");
        var attr11 = document.createAttribute("class");
        attr11.value = "bold-tong";
        b.setAttributeNode(attr11);
        total.appendChild(b);
        id.innerHTML=idf;
        name.innerHTML=namef;
        price.innerHTML=pricef;
        b.innerHTML=pricef;
        row.appendChild(id);
        row.appendChild(del);
        row.appendChild(name);
        row.appendChild(amount);
        row.appendChild(price);
        row.appendChild(total);
        content[0].appendChild(row);
        calTotal();
    }
}
function TangSL(ok){
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
function XoaNL(ok){
    var pa=ok.parentNode;
    pa.parentNode.removeChild(pa);
    calTotal();
}

function calTotal(){
    var gia=document.getElementsByClassName("bold-tong");
    var tong=document.getElementsByClassName("tongtien");
    var length=gia.length;
    var total=0;
    for(var i=0;i<length;i++){
        var numberTotal=parseInt(gia[i].innerHTML,10);
        total=total+numberTotal;
    }
    var stringTotal=total.toString();
    tong[0].innerHTML=stringTotal;
}