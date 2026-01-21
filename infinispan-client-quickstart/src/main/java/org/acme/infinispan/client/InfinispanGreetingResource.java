package org.acme.infinispan.client;

import io.quarkus.infinispan.client.Remote;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.infinispan.client.hotrod.RemoteCache;

@Path("/greeting")
public class InfinispanGreetingResource {

    @Inject
    @Remote("mycache")
    RemoteCache<String, Greeting> cache;

    @POST
    @Path("/{id}")
    public String postGreeting(String id, Greeting greeting) {
        return cache.put(id, greeting).name();
    }

    @GET
    @Path("/{id}")
    public Greeting getGreeting(String id) {
        return cache.get(id);
    }
}
