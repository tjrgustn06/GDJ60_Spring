
//댓글 등록
$("#replyAdd").click(()=>{
    const form1 = new FormData();
    $("form1").append("contents",$("#replyContents").val());
    $("form1").append("bookNumber",$("replyAdd").attr('data-book-bookNum'));

    fetch("../bankBookComment/add", {
        method:"POST",
        //headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:form1,
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
         e.preventDefault();
    });
  





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
        

e.preventDefault();
});

getList(1);


function getList(page){

    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNum')+"&page="+page);

    
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4&&this.status==200){
            commentListResult.innerHTML=this.responseText.trim();
        }        
    })
    
    xhttp.send();

    //0이 출력 : 비동기 방식이기 때문

}

function getList(page){

    fetch("/bankBookComment/list", {
        method:"GET",
        //GET 과 HEAD 메서드는 body속성을 가질 수 없음 
   
    }).then((response)=> response.text())
      .then((res)=>{
        
        $("#commentListResult").html(res.trim());

        //commentListResult.innerHTML=res.trim();
      
    })
}

//page
$("#commentListResult").on("click", ".page", (e)=>{
    let page = $(this).attr("data-board-page")
    getList(page);

});


//delete
$("#commentListResult").on("click", "del", ()=>{
    fetch("/bankBookComment/delete",{
        method:"POST",
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:"num="+del.getAttribute("data-comment-num")
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
    })

//list
$("#commentListResult").on("click", "upd", function(){

    let num=$(this).attr("data-comment-num")

    $("#contents").val($("#contents"+num).text());
    $("#contentsConfirm").attr("data-comment-num", num);
    e.preventDefault();
})

//update
$("#contentsConfirm").click(function(){
    let num = $(this).attr("data-comment-num")

    fetch("/bankBookComment/update", {
        method:"POST",
        headers:{"Content-type":"application/x-www-form-urlencoded"},
        body:"num="+$(this).attr("data-comment-num")+"&contents="+$("#contents")
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