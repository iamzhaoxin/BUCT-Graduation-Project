package buct.budgetsystem.pojo.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@Slf4j
public class ProcessUsing {
    public static HashMap<String, String> process = new HashMap<>();
    public static ArrayList<String> approverId = new ArrayList<>(10);

    ProcessUsing() {
        process.put("id", "");
        process.put("name", "");
        process.put("key", "");
        process.put("version", "");
        approverId.set(0, "2018040437");
        approverId.set(1, "2018040438");
        approverId.set(2, "2018040439");
        approverId.set(3, "2018040440");
    }

    public static void setProcess(String id, String name, String key, String version) {
        process.put("id", id);
        process.put("name", name);
        process.put("key", key);
        process.put("version", version);
        log.info("选择流程：" + process.toString());
    }

}
