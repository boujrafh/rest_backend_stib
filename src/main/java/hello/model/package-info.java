@GenericGenerators({
        @GenericGenerator(
                name = "ID_GENERATOR_POOLED",
                strategy = "enhanced-sequence",
                parameters = {
                        @Parameter(
                                name = "sequence_name",
                                value = "SB_SEQUENCE"
                        ), @Parameter(
                        name = "increment_size",
                        value = Constants.BATCH_SIZE_STRING
                ),
                        @Parameter(
                                name = "optimizer",
                                value = "pooled-lo"
                        )
                }
        ),
        @GenericGenerator(
                name = "ID_GENERATOR",
                strategy = "enhanced-sequence",
                parameters = {
                        @Parameter(
                                name = "sequence_name",
                                value = "SB_SEQUENCE"
                        ),
                        @Parameter(
                                name = "initial_value",
                                value = Constants.INITIAL_ID
                        )
                }
        )
})
package hello.model;

import hello.metadata.Constants;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Parameter;