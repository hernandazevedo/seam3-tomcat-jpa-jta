package br.com.tomcat.weld;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: rossmyt
 * Date: 17.02.2010
 * Time: 16:41:35
 */
@Named(value = "init")
@ApplicationScoped
public class Init implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5815051339599823733L;
//	@Produces
//    @ApplicationScoped
//    @PersistenceContext(unitName = "foo")
    EntityManager em;
	
	public @Produces  @ApplicationScoped EntityManager retrieveEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("foo");
		EntityManager em = emf.createEntityManager();
		
      return em;
    }
}