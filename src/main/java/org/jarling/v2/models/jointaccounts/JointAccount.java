package org.jarling.v2.models.jointaccounts;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.individuals.Individual;

import java.util.UUID;

/**
 * Information about a joint account
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class JointAccount {
    private UUID accountHolderUid;
    private Individual personOne;
    private Individual personTwo;
}
