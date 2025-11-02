package org.qa.light.session10;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    private List<PersonDto> results;
}
