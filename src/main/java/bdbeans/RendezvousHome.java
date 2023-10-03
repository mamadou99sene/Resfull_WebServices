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
 * Home object for domain model class Rendezvous.
 * @see bdbeans.Rendezvous
 * @author Hibernate Tools
 */
public class RendezvousHome {

	private static final Log log = LogFactory.getLog(Rendezvous.class);
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

	public  Rendezvous connexion(String login) {
		Session session=null;
		if (null == login ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Rendezvous.class);
			crit.add(Restrictions.eq("login", login.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Rendezvous rv = (Rendezvous)o;//sous-classement
			session.close();
			return rv;
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
	public List<Rendezvous> getAllRendezVous(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Rendezvous.class);
		//crit.add(Restrictions.eq("categorie", "Rendezvous".trim()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Rendezvous> res=(ArrayList<Rendezvous>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Rendezvous  findRendezVousByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Rendezvous.class);
			crit.add(Restrictions.eq("idRendezvous", id));

			Rendezvous rv = (Rendezvous)crit.uniqueResult();
			if (rv==null){session.close();return null;}
			else {session.close();return rv;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	public  Rendezvous findIfNumCarteExiste(String login) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Rendezvous.class);
			crit.add(Restrictions.eq("login", login.trim()));

			Rendezvous user = (Rendezvous)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Rendezvous findIfEmailExiste(String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Rendezvous.class);
			crit.add(Restrictions.eq("email", email.trim()));

			Rendezvous user = (Rendezvous)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Rendezvous findIfTelephoneCarteExiste(String telephone) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Rendezvous.class);
			crit.add(Restrictions.eq("telephone", telephone.trim()));

			Rendezvous rv = (Rendezvous)crit.uniqueResult();
			if (rv==null){session.close();return null;}
			else {session.close();return rv;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Rendezvous findIfNumCarteExistePourAutreParking(String login, int idRendezvous) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Rendezvous.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.ne("idRendezvous", idRendezvous));
			Rendezvous user = (Rendezvous)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public void persist(Rendezvous transientInstance) {
		log.debug("persisting Rendezvous instance");
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
	public void update(Rendezvous transientInstance) {
		log.debug("update Rendezvous instance");
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
	public void delete(Rendezvous transientInstance) {
		log.debug("deleting Rendezvous instance");
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
	public List<Rendezvous> findByExample(Rendezvous instance) {
		log.debug("finding Rendezvous instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Rendezvous.class);
			List<Rendezvous> results = (List<Rendezvous>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstanceRendezVous() {
		Session session=null;
		log.debug("finding Rendezvous instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Rendezvous.class);
			List<Rendezvous> results = (List<Rendezvous>)crit.list();
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
	public List<Rendezvous> getAllRvUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Rendezvous";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Rendezvous> xx=(List<Rendezvous>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public Rendezvous getRendezvousById(int idRendezvous){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Rendezvous where idRendezvous=:id";
	    Query query = session.createQuery (SQL_QUERY);
	    query.setInteger("id", idRendezvous);
	    @SuppressWarnings("rawtypes")
		Rendezvous parking=(Rendezvous) query.uniqueResult();
	    return parking;
	
	}

	
}
