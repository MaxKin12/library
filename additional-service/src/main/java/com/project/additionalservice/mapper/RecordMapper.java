package com.project.additionalservice.mapper;

import com.project.additionalservice.dto.RecordListDto;
import com.project.additionalservice.model.Record;
import com.project.additionalservice.dto.RecordDto;
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
