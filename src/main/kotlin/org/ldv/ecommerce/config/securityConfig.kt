package org.ldv.ecommerce.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableMethodSecurity
class SecurityConfig {

    // Encodage des mots de passe
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .csrf { it.disable() } // ⚠️ temporaire, à activer plus tard

            .authorizeHttpRequests {

                // --- pages publiques ---
                it.requestMatchers(
                    "/",
                    "/login",
                    "/inscription",
                    "/produits",
                    "/contact",
                    "/a-propos",
                    "/rgpd",
                    "/css/**",
                    "/js/**",
                    "/img/**"
                ).permitAll()

                // --- accès réservé aux admins ---
                it.requestMatchers("/admin/**").hasRole("ADMIN")

                // --- accès réservé aux clients ---
                it.requestMatchers("/client/**").hasRole("CLIENT")

                // --- tout le reste nécessite une connexion ---
                it.anyRequest().authenticated()
            }

            // --- configuration du login ---
            .formLogin { form: FormLoginConfigurer<HttpSecurity?> ->
                form
                    .loginPage("/login")
                    .defaultSuccessUrl("/profil")
                    .failureUrl("/login?error=true")
                    .permitAll()
            }

            // --- configuration du logout ---
            .logout { logout: LogoutConfigurer<HttpSecurity?> ->
                logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .permitAll()
            }

        return http.build()
    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }
}