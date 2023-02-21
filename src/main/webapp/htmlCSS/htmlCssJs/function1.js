const d1 = document.getElementById("d1");

//전역 변수
let n='iu';
var old = "iu";
//funtion 선언

function f1(old){
    console.log("function Test");
    console.log(n);
    var old = "winter";
}
//매개변수 선언시 let const는 생략해야 함
function f2 ( n1,  n2){
    //지역 변수
    let name ='iu';
    return n1+n2;
}



//function 호출
f1();
let result = f2(1,2);
console.log(result);
console.log(name);
//consol.log(n1);
console.log("old : "+ old);

 let fun = function(){
    console.log("익명함수");
    return 1;
}

fun();

function f3 (f){
    console.log("f3 :",f1)
}



//다른 곳에서도 같은 함수를 사용하고 싶을 때 
//d1.addEventListener("click", callback1);
//d1.addEventListener("click", callback2);

//여기에서만 사용하는 함수
d1.addEventListener("click", function(){
    callback1();
    callback2();
});



function callback1(){
    console.log("Callback1");
}

let callback2 = function (){
    console.log("Callback2");
}

