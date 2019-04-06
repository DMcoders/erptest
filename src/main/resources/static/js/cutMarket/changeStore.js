var tailorQcode = [];
var basePath=$("#basePath").val();

$(document).ready(function () {
    $("#changeStoreQcode")[0].focus();

    document.onkeyup = function (event) {
        e = event ? event : (window.event ? window.event : null);
        if (e.keyCode==13 && e.target.getAttribute("id")=="changeStoreQcode") {
            $("#tailorQcode").focus();
            // var msg = new SpeechSynthesisUtterance("扫描成功");
            // window.speechSynthesis.speak(msg);
            var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text=" + encodeURI("扫描成功");// baidu
            var n = new Audio(url);
            n.src = url;
            n.play();
        }else if(e.keyCode==13 && e.target.getAttribute("id")=="tailorQcode") {
            // var areaRows = $("#tailorQcode").val().split("\n").length;
            var areaValue = $("#tailorQcode").val().split("\n");
            var qrCode = [];
            $.each(areaValue, function (index, value) {
                var flag = true;
                $.eah(qrCode,function (index,item) {
                    if(item == value) {
                        flag = false;
                    }