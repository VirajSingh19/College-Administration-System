<jsp:include page="header.jsp"/>

 <div align="center" style="padding-top:10em" class="fl w-100" >
 <p align="left" style="font-family: 'Cabin Sketch', cursive;" class="f2 dim bw2 ml5 grow b--white"> Update Password </p>
<hr>
      <form  action = "Settings"  method = "POST" >
         <p class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Enter old password:</p> <input value="" class=" notebook f3 bl br2 bw2 br-pill b--white grow" type = "password" name="oldpssd"  /><br>
         <br>
         <p class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Enter new password:</p> <input value="" class=" notebook f3 bl br-pill bw2 b--white grow" type = "password" name="newpssd" /><br><br>
         <input class="fs40 dim bw2 br3 grow b--white" type = "submit" value = "Update" style="font-family: 'Libre Barcode 128 Text', cursive;"/><br><br>
<hr>
        <p style="font-family: 'Cabin Sketch', cursive;" class="f2 dim bw2  grow b--white"> Delete Account </p>

         <p class="f2 b--white grow dim" style="font-family: 'Cabin Sketch', cursive;">Enter password:</p> <input class=" notebook f3 bl br-pill bw2 b--white grow" type = "password" name="delpssd" /><br><br>
         <input class="fs40 dim bw2 br3 grow b--white" type = "submit" value = "Delete Account" style="font-family: 'Libre Barcode 128 Text', cursive;"/><br><br>
      </form> 
<hr>      
   </div>
</body>
</html>