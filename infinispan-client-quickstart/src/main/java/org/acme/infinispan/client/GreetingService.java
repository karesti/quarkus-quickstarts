package org.acme.infinispan.client;


import io.quarkus.infinispan.client.CacheInvalidateAll;
import io.quarkus.infinispan.client.CacheResult;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

   @CacheInvalidateAll(cacheName = "mycache")
   public String greetingMessage(String name) {
      try {
         Thread.sleep(2000L);
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }

      return "hello " + name;
   }

}
