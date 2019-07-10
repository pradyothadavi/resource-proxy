package in.adavi.pradyot.resourceproxy.core;

import lombok.Data;

import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Data
public class ResourceProxyBundleConfiguration {
	
	private Map<String,ResourceProxyConfig> resourceProxyConfigMap;
}
