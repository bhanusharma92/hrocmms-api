package in.nic.hrocmms.service;
import in.nic.hrocmms.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestService {

    public List<Test> getData(){
        List<Test> testList = new ArrayList<>();
        Test test = new Test("1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7");
        testList.add(test);
        return testList;
    }


}
