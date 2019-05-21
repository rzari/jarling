package org.jarling.v2.models.individuals;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Email update request
 */
@Data
@RequiredArgsConstructor
public class EmailUpdateRequest {
    @NonNull
    private final String email;
}
