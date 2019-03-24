$(document).ready(function () {
    $("#embStoreQcode")[0].focus();

    document.onkeyup = function (event) {
        var isie = (document.all) ? true : false;
        e = event ? event : (window.event ? window.event : null);
        if (e.keyCode==13 && e.target.getAttribute("id")=="embStoreQcode") {
            $("#tailorQcode").focus();
        }else if(e.keyCode==13 && e.target.getAttribute("id")=="tailorQcode") {
            // var areaRows = $("#tailorQcode").val().split("\n").length;
            var areaValue = $("#tailorQcode").val().split("\n");
            var areaRows=0;
            $.each(areaValue,function (item,value) {
                if(value!="") {
                    areaRows++;
                }
            });
            $("#scanNum").html("已扫描"+areaRows+"件");
        }else if(e.keyCode==8 && e.target.getAttribute("id")=="tailorQcode") {
            var areaValue = $("#tailorQcode").val().split("\n");
            var areaRows=0;
            $.each(areaValue,function (item,value) {
                if(value!="") {
                    areaRows++;
                }
            });
            $("#scanNum").html("已扫描"+areaRows+"件");
        }
    }
});