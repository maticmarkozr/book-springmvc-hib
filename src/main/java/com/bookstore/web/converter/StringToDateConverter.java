package com.bookstore.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts String to Date
 * @author Marcus
 *
 */
public class StringToDateConverter implements Converter<String, Date>{

	private static final String DATE_FORMAT = "dd-MM-yyyy";
	
	/**
	 * dd-MM-yyyy
	 */
	private SimpleDateFormat SIMPLE_DATEFORMAT = new SimpleDateFormat(DATE_FORMAT);
	
	@Override
	public Date convert(String source) {
		try{
			return SIMPLE_DATEFORMAT.parse(source);
		} catch(ParseException e){
			return null;
		}
		}

}
