package in.adavi.pradyot.resourceproxy.core;

import com.google.inject.Inject;
import in.adavi.pradyot.resourceproxy.filter.ResourceProxyFilter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Slf4j
@Data
public class ResourceProxyRegistration implements DynamicFeature {
	
	private Map<String,ResourceProxyConfig> resourceProxyConfigMap;
	private ResourceProxyService resourceProxyService;
	
	@Inject
	public ResourceProxyRegistration(Map<String, ResourceProxyConfig> resourceProxyConfigMap, ResourceProxyService resourceProxyService) {
		this.resourceProxyConfigMap = resourceProxyConfigMap;
		this.resourceProxyService = resourceProxyService;
	}
	
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
			context.register(new ResourceProxyFilter(resourceProxyConfigMap,resourceProxyService,resourceInfo));
	}
}
