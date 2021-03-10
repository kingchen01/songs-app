package com.mondaysSongTask.songsApp.controller.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class SonNewDtoUnitTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    void shouldReturnConstraintsViolation_whenObjectHasNoParameters() {
        SongNewDto songNewDto = SongNewDto.builder().build();

        Set<ConstraintViolation<SongNewDto>> violations = validator.validate(songNewDto);
        assertNotEquals(0, violations.size());
        assertEquals(4, violations.size());

        String message = validator.validateProperty(songNewDto, "title")
                .iterator()
                .next()
                .getMessage();
        assertEquals("The title: '' must not be blank, null nor empty", message);

        int message2 = validator.validateProperty(songNewDto, "title").size();
        assertEquals(1, message2);

        List<String> messages = violations.stream()
                .map(violation -> violation.getMessage())
                .collect(Collectors.toList());

    }


}
