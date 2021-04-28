package com.module.generate;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/4/27 16:32
 **/
public class Generator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());
        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());
        // 包配置
        mpg.setPackageInfo(getPackageConfig());
        // 策略配置
        mpg.setStrategy(getStrategyConfig());
        // 模板生成配置
        mpg.setTemplate(getTemplateConfig());
        // 自定义配置
        mpg.setCfg(getInjectionConfig());
        // 执行代码生成器
        mpg.execute();

//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    }

    private static GlobalConfig getGlobalConfig(){
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/spring-boot-generate/src/main/java");
        gc.setAuthor("lvxc");
        //是否打开输出目录
        gc.setOpen(false);
        //是否覆盖原有文件,建议关闭
        gc.setFileOverride(false);
        gc.setSwagger2(true);
        return gc;
    }

    private static DataSourceConfig getDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/standard-investment?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        return dsc;
    }

    private static PackageConfig getPackageConfig(){
        PackageConfig pc = new PackageConfig();
        //如需设置对模块进行分类可进行设置（多应用、多模块场景）
        // pc.setModuleName();
        pc.setEntity("model");
        pc.setParent("com.module.generate");
        return pc ;
    }

    private static StrategyConfig getStrategyConfig(){
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名
        strategy.setInclude("zs_sys_user");
        strategy.setTablePrefix("zs_","map_","im_");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        // 生成字段常量
        strategy.setEntityColumnConstant(true);
        return strategy ;
    }

    private static TemplateConfig getTemplateConfig(){
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //自定义模板
//        templateConfig.setEntity("templates/entity2.java");
        templateConfig.setService(null);
        templateConfig.setController(null);
        templateConfig.setServiceImpl(null);
        //自定义XML输出路径后这里可以设置为null
        templateConfig.setXml(null);
        return templateConfig ;
    }

    private static InjectionConfig getInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // velocity模板引擎
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/spring-boot-generate/src/main/resources/mapper/"
                         + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir(filePath);
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg ;
    }
}
