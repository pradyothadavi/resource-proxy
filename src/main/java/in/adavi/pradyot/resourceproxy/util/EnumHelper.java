package in.adavi.pradyot.resourceproxy.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pradyot H Adavi
 */
@Slf4j
public class EnumHelper {
	
	public static <T extends Enum<T>> T safeValueOf(Class<T> enumType, String name, T defValue) {
		if (name == null) {
			return defValue;
		} else {
			try {
				return Enum.valueOf(enumType, name);
			} catch (IllegalArgumentException var4) {
				log.debug("Exception Type =  " + enumType.getName() + " and value = " + name, var4);
			} catch (NullPointerException var5) {
				log.debug("Exception Type =  " + enumType + " and value = " + name, var5);
			}
			return defValue;
		}
	}
}
