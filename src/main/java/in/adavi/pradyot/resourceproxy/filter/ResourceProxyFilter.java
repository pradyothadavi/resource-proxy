package in.adavi.pradyot.resourceproxy.filter;

import in.adavi.pradyot.resourceproxy.core.ResourceProxyBundleConfiguration;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyConfig;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyService;
import in.adavi.pradyot.resourceproxy.hystrix.ResProxyHystrixProperties;
import in.adavi.pradyot.resourceproxy.hystrix.ResourceProxyRequestCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Data
@AllArgsConstructor
public class ResourceProxyFilter implements ContainerRequestFilter {
	
	private ResourceProxyService resourceProxyService;
	private ResourceInfo resourceInfo;
	private ResourceProxyBundleConfiguration resourceProxyBundleConfiguration;
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		UriInfo uri = requestContext.getUriInfo();
		String requestMethod = requestContext.getMethod();
		String key = requestMethod+"-"+uri.getPath();
		Map<String,ResourceProxyConfig> resourceProxyConfigMap =
				resourceProxyBundleConfiguration.getResourceProxyConfigMap();
		ResourceProxyConfig resourceProxyConfig = resourceProxyConfigMap.get(key);
		if(null != resourceProxyConfig && resourceProxyConfig.isProxyEnabled()){
			
			Response response = null;
			if(resourceProxyBundleConfiguration.isHystrixEnabled()){
				response =
						new ResourceProxyRequestCommand(resourceProxyConfig.getHost(),key,key,resourceProxyBundleConfiguration.getResProxyHystrixProperties(),
								resourceProxyService, resourceProxyConfig,requestContext,resourceInfo).execute();
			} else {
				response = resourceProxyService.proxyResource(resourceProxyConfig,requestContext,resourceInfo);
			}
			requestContext.abortWith(response);
		}
	}
}
