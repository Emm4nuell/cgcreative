package br.com.cgcreative.domain.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GenericMapper {

    private final ModelMapper modelMapper;

    public <T, E> T map(E source, Class<T> sourceClass) {
        return modelMapper.map(source, sourceClass);
    }
}
