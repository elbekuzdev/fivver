package com.example.main.security;

import com.example.main.entity.RefreshToken;
import com.example.main.entity.Users;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class RefreshTokenUtil {

    public RefreshToken generateRefreshToken(Users users){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(new Date().getTime()+(1000L *60*60*24*30*3)));
        refreshToken.setUser(users);
        return refreshToken;
    }
}
