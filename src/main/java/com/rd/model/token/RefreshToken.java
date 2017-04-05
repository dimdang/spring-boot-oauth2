package com.rd.model.token;

import javax.persistence.*;

/**
 * Created by Chheng on 3/4/2017.
 */
@Entity
@Table(name = "oauth_refresh_token")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "token_id", length = 255)
    private String token_id;
    @Column(name = "token")
    private byte[] token;
    @Column(name = "authentication")
    private byte[] authentication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}
