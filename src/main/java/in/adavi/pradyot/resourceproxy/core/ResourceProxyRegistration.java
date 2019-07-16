package in.adavi.pradyot.resourceproxy.core;

import com.google.inject.Inject;
import in.adavi.pradyot.resourceproxy.filter.ResourceProxyFilter;
import in.adavi.pradyot.resourceproxy.hystrix.ResProxyHystrixProperties;
import lombok.Data;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Data
public class ResourceProxyRegistration implements DynamicFeature {
	
	private Map<String,ResourceProxyConfig> resourceProxyConfigMap;
	private ResourceProxyService resourceProxyService;
	private ResProxyHystrixProperties resProxyHystrixProperties;
	
	@Inject
	public ResourceProxyRegistration(Map<String, ResourceProxyConfig> resourceProxyConfigMap, ResourceProxyService resourceProxyService, ResProxyHystrixProperties resProxyHystrixProperties) {
		this.resourceProxyConfigMap = resourceProxyConfigMap;
		this.resourceProxyService = resourceProxyService;
		this.resProxyHystrixProperties = resProxyHystrixProperties;
	}
	
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
			context.register(new ResourceProxyFilter(resourceProxyConfigMap,resourceProxyService,resourceInfo,resProxyHystrixProperties));
	}
}
