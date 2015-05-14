package com.bookstore.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts date to String
 * @author Marcus
 *
 */
public class DateToStringConverter implements Converter<Date, String>{

	private static final String DATE_FORMAT = "dd-MM-yyyy";
	
	/**
	 * dd-MM-yyyy
	 */
	private final SimpleDateFormat SIMPLE_DATEFORMAT = new SimpleDateFormat(DATE_FORMAT);
	
	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public String convert(Date source) {
		
		return SIMPLE_DATEFORMAT.format(source);
	}

}
