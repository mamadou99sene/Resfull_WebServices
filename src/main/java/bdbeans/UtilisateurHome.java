package bdbeans;
// Generated 2 nov. 2022, 16:22:46 by Hibernate Tools 4.3.6.Final

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Utilisateur.
 * @see bdbeans.Utilisateur
 * @author Hibernate Tools
 */
public class UtilisateurHome {

	private static final Log log = LogFactory.getLog(Utilisateur.class);
Session session;
	private static final SessionFactory sessionFactory= hibernate.sessionfactory.open.SessionFactoryProvider.getSessionFactory();
    
	protected SessionFactory getSessionFactory() {
	try {
		return sessionFactory;
	} catch (Exception e) {
		log.error("Could not locate SessionFactory in JNDI", e);
		throw new IllegalStateException("Could not locate SessionFactory in JNDI");
	}
}

	public  Utilisateur connexion(String password) {
		Session session=null;
		if (null == password ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Utilisateur.class);
			crit.add(Restrictions.eq("password", password.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Utilisateur user = (Utilisateur)o;//sous-classement
			session.close();
			return user;
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			// Critical errors : database unreachable, etc.
			return null;
		}
		/*finally{
			session.close();
		}*/
	}
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUser(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Utilisateur.class);
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Utilisateur> res=(ArrayList<Utilisateur>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Utilisateur  findUserByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Utilisateur.class);
			crit.add(Restrictions.eq("idUtilisateur", id));

			Utilisateur user = (Utilisateur)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	public  Utilisateur findIfNumCarteExiste(String login) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Utilisateur.class);
			crit.add(Restrictions.eq("login", login.trim()));

			Utilisateur user = (Utilisateur)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Utilisateur findIfEmailExiste(String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Utilisateur.class);
			crit.add(Restrictions.eq("email", email.trim()));

			Utilisateur user = (Utilisateur)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Utilisateur findIfTelephoneCarteExiste(String telephone) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Utilisateur.class);
			crit.add(Restrictions.eq("telephone", telephone.trim()));

			Utilisateur structure = (Utilisateur)crit.uniqueResult();
			if (structure==null){session.close();return null;}
			else {session.close();return structure;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Utilisateur findIfNumCarteExistePourAutreUser(String login, int iduser) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Utilisateur.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.ne("idUtilisateur", iduser));
			Utilisateur user = (Utilisateur)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public void persist(Utilisateur transientInstance) {
		log.debug("persisting Utilisateur instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		//new RealEncryption(.docry(transientInstance));
		ss.save(transientInstance);
		tx.commit();
		ss.close();
		log.debug("persist successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("persist failed", re);
		throw re;
	}
	}
	public void update(Utilisateur transientInstance) {
		log.debug("update Utilisateur instance");
		Session ss=null;
		try {ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(transientInstance);
		tx.commit();
		ss.close();
		log.debug("update successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("update failed", re);
		throw re;
	}
	}
	public void delete(Utilisateur transientInstance) {
		log.debug("deleting Utilisateur instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);
		tx.commit();
		ss.close();
		log.debug("delete successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("delete failed", re);
		throw re;
	}
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> findByExample(Utilisateur instance) {
		log.debug("finding Utilisateur instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Utilisateur.class);
			List<Utilisateur> results = (List<Utilisateur>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstanceUtiliateur() {
		Session session=null;
		log.debug("finding Utilisateur instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Utilisateur.class);
			List<Utilisateur> results = (List<Utilisateur>)crit.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			session.close();
			return results.size();
		} catch (RuntimeException re) {
			session.close();
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List<Utilisateur> getAllUserUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Utilisateur";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Utilisateur> xx=(List<Utilisateur>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public Utilisateur getUserById(int idUtilisateur){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Utilisateur where idUtilisateur=:id";
	    Query query = session.createQuery (SQL_QUERY);
	    query.setInteger("id", idUtilisateur);
	    @SuppressWarnings("rawtypes")
		Utilisateur parking=(Utilisateur) query.uniqueResult();
	    return parking;
	}
	

	
}
