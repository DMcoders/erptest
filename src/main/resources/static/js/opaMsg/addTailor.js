var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
    var type=$("#type").val();
    var container = document.getElementById('layerCountExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: ["层数"],
        // autoColumnSize:true,
        // dropdownMenu: true,
        // contextMenu:true,
        contextMenu: ["row_above", "row_below"],
        minRows:20,
        minCols:1,
        maxCols:1,
        colWidths:130,
        language:'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });
    if(type == "detail") {
        var orderName=$("#orderName").val();
        $.ajax({
            url: "/getorderbyname",
            type:'GET',
            data: {
                orderName:orderName
            },
            success: function (data) {
                console.log(data);
                var hotData = [["顾客名","订购方式","订单号","款式描述","版单号","颜色号","颜色名","尺码","数量","签订日期","季度","交货日期"]];
                var i = 1;
                if(data) {
                    $.each(data,function (index,item) {
                        var tmp = [];
                        tmp[0] = item.customerName;
                        tmp[1] = item.purchaseMethod;
                        tmp[2] = item.orderName;
                        tmp[3] = item.styleDescription;
                        tmp[4] = item.clothesVersionNumber;
                        tmp[5] = item.colorNumber;
                        tmp[6] = item.colorName;
                        tmp[7] = item.sizeName;
                        tmp[8] = item.count;
                        tmp[9] = item.orderDate;
                        tmp[10] = item.season;
                        tmp[11] = item.deadLine;
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

    $('#orderName').keyup(function(){
        var keywords = $(this).val();
        if (keywords=='') { $('#orderNameTips').hide(); return };
        $.ajax({
            url: "/getorderhint",
            data: {"subOrderName": $(this).val()},
            success:function(data){
                $('#orderNameTips').empty().show();
                if (data.orderNameList=='')
                {
                    $('#orderNameTips').append('<li class="error" style="color:red;list-style-type:none">没有结果</li>');
                }
                $.each(data.orderNameList, function(index,element){
                    if(index < 10) {
                        $('#orderNameTips').append('<li id="'+element.orderName+'" class="click_work" style="list-style-type:none">' + element.orderName + '</li>');
                    } else {
                        $('#orderNameTips').append('<div style="color:lightgray">更多选项请搜索</div>');
                        return false;
                    }
                })
            },
            error:function(){
                $('#orderNameTips').empty().show();
                $('#orderNameTips').append('<li style="color:red">搜索发生错误</li>');
            }
        });

        $.ajax({
            url: "/getcustomernamebyordername",
            data: {"orderName": keywords},
            success:function(data){
                $("#customerName").val(data);
            },
            error:function(){
            }
        });
        $("#colorName").empty();
        $.ajax({
            url: "/getcolorhint",
            data: {"orderName": keywords},
            success:function(data){
                if (data.colorList) {
                    $.each(data.colorList, function(index,element){
                        $("#colorName").append("<option value="+element.colorName+">"+element.colorName+"</option>");
                    })
                }
            },
            error:function(){
            }
        });
    });

    $(document).on('click','.click_work',function(){
        var word = $(this).attr("id");
        $('#orderName').val(word);
        $('#orderNameTips').hide();

        $.ajax({
            url: "/getcustomernamebyordername",
            data: {"orderName": $("#orderName").val()},
            success:function(data){
                $("#customerName").val(data);
            },
            error:function(){
            }
        });

        $("#colorName").empty();
        $.ajax({
            url: "/getcolorhint",
            data: {"orderName": $("#orderName").val()},
            success:function(data){
                if (data.colorList) {
                    $.each(data.colorList, function(index,element){
                        $("#colorName").append("<option value="+element.colorName+">"+element.colorName+"</option>");
                    })
                }
            },
            error:function(){
            }
        });
    });

    $("#orderName").blur(function(){
        setTimeout(function(){
            $('#orderNameTips').hide();
        },300);
    });
});

function addOrder() {
    var flag = false;
    $("#baseInfo input").each(function () {
        if($(this).val().trim() == "") {
            flag = true;
            return false;
        }
    })
    if(flag) {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请填写完基本信息！</span>",html: true});
        return false;
    }
    if($("#colorName").val == "") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请填写完基本信息！</span>",html: true});
        return false;
    }
    var tailorDataJson = {};
    tailorDataJson.orderName = $("#orderName").val();
    tailorDataJson.jarName = $("#jarName").val();
    tailorDataJson.customerName = $("#customerName").val();
    tailorDataJson.colorName = $("#colorName").val();
    tailorDataJson.bedNumber = $("#bedNumber").val();
    var data = hot.getData();
    console.log(data);
    var layerCount = {};
    flag = true;
    $.each(data,function (index, item) {
        if(item!=null && item!="") {
            layerCount[index+1] = item[0];
            flag = false;
        }
    });
    if(flag) {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入层数！</span>",html: true});
        return false;
    }
    tailorDataJson.layerCount = layerCount;
    var sizeRatio = {};
    flag = true;
    $("input[name='size']").each(function (index,item) {
        var size = $(this).val();
        var radio = $("input[name='radio']").eq(index).val();
        if(size!=null && size!="" && radio!=null && radio!="") {
            sizeRatio[size] = radio;
            flag = false;
        }
    });
    if(flag) {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入唛架配比！</span>",html: true});
        return false;
    }
    tailorDataJson.sizeRatio =sizeRatio;
    var partName = {};
    flag = true;
    $("input[type='checkbox']").each(function (index,item) {
        if($(this).is(':checked')) {
            partName[index] = $(this).val();
            flag = false;
        }
    })
    if(flag) {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请选择部位！</span>",html: true});
        return false;
    }
    tailorDataJson.partName =partName;
    console.log(tailorDataJson);
    $.ajax({
        url: "/generatetailordata",
        type:'POST',
        data: {
            tailorDataJson:JSON.stringify(tailorDataJson)
        },
        success: function (data) {
            if(data && data!= "null") {
                var json = JSON.parse(data);
                console.log(json);
                swal({type:"success",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，生成成功！</span>",html: true},function () {
                    var href = $("li.active a[data-toggle='tab']",parent.document).attr("href");
                    var tabId = href.substr(7);
                    window.parent.document.getElementById("tailorA").click();
                    var $tailorBody = window.parent.document.getElementById("tailorBody");
                    var numberId = window.parent.document.getElementById("numberID").value;
                    var list = "";
                    $.each(json,function (index,item) {
                        list +=  "<tr>" +
                            "<td><input type='checkbox' value='"+numberId+"'></td>" +
                            "<td>"+numberId+"</td>" +
                            "<td>"+item.orderName+"</td>" +
                            "<td>"+item.customerName+"</td>" +
                            "<td>"+item.colorName+"</td>" +
                            "<td>"+item.jarName+"</td>" +
                            "<td>"+item.bedNumber+"</td>" +
                            "<td>"+item.layerCount+"</td>" +
                            "<td>"+item.packageNumber+"</td>" +
                            "<td>"+item.partName+"</td>" +
                            "<td>"+item.sizeName+"</td>" +
                            "<td>"+item.tailorQcode+"</td>" +
                            "<td><a href='#' style='color:#3e8eea' onclick='showQrCode(this)'>查看</a>&nbsp;&nbsp;&nbsp;<a href='#' style='color:#3e8eea' onclick=updateTailor('"+tabId+"')>修改</a></td>" +
                            "</tr>";
                            numberId++;
                    })
                    $tailorBody.innerHTML = list;
                    window.parent.document.getElementById("tailorBody").value=numberId;
                });
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，生成失败！</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
}

function addSize(obj) {

    $(obj).parent().after('<div style="margin-top: 10px;margin-left: 20px">\n' +
        '                    <label class="control-label" style="">尺码</label>\n' +
        '                    <input name="size" class="form-control" autocomplete="off" style="width:20%">\n' +
        '                </div>\n' +
        '                <div style="margin-bottom: 10px;margin-left: 20px">\n' +
        '                    <label class="control-label" style="">配比</label>\n' +
        '                    <input name="radio" class="form-control" autocomplete="off" style="width:20%">\n' +
        '                    <button  class="btn btn-s-xs" style="border-radius: 5px;margin-left: 10px"  onclick="addSize(this)">增加</button>\n' +
        '                    <button  class="btn btn-s-xs" style="border-radius: 5px;margin-left: 10px;background-color: rgb(236, 108, 98);display: none"  onclick="delSize(this)">删除</button>\n' +
        '                </div>');
    $(obj).next().show();
    $(obj).remove();
}

function delSize(obj) {
    $(obj).parent().prev().remove();
    $(obj).parent().remove();
}

