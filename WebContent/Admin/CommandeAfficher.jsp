
<%@page import="Beans.Commande"%>
<%@page import="dao.CommandeDao"%>
<%@page import="Beans.Client"%>
<%@page import="java.util.Vector"%>
<%@page import="dao.ClientDao"%>
<%@page import="dao.ArticleDao"%>



<%@include file="_header.jsp" %>

<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">

        <!--  start page-heading -->
        <div id="page-heading">
            <h1>Details de la Commande de <%= request.getParameter("login") %></h1>
        </div>
        <!-- end page-heading -->

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
                    <!--  start content-table-inner ...................................................................... START -->
                    <div id="content-table-inner">

                        <!--  start table-content  -->
                        <div id="table-content">

                            <!--  start message-green -->
                            <%
                                if (request.getParameter("add") != null && request.getParameter("add").equals("success"))
                                {
                            %>
                            <div id="message-green">
                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="green-left">Mise a jour effectu� avec succes ! :D </td>
                                        <td class="green-right"><a class="close-green"><img src="images/table/icon_close_green.gif"   alt="" /></a></td>
                                    </tr>
                                </table>
                            </div>
                            <% } %>
                            <!--  end message-green -->

                            <!--  start message-Red -->
                            <%
                                if (request.getParameter("add") != null && request.getParameter("add").equals("fail"))
                                {
                            %>
                            <div id="message-red">
                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td class="red-left">Error. <a href="FilmAjouter.jsp">Veillez r�essayer !</a></td>
                                        <td class="red-right"><a class="close-red"><img src="images/table/icon_close_red.gif"   alt="" /></a></td>
                                    </tr>
                                </table>
                            </div>
                            <% } %>
                            <!--  end message-Red -->

                            <%
                            int id = -1 ;    
                            
                            if(request.getParameter("id") != null)
                                id = Integer.parseInt(request.getParameter("id"));
                            %>  
                            <!--  start product-table ..................................................................................... -->             
                                <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                    <tr>
                                        <th style="width: 120px" class="table-header-repeat line-left"><a >Commande id</a></th>
                                        <th style="width: 120px"  class="table-header-repeat line-left"><a >Client</a></th>
                                        <th style="width: 120px"  class="table-header-repeat line-left"><a >prix totale</a></th>

                                    </tr>
                                    <%
                                        CommandeDao dao = new CommandeDao();
                                        Commande commande = dao.findById(id);
                                        if (commande != null){
                                     %>
                                       
                                    <tr style="font-weight: bold">

                                        <td><%= commande.getIdCommande() %></td>
                                        <td><%= commande.getLogin() %></td>
                                        <td><%= commande.getPrixTotale() %></td>

									<%} %>
                                    </tr>
                                    <tr>

                                    <td colspan="3" valign="top" >
                                    
                                        <form id="mainform" method="GET"  action="../validerC">
                                        <input name="id" type="hidden" value="<%= id %>"/>
                                        <input type="submit" value="ValiderC" class="form-submit" style="text-align: center" />
                                        </form>
                                        
                                        <form id="mainform" method="GET"  action="../RefuserCommande">
                                        <input name="id" type="hidden" value="<%= id%>"/>
                                        <input type="submit" value="Refuser" class="form-reset"  style="text-align: center"/>
                                        </form>
                                        
                                    </td>
                                    

                                    </tr>

                                </table>
                                <!--  end product-table................................... --> 
                            
                        </div>
                        <!--  end content-table  -->


                        <!--  start actions-box ............................................... -->
                        <!-- ACTION BOX + PAGINATION 
                        
                        <div id="actions-box">
                                <a href="" class="action-slider"></a>
                                <div id="actions-box-slider">
                                        <a href="" class="action-edit">Edit</a>
                                        <a href="" class="action-delete">Delete</a>
                                </div>
                                <div class="clear"></div>
                        </div>
                        <!-- end actions-box........... -->

                        <!--  start paging..................................................... -->
                        <!-- ACTION BOX + PAGINATION 
                        
                        <table border="0" cellpadding="0" cellspacing="0" id="paging-table">
                        <tr>
                        <td>
                                <a href="" class="page-far-left"></a>
                                <a href="" class="page-left"></a>
                                <div id="page-info">Page <strong>1</strong> / 15</div>
                                <a href="" class="page-right"></a>
                                <a href="" class="page-far-right"></a>
                        </td>
                        <td>
                        <select  class="styledselect_pages">
                                <option value="">Number of rows</option>
                                <option value="">1</option>
                                <option value="">2</option>
                                <option value="">3</option>
                        </select>
                        </td>
                        </tr>
                        </table>
                        <!--  end paging................ -->

                        <div class="clear"></div>

                    </div>
                    <!--  end content-table-inner ............................................END  -->
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
<!--  end content-outer........................................................END -->


<%@include file="_footer.jsp" %>


