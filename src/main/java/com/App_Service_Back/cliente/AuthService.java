package com.App_Service_Back.cliente;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String SECRET_KEY = "yourSecretKey";
    private static final long EXPIRATION_TIME = 3600000;

    public String authenticate(String email, String senha) {
        Cliente cliente = clienteRepository.findByEmail(email);
        System.out.println("cliente:" + cliente);
        if (cliente != null && cliente.getCliente_senha().equals(senha)) {
            return Jwts.builder()
                    .setSubject(cliente.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()))
                    .compact();
        }
        return null;
    }
}