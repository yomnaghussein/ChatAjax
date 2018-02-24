/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    
//    alert(name+message);
    $(document).ready(function(){
       
        /*setInterval(getData, 2000);
        function getData(){
            $.ajax({url:'chatServlet',
                type:'POST',
                dataType: 'json',
                success: function (data) {
                    
                    $("#message").val("");
                    $("#messages").html("");
                    $.each(data, function( key, value ) {
                        
                        $("#messages").append("<tr><td>"+value.name+"</td>"+"<td>"+value.message+"</td></tr>");
                        
                        });
            }
                });
        }*/
        
        $("#signup").click(function(){
            var name = $("#name").val();
            var password = $("#password").val();
            var jsonData = {"name":name,"password":password};
            $.ajax({url:'JSONServlet',
                type:'GET',
                contentType: 'application/json',
                data:jsonData,
                dataType: 'json',
                success: function (data) {
                    
                    //$("#message").val("");
                    //$("#messages").html("");
                    //$.each(data, function( key, value ) {
                        
                      //  $("#messages").append("<tr><td>"+value.name+"</td>"+"<td>"+value.message+"</td></tr>");
                        
                       // });
            }
                });
        });
         
     
    });
    