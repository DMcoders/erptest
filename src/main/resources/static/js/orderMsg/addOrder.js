$(document).ready(function () {
    var container = document.getElementById('addOrderExcel');
    var hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize:true,
        dropdownMenu: true,
        contextMenu:true,
        minRows:16,
        minCols:20,
        // colWidths:70,
        language:'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });

});


var basePath=$("#basePath").val();

function addOrder() {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要提交输入的订单信息吗？</span>",
        type: "warning",
        html:true,
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        cancelButtonText:"我再想想",
        confirmButtonColor: "#ec6c62",
        showLoaderOnConfirm: false
    }, function() {
        swal({type:"success",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，提交成功！</span>",html: true});
    })
}