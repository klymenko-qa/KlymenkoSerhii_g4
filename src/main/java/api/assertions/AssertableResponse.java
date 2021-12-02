package api.assertions;

import api.conditions.Condition;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AssertableResponse {

    public final ValidatableResponse response;

    public AssertableResponse shouldHave(Condition condition) {
        log.info("check for: " + condition);
        condition.check(response);
        return this;
    }
}