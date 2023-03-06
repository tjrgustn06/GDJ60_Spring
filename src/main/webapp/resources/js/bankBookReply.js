const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
//const pageLink = document.querySelectorAll(".page-link");


replyAdd.addEventListener("click", function(){
        
 let xhttp = new XMLHttpRequest();

 xhttp.open('POST', "../bankBookComment/add");

 xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

 xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNum'));

 xhttp.addEventListener("readystatechange", function(){
    if(this.readyState==4 && this.status==200){
    if(this.responseText.trim()==1){
        alert("댓글이 등록 되었습니다");
        replayContents.value="";
        getList();
    }else {
        alert("댓글 등록에 실패했습니다");
    }
    }
 });
});

getList();


function getList(page){

    let count=0;

    let xhttp = new XMLHttpRequest();
    
    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute("data-book-bookNum")+"&page="+page);
     
    xhttp.send();
    
    xhttp.addEventListener("readystatechange", function(){

        if(this.readyState==4 && this.status==200){
                console.log(this.responseText);
                count++
         }
    })
 

    //0이 출력: 비동기 방식이기 떄문
    console.log("count :"+count);

}
//pageing
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
   let xhttp = new XMLHttpRequest();
   xhttp.open("POST", "/bankBookComment/delete");
   xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   xhttp.send("num="+del.getAttribute("data-comment-num"))

   if(this.readyState==4 && this.status==200){
    let result = this.responseText.trim();
    if(result>0){
        alert("댓글이 삭제 되었습니다");
        getList(1);
    }else {
        alert("삭제에 실패 했습니다");
        }
    }
}
    e.preventDefault();
});

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
    //upd.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling
    let num = upd.getAttribute("data-comment-num");
    let contents = document.getElementById("contents"+num);

    contents.firstChild.removeAttribute("readonly");
    let btn = document.createElement("button");
    let attr = document.createAttribute("class");
    attr.value="btn btn-primary";
    btn.setAttributeNode(attr);
    contents.appendChild(btn);
    attr = document.createTextNode("확인");
    btn.appendChild(attr);

    btn.addEventListener("click", function(){
        console.log(contents.firstChild.value);
        console.log(num);

        let xhttp = new XMLHttpRequest();
        xhttp.open("POST", "/bankBookComment/update")
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+num+"&contents="+contents.firstChild.value);

        if(this.readyState==4 && this.status==200){
            let result = this.responseText.trim();
            if(result>0){
                alert("댓글이 수정 되었습니다");
                getList(1);
            }else {
                alert("수정에 실패 했습니다");
                }
            }
    });

    // console.log(contents);
    // contents.innerHTML="<textarea>"+contents.innerHTML+"</textarea>";
}
    e.preventDefault();
});



commentListResult.addEventListener("click", function(e){
    let upd = e.target;

});