var hot;

$(document).ready(function () {
    var basePath=$("#basePath").val();
});

function reportCut() {
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize: true,
        dropdownMenu: true,
        contextMenu: true,
        minRows: 20,
        minCols: 20,
        // colWidths:70,
        language: 'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });


    if($("#orderName1").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的订单号！</span>",html: true});
        return false;
    }
    if($("#bedNumber1").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的床号！</span>",html: true});
        return false;
    }
    $.ajax({
        url: "/tailorreport",
        type:'GET',
        data: {
            orderName:$("#orderName1"),
            bedNumber:$("#bedNumber1"),
        },
        success: function (data) {
            console.log(data);
            var hotData = [["颜色","尺码","数量"]];
            var i = 1;
            if(data) {
                $.each(data,function (index,item) {
                    var tmp = [];
                    tmp[0] = item.colorName;
                    tmp[1] = item.sizeName;
                    tmp[2] = item.tailorReportCount;
                    hotData[i] = tmp;
                    i++;
                })
            }
            hot.loadData(hotData);
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })

    
}
