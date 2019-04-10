$(document).ready(function () {
});

var basePath=$("#basePath").val();

function search() {
    if($("#orderName").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的订单号！</span>",html: true});
        return false;
    }
    $.ajax({
        url: basePath + "embstoragequery",
        type:'GET',
        data: {
            orderName:$("#orderName").val(),
            colorName:$("#colorName").val(),
            bedNumber:$("#bedNumber").val(),
            sizeName:$("#sizeName").val(),
        },
        success: function (data) {
            if(data) {
                var json = JSON.parse(data);
                createOrderTable(json);
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，没有查到相关信息！</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
}

var orderTable;
function createOrderTable(data) {
    if (orderTable != undefined) {
        orderTable.clear(); //清空一下table
        orderTable.destroy(); //还原初始化了的datatable
    }
    orderTable = $('#orderTable').DataTable({
        "data":data,
        language : {
            processing : "载入中",//处理页面数据的时候的显示
            paginate : {//分页的样式文本内容。
                previous : "上一页",
                next : "下一页",
                first : "第一页",
                last : "最后一页"
            },
            search:"搜索：",
            zeroRecords : "没有内容",//table tbody内容为空时，tbody的内容。
            //下面三者构成了总体的左下角的内容。
            info : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//左下角的信息显示，大写的词为关键字。
            infoEmpty : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//筛选为空时左下角的显示。
            infoFiltered : ""//筛选之后的左下角筛选提示(另一个是分页信息显示，在上面的info中已经设置，所以可以不显示)，
        },
        "paging": false,
        "info": false,
        searching:false,
        lengthChange:false,
        "columns": [
        {
            "data": null,
            "title":"序号",
            "width":"10%",
            "defaultContent": "",
            "sClass": "text-center",
            render: function (data, type, row, meta) {
                var no = meta.settings._iDisplayStart + meta.row + 1;
                return no;
            }
        },{
            "data": "embStoreLocation",
            "title":"仓库",
            "width":"30%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "embStorageQueryCount",
            "title":"库存数量",
            "width":"50%",
            "defaultContent": "",
            "sClass": "text-center",
        }
        ]
    });
}