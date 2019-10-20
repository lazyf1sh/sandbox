package test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.xml.internal.ws.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.ws.rs.core.HttpHeaders;
import java.io.File;
import java.util.Locale;

/**
 * Created by ikopylov on 21.06.2017.
 */
public class DynamicTreeApplet extends JApplet {

    private static final String LOGFILENAME         = "printing.log";
    private static final String PARAM_FULL_USER_ID  = "FULL_USER_ID";
    private static final String PARAM_USER_PASSWORD = "USER_PASSWORD";
    private Locale locale;

    //Called when this applet is loaded into the browser.

    public void init() {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(getParameter(PARAM_FULL_USER_ID), getParameter(PARAM_USER_PASSWORD)));
        client.addFilter(new ClientFilter()
        {
            @Override
            public ClientResponse handle(ClientRequest cr) throws ClientHandlerException
            {
                if (!cr.getHeaders().containsKey(HttpHeaders.ACCEPT_LANGUAGE))
                {
                    cr.getHeaders().add(HttpHeaders.ACCEPT_LANGUAGE, locale.getLanguage());
                }
                return getNext().handle(cr);
            }
        });


        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

    private void createGUI() {
        Logger logger = createFileLogger();
        logger.info("Hello World");

        DynamicTreePanel newContentPane = new DynamicTreePanel();
        newContentPane.setOpaque(true);
        setContentPane(newContentPane);
    }

    private static Logger createFileLogger()
    {
        String name = "printing";
        String userHome = System.getProperty("user.home");
        String file = new File(userHome, LOGFILENAME).getAbsolutePath();

        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder ple = new PatternLayoutEncoder();
        ple.setPattern("%-12date{YYYY-MM-dd HH:mm:ss.SSS} %-5level - %msg%n");
        ple.setContext(context);
        ple.start();

        RollingFileAppender<ILoggingEvent> fileAppender = new RollingFileAppender<ILoggingEvent>();
        fileAppender.setFile(file);
        fileAppender.setEncoder(ple);
        fileAppender.setContext(context);
        fileAppender.setAppend(true);

        TimeBasedRollingPolicy<ILoggingEvent> timeBasedRollingPolicy = new TimeBasedRollingPolicy<ILoggingEvent>();
        timeBasedRollingPolicy.setContext(context);
        timeBasedRollingPolicy.setFileNamePattern(userHome + "\\printing-%d{yyyy-MM-dd_HH}.log");
        timeBasedRollingPolicy.setMaxHistory(7);
        timeBasedRollingPolicy.setParent(fileAppender);
        timeBasedRollingPolicy.start();

        fileAppender.setRollingPolicy(timeBasedRollingPolicy);
        fileAppender.start();

        ch.qos.logback.classic.Logger fileLogger = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(name);
        fileLogger.addAppender(fileAppender);
        fileLogger.setLevel(Level.DEBUG);
        fileLogger.setAdditive(false);
        return fileLogger;
    }


}