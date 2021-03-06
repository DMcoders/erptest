var tailorQcode = [];
var basePath=$("#basePath").val();

$(document).ready(function () {
    $("#opaQcode")[0].focus();

    document.onkeyup = function (event) {
        e = event ? event : (window.event ? window.event : null);
        if(e.keyCode==13 && e.target.getAttribute("id")=="opaQcode") {
            // var areaRows = $("#tailorQcode").val().split("\n").length;
            var areaValue = $("#opaQcode").val().split("\n");
            var qrCode = [];
            $.each(areaValue, function (index, value) {
                var flag = true;
                $.each(qrCode,function (index,item) {
                    if(item == value) {
                        flag = false;
                    }
                })
                if(flag && value!="") {
                    qrCode.push(value);
                }
            });
            tailorQcode = qrCode;
            $("#scanNum").html("已扫描" + qrCode.length + "件");
            // var msg = new SpeechSynthesisUtterance("扫描成功");
            // window.speechSynthesis.speak(msg);
            var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text=" + encodeURI("扫描成功");// baidu
            var n = new Audio(url);
            n.src = url;
            n.play();
        }else if(e.keyCode==8 && e.target.getAttribute("id")=="opaQcode") {
            var areaValue = $("#opaQcode").val().split("\n");
            var qrCode = [];
            $.each(areaValue, function (index, value) {
                var flag = true;
                $.each(qrCode,function (index,item) {
                    if(item == value) {
                        flag = false;
                    }
                })
                if(flag && value!="") {
                    qrCode.push(value);
                }
            });
            tailorQcode = qrCode;
            $("#scanNum").html("已扫描"+qrCode.length+"件");
        }
    }
});

function opaMatch() {
    if(tailorQcode.length==0) {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请扫描花片二维码！</span>",html: true});
        return false;
    }
    var matchJson = {};
    matchJson.tailorQcode = tailorQcode;

    $.ajax({
        url: basePath + "getMatch",
        type:'GET',
        data: {matchJson:JSON.stringify(matchJson)},
        success: function (data) {
            // console.log(data);
            var goodsLocation = "";
            $.each(data, function(index, item) {
                goodsLocation += item;
                goodsLocation += "\n";
            })
            $("#storeLocation").val(goodsLocation);

        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
}