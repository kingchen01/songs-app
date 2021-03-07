package com.mondaysSongTask.songsApp.service.util;

import com.mondaysSongTask.songsApp.controller.dto.SongNewDto;
import com.mondaysSongTask.songsApp.model.util.SongCategoryEnum;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
import java.util.stream.Stream;

@NoArgsConstructor
@Component
public class SongValidator {

    public boolean validateString(String string) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        boolean isValid = !(pattern.matcher(string).find());
        if(!isValid) {
            throw new IllegalArgumentException("Input fields are not valid!");
        }
        return true;
    }

}
