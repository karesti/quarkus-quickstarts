package org.acme.infinispan.client;

import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class InfinispanClientApp {

    @Inject
    RemoteCacheManager cacheManager;

    void onStart(@Observes StartupEvent ev) {
        Log.info("Get cache named mycache and add put a key/value");
        RemoteCache<Object, Object> cache = cacheManager.getCache("mycache");
        cache.put("hello", "Hello World, Infinispan is up!");
    }
}
