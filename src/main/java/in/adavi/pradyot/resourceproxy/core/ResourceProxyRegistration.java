package in.adavi.pradyot.resourceproxy.core;

import com.google.inject.Inject;
import in.adavi.pradyot.resourceproxy.filter.ResourceProxyFilter;
import lombok.Data;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * @author Pradyot H Adavi
 */
@Data
public class ResourceProxyRegistration implements DynamicFeature {
	
	private final ResourceProxyBundleConfiguration resourceProxyBundleConfiguration;
	private final ResourceProxyService resourceProxyService;
	
	@Inject
	public ResourceProxyRegistration(ResourceProxyBundleConfiguration resourceProxyBundleConfiguration, ResourceProxyService resourceProxyService) {
		this.resourceProxyBundleConfiguration = resourceProxyBundleConfiguration;
		this.resourceProxyService = resourceProxyService;
	}
	
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
			context.register(new ResourceProxyFilter(resourceProxyService,resourceInfo,resourceProxyBundleConfiguration));
	}
}
