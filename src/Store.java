import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Store {


    private List<Brand> brands;
    private List<Product> mobilePhones;
    private List<Product> noteBooks;

    public Store() {
        this.brands = new ArrayList<>();
        this.mobilePhones = new ArrayList<>();
        this.noteBooks = new ArrayList<>();

        brands.add(new Brand(1, "Apple"));
        brands.add(new Brand(2, "Asus"));
        brands.add(new Brand(3, "Casper"));
        brands.add(new Brand(4, "HP"));
        brands.add(new Brand(5, "Huawei"));
        brands.add(new Brand(6, "Lenovo"));
        brands.add(new Brand(7, "Monster"));
        brands.add(new Brand(8, "Samsung"));
        brands.add(new Brand(9, "Xiaomi"));
        brands.sort(Comparator.comparing(Brand :: getName));
    }

    public void addProduct(Product product,int productChoice){
        if (product instanceof Product){
            for (Brand brand : brands){
                if (product.getBrand().getName().equals(brand.getName())){
                    if(productChoice == 1){
                        mobilePhones.add(product);
                    }else {
                        noteBooks.add(product);
                    }
                    break;
                }
            }
        }
    }

    public void deleteProduct(int productId){

        mobilePhones.removeIf(product -> product.getId() == productId);
        noteBooks.removeIf(product -> product.getId() == productId);


    }
    public  void productListing(){

        System.out.println("Notebook List : ");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                   | Price     | Brand     | Storage  | Screen     | RAM         |");
        System.out.println("| 1 | HUAWEI Matebook 14              | 7000.0 TL | Huawei    | 512      | 14.0       | 16          |");
        System.out.println("| 2 | LENOVO V14 IGL                  | 3699.0 TL | Lenovo    | 1024     | 14.0       | 8           |");
        System.out.println("| 3 | ASUS Tuf Gaming                 | 8199.0 TL | Asus      | 2048     | 15.6       | 32          |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Product product : noteBooks) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-11d |\n", product.getId(), product.getProductName(), product.getUnitPrice(), product.getBrand().getName(), product.getStorage(), product.getScreenSize(), product.getRam());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("\nMobile Phone List : ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                       | Price     | Brand     | Storage  | Screen   | Camera | Pi          | RAM         | Color      |");
        System.out.println("| 1 | SAMSUNG GALAXY A51                  | 3199.0 TL | Samsung   | 128      | 6.5      | 32     | 4000.0      | 12          | Black      |");
        System.out.println("| 2 | IPhone 11 64 GB                     | 7379.0 TL | Apple     | 64       | 6.1      | 5      | 3046.0      | 6           | Blue       |");
        System.out.println("| 3 | Redmi Note 10 Pro 8GB               | 4012.0 TL | Xiaomi    | 128      | 6.5      | 35     | 4000.0      | 12          | White      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (Product product: mobilePhones) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-9d | %-9.1f | %-9d | %-9s |\n", product.getId(), product.getProductName(), product.getUnitPrice(), product.getBrand().getName(), product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(), product.getRam(), product.getColor());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }

    public  void brandListing(){
        System.out.println("| ID |Brand Name  |");
        for (Brand brand : brands) {
            System.out.format("| %-1d  | %-1s |\n",brand.getId(),brand.getName());
        }
    }

    public Brand getBrandById(int id) {
        for (Brand brand : brands) {
            if (brand.getId() == id) {
                return brand;
            }
        }
        return null;
    }

}




