# Hệ Thống Quản Lý Tài Sản - Tài Liệu Sản Phẩm

## 1. Tầm Nhìn Sản Phẩm

Hệ Thống Quản Lý Tài Sản được thiết kế nhằm giúp các tổ chức theo dõi, phân bổ và kiểm kê tài sản một cách hiệu quả. Hệ thống đảm bảo tính minh bạch, giảm thất thoát tài sản và nâng cao độ chính xác của các đợt kiểm kê hàng năm thông qua một nền tảng quản lý tập trung.

---

## 2. Vai Trò Người Dùng

- Quản trị viên (Admin)
- Quản lý tài sản (Asset Manager)
- Nhân viên phòng ban (Department Staff)
- Kiểm toán viên (Auditor)

---

## 3. User Stories

### 3.1 Quản Lý Tài Sản

- Là một Quản lý tài sản, tôi muốn tạo tài sản mới để có thể theo dõi trong hệ thống.
- Là một Quản lý tài sản, tôi muốn cập nhật thông tin tài sản để dữ liệu luôn chính xác.
- Là một Quản lý tài sản, tôi muốn xem toàn bộ tài sản để dễ dàng giám sát.

### 3.2 Phân Bổ Tài Sản

- Là một Quản lý tài sản, tôi muốn phân bổ tài sản cho phòng ban để xác định rõ quyền sở hữu.
- Là một Quản lý tài sản, tôi muốn chuyển tài sản giữa các phòng ban để mọi thay đổi được ghi nhận đúng cách.
- Là một Nhân viên phòng ban, tôi muốn xem các tài sản được phân bổ cho phòng ban của mình để biết chúng tôi đang có gì.

### 3.3 Kiểm Kê Tài Sản Hằng Năm

- Là một Kiểm toán viên, tôi muốn khởi tạo đợt kiểm kê tài sản hằng năm để toàn bộ tài sản được kiểm tra.
- Là một Nhân viên phòng ban, tôi muốn xác nhận trạng thái của từng tài sản để việc kiểm kê chính xác.
- Là một Kiểm toán viên, tôi muốn xem kết quả kiểm kê để tạo báo cáo.

### 3.4 Báo Cáo Và Theo Dõi

- Là một Quản trị viên, tôi muốn xem báo cáo trạng thái tài sản để đưa ra quyết định phù hợp.
- Là một Quản trị viên, tôi muốn xem lịch sử thay đổi tài sản để kiểm tra hoạt động.

### 3.5 Quản Lý Người Dùng

- Là một Quản trị viên, tôi muốn tạo và quản lý tài khoản người dùng để kiểm soát truy cập hệ thống.
- Là một Quản trị viên, tôi muốn phân quyền vai trò để đảm bảo quyền hạn được thực thi.

---

## 4. Product Backlog

| Tính năng          | Ưu tiên    | Mô tả                         |
| ------------------ | ---------- | ----------------------------- |
| CRUD tài sản       | Cao        | Quản lý tài sản cốt lõi       |
| Phân bổ tài sản    | Cao        | Gán tài sản cho phòng ban     |
| Kiểm kê tài sản    | Cao        | Quy trình kiểm kê hằng năm    |
| Quản lý người dùng | Trung bình | Quản lý người dùng và vai trò |
| Báo cáo            | Trung bình | Xem báo cáo và nhật ký        |
| Tính năng nâng cao | Thấp       | Nâng cấp trong tương lai      |

---

# Asset Management System - Product Documentation

## 1. Product Vision

The Asset Management System is designed to help organizations efficiently track, assign, and validate their assets. The system ensures transparency, reduces asset loss, and improves the accuracy of annual audits by providing a centralized platform for asset management.

---

## 2. User Roles

- Admin
- Asset Manager
- Department Staff
- Auditor

---

## 3. User Stories

### 3.1 Asset Management

- As an Asset Manager, I want to create a new asset so that it can be tracked in the system.
- As an Asset Manager, I want to update asset information so that data remains accurate.

- As an Asset Manager, I want to view all assets so that I can monitor them easily.

### 3.2 Asset Assignment

- As an Asset Manager, I want to assign assets to a department so that ownership is clear.
- As an Asset Manager, I want to transfer assets between departments so that changes are properly recorded.
- As a Department Staff, I want to view assets assigned to my department so that I know what we have.

### 3.3 Annual Asset Validation

- As an Auditor, I want to initiate an annual asset validation so that all assets are checked.
- As a Department Staff, I want to confirm the status of each asset so that validation is accurate.
- As an Auditor, I want to mark assets as valid, invalid, or missing so that issues are identified.
- As an Auditor, I want to view validation results so that I can generate reports.

### 3.4 Reporting and Tracking

- As an Admin, I want to view reports of asset status so that I can make informed decisions.
- As an Admin, I want to view the history of asset changes so that I can audit activities.

### 3.5 User Management

- As an Admin, I want to create and manage user accounts so that system access is controlled.
- As an Admin, I want to assign roles so that permissions are enforced.

---

## 4. Product Backlog

| Feature           | Priority | Description                  |
| ----------------- | -------- | ---------------------------- |
| Asset CRUD        | High     | Core asset management        |
| Asset Assignment  | High     | Assign assets to departments |
| Asset Validation  | High     | Annual validation process    |
| User Management   | Medium   | Manage users and roles       |
| Reporting         | Medium   | View reports and audit logs  |
| Advanced Features | Low      | Future enhancements          |

---
