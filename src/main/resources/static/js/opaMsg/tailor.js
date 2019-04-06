$(document).ready(function () {
    // createOrderTable();
    $('#mainFrameTabs').bTabs();

    $('#orderListTab').click(function(){
        createOrderTable();
    });
});

//计算内容区域高度
function calcHeight(){
    var browserHeight = $(window).innerHeight();
    var topHeight = $('#mainFrameHeadBar').outerHeight(true);
    var tabMarginTop = parseInt($('#mainFrameTabs').css('margin-top'));//获取间距
    var tabHeadHeight = $('ul.nav-tabs',$('#mainFrameTabs')).outerHeight(true) + tabMarginTop;
    var contentMarginTop = parseInt($('div.tab-content',$('#mainFrameTabs')).css('margin-top'));//获取内容区间距
    var contentHeight = browserHeight - topHeight - tabHeadHeight - contentMarginTop;
    $('div.tab-content',$('#mainFrameTabs')).height(contentHeight);
};

var basePath=$("#basePath").val();

function createOrderTable() {

}

var tabId = 1;
function addTailor(orderName) {
    if(orderName) {
        $('#mainFrameTabs').bTabsAdd("tabId" + orderName, "订单详情", "addTailorStart?orderName="+orderName);
    }else {
        $('#mainFrameTabs').bTabsAdd("tabId" + tabId, "裁片信息录入", "addTailorStart");
    }
    tabId++;
    calcHeight();
}


function printer() {
    var tailorList = [];
    $("#tailorBody input[type='checkbox']:checked").each(function () {
        var tailor = {};
        tailor.orderName = $(this).parent().parent().find("td").eq(2).text();
        tailor.customerName = $(this).parent().parent().find("td").eq(3).text();
        tailor.colorName = $(this).parent().parent().find("td").eq(4).text();
        tailor.jarName = $(this).parent().parent().find("td").eq(5).text();
        tailor.bedNumber = $(this).parent().parent().find("td").eq(6).text();
        tailor.layerCount = $(this).parent().parent().find("td").eq(7).text();
        tailor.packageNumber = $(this).parent().parent().find("td").eq(8).text();
        tailor.partName = $(this).parent().parent().find("td").eq(9).text();
        tailor.sizeName = $(this).parent().parent().find("td").eq(10).text();
        tailor.tailorQcode = $(this).parent().parent().find("td").eq(11).text();
        tailorList.push(tailor);
    });
    if(tailorList.length<1){
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请选择要打印的信息！</span>",html: true});
    }else{
        console.log(tailorList);
        $("#tailorBody input[type='checkbox']:checked").each(function () {
            $("#printOrderName").text($(this).parent().parent().find("td").eq(2).text());
            $("#printCustomerName").text($(this).parent().parent().find("td").eq(3).text());
            $("#printColorName").text($(this).parent().parent().find("td").eq(4).text());
            $("#printJarName").text($(this).parent().parent().find("td").eq(5).text());
            $("#printBedNumber").text($(this).parent().parent().find("td").eq(6).text());
            $("#printLayerCount").text($(this).parent().parent().find("td").eq(7).text());
            $("#printPackageNumber").text($(this).parent().parent().find("td").eq(8).text());
            $("#printPartName").text($(this).parent().parent().find("td").eq(9).text());
            $("#printSizeName").text($(this).parent().parent().find("td").eq(10).text());
            var tailorQcode = $(this).parent().parent().find("td").eq(11).text();
            var qrcode = new QRCode(document.getElementById("qrcode"), {
                width : 150,
                height : 150
            });
            qrcode.makeCode(tailorQcode);
            var myDoc = {
                documents:document,   // 要打印的div 对象在当前文档document中
                copyrights:'杰创软件拥有版权  www.jatools.com'  // 版权声明,必须
            };
            var jcp = getJCP();
            jcp.print().print(myDoc,false);//直接打印

            $('#qrcode').empty();
        });
        $.ajax({
            url: "/savetailordata",
            data: {tailorList: JSON.stringify(tailorList)},
            success:function(data){
                if(data == 0) {
                    swal({type:"success",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，打印成功！</span>",html: true});
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，打印失败！</span>",html: true});
                }
            },
            error:function(){
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务器发生了未知错误～！</span>",html: true});
            }
        });
    }
}

function showQrCode(obj) {
    $("#printOrderName").text($(obj).parent().parent().find("td").eq(2).text());
    $("#printCustomerName").text($(obj).parent().parent().find("td").eq(3).text());
    $("#printColorName").text($(obj).parent().parent().find("td").eq(4).text());
    $("#printJarName").text($(obj).parent().parent().find("td").eq(5).text());
    $("#printBedNumber").text($(obj).parent().parent().find("td").eq(6).text());
    $("#printLayerCount").text($(obj).parent().parent().find("td").eq(7).text());
    $("#printPackageNumber").text($(obj).parent().parent().find("td").eq(8).text());
    $("#printPartName").text($(obj).parent().parent().find("td").eq(9).text());
    $("#printSizeName").text($(obj).parent().parent().find("td").eq(10).text());
    var tailorQcode = $(obj).parent().parent().find("td").eq(11).text();
    $.blockUI({
        css: {
            width: '20%',
            top: '15%',
            border: 'none',
            padding: '15px',
            backgroundColor: '#fff',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: 1,
            color: '#000'
        },
        message: $('#qrCodeWin')
    });
    // $('#qrcode').qrcode(storehouseLocation);
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 150,
        height : 150
    });
    qrcode.makeCode(tailorQcode);
    $("#closeQrCodeWin").unbind("click").bind("click", function () {
        $.unblockUI();
        $('#qrcode').empty();
    });
}

function updateTailor(tabId) {
    $('#mainFrameTabs').bTabsAdd(tabId, "裁片信息录入", "addTailorStart");
    calcHeight();
}
