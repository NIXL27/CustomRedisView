<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Redis可视化</title>
    <style>
        #box{
            height: 700px;
            width: 1000px;
            margin: 10px auto;
        }

        #title{
            display: flex;
            height: 50px;
            background-color: rgba(7, 7, 7, 0.91);
            align-items: center;
            justify-content: center;
        }

        #title > div{
            font-size: 30px;
            color: white;
        }

        #connect{
            display: flex;
            height: 100px;
            border: 2px solid;
            align-items: center;
            justify-content: space-around;
        }

        input{
            height: 30px;
            outline: none;
        }

        #connect > div{
            font-size: 20px;
        }

        button{
            height: 35px;
            width: 100px;
        }

        #innerbox{
            margin-top: 20px;
            display: flex;
        }

        #left{
            height: 530px;
            width: 380px;
            border: 1px solid;
        }

        #right{
            display: flex;
            margin-left: 20px;
            height: 530px;
            width: 600px;
            border: 1px solid;
            justify-content: space-around;
        }

        #setKey > span{
            display: inline-block;
        }

        #setKey > button{
            margin-left: 390px;
        }


    </style>
</head>
<body>
    <div id="title">
        <div>Redis工具</div>
    </div>
    <div id="box">
        <form id="info">
            <div id="connect">
                <div>
                    <span>服务器地址：</span>
                    <input type="text" name="host"/>
                </div>
                <div>
                    <span>连接端口：</span>
                    <input type="text" name="port"/>
                </div>
                <button id="change" onclick="connect()">连接</button>
            </div>
        </form>
        <div id="innerbox">
            <div id="left">
                <div id="top">
                    <span>键列表:</span>
                </div>
                <form>
                <div id="findByKey">
                    <input type="text" name="key"/>
                    <button type="submit">查询</button>
                </div>
            </form>
                <div id="result"></div>
            </div>
            <div id="right">
                <div id="setKey">
                    <span>键值:</span>
                    <button>设置键值</button>
                </div>
                <div id="value"></div>
            </div>
        </div>
    </div>
    
</body>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    // function connect(){
    //     var info = $("#info").serialize();
    //     $.ajax({
    //         URL:redis/connect,
    //         type: "post",
    //         data: info,
    //         success: function(code){
    //             if(code.success){
    //                 $("#change").html("断开");
    //             }
    //         }
    //
    //     })
    //
    // }
</script>
</html>