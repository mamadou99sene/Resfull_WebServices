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
 * Home object for domain model class Structuredesante.
 * @see bdbeans.Structuredesante
 * @author Hibernate Tools
 */
public class StructuredesanteHome {

	private static final Log log = LogFactory.getLog(Structuredesante.class);
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

	public  Structuredesante connexion(String login) {
		Session session=null;
		if (null == login ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Structuredesante.class);
			crit.add(Restrictions.eq("login", login.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Structuredesante st = (Structuredesante)o;//sous-classement
			session.close();
			return st;
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
	public List<Structuredesante> getAllStructuredeSante(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Structuredesante.class);
		//crit.add(Restrictions.eq("categorie", "Structuredesante".trim()));
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Structuredesante> res=(ArrayList<Structuredesante>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Structuredesante  findStructuredeSanteByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Structuredesante.class);
			crit.add(Restrictions.eq("idStructuresante", id));

			Structuredesante s = (Structuredesante)crit.uniqueResult();
			if (s==null){session.close();return null;}
			else {session.close();return s;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	public  Structuredesante findIfNumCarteExiste(String login) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Structuredesante.class);
			crit.add(Restrictions.eq("login", login.trim()));

			Structuredesante user = (Structuredesante)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Structuredesante findIfEmailExiste(String email) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Structuredesante.class);
			crit.add(Restrictions.eq("email", email.trim()));

			Structuredesante structure = (Structuredesante)crit.uniqueResult();
			if (structure==null){session.close();return null;}
			else {session.close();return structure;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Structuredesante findIfTelephoneCarteExiste(String telephone) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Structuredesante.class);
			crit.add(Restrictions.eq("telephone", telephone.trim()));

			Structuredesante structure = (Structuredesante)crit.uniqueResult();
			if (structure==null){session.close();return null;}
			else {session.close();return structure;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Structuredesante findIfNumCarteExistePourAutreParking(String login, int idStructuresante) {
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Structuredesante.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.ne("idStructuresante", idStructuresante));
			Structuredesante structure = (Structuredesante)crit.uniqueResult();
			if (structure==null){session.close();return null;}
			else {session.close();return structure;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public void persist(Structuredesante transientInstance) {
		log.debug("persisting Structuredesante instance");
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
	public void update(Structuredesante transientInstance) {
		log.debug("update Structuredesante instance");
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
	public void delete(Structuredesante transientInstance) {
		log.debug("deleting Structuredesante instance");
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
	public List<Structuredesante> findByExample(Structuredesante instance) {
		log.debug("finding Structuredesante instance by example");
		try {Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Structuredesante.class);
			List<Structuredesante> results = (List<Structuredesante>)crit.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public int findNumberOfInstanceStructuredeSante() {
		Session session=null;
		log.debug("finding Structuredesante instance by example");
		try {session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Structuredesante.class);
			List<Structuredesante> results = (List<Structuredesante>)crit.list();
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
	public List<Structuredesante> getAllStructuredesanteUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Structuredesante";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Structuredesante> xx=(List<Structuredesante>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}
	public Structuredesante getStructuredeSanteById(int idstructure){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Structuredesante where idStructuresante=:id";
	    Query query = session.createQuery (SQL_QUERY);
	    query.setInteger("id", idstructure);
	    @SuppressWarnings("rawtypes")
		Structuredesante parking=(Structuredesante) query.uniqueResult();
	    return parking;
	}
	

	
}
