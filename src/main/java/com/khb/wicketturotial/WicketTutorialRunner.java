package com.khb.wicketturotial;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WicketTutorialRunner {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        String rootPath = WicketTutorialRunner.class.getClassLoader().getResource(".").toString();
        WebAppContext webapp = new WebAppContext(rootPath + "../../src/main/webapp", "/tutorial");
        server.setHandler(webapp);

        server.start();
        server.join();
    }
}
