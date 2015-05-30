package de.fau.amos4.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Authenticate using the the {@link UserDetailsService} and a hashed password.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // /css/**, /js/** and /images/** is done by Spring Boot Security
        web.ignoring().antMatchers("/fonts/**");
    }

    /**
     * This is the generic security configuration. Further detailed configuration can be provided
     * using i.e. @PreAuthorize on request mappings.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()

                // Allow access to the front page.
                .antMatchers("/").permitAll()
                .anyRequest().fullyAuthenticated()

                .and()

                // Login page at /login with email as username
                .formLogin().loginPage("/client/login").loginProcessingUrl("/client/login").defaultSuccessUrl("/client/list")
                    .usernameParameter("email").failureUrl("/client/login?error").permitAll()

                .and()

                // Logout page at /logout with redirect to home on logout and cookie removal
                .logout().logoutUrl("/client/logout").deleteCookies("remember-me").logoutSuccessUrl("/").permitAll()

                .and()

                // Enable the "remember me" functionality (using a cookie).
                .rememberMe();
    }
}