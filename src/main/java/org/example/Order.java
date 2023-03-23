package org.example;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.deserialize.LocalDateDeserialize;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    @JsonDeserialize(using = LocalDateDeserialize.class)
    private LocalDate date;
    private List<OrderItem> orderItems;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class OrderItem{
    private String productId;
    private int quantity;
}
