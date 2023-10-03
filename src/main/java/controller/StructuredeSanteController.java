package controller;

import java.util.List;

import bdbeans.Structuredesante;
import bdbeans.StructuredesanteHome;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("structures")
public class StructuredeSanteController {
	private StructuredesanteHome structSanteHome;
	public StructuredeSanteController()
	{
		structSanteHome=new StructuredesanteHome();
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Structuredesante> getStructures()
	{
		return structSanteHome.getAllStructuredeSante();
	}
	@Path("{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Structuredesante getStructure(@PathParam("id")int id)
	{
		return structSanteHome.findStructuredeSanteByID(id);
	}
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void add(Structuredesante structure)
	{
		structSanteHome.persist(structure);
		
	}
	@Path("{id}")
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void delete(@PathParam("id")int id,Structuredesante structure)
	{
		structure=structSanteHome.findStructuredeSanteByID(id);
		structSanteHome.delete(structure);
	}
	@Path("{idStructure}")
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void update(@PathParam("idStructure")int id,Structuredesante structure)
	{
		structure=structSanteHome.findStructuredeSanteByID(id);
		structSanteHome.update(structure);
	}

}
