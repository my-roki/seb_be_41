package com.codestates.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtTokenizer {
    // Note. Plain Text 형태인 Secret Key의 byte[]를 Base64 형식의 문자열로 인코딩
    public String encodeBase64SecretKey(String secretKey) {
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // 인증된 사용자에게 JWT를 최초로 발급해주기 위한 JWT 생성 메서드
    public String generateAccessToken(Map<String, Object> claims, String subject, Date expiration, String base64EncoderSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncoderSecretKey);

        return Jwts.builder()
                .setClaims(claims)  // Custom Claims에는 주로 인증된 사용자와 관련된 정보를 추가
                .setSubject(subject)  // JWT에 대한 제목
                .setIssuedAt(Calendar.getInstance().getTime())  // JWT 발행 일자
                .setExpiration(expiration)  // JWT의 만료일시
                .signWith(key)  // 서명을 위한 Key객체
                .compact();  // JWT를 생성하고 직렬화
    }

    // Refresh Token을 생성하는 메서드
    public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    // JWT 검증을 위한 verifySignature() 메서드
    public void verifySignature(String jws, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws);
    }


    // JWT의 서명에 사용할 Secret Key를 생성
    private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey);  //  Base64 형식으로 인코딩 된 Secret Key를 디코딩 한 후, byte array를 반환

        return Keys.hmacShaKeyFor(keyBytes);
    }
}