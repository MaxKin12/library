package com.project.additionalservice.mappers;

import com.project.additionalservice.dtos.RecordListDto;
import com.project.additionalservice.models.Record;
import com.project.additionalservice.dtos.RecordDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordDto toDto(Record record);
    List<RecordDto> toListDto(List<Record> records);
    default RecordListDto toRecordListDto(List<Record> bookList) {
        return new RecordListDto(toListDto(bookList));
    }
}
