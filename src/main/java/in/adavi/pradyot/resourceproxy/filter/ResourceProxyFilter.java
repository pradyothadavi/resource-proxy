package in.adavi.pradyot.resourceproxy.filter;

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
	
	private Map<String, ResourceProxyConfig> resourceProxyConfigMap;
	private ResourceProxyService resourceProxyService;
	private ResourceInfo resourceInfo;
	private ResProxyHystrixProperties resProxyHystrixProperties;
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		UriInfo uri = requestContext.getUriInfo();
		String requestMethod = requestContext.getMethod();
		String key = requestMethod+"-"+uri.getPath();
		ResourceProxyConfig resourceProxyConfig = resourceProxyConfigMap.get(key);
		if(null != resourceProxyConfig && resourceProxyConfig.isProxyEnabled()){
			Response response =
					new ResourceProxyRequestCommand(resourceProxyConfig.getHost(),key,key,resProxyHystrixProperties,
							resourceProxyService, resourceProxyConfig,requestContext,resourceInfo).execute();
//			Response response = resourceProxyService.proxyResource(resourceProxyConfig,requestContext,resourceInfo);
			requestContext.abortWith(response);
		}
	}
}
