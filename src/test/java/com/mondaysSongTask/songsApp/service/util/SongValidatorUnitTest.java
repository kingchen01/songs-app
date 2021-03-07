package com.mondaysSongTask.songsApp.service.util;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SongValidatorUnitTest {

    @Autowired
    private SongValidator songValidator;

    @ParameterizedTest
    @ValueSource(strings = {"", "  ","David Bowie", "123", " 23232 abcd", "D2a ds23 sdVxdDs"})
    void validateString_ShouldReturnTrueForSmallAndCapitalLettersNumbersAndSpace(String input) {
        assertTrue(songValidator.validateString(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd@", "  /"," 123$", "%   "})
    void validateString_ShouldThrowExceptionForSpecialCharacters(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> songValidator.validateString(input));

        String expectedMessage = "Input fields are not valid!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
