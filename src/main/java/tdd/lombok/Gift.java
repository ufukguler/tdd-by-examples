package tdd.lombok;

import lombok.*;

/**
 * created by: ufuk on 8.10.2020 16:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Gift {
    private int id;
    private String name;
    private String description;
    private int price;
}
