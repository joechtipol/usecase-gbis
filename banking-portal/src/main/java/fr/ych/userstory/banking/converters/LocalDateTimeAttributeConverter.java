package fr.ych.userstory.banking.converters;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
    @Override
    public Date convertToDatabaseColumn(LocalDate locDateTime) {
    	return (locDateTime == null ? null : Date.valueOf(locDateTime));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlTimestamp) {
    	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDate());
    }
}