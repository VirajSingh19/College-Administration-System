<%@page import ="College.MyServlet"%>
<jsp:include page="header.jsp"/>   

<div align="right">
</div>

<div align='center' style='padding-top:10em' class='fl w-100'>
<article class="br4 ba dark-gray b--black-10 mv4 w-100 w-50-m w-25-l mw6 shadow-5 center">
      <form  action = "Welcome"  method = "GET" >
  			<label>
  				<select class="grow br2 br3 b--white" name="select" style="" >
	  				<option value="Marks">Marks</option>
	  				<option value="Attendance">Attendance</option>
	  				<option value="Fee">Balance Fee</option>
				</select>
			</label>		
       <input class="dim bw2 br3 grow b--white" type = "submit" value = "Submit" style=""/><br><br>
       <a href="Settings.jsp"  title="Login"><img class="grow dim mt4 mr4"  height="30px" width="30px" src="d:/settings.svg" /></a>
      </form> 
 </article>
 <p align='center' class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Welcome <%=(String)MyServlet.session.getAttribute("user")%></p>
  
<button class='f1 dim bw2 br3 grow b--white' onclick="location.href='Form.jsp'"  type='button'  style="font-family: 'Libre Barcode 128 Text', cursive;">Logout</button>
</div>

</body>
</html>
