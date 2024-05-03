/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.duke.ece651.team1.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.duke.ece651.team1.client.model.*;
import java.net.InetAddress;

import javax.el.ELException;



/**
 * This class represents the main entry point of the Spring Boot application.
 */
@SpringBootApplication
@EnableScheduling
@RestController
public class App {
	/**
     * Handles the root URL request.
     *
     * @return A greeting message.
     */
    @GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}


  	/**
     * The main method that starts the Spring Boot application.
     *
     * @param args The command line arguments.
     */
	public static void main(String[] args)  {
          try {
               InetAddress inetAddress = InetAddress.getLocalHost();
               UserSession.getInstance().setHost(inetAddress.getHostName());
               UserSession.getInstance().setPort("8080");
           } catch (Exception e) {
               e.printStackTrace();
           }
		SpringApplication.run(App.class, args);
	}

}