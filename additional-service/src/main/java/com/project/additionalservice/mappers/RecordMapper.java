package com.project.additionalservice.mappers;

import com.project.additionalservice.models.Record;
import com.project.additionalservice.dtos.RecordDto;
import com.project.additionalservice.dtos.RecordNoIdDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordDto toDto(Record record);
    Record toNoIdModel(RecordNoIdDto recordDto);
    List<RecordDto> toListDto(List<Record> records);
}
