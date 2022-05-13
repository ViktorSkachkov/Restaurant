package com.example.demo.Business;

import com.example.demo.dto.AccessTokenDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public interface AccessTokenEncoder {
     String encode(AccessTokenDTO accessTokenDTO);
}
