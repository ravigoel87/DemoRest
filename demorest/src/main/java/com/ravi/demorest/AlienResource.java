package com.ravi.demorest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;


@Path("aliens")
public class AlienResource {
	
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAliens() throws InterruptedException
	{	
		return repo.getAliens();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("alien/{id}")
	public Alien getAlien(@PathParam("id") int id)
	{	
		
		return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	public Alien createAlien(Alien a1)
	{
		System.out.println(a1);
		repo.create(a1);
		return a1;
		
		
	}
	
	@PUT
	@Path("updatealien")
	public Alien updateAlien(Alien a1)
	{
		System.out.println(a1);
		
		if (repo.getAlien(a1.getId()) == null)
		{
			repo.create(a1);
		}
		else
		{
		repo.update(a1);
		}
		
		return a1;
		
		
	}
	
	
	@DELETE
	@Path("delete/{id}")
	public Alien killAlien(@PathParam("id") int id1)
	{
		
		if(repo.getAlien(id1)!=null)
		{
			//repo.deleteAlien(id1);
			
			repo.aliendel(id1);
		}
		
		return null;
		
	}

}
