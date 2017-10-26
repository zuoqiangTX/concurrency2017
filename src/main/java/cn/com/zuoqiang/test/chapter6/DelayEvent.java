package cn.com.zuoqiang.test.chapter6;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayEvent implements Delayed {
    private Date startDate;

    public DelayEvent(Date startDate) {
        this.startDate = startDate;
    }

    public long getDelay(TimeUnit unit) { //返回到激活日期的剩余日期
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    public int compareTo(Delayed o) { //当前元素大于参数  返回大于0
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        }
        return 0;
    }
}
