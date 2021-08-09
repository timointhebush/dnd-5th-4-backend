package dnd.team4backend.service.assembler;

import dnd.team4backend.domain.Measure;
import dnd.team4backend.domain.vo.MeasureCalendarResponse;

import java.util.List;
import java.util.stream.Collectors;

public class MeasureCalendarAssembler {

    public static MeasureCalendarResponse toDto(Measure measure) {
        return new MeasureCalendarResponse(measure.getId(), measure.getUser().getId(),
                measure.getDate(), measure.getTemperatureHigh(),
                measure.getTemperatureLow(), measure.getHumidity(), measure.getMood().toString());
    }

    public static List<MeasureCalendarResponse> toDtos(List<Measure> measures) {
        return measures.stream()
                .map(measure -> MeasureCalendarAssembler.toDto(measure))
                .collect(Collectors.toList());
    }
}
