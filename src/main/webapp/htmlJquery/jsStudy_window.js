const btn1 = document.getElementById("btn1");


btn1.addEventListener("click", function(){
    //window.open("./new.html", "test", "width=400, heigth=100, top=100, left=200");
    clearInterval(st);
});

//set Timeout
setTimeout(function(){
    alert("time");
}, 1000);

let st = setInterval(function(){
    console.log("Interval");
}, 1000);







