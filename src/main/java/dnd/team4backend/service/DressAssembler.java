package dnd.team4backend.service;

import dnd.team4backend.domain.DressResponse;
import dnd.team4backend.domain.MeasureDress;

public class DressAssembler {
    public static DressResponse toDto(MeasureDress measureDress) {
        return new DressResponse(
                measureDress.getDress().getId(),
                measureDress.getDress().getDressName(),
                measureDress.getDress().getDressType().toString(),
                measureDress.getPartialMood().toString()
        );
    }
}
