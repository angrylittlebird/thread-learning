package uncaughtexception;

import java.util.logging.Logger;

/**
 * @Author: ZHANG
 * @Date: 2019/11/24
 * @Description: 对线程中未捕获的异常进行统一处理
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.warning(name + "捕获了 " + t.getName() + ": " + e);
    }
}
