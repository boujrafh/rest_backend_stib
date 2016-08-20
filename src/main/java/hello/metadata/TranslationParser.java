package hello.metadata;

import hello.model.Translation;
import org.springframework.stereotype.Component;

@Component
public class TranslationParser implements Parser<Translation> {
    @Override
    public Translation parse(String line) {
        String[] splitLine = line.trim().split(",");
        return new Translation(
                splitLine[0],
                splitLine[1],
                splitLine[2]);
    }
}
