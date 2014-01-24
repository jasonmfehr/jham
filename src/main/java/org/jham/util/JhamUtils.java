package org.jham.util;

import java.text.MessageFormat;

public final class JhamUtils {

	private JhamUtils() {
		
	}
	
	/**
	 * Performs placeholder substitution on a given string by 
	 * taking in a messages that can be parameterized using curly 
	 * braces with the index of the replacement provided in the 
	 * replacements parameter.
	 *   
	 * For example, say the log message for a user logon needs 
	 * to contain the user name as well as the IP address of 
	 * their client.  The message would passed in as: 
	 * 
	 * <code>user {0} has logged on from client with IP address {1}</code>
	 * 
	 * This function will perform parameter substitution by replacing 
	 * the two placeholders with the two arguments provided in the 
	 * replacements parameter.
	 * 
	 * @param message {@link String} containing the (optionally) 
	 *                paramaterized message to perform placeholder 
	 *                substitution upon
	 * @param replacements {@link String} varargs containing values to 
	 *                     use in the parameter substitutions, if 
	 *                     nothing is provided in this parameter, then 
	 *                     the message is returned unchanged
	 * @return {@link String} containing the message string after 
	 *         having and placeholder substitutions performed
	 */
	public static String parseString(final String message, final String... replacements) {
		if(replacements != null && replacements.length > 0 && message != null){
			return MessageFormat.format(message, (Object[])replacements);
		}else{
			return message;
		}
	}
}
