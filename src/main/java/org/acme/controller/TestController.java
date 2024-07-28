package org.acme.controller;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.models.Test;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

import static org.jboss.resteasy.reactive.RestResponse.Status.CREATED;

@Path("/quarkus/test")
@ApplicationScoped
public class TestController {
    @GET
    public Uni<List<Test>> get(){
        return Test.listAll(Sort.by("name"));
    }
    @GET
    @Path("/{id}")
    public Uni<Test> getById(Long id){
        return Test.findById(id);
    }

    @POST
    public Uni<RestResponse<Test>> create(Test test){
        return Panache.withTransaction(test::persist).replaceWith(RestResponse.status(CREATED, test));
    }




}
