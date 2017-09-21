package model;

import java.util.ArrayList;

/**
 * Created by Ali on 21.09.2017.
 */
public class JiraTask {
    String taskId;
    ArrayList<String> caseList = new ArrayList<>();
    String ownerName;

    public JiraTask(String taskId, ArrayList<String> caseList, String ownerName) {
        this.taskId = taskId;
        this.caseList = caseList;
        this.ownerName = ownerName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public ArrayList<String> getCaseList() {
        return caseList;
    }

    public void setCaseList(ArrayList<String> caseList) {
        this.caseList = caseList;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
