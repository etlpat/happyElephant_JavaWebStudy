package com.etlpat;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;


// JWT令牌
//
//
// (1)JWT介绍
//  JWT全称:JSON Web Token
//  JWT定义了一种简洁的、自包含的格式,用于通信双方以json数据格式安全的传输信息。
//
//
// (2)JWT令牌的组成
//  JWT格式：eyJhbXXXXXIkVCJ9.JTdCJTIyXXXXXMjI1N0Q=.Sf1KxwXXXXX4fwpMeJf...
//  如上，JWT被"."划分为三部分：
//      第一部分:Header(头),记录签名算法、令牌类型等。
//          例如:{"alg":"HS256","type":"JWT"}
//      第二部分:Payload(有效载荷),携带一些自定义信息、默认信息等。
//          例如:{"id":"1","username":"Tom"}
//      第三部分:Signature(签名),防止Token被篡改、确保安全性。
//          将header、payload,并加入指定秘钥,通过指定签名算法计算而来。
//
//  注意：①前两部分不具有加密性，因此不要使用有效载荷来携带私密信息。
//       ②第三部分的数字签名，由前两部分通过加密算法加密得来。
//          因此接收方接收到JWT令牌后，将前两部分加密，之后与第三部分比对，即可得知令牌是否被篡改。
//
//
// (3)JWT令牌的创建和验证
//  见以下代码...
//


public class JWTTest {
    private String token;
    private String key;


    // (1)如何创建JWT令牌？
    @Test
    public void testCreateJWT() {
        // 创建令牌要携带的用户信息（有效载荷）
        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("id", 1);
        userMap.put("username", "张三");

        // 创建密钥
        key = "etlpatKey";


        // 创建JWT令牌
        String token = JWT.create()
                .withClaim("user", userMap)// 添加有效载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))// 添加过期时间（一天）
                .sign(Algorithm.HMAC256(key));// 指定加密算法，并配置密钥

        System.out.println(token);
        this.token = token;
    }


    // (2)如何验证JWT令牌？
    @Test
    public void testVerifyJWT() {
        testCreateJWT();// 获取上个方法的令牌和密钥

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(key)).build();// 创建令牌验证器

        DecodedJWT decodedJWT = jwtVerifier.verify(token);// 验证token，生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();// 获取有效载荷
        Claim userMap = claims.get("user");
        // 注意：若令牌过期/被篡改，则报错

        System.out.println(claims);
        System.out.println(userMap);
    }

}
