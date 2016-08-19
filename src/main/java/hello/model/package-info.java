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
                        value = "1000"
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
                                value = "1000"
                        )
                }
        )
})
package hello.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Parameter;