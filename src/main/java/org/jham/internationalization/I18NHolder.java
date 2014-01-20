package org.jham.internationalization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Bootstraps the i18n resource bundle for the app to access.  
 * The resource bundle is lazily initialized when the 
 * {@link I18NHolder#getBundle()} method is called  
 * the first time. 
 * 
 * This class only allows for retrieving the 
 * {@link ResourceBundle} default locale. 
 * 
 * @see {@link Locale#getDefault()}
 * 
 * @author jasonmfehr
 * @since 1.0
 */
public final class I18NHolder {

	private static final String PROP_FILES_BASE_PATH = "i18n/";
	private static ResourceBundle bundle;
	
	//message key constants
	public static final String CLIENT_ID_NOT_PROVIDED_DEFAULT_MESSAGE ="client-id-not-provided.default-message";
	public static final String CLIENT_ID_NOT_PROVIDED_WITH_IP_MESSAGE ="client-id-not-provided.with-ip-message";

	private I18NHolder() {
	}
	
	/**
	 * Retrieves a single entry in the resource bundle performing 
	 * parameter replacements if necessary.
	 * 
	 * If needed, the messages can be parameterized using curly 
	 * braces that contain the index of the parameter to use.  
	 * For example, say the log message for a user logon needs 
	 * to contain the user name as well as the IP address of 
	 * their client.  The message would be set up in the i18n 
	 * properties file as: 
	 * 
	 * <code>user {0} has logged on from client with IP address {1}</code>
	 * 
	 * To retrieve the localized message and perform parameter substitution, 
	 * call this method passing two arguments for the replacements vararg: 
	 * 
	 * <code>I18NHolder.getString("user.logon", userName, clientIP);</code>
	 * 
	 * Note that this method does not perform any localization during 
	 * parameter substitution.  
	 *  
	 * @param key {@link String} containing the entry to retrieve
	 *                           from the resource bundle
	 * @param replacements {@link String} varargs containing values to 
	 *                                    use in the parameter substitutions
	 * @return {@link String} containing the entry that was retrieved
	 *                        from the resource bundle
	 */
	public static String getString(final String key, final String... replacements) {
		final String message;
		
		message = getBundle().getString(key);
		if(replacements != null && replacements.length > 0 && message != null){
			return MessageFormat.format(message, (Object[])replacements);
		}else{
			return message;
		}
	}

	/**
	 * Retrieves the resource bundle that has been 
	 * loaded with the i18n messages for the default locale.  
	 * Will initialize the bundle the first time this method 
	 * is called;
	 * 
	 * @return {@link ResourceBundle} containing resources 
	 *                                for the default locale
	 */
	private static ResourceBundle getBundle() {
		if(bundle == null){
			bundle = ResourceBundle.getBundle(PROP_FILES_BASE_PATH + "i18n", Locale.getDefault());
		}
		
		return bundle;
	}
	
}
