package med.voll.api.Infra.security;

// CLASSE DESTINADA PARA INFORMAÇÕES DE SEGURANÇA DA API

import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;





@Configuration
@EnableWebSecurity // personalizar as cofigs de seguraça
public class SecurityConfigurations {

    // @BEAN serve para exportar uma classe para o spring, fazendo com que ele consiga carrega-la e realize a sua injeção de dependencias em outra classe

    @Autowired
    private SecurityFilter securityFilter;


    @Bean
    // metodo para retirar as restrições de segurança default do spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return
                http.csrf(csrf -> csrf.disable())
                        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        // colocando restrição em tudo menos no login
                        .authorizeHttpRequests(req -> {
                            req.requestMatchers("/login").permitAll(); // -----> permitir o login para todos
                            req.requestMatchers("/auth/register").permitAll(); // ----> permitir fazer um login

                            req.anyRequest().authenticated();// ----> Qualquer outra requisição a pessoa tem que estar autenticada
                                     // --> avisa para o spring usar o meu filtro primeiro que o dele
                        })
                        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

















}
