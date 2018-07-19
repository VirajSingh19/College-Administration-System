<%@page import ="College.Welcome"%>
<jsp:include page="header.jsp"/>   

<div align="right">

<a href="Settings.jsp"  title="Login"><img class="mt4 mr4"  height="30px" width="30px" src="d:/settings.svg" /></a>
</div>

<div align='center' style='padding-top:10em' class='fl w-100'>
<p align='center' class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Welcome <%=(String)Welcome.session.getAttribute("user")%></p>
<button class='f1 dim bw2 br3 grow b--white' onclick="location.href='Form.jsp'"  type='button'  style="font-family: 'Libre Barcode 128 Text', cursive;">Logout</button>
</div>

 <span class="alert alert-info">
 <strong>Session id : <%= Welcome.session.getId() %> </strong>  
</span>
</body>
</html>
