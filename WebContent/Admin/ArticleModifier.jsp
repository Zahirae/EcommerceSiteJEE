<%@page import="dao.ArticleDao"%>
<%@page import="Beans.Article"%>
<% 
        int id = 0;
        
        try
        {
            
            id = Integer.parseInt(request.getParameter("id"));
        
        }catch(Exception ex){
            
        }
        
        
        Article f = (new ArticleDao()).findByID(id);
        
        if(f == null)
            f = new Article();
        
%>


<%@include file="_header.jsp" %>

<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajout d'un article</h1></div>


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
			<div class="step-dark-left"><a href="">Détails d'un article</a></div>
			<div class="step-dark-right">&nbsp;</div>
			<div class="step-no-off"> # </div>
			<div class="step-light-left">Veillez saisir les détails </div>
			<div class="step-light-right">&nbsp;</div>
			
		</div>
		<!--  end step-holder -->
	
		<!-- start id-form -->
        <form method="GET" action="../ModifierArticle">
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                
        <tr>
			<th valign="top">ID</th>
                        <td>
                            <input type="text" name="id" required  value="<%= f.getIdArticle() %>" class="inp-form" style=";text-align: center;border-width: thin;border-radius:4px  ;background-image: none;background-color:  #ececec" readonly />
                        </td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                
		<tr>
			<th valign="top">Libelle</th>
                        <td><input name="libelle" value="<%= f.getLibelle() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                
		<tr>
			<th valign="top">Prix</th>
                        <td><input name="prix" value="<%= f.getPrix() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
                <tr>
			<th valign="top">Quantité</th>
                        <td><input name="quantite" value="<%= f.getStock() %>" required type="text" class="inp-form"  /></td>
<!--			-error
                        <td>
			<div class="error-left"></div>
			<div class="error-inner">This field is required.</div>
			</td>-->
		</tr>
	<tr>
		<th valign="top">Description</th>
                <td><textarea name="desc" rows="" cols="" class="form-textarea">
                        <%= f.getDescription() %>
                    </textarea></td>
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
	<th>URL Image :</th>
        <td>
            <input name="urlImage" value="<%= f.getImage() %>" placeholder="" type="text" class=""  style="border-style: inset; width: 318px; height: 20px;"/>
        </td>
	<td>
	
	</td>
	</tr>
	
        
        
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

<div id="content-table-inner" style="float: left;width: 38%; margin-top: 50px">
    <img width="400" src="../images/home/article.png" />
</div>
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
