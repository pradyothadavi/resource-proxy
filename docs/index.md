# resource-proxy-bundle

A dropwizard bundle to proxy requests to a resource in a dropwizard
application. 

## Salient Features

* Integrating with an existing dropwizard application is a two step
  process without code changes. 
  
  * Add resource proxy bundle to the dropwizard application class. 
  * In the YAML configuration file of the application add the resource
    paths which are to be proxied. 
    
* Optionally, enable Hystrix Circuit Breaker

* Metrics for visibility

## WIP Features

* Gzip Compression

* Dis/enable proxy for a given resource path