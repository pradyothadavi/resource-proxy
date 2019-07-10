package in.adavi.pradyot.resourceproxy.filter;

import in.adavi.pradyot.resourceproxy.core.ResourceProxyConfig;
import in.adavi.pradyot.resourceproxy.core.ResourceProxyService;
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
@Slf4j
@AllArgsConstructor
public class ResourceProxyFilter implements ContainerRequestFilter {
	
	private Map<String, ResourceProxyConfig> resourceProxyConfigMap;
	private ResourceProxyService resourceProxyService;
	private ResourceInfo resourceInfo;
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		UriInfo uri = requestContext.getUriInfo();
		String requestMethod = requestContext.getMethod();
		ResourceProxyConfig resourceProxyConfig = resourceProxyConfigMap.get(requestMethod+"-"+uri.getPath());
		if(null != resourceProxyConfig && resourceProxyConfig.isProxyEnabled()){
			Response response = resourceProxyService.proxyResource(resourceProxyConfig,requestContext,resourceInfo);
			requestContext.abortWith(response);
		}
	}
}
