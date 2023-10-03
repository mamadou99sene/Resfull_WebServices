package controller;

import java.util.List;

import bdbeans.Utilisateur;
import bdbeans.UtilisateurHome;

public class UtilisateurController {
	public List<Utilisateur> getAllUser()
	{
		return new UtilisateurHome().findByExample(null);
		
	}

	public void createUser(Utilisateur u)
	{
		new UtilisateurHome().persist(u);
	}
	public void deleteUser(Utilisateur u)
	{
		new UtilisateurHome().delete(u);
	}
	

}
