package velogteam.velogcloneproject.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    static final String[] allowList = {
            "/**.js","/**.css","/**.html","/favicon.ico"
    } ;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .csrf()
                    .disable()
                .httpBasic()
                    .disable()
                .authorizeRequests()
                    .antMatchers(allowList)
                        .permitAll()
                    .antMatchers("/auth/**","/oauth2/**")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                .oauth2Login()
                    .authorizationEndpoint()
                    .and()
                    .redirectionEndpoint()
                    .and()
                    .userInfoEndpoint()
                    .and()
                    .successHandler()
                    .failureHandler();
        http.addFilterBefore(, UsernamePasswordAuthenticationFilter.class);


    }
}
