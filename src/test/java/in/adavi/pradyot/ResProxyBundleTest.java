package in.adavi.pradyot;

import in.adavi.pradyot.resourceproxy.app.ResourceProxyApp;
import in.adavi.pradyot.resourceproxy.app.model.SimpleRequest;
import in.adavi.pradyot.resourceproxy.app.model.SimpleResponse;
import in.adavi.pradyot.resourceproxy.app.web.ResProxyAppConfiguration;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/**
 * @author Pradyot H Adavi
 */
public class ResProxyBundleTest {
	
	@ClassRule
	public static final DropwizardAppRule<ResProxyAppConfiguration> RULE =
			new DropwizardAppRule<ResProxyAppConfiguration>(ResourceProxyApp.class,
					ResourceHelpers.resourceFilePath("config.yml"));
	
	@Test
	public void proxySimpleGetTest(){
		
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target(String.format("http://localhost:19090/resource-proxy/demo/0", RULE.getLocalPort()))
				.request()
				.get();
		SimpleResponse simpleResponse = response.readEntity(SimpleResponse.class);
		
		Assert.assertEquals(Response.Status.ACCEPTED.getStatusCode(),response.getStatus());
		Assert.assertNotNull(simpleResponse);
		Assert.assertEquals("demo1",simpleResponse.getResponseMsg());
	}
	
	@Test
	public void noProxyGetTest(){
		
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target(String.format("http://localhost:19090/resource-proxy/demo/2", RULE.getLocalPort()))
				.request()
				.get();
		SimpleResponse simpleResponse = response.readEntity(SimpleResponse.class);
		
		Assert.assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
		Assert.assertNotNull(simpleResponse);
		Assert.assertEquals("demo2",simpleResponse.getResponseMsg());
	}
	
	@Test
	public void proxySimplePostTest(){
		
		SimpleRequest simpleRequest = new SimpleRequest();
		simpleRequest.setRequestMsg("post request");
		
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target(String.format("http://localhost:19090/resource-proxy/demo/3",
				RULE.getLocalPort()))
				.request()
				.post(Entity.json(simpleRequest));
		SimpleResponse simpleResponse = response.readEntity(SimpleResponse.class);
		
		Assert.assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
		Assert.assertNotNull(simpleResponse);
		Assert.assertEquals("proxy response",simpleResponse.getResponseMsg());
	}
	
	@Test
	public void proxyQueryParamsGetTest(){
		
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target(String.format("http://localhost:19090/resource-proxy/demo/5?msg=demo5",
				RULE.getLocalPort()))
				.request()
				.get();
		SimpleResponse simpleResponse = response.readEntity(SimpleResponse.class);
		
		Assert.assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
		Assert.assertNotNull(simpleResponse);
		Assert.assertEquals("proxy response demo5",simpleResponse.getResponseMsg());
		
	}
	
	@Test
	public void proxySimplePutTest(){
		
		SimpleRequest simpleRequest = new SimpleRequest();
		simpleRequest.setRequestMsg("post request");
		
		Client client = ClientBuilder.newBuilder().build();
		Response response = client.target(String.format("http://localhost:19090/resource-proxy/demo/7",
				RULE.getLocalPort()))
				.request()
				.put(Entity.json(simpleRequest));
		SimpleResponse simpleResponse = response.readEntity(SimpleResponse.class);
		
		Assert.assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
		Assert.assertNotNull(simpleResponse);
		Assert.assertEquals("proxy response put",simpleResponse.getResponseMsg());
	}
}
