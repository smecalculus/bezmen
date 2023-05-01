package org.smecalculus.bezmen.testing;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

public class ShardingExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        int modulus = Integer.getInteger("bezmen.sharding.modulus", 1);
        if (modulus <= 1) {
            return enabled("without sharding");
        }
        if (context.getTestMethod().isEmpty()) {
            return enabled("classes always enabled");
        }
        var reminder = Integer.getInteger("bezmen.sharding.reminder", 0);
        var testId = context.getUniqueId().hashCode();
        if (testId % modulus == reminder) {
            return enabled("shard match: " + reminder);
        }
        return disabled("shard mismatch: " + reminder);
    }
}
