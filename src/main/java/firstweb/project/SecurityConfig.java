package firstweb.project;



import firstweb.project.models.MyUserDetails;
import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileWriter;


@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService myUserDetailsService;
//
//
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").hasAuthority("user").and().formLogin();

    }
//protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().
//                disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**")
//                .permitAll()
//                .anyRequest().authenticated()
//
//                .and()
//                .httpBasic();
//}
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/users").antMatchers("/auth");
    }
}