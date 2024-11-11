package com.slippery.usermanagement.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private final String SECRETkEY ="b96644f22dd421471f52b005fec9c9dc89abd98b255ec71a9d5579752fc585a767d02f8da85a9e1b59c4c520255abfaa76da965cb9126ffd13c6d4b1aa05fe4e279548a6530f239da2a7597c7bda679a95c7be34bafb21c1b6c146893cbd943e19a6f0a8d207915028874b7961712a47b4309597da31967b998968e5823b83368c2f57f941e004bdbba254a56d96685a993aefebba884f37fcfbfefda57aaf8503f5a1e2e0642b4ecfc5ff4b775a59e1fbe2d97065c7c4a8ad92b638fea2f521a68570de4e87c2606e06deb2fe2ec65b7a881fc456eda2d37478af6c5b2db842c3fb289a3ad13cfb8af92110469de322f37ac22d283671c26a950c147b1f1d3c";
    private final long EXPIRATIONTIME =34000000L;

    protected SecretKey generateSecretKey(){
        byte[] keyBytes = Base64.getDecoder().decode(SECRETkEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateJwtToken(String username){
        Map<String, Object> claims =new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .and()
                .signWith(generateSecretKey())
                .compact();

    }
}
