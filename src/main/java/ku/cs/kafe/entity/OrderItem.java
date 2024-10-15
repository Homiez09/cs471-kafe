//6510405750 Phumrapee Soenvanichakul
package ku.cs.kafe.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class OrderItem {


    @EmbeddedId
    private OrderItemKey id;


    private int quantity;


    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private PurchaseOrder purchaseOrder;


    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public double getSubtotal() {
        return menu.getPrice() * quantity;
    }


    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(OrderItemKey id) {
        this.id = id;
    }
}
