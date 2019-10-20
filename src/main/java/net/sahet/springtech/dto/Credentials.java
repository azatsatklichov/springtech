package net.sahet.springtech.dto;

import lombok.Data;

@Data
public class Credentials {
    private String authMethod;
    private String username;
    private String password;
}
