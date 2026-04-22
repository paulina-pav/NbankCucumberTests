package cucumber.steps;

import api.generators.RandomModelGenerator;
import api.generators.ServiceMessages;
import api.models.CreatedUser;
import api.models.GetCustomerProfileResponse;
import api.models.UserChangeNameRequest;
import api.models.UserChangeNameResponse;
import api.requests.steps.AdminSteps;
import api.requests.steps.UserSteps;
import cucumber.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps {
    private final TestContext context;

    public TestSteps(TestContext context) {
        this.context = context;
    }

    private UserChangeNameResponse result;
    private UserChangeNameRequest newName;
    private GetCustomerProfileResponse userAfter;


    @Given("I create a new user")
    public void createUser() {
        context.setCreatedUser(AdminSteps.createUser());

    }

    @When("I change user's name")
    public void changeName() {
        newName = RandomModelGenerator.generate(UserChangeNameRequest.class);
        result = UserSteps.changesRandomNameReturnsResponse(context.getCreatedUser().getRequest(), newName);

        userAfter = UserSteps.getsProfile(context.getCreatedUser().getRequest());
    }

    @Then("Name is changed")
    public void checkIfNameChanged() {
        assertThat(result.getMessage()).isEqualTo(ServiceMessages.PROFILE_UPDATED_SUCCESSFULLY.getMessage());
        assertThat(result.getCustomer().getName()).isEqualTo(newName.getName());
        assertThat(result.getCustomer().getName()).isEqualTo(userAfter.getName());
    }
}

