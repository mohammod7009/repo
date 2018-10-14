<!DOCTYPE html>
 
<html>
    <head>
        <title>WebSocket Test</title>
        <meta charset="UTF-8">
    </head>
    <body>
       
        <div>
            <input type="text" id="messageinput"/>
        </div>
        <div>
            <button type="button" onclick="openSocket();" >Open</button>
            <button type="button" onclick="send();" >Send</button>
            <button type="button" onclick="closeSocket();" >Close</button>
        </div>

        <div id="messages"></div>
       
        <script type="text/javascript">
            var message = document.getElementById("messages");
			var ws;

			function openSocket() {
			
				ws = new WebSocket("ws://localhost:8080/wstest");
				
				ws.onopen = function  (event) {
					writeResponse("opened");	
				};
				ws.onmessage = function  (event) {
					writeResponse("message received: "+ event.data);	
				};
				ws.onclose = function  (event) {
					writeResponse("closed.");	
				};
			}
			
			function send() {
				ws.send(document.getElementById("messageinput").value);
			}
			
			function closeSocket() {
				ws.close();
			}

            function writeResponse(text){
                messages.innerHTML += "<br/>" + text;
            }
        </script>
       
    </body>
</html>