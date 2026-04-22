package cucumber.context;

import api.models.CreatedUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {
    private CreatedUser createdUser;

    public void clear() {
        this.createdUser = null;
    }
}
