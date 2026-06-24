package com.example.demo.services;

import com.example.demo.entities.Kullanici;
import com.example.demo.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final KullaniciRepository kullaniciRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {

        Kullanici kullanici =
                kullaniciRepository
                        .findByUsername(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(
                                        "Kullanici bulunamadi"
                                )
                        );

        return new User(

                kullanici.getUsername(),
                kullanici.getPassword(),

                List.of(
                        new SimpleGrantedAuthority(
                                kullanici.getRole()
                        )
                )
        );
    }
}