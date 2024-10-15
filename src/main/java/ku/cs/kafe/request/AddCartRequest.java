//6510405750 Phumrapee Soenvanichakul
package ku.cs.kafe.request;


import lombok.Data;


@Data
public class AddCartRequest {
    private int quantity;

    public int getQuantity() {
        return quantity;
    }
}
