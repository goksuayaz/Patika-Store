import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Delete Products");
            System.out.println("4. List Brands");
            System.out.println("5. Exit");
            System.out.print("Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case  1:
                    System.out.println("Add Mobile Phone : 1");
                    System.out.println("Add Notebook : 2");
                    int productChoice = scanner.nextInt();
                    System.out.print("Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Unit Price : ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Amount of Stock : ");
                    int stokAmount = scanner.nextInt();
                    System.out.print("Brand ID : ");
                    int brandId = scanner.nextInt();

                    scanner.nextLine();
                    Brand brand = store.getBrandById(brandId);
                    if (brand != null){
                        int storage, camera, ram;
                        double screenSize, battery;
                        if (productChoice == 1){
                            System.out.print("Memory (GB): ");
                            storage = scanner.nextInt();
                            System.out.print("Screen Size (inch): ");
                            screenSize = scanner.nextDouble();
                            System.out.print("Camera (MP): ");
                            camera = scanner.nextInt();
                            System.out.print("Battery (mAh): ");
                            battery = scanner.nextDouble();
                            scanner.nextLine();
                            Product mobilePhone = new Product(unitPrice,stokAmount,productName,brand,storage,screenSize,camera,battery);
                            store.addProduct(mobilePhone,productChoice);
                        }else {
                            System.out.print("Storage (GB): ");
                            storage = scanner.nextInt();

                            System.out.print("RAM (GB): ");
                            ram = scanner.nextInt();
                            System.out.print("Screen Size (inch): ");
                            screenSize = scanner.nextDouble();
                            scanner.nextLine();
                            Product notebook = new Product(unitPrice,stokAmount,productName,brand,storage,screenSize,ram);
                            store.addProduct(notebook,productChoice);
                        }
                        System.out.println("Product added");
                    }else {
                        System.out.println("Invalid brand ID");
                    }
                    break;

                case 2:
                    store.productListing();
                    break;
                case 3:
                    System.out.println("Select the product to delete");
                    int deleteId = scanner.nextInt();
                    store.deleteProduct(deleteId);
                    System.out.println("Product deleted");
                    break;
                case 4:
                    store.brandListing();
                    break;
                case 5:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("Invalid Selection");

            }
        }
    }


}
