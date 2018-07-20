<jsp:include page="header.jsp"/>

   <div align="center" style="padding-top:10em" class="fl w-100" >
  <article class="br4 ba dark-gray b--black-10 mv4 w-100 w-50-m w-25-l mw6 shadow-5 center">
      <form  action = "MyServlet"  method = "GET" >
         <p class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Username:</p> <input class="notebook f3 bl br2 bw2 br-pill b--white grow" type = "text" name = "firstname" required><br>
         <br/>
         <p class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Password:</p> <input class=" notebook f3 bl br-pill bw2 b--white grow" type = "password" name = "lastname" required/><br><br>
         <input class="fs40 dim bw2 br3 grow b--white" type = "submit" value = "Submit" style="font-family: 'Libre Barcode 128 Text', cursive;"/><br><br>
         <a href="Register.jsp"  class="f2 dim bw2 br3 grow b--white" style="font-family: 'Cabin Sketch', cursive;">Register</a>
      </form> 
      </article>
   </div>
   </body>
</html>
 