package OOP;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Bai3 {
    private int ma;
    private String ten;
    private double gia;
    private Date sx, hh;

    public Bai3(int ma, String ten, double gia, Date sx, Date hh) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.sx = sx;
        this.hh = hh;
    }
    public Bai3(){}

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getSx() {
        return sx;
    }

    public void setSx(Date sx) {
        this.sx = sx;
    }

    public Date getHh() {
        return hh;
    }

    public void setHh(Date hh) {
        this.hh = hh;
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi","VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String money = numberFormat.format(gia);

        SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
        String pro = date.format(sx);
        String ex = date.format(hh);

        return "Thông tin chi tiết" +
                "\nMã: " + ma +
                "\nTên: " + ten +
                "\nPrice: " + money +
                "\nNgày sản xuất: " + pro +
                "\nNgày hết hạn: " + ex
                ;
    }
    public void setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month , day);
        this.sx = calendar.getTime();
    }
    public void setHSD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        this.hh = calendar.getTime();
    }
    public boolean checkName(boolean k) {
        if (this.ten == "" || this.ten.isEmpty()){
            System.out.println("Tên hàng không đc để trống !");
        } else {
            k = false;
        }
        return k;
    }
    public boolean checkDate(boolean t) {
        if (this.getSx().compareTo(getHh())<0){
        } else {
            t = false;
            System.out.println("Tên hết hạn ko đc trc ngày sản xuất !");
        }
        return t;
    }
    public void checkExpire(){
        Date today = new Date();
        today.getTime();
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
        String st = simple.format(today);
        if (this.getHh().compareTo(today)<0){
            System.out.println("Hôm nay ngày "+st+" sản phẩm đã hết hạn !");
        } else {
            System.out.println("Hôm nay ngày "+st+" sản phẩm chưa hết hạn !");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bai3 bai3 = new Bai3();
        boolean kt = true;
        boolean th = false;
        System.out.println("Nhập mã hàng : ");
        bai3.setMa(scanner.nextInt());
        scanner.nextLine();
        do {
            System.out.println("Nhập tên hàng : ");
            bai3.setTen(scanner.nextLine());
        } while (bai3.checkName(kt));
        System.out.println("Nhập đơn giá : ");
        bai3.setGia(scanner.nextDouble());
        do {
            System.out.println("Nhập năm,tháng,ngày sản xuất : ");
            bai3.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.println("nhập năm,tháng,ngày hết hạn : ");
            bai3.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        } while (bai3.checkDate(th));{
            System.out.println(bai3);
            bai3.checkExpire();
        }
    }

}
