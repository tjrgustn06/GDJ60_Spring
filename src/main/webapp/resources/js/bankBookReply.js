const replayAdd = document.getElementById("replayAdd");
const replayContents = document.getElementById("replayContents");


replayAdd.addEventListener("click", function(){
        
 let xhttp = new XMLHttpRequest();

 xhttp.open('GET', "../bankBookComment/add");

 xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

 xhttp.send("replyNum="+replyNum+"&contents="+contents);

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


function getList(){
    let xhttp = new XMLHttpRequest();
    
    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replayAdd.getAttribute("data-book-bookNum"))

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){

        if(this.readyState==4 && this.status==200){
                console.log(this.responseText);
         }
    })

}










