var Admin=function () {
    //var img_1;
    var admin_pic;
    var admin_email;
    var admin_name;
    var data1;
    
    var getAdminM = function () {
        admin_pic=$(".admin_pic");
        admin_email = $(".admin_email");
        admin_name =$(".admin_name");
        $.ajax(
            {
                url:"/admin/msg",
                success:function (data) {
                    if (data.status===200){
                        data1 =data.data;
                        if (data.data.a_pic!=null && data.data.a_pic!=''){
                            admin_pic.each(function () {
                                //this.src=data.data.a_pic;
                                $(this).attr("src",data.data.a_pic);
                            });
                        }

                        if (data.data.a_name !=null && data.data.a_name !=''){
                            admin_name.each(function () {
                                $(this).text(data.data.a_name);
                            });
                        }

                       if (data.data.email !=null && data.data.email!=''){
                           admin_email.each(function () {
                               $(this).text(data.data.email)
                           });
                       }

                    }else {
                        alert("失败")
                    }
                }
            }
        )
    }

    var getData = function () {
        return data1;
    }
    return {
        admin:function(){
            getAdminM();

        },
        data:function f() {
            getData();
        }
    }
}();