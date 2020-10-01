import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList <Product> productsList = new ArrayList<>();


public static void addProduct() throws IOException {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sp");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sx");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập giá sp");
        double price = scanner.nextDouble();
        if (productsList.add(new Product(productsList.size()+1, name,manufacturer,price))){
            writeFile();
            System.out.println("Thêm thành công");
        }else {
            System.out.println("Không thành công");
        }
    }

    public static void displayProduct() throws IOException, ClassNotFoundException {
        readFile();
        for (Product i : productsList) {
            System.out.println(i.toString());
        }
    }


    public static void findProductByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sp cần tìm");
        String nameNeedFind = scanner.nextLine();
        boolean checkFind = true;
        for (Product product : productsList){
            if (nameNeedFind.equals(product.getName())){
                System.out.println(product.toString());
                checkFind = false;
            }
        }
        if ((checkFind)){
            System.out.println("Không có sp này");
        }
    }
    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("product.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(productsList);
        oos.close();
        fos.close();
    }
    public static void readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("product.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        productsList = (ArrayList<Product>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
    }

}
