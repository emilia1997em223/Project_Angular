package com.unifun.voice.orm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/testtable")
@ApplicationScoped
@Produces("application/json")
public class TestTableRes {
	@Inject
	EntityManager em;
	
	@GET
	public String get() {
		return JsonbBuilder.create().toJson(em.createNamedQuery("testtable.getAll", TestTable.class).getResultList());
	}

}
