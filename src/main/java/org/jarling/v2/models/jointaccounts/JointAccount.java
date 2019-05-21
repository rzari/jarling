package org.jarling.v2.models.jointaccounts;

import lombok.Data;
import org.jarling.v2.models.individuals.Individual;

import java.util.UUID;

/**
 * Information about a joint account
 */
@Data
public class JointAccount {
    private final UUID accountHolderUid;
    private final Individual personOne;
    private final Individual personTwo;
}
