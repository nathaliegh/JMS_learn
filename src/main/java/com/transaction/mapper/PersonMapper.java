package com.transaction.mapper;

import com.transaction.entity.PersonEntity;
import com.transaction.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonEntity convertToEntity(Person person);

}
