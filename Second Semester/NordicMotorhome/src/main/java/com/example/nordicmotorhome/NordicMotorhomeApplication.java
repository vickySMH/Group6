package com.example.nordicmotorhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class NordicMotorhomeApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(NordicMotorhomeApplication.class, args);
    }

}
