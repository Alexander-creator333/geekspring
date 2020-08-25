package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "productid")
    private int productId;


    @OneToOne
    @JoinColumn(name = "userId")
    private Users name;

    @OneToOne
    @JoinColumn(name = "productId")
    private Product productname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Users getName() {
        return name;
    }

    public void setName(Users name) {
        this.name = name;
    }

    public Product getProductname() {
        return productname;
    }

    public void setProductname(Product productname) {
        this.productname = productname;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "userId=" + userId +
                ", userName=" + name.getName() +
                ", productId=" + productId +
                ", productName=" + productname.getProductName() +
                '}';
    }
}
