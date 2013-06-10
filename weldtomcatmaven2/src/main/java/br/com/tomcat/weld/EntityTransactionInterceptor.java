package br.com.tomcat.weld;
import java.io.Serializable;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Declarative JPA EntityTransactions
 *
 * @author Gavin King
 */
@Transactional
@Interceptor
public class EntityTransactionInterceptor  implements Serializable
{

    private
    @Inject
    @Any
    EntityManager em;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception
    {
    	
//    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("foo");
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		Book b = new Book();
//		b.setId(1L);
//		b.setAuthor("xxx");
//		b.setName("dsda");
//		em.persist(b);
//		em.flush();
////		em.getTransaction().commit();
//		
////		em.close();
////		emf.close();			
//    	
    	boolean act = false;
        
    	try{
    		act = !em.getTransaction().isActive();
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	
    	
        if (act)
        {
            em.getTransaction().begin();
        }
        try
        {
            Object result = ic.proceed();
            if (act)
            {
                em.getTransaction().commit();
            }
            return result;
        }
        catch (Exception e)
        {
            if (act)
            {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }
}