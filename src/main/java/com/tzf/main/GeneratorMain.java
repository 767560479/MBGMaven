/**
 *  @Title:  GeneratorMain.java 
 *  @author: tzf
 *  @Description:    TODO(用一句话描述该文件做什么)
 *  @date:   2019年4月23日 下午4:28:13 
 *
 */
package com.tzf.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorMain {


	public static void main(String[] args)throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "/generatorConfig.xml";
        File configFile = new File(GeneratorMain.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = null;
        try {
			configuration = cp.parseConfiguration(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (XMLParserException e) {
			e.printStackTrace();
		}
        DefaultShellCallback callback =new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        
        try {
			myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
        try {
			myBatisGenerator.generate(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
