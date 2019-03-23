$(document).ready(function () {

});

function login() {
    if($("#userName").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入账号！</span>",html: true});
        return false;
    }
    if($("#passWord").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入密码！</span>",html: true});
        return false;
    }

}