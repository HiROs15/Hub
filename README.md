<!--
<script type="text/javascript">
var string = "Hello my name is kyle. What is yours? ";
var length = 16;
var i = 0;
function start() {
var split = string.substring(i) + "" + string.substring(0, i);
var win = split.substring(0, length);
document.getElementById('temp').innerHTML = win;

i++;

if(i == string.length) {
i = 0;
}

setTimeout("start()",300);
}
</script>
<body>
<div id='temp'>fd</div>
<input type=button value=START onclick="start()">
</body>Hub
===
<script type="text/javascript">
var string = "Hello my name is kyle. What is yours? ";
var length = 16;
var i = 0;
function start() {
var split = string.substring(i) + "" + string.substring(0, i);
var win = split.substring(0, length);
document.getElementById('temp').innerHTML = win;

i++;

if(i == string.length) {
i = 0;
}

setTimeout("start()",300);
}
</script>
<body>
<div id='temp'>fd</div>
<input type=button value=START onclick="start()">
</body>
</code>
