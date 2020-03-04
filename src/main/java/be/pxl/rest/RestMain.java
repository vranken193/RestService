package be.pxl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.security.util.Password;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJms
@EnableGlobalMethodSecurity(securedEnabled = true)
public class RestMain {

    public static void main(String[] args) {
        SpringApplication.run(RestMain.class, args);

        String password = "test";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);



        System.out.println(passwordEncoder.encode("test"));

        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = new UsernamePasswordAuthenticationToken("giel","test");
        sc.setAuthentication(auth);
    }

    @Autowired
    public void configureSecurity(AuthenticationManagerBuilder auth, DataSource ds) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(ds)
                .usersByUsernameQuery("select name, password, enabled from users where name = ?")
                .authoritiesByUsernameQuery("select name, role from users where name = ?");
    }


}


