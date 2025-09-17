public class Solution {
    // Phương thức trả về chuỗi "HelloWorld"
    public String printHello() {
        return "HelloWorld";
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        // Tạo đối tượng Solution
        Solution s = new Solution();

        // Gọi phương thức printHello và in kết quả ra màn hình
        System.out.println(s.printHello());

        // Kiểm tra nếu có truyền tham số dòng lệnh
        if (args.length > 0) {
            String student_name = args[0];
            System.out.println("Hello " + student_name);
        }
    }
}
