package edu.neu.cs5200.jpa.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	    @POST
	    @Path("/site")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)	
		public List<Site> createSite(Site site) {
			List<Site> sites=new ArrayList<Site>();
			em.getTransaction().begin();
			em.persist(site);			
			em.getTransaction().commit();
			em.close();
			Query query=em.createNamedQuery("findAllSites");
			sites=query.getResultList();
			return sites;
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
		@PUT
		@Path("/site/ID/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public List<Site> updateSite(@PathParam("id") Integer siteid, Site site)
		{
			List<Site> sites=new ArrayList<Site>();
			em.getTransaction().begin();
			site.setId(siteid);
			em.merge(site);
			em.getTransaction().commit();
			em.close();
			Query query=em.createNamedQuery("findAllSites");
			sites=query.getResultList();
			return sites;
		}
		
		// deleteMovie
		@DELETE
		@Path("/site/ID/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Site> removeSite(@PathParam("id") int id) {
			List<Site> sites=new ArrayList<Site>();
			Site site=null;
			em.getTransaction().begin();
			site = em.find(Site.class, id);
			em.remove(site);
			em.getTransaction().commit();
			em.close();
			Query query=em.createNamedQuery("findAllSites");
			sites=query.getResultList();
			return sites;
		}

		/*
	public static void main(String args[]){
		SiteDAO dao=new SiteDAO();		
		dao.removeSite(3);
		
		
	}
	*/
}
