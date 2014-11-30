<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<script src="./resources/sockjs-0.3.4.min.js"></script>
    <script src="./resources/stomp.min.js"></script>
    <script src="./resources/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		function connect() {
	        var socket = new SockJS('/projectbrowsergamespring/chatreg');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            console.log('Connected: ' + frame);
	            stompClient.subscribe('/chat/connect', function(message){
	            	$("#chat").val($("#chat").val() + "\n" + message.body);
	            });
	            stompClient.subscribe('/chat/message', function(message){
	            	$("#chat").val($("#chat").val() + "\n" + message.body);
	            });
	            stompClient.send("/app/connect");
	        });
	    }
		connect();
		function sendMessage()
		{
			stompClient.send("/app/message", {}, $("#textinput").val());
			$("#textinput").val("");
		}
		
		
		window.onkeydown = function (e) {
		    var code = e.keyCode ? e.keyCode : e.which;
		    if(code == 13)
	    	{
		    	sendMessage();
	    	}
		};
	</script>
<table>
	<tr>
		<td colspan="2"><textarea rows="20" cols="100" id="chat">test.</textarea></td>
	</tr>
	<tr>
		<td><input type="text" id="textinput"/></td><td><button onclick="sendMessage()">Send</button></td>
	</tr>
</table>
</body>
</html>