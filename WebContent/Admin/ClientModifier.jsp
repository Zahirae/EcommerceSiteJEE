<%@page import="Beans.Client"%>
<%@page import="dao.ClientDao"%>
<% 
    String log="";
	try{
        log = request.getParameter("login");
        }catch(Exception ex){
            
        }
    Client f = (new ClientDao()).findByLogin(log);
    if(f == null)
      f = new Client();      
%>

<%@include file="_header.jsp" %>

<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajout de Client</h1></div>


<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
<tr>
	<th rowspan="3" class="sized"><img src="images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
	<th class="topleft"></th>
	<td id="tbl-border-top">&nbsp;</td>
	<th class="topright"></th>
	<th rowspan="3" class="sized"><img src="images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
</tr>
<tr>
	<td id="tbl-border-left"></td>
	<td>
	<!--  start content-table-inner -->
        <div id="content-table-inner" style="width: 60%;float: left">
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
	<td>
	
	
		<!--  start step-holder -->
		<div id="step-holder">
			<div class="step-no"> - </div>
			<div class="step-dark-left"><a href="">D�tails du Client</a></div>
			<div class="step-dark-right">&nbsp;</div>
			<div class="step-no-off"> # </div>
			<div class="step-light-left">Veillez saisir les d�tails </div>
			<div class="step-light-right">&nbsp;</div>
			
		</div>
		<!--  end step-holder -->
	
		<!-- start id-form -->
                <form method="GET" action="../ModifierClientServlet">
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                    <% int etat=f.getEtat();
                            String etatf="";   
                        if(etat==0)
                            etatf="Bloqu�";
                        else
                             etatf="Actif";
                    %>
		<!--
                <tr>
			<th valign="top">ID :</th>
                        <td><input name="id" type="number" min="1" required class="inp-form"   /></td>
			<td></td>
		</tr>
                -->
                
            
                
		<tr>
			<th valign="top">nom</th>
                        <td><input name="nom" value="<%= f.getNom() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                
		<tr>
			<th valign="top">prenom</th>
                        <td><input name="prenom" value="<%= f.getPrenom() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                <tr>
			<th valign="top">Login</th>
                        <td><input name="login" value="<%= f.getEmail() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
		
		  
		
		   <tr>
			<th valign="top">mot de passe</th>
                        <td><input name="mdp" value="<%= f.getPassword() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                
                 <tr>
			<th valign="top">Etat</th>
                        <td><input name="etat" value="<%=etatf %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                
		<tr>
		<th valign="top">Date :</th>
		<td class="noheight">
		
			<table border="0" cellpadding="0" cellspacing="0">
			<tr  valign="top">
				<td>
				
				<select name="date_j" id="d" class="styledselect-day">
					<option value="">dd</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
				</select>
				</td>
				<td>
					<select name="date_m" id="m" class="styledselect-month">
						<option value="">mmm</option>
						<option value="1">Jan</option>
						<option value="2">Feb</option>
						<option value="3">Mar</option>
						<option value="4">Apr</option>
						<option value="5">May</option>
						<option value="6">Jun</option>
						<option value="7">Jul</option>
						<option value="8">Aug</option>
						<option value="9">Sep</option>
						<option value="10">Oct</option>
						<option value="11">Nov</option>
						<option value="12">Dec</option>
					</select>
				</td>
				<td>
					<select name="date_a" id="y"  class="styledselect-year">
                                                <% 
                                                    for(int i = 1900; i < 2015; i ++)
                                                    {
                                                %>    
                                                    <option value="<%= i %>"><%= i %></option>
                                                    
                                                <% } %>
                                                
						
					</select>
					
				</td>
				<td><a href=""  id="date-pick"><img src="images/forms/icon_calendar.jpg"   alt="" /></a></td>
			</tr>
			</table>
		
		</td>
		<td></td>
	</tr>
	
        

        
        
        
	<!--<tr>
	<th>Image :</th>
        <td><input name="image" type="file" class="file_1" /></td>
	<td>
	<div class="bubble-left"></div>
	<div class="bubble-inner">JPEG, GIF 5MB max per image</div>
	<div class="bubble-right"></div>
	</td>
	</tr>
        -->
	
	
        
        
	<tr>
		<th>&nbsp;</th>
		<td valign="top">
                    <input type="submit" value="" class="form-submit" />
			<input type="reset" value="" class="form-reset"  />
		</td>
		<td></td>
	</tr>
	</table>
	<!-- end id-form  -->
        </form>
                
	</td>
	<td>

	

</td>
</tr>
<tr>
<td><img src="images/shared/blank.gif" width="695" height="1" alt="blank" /></td>
<td></td>
</tr>
</table>
 
<div class="clear"></div>
 

</div>
<!--  end content-table-inner  -->


</td>
<td id="tbl-border-right"></td>
</tr>
<tr>
	<th class="sized bottomleft"></th>
	<td id="tbl-border-bottom">&nbsp;</td>
	<th class="sized bottomright"></th>
</tr>
</table>









 





<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->

 
<%@include file="_footer.jsp" %>
