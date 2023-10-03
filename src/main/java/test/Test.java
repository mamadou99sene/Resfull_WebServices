package test;

import java.util.List;

import bdbeans.Utilisateur;
import bdbeans.UtilisateurHome;

public class Test {

	public static void main(String[] args) {
		Utilisateur u=new Utilisateur();
		u.setPrenom("Jean");
		u.setNom("Jaures");
		u.setEmail("jaures@gmail.com");
		u.setPhone("3367890989");
		u.setPassword("JAURES344");
		//new UtilisateurHome().persist(u);
		List<Utilisateur> l=new UtilisateurHome().getAllUser();
		System.out.print(l.size());
	}

}
