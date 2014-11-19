<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<script src="./resources/sockjs-0.3.4.min.js"></script>
    <script src="./resources/stomp.min.js"></script>
	<script type="text/javascript">
		function connect() {
	        var socket = new SockJS('/projectbrowsergamespring/testreg');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            console.log('Connected: ' + frame);
	            stompClient.subscribe('/test1/dayum', function(greeting){
	            	alert(greeting.body);
	            });
	        });
	    }
		connect();
	</script>
DAYUUUUUUUUUUUUUUUUUM
</body>
</html>