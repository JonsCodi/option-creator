package br.com.tetrabit.jira.plugins.oc.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource of message.
 */
@Path("/message")
public class PluginResource {

    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getMessage()
    {
       return Response.ok("Hello World").build();
    }
}