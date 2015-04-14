package edu.neu.cs5200.jpa.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.neu.cs5200.jpa.orm.models.Site;

@Path("/api")
public class SiteDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWS and JPA Assignment");
	EntityManager em = factory.createEntityManager();
	
		// createSite
		public Site createSite(Site site) {
			em.getTransaction().begin();
			em.persist(site);
			em.getTransaction().commit();
			return site;
		}
		


		// readSiteById
		@GET
		@Path("/site/ID/{Id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Site findSite(@PathParam("Id") Integer id)
		{
			return em.find(Site.class, id);
		}
		
		// readAllMovies
		@GET
		@Path("/site")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Site> findAllSites()
		{
			Query query = em.createQuery("select site from Site site");
			return (List<Site>)query.getResultList();
		}
		
		// updateMovie
		public Site updateSite(Site site)
		{
			em.getTransaction().begin();
			em.merge(site);
			em.getTransaction().commit();
			return site;
		}
		// deleteMovie
		public void  removeSite(int id) {
			em.getTransaction().begin();
			Site site = em.find(Site.class, id);
			em.remove(site);
			em.getTransaction().commit();
		}

	
	public static void main(String args[]){
		SiteDAO dao=new SiteDAO();		
		dao.removeSite(3);
		
		
	}

}
