package org.qa.light.session10;

import lombok.Data;

@Data
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;
    private LocationDto location;
}
