var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize:true,
        dropdownMenu: true,
        contextMenu:true,
        minRows:12,
        minCols:18,
        // colWidths:70,
        language:'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });
    var orderName=$("#orderName").val();
    var bedNumber=$("#bedNumber").val();
    $.ajax({
        url: "/getbyordernamebednum",
        type:'GET',
        data: {
            orderName:orderName,
            bedNumber:bedNumber
        },
        success: function (data) {
            // console.log(data);
            var hotData = [["订单号","顾客名","床号","颜色","尺码","数量"]];
            var i = 1;
            if(data) {
                $.each(data,function (index,item) {
                    var tmp = [];
                    tmp[0] = item.orderName;
                    tmp[1] = item.customerName;
                    tmp[2] = item.bedNumber;
                    tmp[3] = item.colorName;
                    tmp[4] = item.sizeName;
                    tmp[5] = item.opaTailorCount;
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
});