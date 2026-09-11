package in.strikes;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // boilerplate code

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File(
                System.getProperty("src/main/webapp")
        ).getAbsolutePath();

        Context context = tomcat.addContext(contextPath , baseDoc);
    }
}