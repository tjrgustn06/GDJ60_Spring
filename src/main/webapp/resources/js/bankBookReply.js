const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
//const pageLink = document.querySelectorAll(".page-link");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal = document.getElementById("closeModal");



//댓글 등록
replyAdd.addEventListener("click", function(){
    console.log(replyAdd.getAttribute('data-book-bookNum'));

    //JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData(); //<form></form>이게 생성된거랑 같음
    form.append("contents", replyContents.value);//<form><input type="text" name="contents" value="dfds"></form> 
    form.append("bookNumber", replyAdd.getAttribute('data-book-bookNum'))//<form><input type="text" name="contents" value="dfds"><input type="text" name="bookNumber" value="123"></form>

    fetch("../bankBookComment/add", {
        method:"POST",
        //headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:JSON.stringify({
            contents:replyContents.value,
            bookNumber:form,
        }).then((response)=> response.text())
    .then((res)=>{
        if(res.trim()==1){
            alert("댓글이 등록 되었습니다");
            replyContents.value="";
            getList(1);
        }else {
             alert("댓글 등록에 실패했습니다");
        }
    }).catch(()=>{
    })

    });
        
//  let xhttp = new XMLHttpRequest();

//  xhttp.open('POST', "../bankBookComment/add");

//  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

//  xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNum'));

//  xhttp.addEventListener("readystatechange", function(){
//     if(this.readyState==4 && this.status==200){
//     if(this.responseText.trim()==1){
//         alert("댓글이 등록 되었습니다");
//         replyContents.value="";
//         getList();
//     }else {
//         alert("댓글 등록에 실패했습니다");
//     }
//     }
//  });
e.preventDefault();
});

getList(1);


function getList(page){

    let count=0;

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page);

    
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
            count++;
        }        
    })
    
    xhttp.send();

    //0이 출력 : 비동기 방식이기 때문
    console.log("count : ", count);

}

function getList(page){

    fetch("/bankBookComment/list", {
        method:"GET",
        //GET 과 HEAD 메서드는 body속성을 가질 수 없음 
   
    }).then((response)=> response.text())
    .then((res)=>{
        commentListResult.innerHTML=res.trim();
        count++;
    })
}

//page
commentListResult.addEventListener("click", function(e){
        let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute("data-board-page");
        getList(page);
    }
    e.preventDefault();

});

//delete
commentListResult.addEventListener("click", function(e){
    let del = e.target;
if(del.classList.contains("del")){
    fetch("/bankBookComment/delete",{
    method:"POST",
    headers:{"Content-type":"application/x-www-form-urlencoded"},
    body:"num="+del.getAttribute("data-comment-num")
    })
    }   
    //응답 객체에서 Data 추출
}).then((response)=>{return response.text()})//.then(function(response){retutn response.text()})
    //추출한 Data 사용
.then((res)=>{
    if(res.trim()>0){
        alert("댓글 삭제")
        getList(1)
    }else{
        alert("삭제 실패")
    }
});


//    let xhttp = new XMLHttpRequest();
//    xhttp.open("POST", "/bankBookComment/delete");
//    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//    xhttp.send("num="+del.getAttribute("data-comment-num"))

//    if(this.readyState==4 && this.status==200){
//     let result = this.responseText.trim();
//     if(result>0){
//         alert("댓글이 삭제 되었습니다");
//         getList(1);
//     }else {
//         alert("삭제에 실패 했습니다");
//         }
//     }
    


//update
// commentListResult.addEventListener("click", function(e){
//     let upd = e.target;
// if(upd.classList.contains("upd")){
//    let xhttp = new XMLHttpRequest();
//    xhttp.open("POST", "/bankBookComment/update");
//    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//    xhttp.send("num="+upd.getAttribute("data-comment-num"));

//    if(this.readyState==4 && this.status==200){
//     let result = this.responseText.trim();
//     if(result>0){
//         alert("댓글이 수정 되었습니다");
//         getList(1);
//     }else {
//         alert("수정에 실패 했습니다");
//         }
//     }
// }
//     e.preventDefault();
// });


commentListResult.addEventListener("click", function(e){
    let upd = e.target;
if(upd.classList.contains("upd")){
    let num = upd.getAttribute("data-comment-num");
    let contents = document.getElementById("contents"+num);
    let contnetsTextarea = document.getElementById("content"); //Modal textarea
    contnetsTextarea.value=contents.innerText;
   contentsConfirm.setAttribute("data-comment-num", num);
}
    e.preventDefault();
});

// contentsConfirm.addEventListener("click", function(){
//     console.log("Update Post");
//     let updateContents = document.getElementById("contents").value;
//     let num = contentsConfirm.getAttribute("data-comment-num");

//     let xhttp = new XMLHttpRequest();
//     xhttp.open("POST", "/bankBookComment/update");
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttp.send("num="+num+"&contents="+updateContents);
 
//     if(this.readyState==4 && this.status==200){
//      let result = this.responseText.trim();
//      if(result>0){
//          alert("수정 성공");
//          getList(1);
//          closeModal.click();
//      }else {
//          alert("수정 실패");
//          }
//      }

// });

contentsConfirm.addEventListener("click", function(){
    console.log("Update Post");
    let updateContents = document.getElementById("contents").value;
    let num = contentsConfirm.getAttribute("data-comment-num");

  
    fetch("/bankBookComment/update", {
        method:"POST",
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:"num="+num+"&contents="+updateContents
    })
    }).then((response) => response.text())
.then((res)=>{
    if(res.trim()>0){
        alert("수정 성공")
        closeModal.click()
        getList(1)
    }else{
        alert("수정실패")
    }
}).catch(()=>{
    alert("관리자에게 문의하세요");
});
