
$("#btn").click(()=>{
    let productId = $("#productId").val();

    $.get("https://dummyjson.com/products/"+productId, (repsonse)=>{
        console.log(repsonse);
        console.log(repsonse.title);
    });
});


$.get("https://dummyjson.com/products", (repsonse)=>{
    console.log(repsonse.products.length);
    for(let item of repsonse.products){
        console.log(item);
        let result = '<div class="card" style="width: 18rem;">';
        result = result + '<img src="'+item.thumbnail+'" class="card-img-top" alt="...">';
        result = result + '<div class="card-body">';
        result = result +'<h5 class="card-title">'+item.title+'</h5>';
        result = result + '<p class="card-text">'+item.description+'</p>';
        result = result + '<a href="#" class="btn btn-primary detail" data-productId="'+item.id+'">'+item.price+'</a>';
        result = result + '</div></div>';
        $("#productList").append(result);
    }
});

$("#productList").on("click", "detail", function(){
    console.log("ID :", $(this).attr("data-productId"));
    e.preventDefault();
});



