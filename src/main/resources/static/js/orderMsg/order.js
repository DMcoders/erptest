$(document).ready(function () {
    createOrderTable();
    $('#mainFrameTabs').bTabs();
});

var basePath=$("#basePath").val();

var orderTable;
function createOrderTable() {
    if (orderTable != undefined) {
        orderTable.clear(); //清空一下table
        orderTable.destroy(); //还原初始化了的datatable
    }
    orderTable = $('#orderTable').DataTable({
        "retrieve": true,
        "ajax": {
            "url": basePath + "getallorderclothes",
            "data": {},
            "error": function () {
                swal("OMG!", "发生了未知错误，请联系技术童鞋～～～!", "error");
            }
        },
        language : {
            processing : "载入中",//处理页面数据的时候的显示
            paginate : {//分页的样式文本内容。
                previous : "上一页",
                next : "下一页",
                first : "第一页",
                last : "最后一页"
            },
            zeroRecords : "没有内容",//table tbody内容为空时，tbody的内容。
            //下面三者构成了总体的左下角的内容。
            info : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//左下角的信息显示，大写的词为关键字。
            infoEmpty : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//筛选为空时左下角的显示。
            infoFiltered : ""//筛选之后的左下角筛选提示(另一个是分页信息显示，在上面的info中已经设置，所以可以不显示)，
        },
        pageLength : 10,// 每页显示10条数据
        pagingType : "full_numbers", // 分页样式：simple,simple_numbers,full,full_numbers，
        "paging": true,
        // "ordering" : false,
        "info": false,
        searching:false,
        lengthChange:false,
        "columns": [
        {
            "data": null,
            "title":"序号",
            "defaultContent": "",
            "sClass": "text-center",
            render: function (data, type, row, meta) {
                var no = meta.settings._iDisplayStart + meta.row + 1;
                return no;
            }
        },{
            "data": "orderName",
            "title":"订单号",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "customerName",
            "title":"客户名",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "count",
            "title":"订单量",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "orderDate",
            "title":"订货日期",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "season",
            "title":"季度",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "deadLine",
            "title":"交货日期",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "orderClothesID",
            "title": "操作",
            "defaultContent": "",
            "sClass": "text-center",
        }
        ],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [7], // 指定的列
                "data" : "orderClothesID",
                "render" : function(data, type, full, meta) {
                    return "<a href='#' style='color:#3e8eea' onclick='orderDetail("+data+")'>订单详情</a>&nbsp;&nbsp;<a href='#' style='color:#3e8eea' onclick='deleteOrder("+data+")'>删除</a>";
                }
            }]
    });
}

function addCustomer(customerID,customerName,companyName,linkmanName,linkmanPhone,companyAddress) {
    $.blockUI({
        css: {
            width: '30%',
            top: '15%',
            border: 'none',
            padding: '15px',
            backgroundColor: '#fff',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: 1,
            color: '#000'
        },
        message: $('#editPro')
    });
    var url = basePath + "addcustomer";
    if(customerID) {
        $("#customerName").val(customerName);
        $("#companyName").val(companyName);
        $("#linkmanName").val(linkmanName);
        $("#linkmanPhone").val(linkmanPhone);
        $("#companyAddress").val(companyAddress);
        $("#customerID").val(customerID);
        url = basePath + "updatecustomer";
    }
    $("#editYes").unbind("click").bind("click", function () {
        if($("#customerName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入顾客名！</span>",html: true});
            return false;
        }
        if($("#companyName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入公司名！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                customerID:customerID,
                customerName:$("#customerName").val(),
                companyName:$("#companyName").val(),
                linkmanName:$("#linkmanName").val(),
                linkmanPhone:$("#linkmanPhone").val(),
                companyAddress:$("#companyAddress").val()
            },
            success: function (data) {
                if(data == 0) {
                    $.unblockUI();
                    $("input").val("");
                    swal({
                        type:"success",
                        title:"",
                        text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，保存成功！</span>",
                        html: true
                    },
                    function(){
                        location.href=basePath+"customerStart";
                    });
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，保存失败！</span>",html: true});
                }
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        });
    });
    $("#editNo").unbind("click").bind("click", function () {
        $.unblockUI();
        $("input").val("");
    });
}

function deleteCustomer(customerID) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除该顾客的信息吗？</span>",
        type: "warning",
        html:true,
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        cancelButtonText:"我再想想",
        confirmButtonColor: "#ec6c62",
        showLoaderOnConfirm: true
    }, function() {
        $.ajax({
            url: basePath + "deletecustomer",
            type:'POST',
            data: {
                customerID:customerID
            },
            success: function (data) {
                if(data == 0) {
                    $.unblockUI();
                    $("input").val("");
                    swal({
                            type:"success",
                            title:"",
                            text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，删除成功！</span>",
                            html: true
                        },
                        function(){
                            location.href=basePath+"customerStart";
                        });
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，删除失败！</span>",html: true});
                }
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        })
    });
}

var tabId = 1;
function addOrder() {
    $('#mainFrameTabs').bTabsAdd("tabId"+tabId,"订单录入","addOrderStart");
    tabId++;
}