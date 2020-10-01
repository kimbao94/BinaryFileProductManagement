import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("QUẢN LÝ SẢN PHẨM");
        System.out.println("Các chức năng");
        System.out.println("1.Thêm sản phẩm");
        System.out.println("2.Hiển thị danh sách sản phẩm");
        System.out.println("3.Tìm kiếm sản phẩm");
        System.out.println("4.Thoát");
        int num = scanner.nextInt();

        switch (num){
            case 1:
                try {
                    ProductManager.addProduct();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ProductManager.displayProduct();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                ProductManager.findProductByName();
                break;
            default:
                break;
        }
    }
}
