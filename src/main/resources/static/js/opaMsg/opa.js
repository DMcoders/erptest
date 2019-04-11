$(document).ready(function () {
    laydate.render({
        elem: '#opaDate', //指定元素
        trigger: 'click'
    });

    $('#mainFrameTabs').bTabs();
});

var basePath=$("#basePath").val();

function addOPA() {
    $.blockUI({
        css: {
            width: '30%',
            top: '10%',
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
    var url = basePath + "addopa";
    $("#editYes").unbind("click").bind("click", function () {
        var flag = false;
        $("#editPro input").each(function (index, item) {
            if($(this).val() == "") {
                flag = true;
                return false;
            }
        });
        if(flag) {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入完全部信息！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                orderName:$("#orderName").val(),
                customerName:$("#customerName").val(),
                destination:$("#destination").val(),
                bedNumber:$("#bedNumber").val(),
                opaCount:$("#opaCount").val(),
                opaDate:$("#opaDate").val(),
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
                        location.href=basePath+"opaStart";
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

function deleteOPA(opaID) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除该条信息吗？</span>",
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
            url: basePath + "deleteopa",
            type:'POST',
            data: {
                opaID:opaID
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
                            location.href=basePath+"opaStart";
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

function detail(orderName, bedNumber) {
    $('#mainFrameTabs').bTabsAdd("tabId" + orderName, "详情", "detailOpaStart?orderName="+orderName+"&bedNumber="+bedNumber);
}