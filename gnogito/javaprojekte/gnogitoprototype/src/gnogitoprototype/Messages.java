/*
 * Created on 13.02.2004
 *
 */
package gnogitoprototype;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * @author matthias
 * 
 * created first in project gnogitoprototype
 */
public class Messages {
	private static final String BUNDLE_NAME = "gnogitoprototype.gnogitoprototype"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
	/**
	 *  
	 */
	private Messages() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		// TODO Auto-generated method stub
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
