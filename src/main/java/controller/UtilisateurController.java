package controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import bdbeans.Utilisateur;
import bdbeans.UtilisateurHome;
@Path("utilisateurs")
public class UtilisateurController {
	private UtilisateurHome userHome;
	public UtilisateurController()
	{
		userHome=new UtilisateurHome();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Utilisateur> getUtilisateurs()
	{
		return userHome.getAllUser();
		
	}
	@Path("{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Utilisateur getUtiliateur(@PathParam("id") int id)
	{
		return userHome.findUserByID(id);
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void add(Utilisateur u)
	{
		 userHome.persist(u);
	}
	@Path("{idUtilisateur}")
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deleteUser(@PathParam("idUtilisateur")int iduser, Utilisateur u)
	{
		u=userHome.findUserByID(iduser);
		userHome.delete(u);
	}
	@Path("{id}")
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void update(@PathParam("id") int idUtilisateur, Utilisateur u)
	{
		u=userHome.findUserByID(idUtilisateur);
		userHome.update(u);
	}

}
