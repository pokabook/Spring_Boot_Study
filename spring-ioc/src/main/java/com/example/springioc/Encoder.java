package com.example.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}

@Configuration
class Appconfig{

    @Bean("Base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }
    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}