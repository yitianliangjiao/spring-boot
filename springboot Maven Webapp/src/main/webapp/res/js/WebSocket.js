         function WebSocketTest(url,opendata,callback)
         {
            if ("WebSocket" in window)
            {
               console.log("您的浏览器支持 WebSocket!");
               
               // 打开一个 web socket
               //var ws = new WebSocket("ws://127.0.0.1:8080/echo");
               var ws = new WebSocket(url);
               ws.onopen = function()
               {
                  // Web Socket 已连接上，使用 send() 方法发送数据
                  ws.send(opendata);
                  console.log("数据发送中...");
               };
                
               ws.onmessage = function (evt) 
               { 
                  var received_msg = evt.data;
                  console.log(received_msg);
                  callback(evt);
               };
                
               ws.onclose = function()
               { 
                  // 关闭 websocket
            	   console.log("连接已关闭..."); 
               };
            }
            
            else
            {
               // 浏览器不支持 WebSocket
               console.log("您的浏览器不支持 WebSocket!");
            }
         }