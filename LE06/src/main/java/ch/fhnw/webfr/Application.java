package ch.fhnw.webfr;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"ch.fhnw.webfr.hello"})
@EnableAutoConfiguration
public class Application {
}