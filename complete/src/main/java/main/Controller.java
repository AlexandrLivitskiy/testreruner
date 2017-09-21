package main;

import model.JiraTask;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.jayway.jsonpath.JsonPath.read;

@RestController
public class Controller {

    static ConcurrentHashMap<String,JiraTask> jiraTask = new ConcurrentHashMap();
    JiraApi jiraApi = new JiraApi();

    @RequestMapping("/getCDR")
    public Enumeration<String> greeting(@RequestParam(value="name", defaultValue="not Found") String name) {
        String test ="";
        try {
            test = jiraApi.getCDR();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fillMap(test);
        System.out.println(test);
        return jiraTask.keys();
    }

    public static void fillMap(String result){
        List<String> issueKeys =  read(result, "$.issues[*].key");
        List<String> description = read(result, "$.issues[?(@.key)].fields.description");
        List<String> names = read(result, "$.issues[*].fields.assignee.name");
        int i=0;
        for (String key : issueKeys){
            ArrayList<String> caseList = getIdList(description.get(i));
            jiraTask.putIfAbsent(key,new JiraTask(key,caseList,names.get(i)));
            i++;
        }
    }

    public static ArrayList<String> getIdList(String text){
        ArrayList<String> returnList = new ArrayList<>();
        text = text.split("\n")[0];
        for (String id: text.split(",")){
            returnList.add(id.trim());
        }
        return returnList;
    }
}
