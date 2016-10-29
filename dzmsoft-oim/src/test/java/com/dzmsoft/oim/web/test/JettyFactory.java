package com.dzmsoft.oim.web.test;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

import com.google.common.collect.Lists;

/**
 * 创建Jetty Server的工厂类.
 * 
 * @author calvin
 */
public class JettyFactory {

	private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
	private static final String WINDOWS_WEBDEFAULT_PATH = "src/test/resources/jetty/webdefault-windows.xml";

	/**
	 * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
	 */
	public static Server createServerInSource(int port, String contextPath) {
		Server server = new Server();
		// 设置在JVM退出时关闭Jetty的钩子。
		server.setStopAtShutdown(true);

		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(port);
		// 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
		connector.setReuseAddress(false);
		server.setConnectors(new Connector[] { connector });
		// 上下文
		ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
		// 当前应用
		WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
		// 修改webdefault.xml，解决Windows下Jetty Lock住静态文件的问题.
		webContext.setDefaultsDescriptor(WINDOWS_WEBDEFAULT_PATH);
		contextHandlerCollection.addHandler(webContext);
		// 虚拟目录
		WebAppContext uploadContext = new WebAppContext();
		uploadContext.setContextPath("/oim/upload");
		uploadContext.setResourceBase("/usr/local/upload/");
		contextHandlerCollection.addHandler(uploadContext);
		//
		server.setHandler(contextHandlerCollection);
		
		return server;
	}
	
	private static WebAppContext getWebAppContext(Server server){
	    ContextHandlerCollection contextHandlerCollection = (ContextHandlerCollection) server.getHandler();
	    Handler[] handlers = contextHandlerCollection.getHandlers();
	    WebAppContext context = null;
	    if (handlers!=null && handlers.length>0){
	        for (Handler handler:handlers){
	            if (((WebAppContext)handler).getContextPath().equals(QuickStartServer.CONTEXT)){
	                context = (WebAppContext)handler;
	            }
	        }
	    }
	    return context;
	}

	/**
	 * 设置除jstl-*.jar外其他含tld文件的jar包的名称.
	 * jar名称不需要版本号，如sitemesh, shiro-web
	 */
	public static void setTldJarNames(Server server, String... jarNames) {
		WebAppContext context = getWebAppContext(server);
		List<String> jarNameExprssions = Lists.newArrayList(".*/jstl-[^/]*\\.jar$", ".*/.*taglibs[^/]*\\.jar$");
		for (String jarName : jarNames) {
			jarNameExprssions.add(".*/" + jarName + "-[^/]*\\.jar$");
		}

		context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
				StringUtils.join(jarNameExprssions, '|'));

	}

	/**
	 * 快速重新启动application，重载target/classes与target/test-classes.
	 */
	public static void reloadContext(Server server) throws Exception {
		WebAppContext context = getWebAppContext(server);

		System.out.println("[INFO] Application reloading");
		context.stop();

		WebAppClassLoader classLoader = new WebAppClassLoader(context);
		classLoader.addClassPath("target/classes");
		classLoader.addClassPath("target/test-classes");
		context.setClassLoader(classLoader);

		context.start();

		System.out.println("[INFO] Application reloaded");
	}
}
