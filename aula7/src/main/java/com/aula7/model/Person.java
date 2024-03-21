package com.aula7.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Generated
@Setter
@ToString
public class Person implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("gender")
    private String gender;
}
