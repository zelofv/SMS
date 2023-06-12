package com.ddd.info.simple.util;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ddd.info.simple.entity.permission.LoginUser;

import java.util.Date;
import java.util.List;

public class TokenUtil {
    private static final String TOKEN_SECRET = "ZCEQIUBFKSJBFJH2020BQWE";

    public static String getToken(LoginUser loginUser) {

        // 保存userPermissionsCode，防止loginUser内存空间里面被修改，导致其他错误。
        List<String> userPermissionsCode = loginUser.getUserPermissionsCode();

        // 权限设置为null，节约头部空间
        loginUser.setUserPermissionsCode(null);
        String token = JWT.create().withClaim("loginUser", JSONObject.toJSONString(loginUser))
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).sign(Algorithm.HMAC256(TOKEN_SECRET));
        // 设回userPermissionsCode，该userPermissionsCode需要传回前台
        loginUser.setUserPermissionsCode(userPermissionsCode);
        return token;
    }

    public static DecodedJWT verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LoginUser getLoginUser(DecodedJWT jwt) {
        try {
            Claim claim = jwt.getClaim("loginUser");
            LoginUser loginUser = JSONObject.parseObject(claim.asString(), LoginUser.class);
            return loginUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
