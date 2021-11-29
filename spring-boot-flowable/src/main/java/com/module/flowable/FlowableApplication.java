package com.module.flowable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/11/29 16:31
 **/
public class FlowableApplication {

  public static void main(String[] args) {
    //1、创建ProcessEngineConfiguration实例,该实例可以配置与调整流程引擎的设置
    ProcessEngineConfiguration cfg=new StandaloneProcessEngineConfiguration()
        //2、通常采用xml配置文件创建ProcessEngineConfiguration，这里直接采用代码的方式
        //3、配置数据库相关参数
        .setJdbcUrl("jdbc:mysql://localhost:3306/standard-investment?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2b8&nullCatalogMeansCurrent=true")
        .setJdbcUsername("root")
        .setJdbcPassword("123456")
        .setJdbcDriver("com.mysql.cj.jdbc.Driver")
        .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    //4、初始化ProcessEngine流程引擎实例
    ProcessEngine processEngine=cfg.buildProcessEngine();

    // 使用BPMN 2.0定义process。存储为XML，同时也是可以可视化的。NPMN 2.0标准可以让技术人员与业务人员都
    // 参与讨论业务流程中来

    // 部署流程
    RepositoryService repositoryService = processEngine.getRepositoryService();
    Deployment deployment = repositoryService.createDeployment()
        .addClasspathResource("holiday-request.bpmn20.xml")
        .deploy();
    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
        .deploymentId(deployment.getId())
        .singleResult();
    System.out.println("Found process definition : " + processDefinition.getName());

    // 启动process实例，需要一些初始化的变量，这里我们简单的从Scanner中获取，一般在线上会通过接口传递过来
    Scanner scanner= new Scanner(System.in);

    System.out.println("Who are you?");
    String employee = scanner.nextLine();

    System.out.println("How many holidays do you want to request?");
    Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());

    System.out.println("Why do you need them?");
    String description = scanner.nextLine();

    RuntimeService runtimeService = processEngine.getRuntimeService();

    Map<String, Object> variables = new HashMap<>();
    variables.put("employee", employee);
    variables.put("nrOfHolidays", nrOfHolidays);
    variables.put("description", description);

    // 当创建实例的时候，execution就被创建了，然后放在启动的事件中，这个事件可以从数据库中获取，
    // 用户后续等待这个状态即可
    ProcessInstance processInstance =
        runtimeService.startProcessInstanceByKey("holidayRequest", variables);

    // 在Flowable中数据库的事务对数据一致性起着关键性的作用。
    // 查询和完成任务

    TaskService taskService = processEngine.getTaskService();
    List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
    System.out.println("You have " + tasks.size() + " tasks:");
    for (int i=0; i<tasks.size(); i++) {
      System.out.println((i+1) + ") " + tasks.get(i).getName());
    }


    System.out.println("Which task would you like to complete?");
    int taskIndex = Integer.valueOf(scanner.nextLine());
    Task task = tasks.get(taskIndex - 1);
    Map<String, Object> processVariables = taskService.getVariables(task.getId());
    System.out.println(processVariables.get("employee") + " wants " +
        processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");

    boolean approved = scanner.nextLine().toLowerCase().equals("y");
    variables = new HashMap<String, Object>();
    variables.put("approved", approved);
    taskService.complete(task.getId(), variables);


    HistoryService historyService = processEngine.getHistoryService();
    List<HistoricActivityInstance> activities =
        historyService.createHistoricActivityInstanceQuery()
            .processInstanceId(processInstance.getId())
            .finished()
            .orderByHistoricActivityInstanceEndTime().asc()
            .list();

    for (HistoricActivityInstance activity : activities) {
      System.out.println(activity.getActivityId() + " took "
          + activity.getDurationInMillis() + " milliseconds");
    }
  }

}
