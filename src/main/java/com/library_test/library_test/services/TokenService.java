package com.library_test.library_test.services;

import com.library_test.library_test.models.UserCredentials;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder){
        this.encoder = encoder;
    }

    public String generateToken(UserCredentials user){
        Instant now = Instant.now();
        Instant expiresAt = now.plus(1, ChronoUnit.HOURS);

        //String scope = auth.getAuthorities().stream()
        //        .map(GrantedAuthority::getAuthority)
        //        .collect(Collectors.joining(""));

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .subject(user.getUsername())
                .expiresAt(expiresAt)
                //.claim("scope", scope)
                .build();

        return this.encoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}
