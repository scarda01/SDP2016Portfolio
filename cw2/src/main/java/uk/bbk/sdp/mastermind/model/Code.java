package uk.bbk.sdp.mastermind.model;

import com.google.inject.name.Named;
import lombok.Getter;

import javax.inject.Inject;
import java.util.List;

import static uk.bbk.sdp.mastermind.util.CodeUtil.generateSecretCode;
import static uk.bbk.sdp.mastermind.util.CodeUtil.processColours;

public class Code {

    private @Getter List<Colour> colours;
    private @Getter int size;
    private @Getter String secretCode;

    @Inject
    public Code(@Named("colours") String colourStr, @Named("size") Integer size) {
        this.size = size;
        this.colours = processColours(colourStr);
        this.secretCode = generateSecretCode(colours, size);
    }
}
