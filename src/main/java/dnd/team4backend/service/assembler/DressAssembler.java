package dnd.team4backend.service.assembler;

import dnd.team4backend.domain.MeasureDress;
import dnd.team4backend.domain.vo.DressResponse;

public class DressAssembler {
    public static DressResponse toDto(MeasureDress measureDress) {
        try {
            return new DressResponse(
                    measureDress.getDress().getId(),
                    measureDress.getDress().getDressName(),
                    measureDress.getDress().getDressType().toString(),
                    measureDress.getPartialMood().toString()
            );
        } catch (NullPointerException e) {
            return new DressResponse(
                    measureDress.getDress().getId(),
                    measureDress.getDress().getDressName(),
                    measureDress.getDress().getDressType().toString(),
                    "null"
            );
        }

    }
}
