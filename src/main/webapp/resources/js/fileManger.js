const fileList = document.getElementById("fileList");
const fileAdd = document.getElementById("fileAdd");

let count =0;
let max=1;
let param='pic';

function setParam(n){
    param=p;
}

function setMax(m){}{
    max=m;
}

fileAdd.addEventListener('click', function(){

    if(count>=max){
        alert('첨부 파일은' +max+ '까지만 가능합니다')
        return;
    }
    count++;
   
    //Element, Text 들을 생성
    let d = document.createElement('div') //부모 div태그
    let l = document.createElement('lable'); //lable 태그
    let t = document.createTextNode('Image');
    let i = document.createElement('input'); //input 태그
    
    //Element 들을 조합
    d.appendChild(l);
    d.appendChild(i);
    l.appendChild(t);
    

    //attribute 생성 적용
    //div
    let attr= document.createAttribute('class');
    attr.value='mb-3';
    d.setAttributeNode(attr);

    //lable
    attr = document.createAttribute('class');
    attr.value='form-lable';
    l.setAttribute(attr);
    
    attr = document.createAttribute('for');
    attr.value='files';
    l.setAttributeNode(attr);

    //input
    attr = document.createAttribute("type");
    attr.value='file';
    i.setAttributeNode(attr);

    attr = document.createAttribute('class');
    attr.value='form-control';
    i.setAttributeNode(attr);

    attr = document.createAttribute('id');
    attr.value='files';
    i.setAttributeNode(attr);

    attr = document.createAttribute('name');
    attr.value=param;
    i.setAttributeNode(attr);


});







