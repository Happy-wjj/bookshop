var path = $("#path").val();
$(function () {
    $("#submit").click(function () {
        var number = $("#number").val();
        var bid = $("#bid").val();
        /* addGoodsInCart?bid=${book.bid}&number=" */
        $.post(path + "/addGoodsInCart", {"number": number, "bid": bid}, function () {
            alert("成功添加入购物车");
        });
    })
})
$(function () {
    $("#buy").click(function () {
        var number = $("#number").val();
        var bid = $("#bid").val();
        /* addGoodsInCart?bid=${book.bid}&number=" */
        $.post(path + "/addGoodsInCart", {"number": number, "bid": bid}, function () {
            window.location.href = path + "/cartPage";
        });
    })
})

function addNum() {
    var num = parseInt(document.getElementById("number").value);
    if (num < 100) {
        document.getElementById("number").value = ++num;
    }
}

function subNum() {
    var num = parseInt(document.getElementById("number").value);
    if (num > 1) {
        document.getElementById("number").value = --num;
    }
}