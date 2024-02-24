package smecalculus.bezmen.testing;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static smecalculus.bezmen.configuration.TestingProps.MODULUS_KEY;
import static smecalculus.bezmen.configuration.TestingProps.REMINDER_KEY;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ShardingExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        int modulus = requireNonNull(Integer.getInteger(MODULUS_KEY));
        if (modulus <= 1) {
            return enabled("without sharding");
        }
        if (context.getTestMethod().isEmpty()) {
            return enabled("classes always enabled");
        }
        var reminder = requireNonNull(Integer.getInteger(REMINDER_KEY));
        var testId = context.getUniqueId().hashCode();
        if (testId % modulus == reminder) {
            return enabled("shard match: " + reminder);
        }
        return disabled("shard mismatch: " + reminder);
    }
}
