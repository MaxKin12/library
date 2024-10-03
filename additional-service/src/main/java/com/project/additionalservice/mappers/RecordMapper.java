package com.project.additionalservice.mappers;

import com.project.additionalservice.dtos.RecordNoIdsDto;
import com.project.additionalservice.models.Record;
import com.project.additionalservice.dtos.RecordDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordDto toDto(Record record);
    Record toNoIdsModel(RecordNoIdsDto recordDto);
    List<RecordDto> toListDto(List<Record> records);
}
