package dnd.team4backend.service.assembler;

import dnd.team4backend.domain.Measure;
import dnd.team4backend.domain.MeasureDress;
import dnd.team4backend.domain.vo.DressResponse;
import dnd.team4backend.domain.vo.MeasureResponse;

import java.util.List;
import java.util.stream.Collectors;

public class MeasureAssembler {
    public static MeasureResponse toDto(Measure measure) {
        List<MeasureDress> measureDresses = measure.getMeasureDressList();
        List<DressResponse> dressResponses = measureDresses.stream()
                .map(DressAssembler::toDto)
                .collect(Collectors.toList());
        MeasureResponse measureResponse = new MeasureResponse(
                measure.getId(), measure.getUser().getId(), measure.getUser().getName(),
                measure.getUser().getConstitution().toString(), measure.getDate(), measure.getTempInfo(), measure.getTemperatureHigh(),
                measure.getTemperatureLow(), measure.getHumidity(), measure.getArea(),
                measure.getMood().toString(), measure.getComment(), dressResponses
        );
        return measureResponse;
    }

    public static List<MeasureResponse> toDtos(List<Measure> measures) {
        return measures.stream()
                .map(measure -> MeasureAssembler.toDto(measure))
                .collect(Collectors.toList());
    }
}
