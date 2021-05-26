package com.module.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = "com.module")
@Slf4j
public class SpringBootModuleApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(SpringBootModuleApplication.class, args);
		Environment env = application.getEnvironment();
		String host= InetAddress.getLocalHost().getHostAddress();
		String port=env.getProperty("server.port");
		log.info("\n----------------------------------------------------------\n" +
						"\t接口文档: \thttp://{}:{}/doc.html\n"+
						"\tDruid地址: \thttp://{}:{}/druid/index.html\n"+
						"----------------------------------------------------------\n",
				host,port,host,port);
	}

}
