# Cheatsheet

- For Servlet container 3.x, you can annotate the listener with @WebListener, no need to declares in web.xml.

- <listener-class>:
```
This element registers a listener with the Web container.

The data provided between the tags is the fully qualified class name for the listener class.

The class must implement one or more interfaces from the javax.servlet API, and also have a public constructor that takes no arguments. See the examples for more information on each interface.

The order in which listeners are invoked, is the same as the order they are registered in, which is the order they appear in the deployment descriptor (web.xml file).

The container instantiates each listener class before executing any requests. However, there is nothing to prevent a listener and request being executed at the same time according to the specification.

Example code demonstrating the <listener> and <listener-class> elements:
Context Listener example, to listen for application create/destroy events
Session Listener example, to listen for session create/destroy events
Session Attribute Listener example, to listen for changes to session attributes
```

# Links
- https://www.mkyong.com/servlet/what-is-listener-servletcontextlistener-example/
- http://wiki.metawerx.net/wiki/Web.xml.ListenerClass