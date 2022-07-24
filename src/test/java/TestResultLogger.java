import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class TestResultLogger extends TestWatcher {
    Log log = new Log();

    @Override
    public void succeeded(Description description) {
        String testName = description.getDisplayName();
        log.info(testName+" PASSED");
    }

    @Override
    public void failed(Throwable e, Description description) {
        String testName = description.getDisplayName();
        String cause = e.getMessage();
        log.error(testName +" FAILED :" + cause);
    }


}
