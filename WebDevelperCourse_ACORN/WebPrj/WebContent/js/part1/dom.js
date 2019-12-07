/* ex11 예제 */

window.addEventListener("load", function () {
    
    var load = function(page){        
        
        var request = new XMLHttpRequest();
        // var pIndex = e.target.href.lastIndexOf("p=");
        // var page = e.target.href.substring(pIndex+2);
        // console.log(pIndex + ", " + page);

        // default가 비동기
        request.open("GET", "../../notice/list-json?p="+page); // 요청 내용 설정
        
        // onreadystatechange - > 5번 호출됨
        // request.onreadystatechange = function(){

        //     if(request.readyState != 4)
        //         return;

        request.onload = function(){

            var list = JSON.parse(request.responseText);

            // 방법 4. 템플릿을 복사해서 사용하기
            var trTemplate = section.querySelector(".tr-template");
            tbody.innerHTML = "";
    
            for (var i = 0; i < list.length; i++) {
            	
            	if(request.readyState != 4)
                    return;
            	
                var cloneTr = document.importNode(trTemplate.content, true);
    
                // children은 트리구조에 포함 됬을때만 사용가능 -> 화면에 보이는 것들
                var tds = cloneTr.querySelectorAll("td");
                tds[0].innerText = list[i].id;
                var aTag = tds[1].firstElementChild;
                aTag.dataset.id = list[i].id;
                // aTag.dataset["writer-id"] = list[i].writerId;
                aTag.innerText = list[i].title;          
                tds[2].innerText = list[i].writerId;
                tds[3].innerText = list[i].regdate;
                tds[4].innerText = list[i].hit;
    
                tbody.append(cloneTr);
            }
        };

        request.send(); //  요청한 후 기다림
    }    
    
    
    
    var section = document.querySelector("#ex11");
    var addBtn = section.querySelector(".add-button");
    var regBtn = section.querySelector(".reg-button");
    var loadBtn = section.querySelector(".load-button");
    var tbody = section.querySelector("table tbody");
    var pager = section.querySelector(".pager");
    
    load(1);  
    // ============================ Handlers =====================================
    // 제목을 클릭하면 상세 내용을 보는 핸들러
    tbody.onclick = function(e){
        if(!e.target.parentNode.classList.contains("title"))
        {
            return;
        }    

        e.preventDefault();

        // 현재 tr을 찾기부터
        var currentTr = e.target.parentNode.parentNode;
        var nextTr = currentTr.nextElementSibling;

        if(nextTr.classList.contains("detail"))
        {
            alert("already exists");
            return;
        }

        if(ajaxIcon != undefined)
        {
            alert("working on it");
            return;
        }

        // 현재 target으로부터 전송할 식별자(id)를 얻는다.
        var id = e.target.dataset.id;
        // alert(id);

        // 자세한 정보를 요청
        // Ajax 아이콘을 추가하고
        var ajaxIcon = document.createElement("img");
        ajaxIcon.src = "../../images/ajax-loader-tr.gif";
        e.target.parentNode.append(ajaxIcon);
        
        var request = new XMLHttpRequest();       
        request.open("GET", "../../notice/detail-json?id="+id,true); // 요청 내용 설정
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        
        request.onload = function(){
            var notice = JSON.parse(request.responseText);
            
            var template = section.querySelector(".detail-template");
            var cloneTr = document.importNode(template.content, true);

            var td = cloneTr.querySelector("td");
            td.innerHTML = notice.content;

            // 이제  td를 삽입해야함
          
            tbody.insertBefore(td, nextTr);    
            // Ajax 아이콘을 제거  
           ajaxIcon.remove();   
           ajaxIcon = null;   
        };
        request.send();
    };


    regBtn.onclick = function(){
        //1. 데이터 준비
        var form = section.querySelector(".form");     
        var id = form.querySelector("input[name=\"id\"]").value;
        var title = form.querySelector("input[name=\"title\"]").value;
        var writerId = form.querySelector("input[name=\"writerId\"]").value;
        var regdate = form.querySelector("input[name=\"regdate\"]").value;
        var hit = form.querySelector("input[name=\"hit\"]").value;
        

        title = encodeURI(title);
        console.log(title);

        var data = [["id",id],["title",title],["writerId",writerId],["regdate",regdate],["hit",hit]];
        var sendData = [];

        for(var i=0; i<data.length; i++)
            sendData[i] = data[i].join("=");
        
        sendData = sendData.join("&");
        console.log(sendData);

        //2. 데이터 전송
        var request = new XMLHttpRequest();       
        request.open("POST", "../../notice/reg-json"); // 요청 내용 설정
        request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        
        request.onload = function(){
            //3. 결과에 따라서 조치를 취한다.
            //3-1 결과 값을 확인하고
            console.log(request.responseText);
            //3-2 새로운 목록을 다시 요청한다.

            //3-3 요청한 데이터로 화면을 갱신한다.
            load(request.responseText);
        };
        request.send(sendData); // 데이터를 여기다가 넣는다

        
    }

    pager.onclick = function(e){
        if(e.target.nodeName != "A")
            return;
               
        e.preventDefault();
        
        load(e.target.innerText);                     
    }
    

    loadBtn.onclick = function (e) {
        //1. 서버에서 데이터를 가져와서
        //2. 화면을 갱신한다.

        //Ajax(Asyncronous Javascript and SML???
        //자바스크립트로 서버로 데이터를 비동기로 요청 후 
        //그 데이터로 화면을 갱신하는 기술

        var request = new XMLHttpRequest();
        request.open("GET", "../../notice/list-json", false); // 요청 내용 설정
        request.send();

        var list = JSON.parse(request.responseText);

        // 방법 4. 템플릿을 복사해서 사용하기
        var trTemplate = section.querySelector(".tr-template");
        tbody.innerHTML = "";

        for (var i = 0; i < list.length; i++) {
            var cloneTr = document.importNode(trTemplate.content, true);

            // children은 트리구조에 포함 됬을때만 사용가능 -> 화면에 보이는 것들
            var tds = cloneTr.querySelectorAll("td");
            tds[0].innerText = list[i].id;
            tds[1].firstElementChild.innerText = list[i].title;
            tds[2].innerText = list[i].writer_id;
            tds[3].innerText = list[i].regdate;
            tds[4].innerText = list[i].hit;

            tbody.append(cloneTr);
        }

        
    };

});


/* ex10 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex10");    
    var addBtn = section.querySelector(".add-button");
    var tbody = section.querySelector("table > tbody");
    var regBtn = section.querySelector(".reg-button");
    
    var notices = [
        {id:1, title:"This it Title", wrtierId:"newlec", regDate:"2019-11-29", hit:20},
        {id:1, title:"This it Title", wrtierId:"newlec", regDate:"2019-11-29", hit:12}
    ];

    regBtn.onclick = function(e){
        var form = section.querySelector(".form");
        // var inputs = form.getElementsByTagName("input");
        var id = form.querySelector("input[name=\"id\"]").value;
        var title = form.querySelector("input[name=\"title\"]").value;
        var writer_id = form.querySelector("input[name=\"writer_id\"]").value;
        var regdate = form.querySelector("input[name=\"regdate\"]").value;
        var hit = form.querySelector("input[name=\"hit\"]").value;
        var cmtCount = form.querySelector("input[name=\"cmt_count\"]").value;

        var trTemplate = section.querySelector(".tr-template");
        var cloneTr = document.importNode(trTemplate.content, true);
        var tds = cloneTr.querySelectorAll("td");
        tds[0].innerText = id;      
        tds[1].firstElementChild.innerText = title;
        tds[1].innerText += "["+cmtCount+"]";
        tds[2].innerText = writer_id;
        tds[3].innerText = regdate;
        tds[4].innerText = hit;
        
        
        var emptyTr = tbody.querySelector("tr").remove();
        console.log(tds[1].innerText);

        tbody.append(cloneTr);
    }

    addBtn.onclick = function(e){

    // 방법 4. 템플릿을 복사해서 사용하기
    var trTemplate = section.querySelector(".tr-template");
    var cloneTr = document.importNode(trTemplate.content, true);
    
    // children은 트리구조에 포함 됬을때만 사용가능 -> 화면에 보이는 것들
    var tds = cloneTr.querySelectorAll("td");
    tds[0].innerText = notices[0].id;      
    tds[1].firstElementChild.innerText = notices[0].title;
    tds[2].innerText = notices[0].wrtierId;
    tds[3].innerText = notices[0].regDate;
    tds[4].innerText = notices[0].hit;
    
    tbody.append(cloneTr);

    
    // 방법 3. 기존 레코드 복사해서 사용하기
    // cloneNode(true) ; 자식노드들까지 recursive하게 복사
    // var cloneTr = tbody.firstElementChild.cloneNode(true);
    // var tds = cloneTr.children;
    // tds[0].innerText = notices[0].id;      
    // tds[1].firstElementChild.innerText = notices[0].title;
    // tds[2].innerText = notices[0].wrtierId;
    // tds[3].innerText = notices[0].regDate;
    // tds[4].innerText = notices[0].hit;
    // tbody.append(cloneTr);

    // 방법 2. innterHTML 사용 -> += 연산자를 이용할 시 성능저하 우려
    // var trHtml = `<tr> \
    // <td>6</td> \
    // <td class="title indent text-align-left"><a href="detail.html">뉴렉쌤 9월 초 국기과정 모집 안내</a> [22]</td> \
    // <td>newlec</td> \
    // <td> \
    //     2019-06-11 \      
    // </td> \
    // <td>517</td> \
    // </tr>`;

    // tbody.innerHTML += trHtml;
    
    // 방법 1. document 엘리먼트를 이용해서 tr, td객체 생성
    //    var tr = document.createElement("tr");
    //    var tds = [];
    //    for(var i=0; i<5; i++)
    //    {    
    //         var td = document.createElement("td");
    //         tds[i] = td;
    //         tr.append(tds[i]);
    //    }

    //    var txt1 = document.createTextNode("3");
    //    tds[0].append(txt1);
    //    var txt2 = document.createTextNode("test title");
    //    var a = document.createElement("a");
    //    a.text = txt2.data;
    //    a.href = "http://naver.com";
    //    tds[1].append(a);
    //    var txt3 = document.createTextNode("newlec");      
    //    tds[2].append(txt3);
    //    var txt4 = document.createTextNode("2019-03-03");
    //    tds[3].append(txt4);
    //    var txt5 = document.createTextNode("1000");
    //    tds[4].append(txt5);
    //    tbody.append(tr);
      
       
    };
});

/* ex9 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex9");
    
    var textBtn = section.querySelector(".text-button");
    var imgBtn = section.querySelector(".img-button");
    var linkBtn = section.querySelector(".link-button");
    var delBtn = section.querySelector(".del-button");
    var stage = section.querySelector(".stage");


    textBtn.onclick = function(e){
        var textNode = document.createTextNode("hahaha");
        // stage.appendChild(textNode);
        stage.append(textNode);
    };

    imgBtn.onclick = function(e){
        var img = document.createElement("img");
        img.src = "../../images/youtube-icon.png";
        stage.append(img);
    };

    linkBtn.onclick = function(e){
        var txt = document.createTextNode("NEXT");
        var link = document.createElement("a");
        link.text = txt.data;
        link.href = "https://arxiv.org/abs/1801.09414";
        stage.append(link);
                
    };

    delBtn.onclick = function(e){
        // stage.removeChild(stage.lastChild);
        // stage.removeChild(stage.lastElementChild); // element만 대상이라 테그스틑 삭제 안됨
        stage.lastChild.remove()
    };

});


/* ex8 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex8");
    
    var tagetButton = section.querySelector("input[type=file]");
    var fileButton = section.querySelector(".file-button");
    fileButton.onclick = function(e){
        var event = new MouseEvent("click",{
            view:window,
            bubbles:true,
            cancelable:true,
        }
        ); // IE에서 호환안됨
        
        //var event = document.createEvent();

        tagetButton.dispatchEvent(event);
    };

});

/* ex7 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex7");    
    
    var ul = section.querySelector("div > ul");
    var imgs = section.querySelectorAll("div:last-child > ul > li > img");
    
    // rev ver2 ==================================
    // 이벤트 버블링을 이용해서 자잘하게 반복되는 자식에세 부여할 이벤트를
    // 그 부모에게 한번만 적용.

    // imgs[0].parentElement.onclick = function(){
    //     console.log("li clicked");
    // }

    // imgs[0].parentElement.parentElement.onclick = function(){
    //     console.log("ul clicked");
    // }

    var imgClickHandler = function(e){
        console.log(e.target);
        console.log(e.currentTarget); // 실제 처리를 담당하는 객체
        
        var img = section.querySelector(".stage img");       
        var clickedImg = e.target;        
        if(e.target.tagName == "IMG")
            img.src = clickedImg.src;
        
        
    }
  
    // 이 부분을 부모에게 한번만 적용시켜보자.
   
    ul.onclick = imgClickHandler;
    
    // 기본행위를 가지는 태그들 <a><input><img>...
    ul.firstElementChild.onclick = function(e){
        console.log(e.target);
        console.log(e.currentTarget);
        e.preventDefault(); // 기본행위를 맞는 역할
        e.stopPropagation();
        alert("previous page");
        
    }


    // rev ver1 ==================================
    // var imgClickHandler = function(e){
    //     console.log("image clicked");
    //     var img = section.querySelector(".stage img");
    //     var clickedImg = e.target;
    //     img.src = clickedImg.src;
    // }
  

    // for(var i in imgs)
    // {
    //     imgs[i].onclick = imgClickHandler;
      
    // }
    

    // imgs[0].onclick = function(e){
    //     // 문제점 1 : 수정할 때 html과 js를 같이 수정해야 한다.
    //     // 문제점 2 : imgs[0],[1],[2] 클릭 이벤트 핸들러가 거의 동일하지만 합칠 수 있으면
    //     //            만약에 img.src = clickedImg.src; 처럼 한다면 함수 하나로 끝낼수 있다.
    //     var img = section.querySelector(".stage img");        
    //     var clickedImg = e.target;
    //     img.src = clickedImg.src;
    // }

});





/* ex6-2 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex6-2");
    var scatBtn = section.querySelector(".scat-button");
    var swapBtn = section.querySelector(".swap-button");
    var divBoxes = section.querySelectorAll(".stage div");

    // 지금 이 코드에는 해서는 안되는 코드가 남아있음
    // 다음에 더 공부하면 알게 될 내용.
    for (var i = 0; i < divBoxes.length; i++) {
        divBoxes[i].onclick = function (e) {
            for (var key in e) {
                console.log(key);
            }
        }
    }


    var offset = 0;

    scatBtn.onclick = function () {

        for (var i = 0; i < divBoxes.length; i++) {
            divBoxes[i].className = "pos" + (i + 1);
            divBoxes[i].classList.add("color" + (i + 1));
        }
    };

    var tid1 = null;
    var tid2 = null;
    var maxDuration = 1000;
    var duration = 300;

    swapBtn.onclick = function () {
        if (tid1 != null) {
            tid1 = null;
            return;
        }


        var posVal = [];
        var colorVal = [];
        tid1 = window.setInterval(function () {           
            duration -= 10;
            if (tid2 == null) {
                tid2 = window.setInterval(function () {
                    offset++; // 1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 ->...
                    for (var i = 0; i < divBoxes.length; i++) {
                        //posVal[i] = (i + offset) % 5 + 1;
                        // colorVal[i] = i + 1;
                        posVal[i] = i+1;
                        colorVal[i] = ((i + divBoxes.length) - ((offset) % 5)) % 5 + 1;
                        //divBoxes[i].className = "pos" + posVal[i];
                        //divBoxes[i].classList.add("color" + colorVal[i]);
                        divBoxes[i].className = "pos" + posVal[i];
                        divBoxes[i].classList.add("color" + colorVal[i]);
                    }
                }, maxDuration);
            }
            else{
               
                if (duration < 200) {
                    clearInterval(tid2);
                    tid2 = null;
                    maxDuration -= 200;
                    duration = 300;
                }    
            }

            if(maxDuration < 200)
            {
                maxDuration = 1000;
            }
            // console.log(duration + ", " + maxDuration);
        
        }, 500);

    };
});




/* ex6 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex6");
    var scatBtn = section.querySelector(".scat-button");
    var swapBtn = section.querySelector(".swap-button");
    var divBoxes = section.querySelectorAll(".stage div");

    // 지금 이 코드에는 해서는 안되는 코드가 남아있음
    // 다음에 더 공부하면 알게 될 내용.
    for (var i = 0; i < divBoxes.length; i++) {
        divBoxes[i].onclick = function (e) {
            for (var key in e) {
                console.log(key);
            }
        }
    }


    var offset = 0;

    scatBtn.onclick = function () {

        for (var i = 0; i < divBoxes.length; i++) {
            divBoxes[i].className = "pos" + (i + 1);
            divBoxes[i].classList.add("color" + (i + 1));
        }
    };

    var tid = null;

    swapBtn.onclick = function () {
        if (tid != null) {
            tid = null;
            return;
        }

        var x = 0;
        var posVal = [];
        var colorVal = [];
        tid = window.setInterval(function () {

            if (x == 0) {
                offset++; // 1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 ->...
                for (var i = 0; i < divBoxes.length; i++) {
                    posVal[i] = (i + offset) % 5 + 1;
                    colorVal[i] = i + 1;
                    divBoxes[i].className = "pos" + posVal[i];
                    divBoxes[i].classList.add("color" + colorVal[i]);

                }
                // console.log(divBoxes[0].className);
                x = 1;
                return;
            }

            if (x == 1) {
                for (var i = 0; i < divBoxes.length; i++) {
                    divBoxes[i].className = "pos0";
                }
                x = 2;
                return;
            }

            if (x == 2) {
                for (var i = 0; i < divBoxes.length; i++) {
                    divBoxes[i].className = "pos" + posVal[i];
                    divBoxes[i].classList.add("color" + colorVal[i]);
                }
                x = 0;
                return;
            }
            // console.log(x);
        }, 300);



    };
});



/* ex5 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex5");
    var countdownBtn = section.querySelector(".countdown-button");
    var countdownTextBox = section.querySelector(".status input");
    var countDownSpan = section.querySelector(".progress span:last-child");
    var countDownSpanBar = section.querySelector(".progress span:first-child");

    var tid = null;

    countdownBtn.onclick = function () {
        if (tid != null) {
            clearInterval(tid);
            tid = null;
            return;
        }

        tid = window.setInterval(function () {
            var count = parseInt(countdownTextBox.value);
            count--;
            if (count < 0) {
                clearInterval(tid);
                return;
            }
            countdownTextBox.value = count;

            countDownSpan.innerText = count;
            var countDownSpanBarStyle = window.getComputedStyle(countDownSpanBar);
            var countDownSpanBarWidth = countDownSpanBarStyle.width;

            var decreseStep = parseInt(countDownSpanBarWidth) / count;
            console.log(parseInt(decreseStep));
            var tmpWidth = parseInt(countDownSpanBarWidth) - parseInt(decreseStep);

            // console.log(tmpWidth);
            countDownSpanBar.style.width = tmpWidth + "px";
        }, 100);


    };
});



/* ex4 예제 */

window.addEventListener("load", function () {
    var section = document.querySelector("#ex4");
    var btnMove = section.querySelector(".move-button");

    var box1 = section.querySelector(".stage div:first-child");
    var box2 = section.querySelector(".stage div:first-child + div");

    btnMove.onclick = function () {

        alert("Hello World");

        var box1Style = window.getComputedStyle(box1);
        // var left = box1.style.left; // 불가능
        // var top = box1.style.top;
        var left = box1Style.left;
        var top = box1Style.top;
        console.log(left + " " + top);

        box2.style.left = left;
        box2.style.top = top;
    };
});


/* ex3 예제 */

window.addEventListener("load", function () {
    var section = this.document.getElementById("ex3");


    var downBtn = section.getElementsByClassName("down-button")[0];
    var prevBtn = section.getElementsByClassName("prev-button")[0];
    var nextBtn = section.getElementsByClassName("next-button")[0];
    var upBtn = section.getElementsByClassName("up-button")[0];
    var stage = section.getElementsByClassName("stage")[0];

    var currentNode = stage.getElementsByClassName("current")[0];


    prevBtn.onclick = function () {

        // var tmpNode = currentNode[0];
        // currentNode[0].previousElementSibling.classList.add("current");
        // tmpNode.classList.remove("current");

        if (currentNode.previousElementSibling != null) {
            currentNode.classList.remove("current");
            currentNode = currentNode.previousElementSibling;
            currentNode.classList.add("current");
        } else {
            alert("NO MORE PREV NODE");
        }

        idx--;
        if (idx <= 0) {
            idx = 0;
        }
    };

    nextBtn.onclick = function () {

        // var tmpNode = currentNode[0];
        // currentNode[0].nextElementSibling.classList.add("current");
        // tmpNode.classList.remove("current");

        // currentNode = currentNode.nextSibling;
        // alert(currentNode.nodeType + " " + currentNode.nodeName + " " + currentNode.nodeValue); 


        if (currentNode.nextElementSibling != null) {
            currentNode.classList.remove("current");
            currentNode = currentNode.nextElementSibling;
            currentNode.classList.add("current");
        } else {
            alert("NO MORE NEXT NODE");
        }

        idx++;
        if (idx >= 9) {
            idx = 9;
        }
    };

    upBtn.onclick = function () {
        // var tmpNode = currentNode[0];
        // currentNode[0].parentElement.parentElement.firstElementChild.firstElementChild.classList.add("current");
        // tmpNode.classList.remove("current");

        // if(currentNode.parentElement.previousElementSibling != null)
        // {
        //     currentNode.classList.remove("current");
        //     currentNode = currentNode.parentElement.previousElementSibling.firstElementChild;
        //     currentNode.classList.add("current");
        // }
        // else{
        //     alert("No MORE UP NODE");
        // }
        if (currentNode.parentElement.previousElementSibling != null) {
            currentNode.classList.remove("current");
            currentNode = currentNode.parentElement.previousElementSibling.children[idx];
            currentNode.classList.add("current");
        } else {
            alert("NO UP NODE");
        }

    };

    var idx = 0;
    downBtn.onclick = function () {
        // var tmpNode = currentNode[0];
        // currentNode[0].parentElement.parentElement.lastElementChild.firstElementChild.classList.add("current");
        // tmpNode.classList.remove("current");



        // if(currentNode.parentElement.nextElementSibling != null)
        // {
        //     currentNode.classList.remove("current");
        //     currentNode = currentNode.parentElement.nextElementSibling.firstElementChild;

        //     currentNode.classList.add("current");
        // }
        // else{
        //     alert("No MORe DOWN NODE");
        // }
        if (currentNode.parentElement.nextElementSibling != null) {
            currentNode.classList.remove("current");
            currentNode = currentNode.parentElement.nextElementSibling.children[idx];
            currentNode.classList.add("current");
        } else {
            alert("NO DOWN NODE");
        }
    };
});


/* ex2 예제 */

window.addEventListener("load", function () {
    var section = this.document.getElementById("ex2");
    var widthTextBox = section.getElementsByClassName("width")[0];
    var heightTextBox = section.getElementsByClassName("height")[0];
    var btnTextBox = section.getElementsByClassName("button")[0];

    var borderTextBox = section.getElementsByClassName("border");

    var img1 = section.getElementsByTagName("img")[0];

    btnTextBox.onclick = function () {

        var w = widthTextBox.value + "px"; // 수치의 단위는 반드시 포함해야함.
        var h = heightTextBox.value + "px";
        img1.style.length = w;
        img1.style.height = h;

        img1.style.borderStyle = borderTextBox[0].value;
        img1.style.borderColor = "#" + borderTextBox[1].value;
        img1.style.borderWidth = borderTextBox[2].value + "px";


    };
});


/* ex1 예제 */

window.addEventListener("load", function () {
    var section = this.document.getElementById("ex1");
    var xTextBox = section.getElementsByClassName("x")[0];
    var yTextBox = section.getElementsByClassName("y")[0];
    var calcTextBox = section.getElementsByClassName("calc")[0];
    var resultTextBox = section.getElementsByClassName("result")[0];

    calcTextBox.onclick = function () {
        resultTextBox.value = parseInt(xTextBox.value) + parseInt(yTextBox.value);

    };
});