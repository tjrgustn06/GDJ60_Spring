//FileManger.js


const fileAdd = document.getElementById("fileAdd");
const fileList = document.getElementById("fileList");

let count=0;
let max=1;
let param='pic';
let idx=0;

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}

fileList.addEventListener("click", function(e){
   if(e.target.classList.contains('dels')){
   console.log(e.target.parentNode);
   e.target.parentNode.remove();
    // let id = e.target.getAttribute('data-dels-id');
    // document.getElementById(id).remove();
    count--;
   }

});


fileAdd.addEventListener("click", function(){

    if(count>=max){
        alert('첨부파일은 최대 '+max+ ' 까지만 가능');
        return;
    }

    count++;

    //Element, Text 들을 생성
    let d = document.createElement('div');// 부모 DIV
   // let l = document.createElement('label');//label
   // let t = document.createTextNode('Image');
    let i = document.createElement('input');//input
    let b = document.createElement('button');

    //Element들을 조합
    //d.appendChild(l);
    d.appendChild(i);
    d.appendChild(b);

    //attribute 생성 적용
    //div
    let attr = document.createAttribute("class");
    attr.value='in put group mb-3';
    d.setAttributeNode(attr);

    attr=document.createAttribute("id");
    attr.value='f'+idx;
    d.setAttributeNode(attr);
    

    //label
    // attr = document.createAttribute("class");
    // attr.value='form-label';
    // l.setAttributeNode(attr);

    // attr = document.createAttribute("for");
    // attr.value='files';
    // l.setAttributeNode(attr);

    //input
    attr = document.createAttribute("type");
    attr.value="file";
    i.setAttributeNode(attr);

    attr = document.createAttribute("class");
    attr.value='form-control';
    i.setAttributeNode(attr);

    attr = document.createAttribute("id");
    attr.value='files';
    i.setAttributeNode(attr);

    attr = document.createAttribute("name");
    attr.value=param;
    i.setAttributeNode(attr);

    //button
    attr = document.createAttribute("type");
    attr.value="button";
    attr = document.createAttribute("class");
    attr.value="btn btn-outline-danger dels";
    attr=document.createTextNode("X");
    b.appendChild(attr);

    attr = document.createAttribute("data-desls-id");
    attr.value='f'+idx;
    b.setAttributeNode(attr);


    idx++;
    fileList.prepend(d);

});







