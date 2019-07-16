package in.adavi.pradyot.resourceproxy.core;

import in.adavi.pradyot.resourceproxy.hystrix.ResProxyHystrixProperties;
import lombok.Data;

import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Data
public class ResourceProxyBundleConfiguration {
	
	private Map<String,ResourceProxyConfig> resourceProxyConfigMap;
	
	private ResProxyHystrixProperties resProxyHystrixProperties;
}
