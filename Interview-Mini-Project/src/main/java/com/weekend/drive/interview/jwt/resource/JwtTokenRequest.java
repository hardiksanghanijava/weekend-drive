package com.weekend.drive.interview.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjI5MjY5NDEyLCJpYXQiOjE2Mjg2NjQ2MTJ9.GrzxDyV5mjaK5rogH7kWqviRVjQj_f2oNENY-Ya4gKHHl6z3LhGg1FH26ahhrrCg3fOQWtnZD0PhCq7P7ZclaQ"
//    }

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

