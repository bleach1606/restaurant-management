function oneclick(id){
// click one
    var isCheck = true;
    var lengitemfood = document.getElementsByClassName("item-food-name").length ;
    if(lengitemfood > 0){
        var nameFoodid = id.parentNode.parentNode.getElementsByClassName("food-name")[0].textContent;
        for (var i = 0; i < lengitemfood; i++) {
            if (nameFoodid === document.getElementsByClassName("item-food-name")[i].textContent){
                isCheck = false;
                break;
            }
        }
    }
    if(isCheck){
        var food = {id:id.parentNode.parentNode.getElementsByClassName("food-name")[0].textContent,
            name: id.parentNode.parentNode.getElementsByClassName("food-name")[0].textContent,
            count: 1};
        createOne(food);
        var amountWait = id.parentNode.parentNode.getElementsByClassName("food-count")[0].getElementsByTagName("span")[0].textContent;
        if(parseInt(amountWait) - 1 == 0){
            id.parentNode.parentNode.remove();
        }else{
            id.parentNode.parentNode.getElementsByClassName("food-count")[0].getElementsByTagName("span")[0].textContent = parseInt(amountWait) - 1;
        }
    }else{
        var amountWait = id.parentNode.parentNode.getElementsByClassName("food-count")[0].getElementsByTagName("span")[0].textContent;
        if(parseInt(amountWait) - 1 == 0){
            id.parentNode.parentNode.remove();
        }else{
            id.parentNode.parentNode.getElementsByClassName("food-count")[0].getElementsByTagName("span")[0].textContent = parseInt(amountWait) - 1;
        }
        var amountComplete = document.getElementsByClassName("item-food-count")[i].getElementsByTagName("span")[0].textContent;
        document.getElementsByClassName("item-food-count")[i].getElementsByTagName("span")[0].textContent = parseInt(amountComplete) + 1;
    }

}


function createOne(food){
    var article = document.createElement("ARTICLE");
    var nameFood =document.createElement("P");
    var countFood =document.createElement("DIV");
    var btnComplete =document.createElement("BUTTON");
    var title = document.createElement("P");
    var count = document.createElement("SPAN");

    var attrArticleId = document.createAttribute("id");
    var attrbtnCompleteId = document.createAttribute("id");

    var attrClick = document.createAttribute("onclick");

    var attrArticle = document.createAttribute("class");
    var attrNameFoood = document.createAttribute("class");
    var attrcountFoood = document.createAttribute("class");
    var attrbtnComplete = document.createAttribute("class");


    attrArticleId.value = food.id;//food.id
    attrArticle.value = "item-food";
    article.setAttributeNode(attrArticleId);
    article.setAttributeNode(attrArticle);
    document.getElementById("waitfood").appendChild(article);

    attrNameFoood.value= "item-food-name";
    nameFood.setAttributeNode(attrNameFoood);
    nameFood.innerHTML =food.name; //food.name
    article.appendChild(nameFood);

    attrcountFoood.value= "item-food-count";
    countFood.setAttributeNode(attrcountFoood);
    title.innerHTML = "Số lượng: ";
    count.innerHTML = food.count;//food.count
    article.appendChild(countFood);
    countFood.appendChild(title);
    countFood.appendChild(count);

    attrbtnComplete.value= "item-food-complete";
    attrClick.value = "complete(this)";
    btnComplete.setAttributeNode(attrClick);
    btnComplete.setAttributeNode(attrbtnCompleteId);
    btnComplete.setAttributeNode(attrbtnComplete);
    btnComplete.innerHTML = "Đã nhận";
    article.appendChild(btnComplete);
}
function allclick(id){
    var isCheck = true;
    var lengitemfood = document.getElementsByClassName("item-food-name").length ;
    if(lengitemfood > 0){
        var nameFoodid = id.parentNode.parentNode.getElementsByClassName("food-name")[0].textContent;
        for (var i = 0; i < lengitemfood; i++) {
            if (nameFoodid === document.getElementsByClassName("item-food-name")[i].textContent){
                isCheck = false;
                break;
            }
        }
    }
    if(isCheck){
        var food = {id:id.parentNode.parentNode.getElementsByClassName("food-name")[0].textContent,
            name: id.parentNode.parentNode.getElementsByClassName("food-name")[0].textContent,
            count:id.parentNode.parentNode.getElementsByClassName("food-count")[0].getElementsByTagName("span")[0].textContent};
        createOne(food);
        id.parentNode.parentNode.remove();
    }else{
        var amountWait = id.parentNode.parentNode.getElementsByClassName("food-count")[0].getElementsByTagName("span")[0].textContent;
        var amountComplete = document.getElementsByClassName("item-food-count")[i].getElementsByTagName("span")[0].textContent;
        document.getElementsByClassName("item-food-count")[i].getElementsByTagName("span")[0].textContent = parseInt(amountComplete) + parseInt(amountWait) ;
        id.parentNode.parentNode.remove();
    }
}



function complete(id){
    alert(id.parentNode.getAttribute("id"));
}

function loadData(){
//    var s = '[{"wf":"abc","sb":"def"},{"wf":"dss","sb":"ddd"}]';


//    var leng = Math.floor(Math.random() *100) +1;
//    for (var i = 0; i < test.length; i++) {
//        alert(test[0].wf);
//        creatItemWaite(test[i]);
//    }

//      setInterval(update, 5000);
}



function update(){
    removeAll();
//    alert("uapdate");
    var leng = Math.floor(Math.random() *10) +1;
    for (var i = 0; i < leng; i++) {
        creatItemWaite(i);
    }
}
function removeAll(){
    const myNode = document.getElementById("food");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}

function creatItemWaite(id){
    var article = document.createElement("ARTICLE");
    var nameFood =document.createElement("P");
    var countFood =document.createElement("DIV");
    var title = document.createElement("P");
    var count = document.createElement("SPAN");
    var groudbutton = document.createElement("DIV");
    var image1= document.createElement("IMG");
    var image2= document.createElement("IMG");

    var attrArticle = document.createAttribute("class");
    var attrNameFoood = document.createAttribute("class");
    var attrcountFoood = document.createAttribute("class");
    var attrChooseOne = document.createAttribute("class");
    var attrChooseAll = document.createAttribute("class");
    var attrGroudbutton = document.createAttribute("class");

    var attrcount = document.createAttribute("class");
    var attrtitle = document.createAttribute("class");

    var atttId1 = document.createAttribute("id");
    var atttId2 = document.createAttribute("id");
    var attrID = document.createAttribute("id");


    var attrChooseOneClick = document.createAttribute("onclick");
    var attrChooseAllClick = document.createAttribute("onclick");
    var attrimg1 = document.createAttribute("src");
    var attrimg2 = document.createAttribute("src");
    var attrwidth = document.createAttribute("width");
    var attrheight = document.createAttribute("height");
    var attrwidth2 = document.createAttribute("width");
    var attrheight2 = document.createAttribute("height");

    attrID.value = id;
    attrArticle.value = "food";
    article.setAttributeNode(attrArticle);
    article.setAttributeNode(attrID);
    document.getElementById("food").appendChild(article);

    attrNameFoood.value= "food-name";
    nameFood.setAttributeNode(attrNameFoood);
    nameFood.innerHTML = "Tên món ăn " + id.wf;
    article.appendChild(nameFood);

    attrcountFoood.value= "food-count";
    countFood.setAttributeNode(attrcountFoood);
    title.innerHTML = "Sô lương ";
    count.innerHTML = id.sb;
    article.appendChild(countFood);
    countFood.appendChild(title);
    countFood.appendChild(count);

    attrGroudbutton.value = "groud-button";
    groudbutton.setAttributeNode(attrGroudbutton);
    article.appendChild(groudbutton);

    attrChooseOneClick.value = "oneclick(this.id)";
    attrimg1.value = "../Image/right-arrow.png";
    attrwidth.value = "20";
    attrheight.value = "20";
    atttId1.value = id;
    image1.setAttributeNode(attrimg1);
    image1.setAttributeNode(attrwidth);
    image1.setAttributeNode(attrheight);
    image1.setAttributeNode(attrChooseOneClick);
    image1.setAttributeNode(atttId1);
//        btnChooseOne.setAttributeNode(attrChooseOne);
//        btnChooseOne.setAttributeNode(attrChooseOneClick);
    groudbutton.appendChild(image1);
//        btnChooseOne.appendChild(image1);

//        attrChooseAll.value= "food-chooseall";
    attrChooseAllClick.value = "allclick(this.id)";
    attrimg2.value = "../Image/right-arrow.png";
    attrwidth2.value = "20";
    attrheight2.value = "20";
    atttId2.value = id;
    image2.setAttributeNode(attrimg2);
    image2.setAttributeNode(attrwidth2);
    image2.setAttributeNode(attrheight2);
    image2.setAttributeNode(attrChooseAllClick);
    image2.setAttributeNode(atttId2);
//        btnChooseAll.setAttributeNode(attrChooseAll);
//        btnChooseAll.setAttributeNode(attrChooseAllClick);
    groudbutton.appendChild(image2);
//        btnChooseAll.appendChild(image2);

}

function ShowMenu(){
    var detailMenu=document.getElementsByClassName("detail-menu");
    var hideMenu=document.getElementsByClassName("hide-menu");
    detailMenu[0].classList.toggle("display-detail-menu");
//    hideMenu[0].classList.toggle("display-detail-menu");
}

function quanliClick(){
    window.location="http://localhost:8080/LTWEB/Jsp/main.jsp";
}

function dangxuatClick(){

    const userAction = async () => {
        const response = await fetch('http://example.com/movies.json', {
            method: 'POST',
            body: myBody, // string or object
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const myJson = await response.json(); //extract JSON from the http response
        // do something with myJson
        var test = JSON.parse(myJson);
    }

//    window.location="https://www.youtube.com/";
}
