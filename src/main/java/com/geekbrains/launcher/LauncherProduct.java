package com.geekbrains.launcher;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

import java.net.URL;
import java.security.ProtectionDomain;

public class LauncherProduct {
    public static void main(String[] args) throws Exception {
        Server server = new MetricsProperties.Web.Server(8189);
        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(location.toExternalForm());
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}