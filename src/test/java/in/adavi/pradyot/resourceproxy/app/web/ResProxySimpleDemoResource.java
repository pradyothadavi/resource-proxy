package in.adavi.pradyot.resourceproxy.app.web;

import in.adavi.pradyot.resourceproxy.app.model.SimpleRequest;
import in.adavi.pradyot.resourceproxy.app.model.SimpleResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Pradyot H Adavi
 */
@Path("/demo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class ResProxySimpleDemoResource {
	
	@GET
	@Path("/0")
	public Response demo(){
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg("demo");
		return Response.ok(simpleResponse).build();
	}
	
	@GET
	@Path("/1")
	public Response demo1(){
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg("demo1");
		return Response.accepted(simpleResponse).build();
	}
	
	@GET
	@Path("/2")
	public Response demo2(){
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg("demo2");
		return Response.ok(simpleResponse).build();
	}
	
	@POST
	@Path("/3")
	public Response demo3(SimpleRequest simpleRequest){
		
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg(simpleRequest.getRequestMsg());
		
		return Response.ok(simpleResponse).build();
	}
	
	@POST
	@Path("/4")
	public Response demo4(SimpleRequest simpleRequest){
		
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg("proxy response");
		
		return Response.ok(simpleResponse).build();
	}
	
	@GET
	@Path("/5")
	public Response demo5(@QueryParam("msg")String msg){
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg(msg);
		return Response.ok(simpleResponse).build();
	}
	
	@GET
	@Path("/6")
	public Response demo6(@QueryParam("msg")String msg){
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg("proxy response "+msg);
		return Response.ok(simpleResponse).build();
	}
	
	@PUT
	@Path("/7")
	public Response demo7(SimpleRequest simpleRequest){
		
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg(simpleRequest.getRequestMsg());
		
		return Response.ok(simpleResponse).build();
	}
	
	@PUT
	@Path("/8")
	public Response demo8(SimpleRequest simpleRequest){
		
		SimpleResponse simpleResponse = new SimpleResponse();
		simpleResponse.setResponseMsg("proxy response put");
		
		return Response.ok(simpleResponse).build();
	}
}
