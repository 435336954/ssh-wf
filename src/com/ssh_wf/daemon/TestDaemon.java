package com.ssh_wf.daemon;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*1.4、测试spring定时任务*/
@Service("testDaemon")
public class TestDaemon {

    private Integer i = 0 ;

    /**
     *  已过期订单，释放已分配库存
     */
    @Transactional
    public void testMethod(){
        System.out.println("测试定时"+i++);
    }
}
