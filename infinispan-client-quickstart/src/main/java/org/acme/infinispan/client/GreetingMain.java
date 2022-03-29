package org.acme.infinispan.client;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.inject.Inject;

@QuarkusMain
public class GreetingMain implements QuarkusApplication {

    @Inject
    GreetingService service;

    @Override
    public int run(String... args) {

        if(args.length>0) {
            System.out.println(service.greetingMessage(String.join(" ", args)));
        } else {
            System.out.println(service.greetingMessage("commando"));
        }

        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(GreetingMain.class, args);
    }

}
