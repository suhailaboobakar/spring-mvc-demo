package in.strikes;

import in.strikes.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {
    public static void main(String[] args) throws LifecycleException {

        // boilerplate code

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath , baseDoc);

        // IOC container app
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(WebConfig.class);

        // dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        Tomcat.addServlet(context , "dispatcherServlet" , dispatcherServlet);

        context.addServletMappingDecoded("/" , "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat running on port 8080");

        //keep server running
        tomcat.getServer().await();
    }
}