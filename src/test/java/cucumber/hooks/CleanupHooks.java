package cucumber.hooks;

import api.requests.steps.AdminSteps;
import cucumber.context.TestContext;
import io.cucumber.java.After;

public class CleanupHooks {
    private final TestContext context;

    public CleanupHooks(TestContext context) {
        this.context = context;
    }

    @After
    public void cleanup() {
        if (context.getCreatedUser() != null) {
            try {
                AdminSteps.deletesUser(context.getCreatedUser());
            } catch (Exception e) {
                System.out.println("Cleanup failed for user: " + e.getMessage());
            }
        }

        context.clear();
    }
}
