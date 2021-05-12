单元测试可以通过安装插件JUnitGenerator V2.0  
后编写模板自动批量生成单元测试  
配置输出路径
```
${SOURCEPATH}/../../test/java/${PACKAGE}/${FILENAME}
```
Junit5简易模板参见
```
resources/JUnitGenerator-Junit5-Template.vm
```  
Idea 操作
```
想要单元测试的类右键 -> Generate.. -> Junit Test -> Junit4/Junit3(选你配置的地方)
```