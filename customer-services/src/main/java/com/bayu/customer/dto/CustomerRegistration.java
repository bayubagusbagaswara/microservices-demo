package com.bayu.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerRegistration(
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        String gender,
        @JsonProperty("email") String email,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("id_type") String idType,
        @JsonProperty("id_value") String idValue
) {
}
