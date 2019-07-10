package in.adavi.pradyot.resourceproxy.core;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Pradyot H Adavi
 */
@Slf4j
public class ResourceProxyMgr implements ResourceProxyService  {
	
	private Client client;
	
	@Inject
	public ResourceProxyMgr(Client client) {
		this.client = client;
	}
	
	public Response proxyResource(ResourceProxyConfig resourceProxyConfig,
	                              ContainerRequestContext containerRequestContext, ResourceInfo resourceInfo) {
		
		System.setProperty("sun.net.http.allowRestrictedHeaders","true");
		
		String targetUri = resourceProxyConfig.getHost()+resourceProxyConfig.getPort();
		WebTarget webTarget = client.target(targetUri);
		
		HTTP_METHOD httpMethod = HTTP_METHOD.valueOf(containerRequestContext.getMethod());
		
		MultivaluedMap<String,Object> headers = getHeaders(containerRequestContext.getHeaders());
		webTarget = setQueryParams(webTarget, containerRequestContext.getUriInfo().getQueryParameters());
		String requestData = getRequestData(containerRequestContext.getEntityStream());
		
		Response response = null;
		
		Invocation.Builder invocationBuilder = webTarget
				.path(resourceProxyConfig.getPath())
				.request(containerRequestContext.getMediaType())
				.headers(headers);
		
		switch (httpMethod){
			case GET:
				response = invocationBuilder.get();
				break;
					
			case POST:
				response = invocationBuilder.post(Entity.entity(requestData,containerRequestContext.getMediaType()));
				break;
				
			case PUT:
				response = invocationBuilder.put(Entity.entity(requestData,containerRequestContext.getMediaType()));
				break;
				
			case DELETE:
				break;
		}
		return response;
	}
	
	private MultivaluedMap<String,Object> getHeaders(MultivaluedMap<String, String> containerHeaders){
		
		String ipAddress = null;
		
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			ipAddress = localHost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			log.error("Exception occurred while getting the proxy host ip address",e);
		}
		
		String[] restrictedHeaders = {
				"Access-Control-Request-Headers",
				"Access-Control-Request-Method",
				"Connection", /* close is allowed */
				"Content-Length",
				"Content-Transfer-Encoding",
				"Host",
				"Keep-Alive",
				"Origin",
				"Trailer",
				"Transfer-Encoding",
				"Upgrade",
				"Via",
				"User-Agent",
				"Accept"
		};
		
		List<String> res = Arrays.asList(restrictedHeaders);
		
		MultivaluedMap<String,Object> headers = new MultivaluedHashMap<String, Object>();
		
		for (Map.Entry<String,List<String>> entry: containerHeaders.entrySet()) {
			if(!res.contains(entry.getKey())){
				headers.add(entry.getKey(),entry.getValue());
			}
		}
		headers.add("X-Proxy-Bundle",ipAddress);
		
		return headers;
	}
	
	private WebTarget setQueryParams(WebTarget webTarget,MultivaluedMap<String, String> queryParameters){
		
		if(null != queryParameters && queryParameters.size() > 0) {
			for (Map.Entry<String, List<String>> entry : queryParameters.entrySet()) {
				if(1 == entry.getValue().size()){
					webTarget = webTarget.queryParam(entry.getKey(), entry.getValue().get(0));
				} else {
					webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
				}
			}
		}
		return webTarget;
	}
	
	private String getRequestData(InputStream in){
		
		String requestData = null;
		try {
			ByteArrayOutputStream result = new ByteArrayOutputStream();
			byte[] buffer = new byte[in.available()];
			int length;
			while ((length = in.read(buffer)) != -1) {
				result.write(buffer, 0, length);
			}
			requestData = result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestData;
	}
}
