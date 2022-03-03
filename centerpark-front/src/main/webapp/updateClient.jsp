<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.*" %>
<%@ page import="util.Context" %>
    
    
    <main>
    
    <%
    int id = Integer.parseInt(request.getParameter("id"));
    Client c = (Client)Context.getSingleton().getDaoCompte().findById(id);
    	
    %>
    
    
    <form id="updateFormCompte">
			<div>
				Mail : <input required type="text" value="<%=c.getMail() %>"placeholder="Saisissez un mail">
			</div>
			<div>
				Password : <input required value="<%=c.getPassword() %>" type="password"
					placeholder="Saisissez un password">
			</div>
			<div>Tel : <input  type="text" value="<%=c.getTel() %>"placeholder="Saisissez le tel"> </div>
			<div>Numero : <input  type="text" value="<%=c.getAdresse().getNumero() %>" placeholder="Saisissez le numero"> </div>
			<div>Voie : <input  type="text" value="<%=c.getAdresse().getVoie() %>" placeholder="Saisissez la voie"> </div>
			<div>CP : <input  type="text" value="<%=c.getAdresse().getCp() %>" placeholder="Saisissez le CP"> </div>
			<div>Ville : <input  type="text" value="<%=c.getAdresse().getVille() %>" placeholder="Saisissez la ville"> </div>

			

			<input type="submit" class="btn btn-success mb-2"
				value="modifier un compte">
			 <a href="comptes.jsp"><button type="button" class="btn btn-danger">Annuler</button></a>
		</form>
    
    
    </main>