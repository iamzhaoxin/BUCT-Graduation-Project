package buct.budgetsystem.pojo.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@Data
@Slf4j
public class ProcessUsing {
    public static HashMap<String, String> process = new HashMap<>();
    public static LinkedList<String> approverId = new LinkedList<>();
    public ProcessUsing() {
        process.put("id", "");
        process.put("name", "");
        process.put("key", "");
        process.put("version", "");

        approverId.push("2018040440");
        approverId.push("2018040439");
        approverId.push("2018040438");
        approverId.push("2018040437");
    }
    public static void addApprover(String userId){
        approverId.set(approverId.size(),userId);
    }
    public static void setProcess(String id, String name, String key, String version) {
        process.put("id", id);
        process.put("name", name);
        process.put("key", key);
        process.put("version", version);
        log.info("选择流程：" + process.toString());
    }

}
