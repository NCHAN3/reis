import com.tiaa.Dispatcher;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by navchand0 on 7/1/2018.
 */
public class DispatcherTests {

    @Test
    public void processWorkers() throws ExecutionException, InterruptedException {

        int noOfBolts = 6;
        int noOfMachines = 3;
        long sleepTime = 60;
        Dispatcher dispatcher = new Dispatcher(noOfBolts,noOfMachines, sleepTime);
        assertEquals(noOfMachines, dispatcher.processWorkers());

    }

    @Test
    public void processWorkersFailed() throws ExecutionException, InterruptedException {

        int noOfBolts = 6;
        int noOfMachines = 3;
        long sleepTime = 60;
        Dispatcher dispatcher = new Dispatcher(noOfBolts,noOfMachines, sleepTime);
        assertNotEquals(noOfBolts, dispatcher.processWorkers());

    }

    @Test
    public void processWorkersExecutionTimeTest() throws ExecutionException, InterruptedException {

        int noOfBolts = 6;
        int noOfMachines = 3;
        long sleepTime = 60;
        Dispatcher dispatcher = new Dispatcher(noOfBolts,noOfMachines, sleepTime);
        assertNotEquals(noOfBolts, dispatcher.processWorkers());

    }
}
