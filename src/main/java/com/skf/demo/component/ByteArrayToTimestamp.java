package com.skf.demo.component;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class ByteArrayToTimestamp implements Converter<byte[], Timestamp> {

	@Override
	public Timestamp convert(byte[] source) {
		String value = new String(source);
        return new Timestamp(Long.parseLong(value));
	}

}
