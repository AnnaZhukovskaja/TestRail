package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TestCase {
    String title;
    String estimate;
    String references;
    String preconditions;

}
