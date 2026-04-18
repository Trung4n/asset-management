# Yêu Cầu Giao Diện Người Dùng - Hệ Thống Quản Lý Tài Sản

## 1. Tổng Quan

Tài liệu này định nghĩa các yêu cầu giao diện người dùng (UI) cho Hệ Thống Quản Lý Tài Sản. Nó tập trung vào những gì người dùng nên thấy và cách họ tương tác với hệ thống. Chi tiết triển khai (mã, định kiểu) được xử lý bởi nhóm phát triển frontend.

---

## 2. Nguyên Tắc Giao Diện Chung

- Giao diện phải đơn giản và trực quan
- Tất cả các hành động chính phải có thể truy cập trong vòng 3 lần nhấp chuột
- Bố cục nhất quán trên tất cả các trang
- Thiết kế đáp ứng (ưu tiên cho máy tính để bàn, nhưng có thể thích ứng)
- Phản hồi rõ ràng cho hành động của người dùng (thành công, lỗi, đang tải)

---

## 3. Các Màn Hình Chính Và Yêu Cầu

### 3.1 Trang Đăng Nhập

**Mục Đích:** Cho phép người dùng xác thực vào hệ thống

**Các Phần Tử Giao Diện:**
- Nhập: Email / Tên Người Dùng
- Nhập: Mật Khẩu
- Nút: Đăng Nhập
- Hiển Thị Thông Báo Lỗi

**Hành Vi:**
- Hiển thị lỗi nếu thông tin đăng nhập không hợp lệ
- Chuyển hướng đến bảng điều khiển sau khi đăng nhập thành công

---

### 3.2 Bảng Điều Khiển (Dashboard)

**Mục Đích:** Cung cấp tổng quan về hệ thống

**Các Phần Tử Giao Diện:**
- Thẻ tóm tắt:
  - Tổng số tài sản
  - Tài sản theo trạng thái (hợp lệ, không hợp lệ, mất tích)
- Menu điều hướng (thanh bên hoặc thanh trên cùng)

**Hành Vi:**
- Dữ liệu tải trong vòng 2 giây
- Nhấp vào tóm tắt để điều hướng đến chế độ xem chi tiết

---

### 3.3 Trang Danh Sách Tài Sản

**Mục Đích:** Cho phép người dùng xem và quản lý tài sản

**Các Phần Tử Giao Diện:**
- Bảng tài sản (Tên, Loại, Phòng Ban, Trạng Thái, Hành Động)
- Nút: Tạo Tài Sản
- Bộ Lọc (Theo phòng ban, Theo trạng thái)
- Thanh Tìm Kiếm

**Hành Vi:**
- Nhấp vào hàng để mở chi tiết tài sản
- Bộ lọc cập nhật danh sách động
- Phân trang cho bộ dữ liệu lớn

---

### 3.4 Trang Chi Tiết Tài Sản

**Mục Đích:** Hiển thị thông tin chi tiết về tài sản cụ thể

**Các Phần Tử Giao Diện:**
- Thông tin tài sản, Nút: Chỉnh Sửa, Nút: Chuyển
- Phần Lịch Sử (thay đổi, gán)

**Hành Vi:**
- Chỉnh sửa mở biểu mẫu với dữ liệu được điền sẵn
- Lịch sử được hiển thị theo thứ tự thời gian

---

### 3.5 Biểu Mẫu Tạo / Chỉnh Sửa Tài Sản

**Mục Đích:** Cho phép Quản Lý Tài Sản tạo hoặc cập nhật tài sản

**Các Phần Tử Giao Diện:**
- Trường Nhập (Tên, Loại, Giá Trị, Ngày Mua)
- Thả Xuống: Phòng Ban, Trạng Thái
- Nút: Lưu, Hủy

**Hành Vi:**
- Xác thực các trường bắt buộc trước khi gửi
- Hiển thị thông báo thành công hoặc lỗi

---

### 3.6 Gán / Chuyển Tài Sản

**Mục Đích:** Gán hoặc chuyển tài sản giữa các phòng ban

**Các Phần Tử Giao Diện:**
- Thả Xuống: Chọn Phòng Ban
- Nút: Xác Nhận Chuyển

**Hành Vi:**
- Cập nhật phòng ban của tài sản ngay sau khi xác nhận
- Ghi lại thay đổi trong lịch sử

---

### 3.7 Trang Xác Thực (Kiểm Kê Hằng Năm)

**Mục Đích:** Hỗ trợ quy trình xác thực tài sản

**Các Phần Tử Giao Diện:**
- Danh sách tài sản được gán cho phòng ban
- Bộ Chọn Trạng Thái (Hợp Lệ, Không Hợp Lệ, Mất Tích)
- Nút: Gửi Xác Thực

**Hành Vi:**
- Người dùng có thể cập nhật trạng thái cho mỗi tài sản
- Gửi sẽ lưu tất cả các thay đổi

---

### 3.8 Trang Báo Cáo

**Mục Đích:** Cho phép Admin và Kiểm Toán Viên xem báo cáo

**Các Phần Tử Giao Diện:**
- Bộ Lọc (Khoảng Ngày, Phòng Ban)
- Biểu Đồ hoặc Bảng Hiển Thị (Phân bố trạng thái tài sản, Kết quả xác thực)

**Hành Vi:**
- Báo cáo cập nhật dựa trên các bộ lọc được chọn

---

# Asset Management System - UI Requirements

## 1. Overview

This document defines the user interface (UI) requirements for the Asset Management System. It focuses on what users should see and how they interact with the system. Implementation details (code, styling) are handled by the frontend development team.

---

## 2. General UI Principles

- The interface must be simple and intuitive
- All main actions should be accessible within 3 clicks
- Consistent layout across all pages
- Responsive design (desktop-first, but adaptable)
- Clear feedback for user actions (success, error, loading)

---

## 3. Main Screens and Requirements

## 3.1 Login Page

### Purpose

Allow users to authenticate into the system

### UI Elements

- Input: Email / Username
- Input: Password
- Button: Login
- Error message display

### Behavior

- Show error if credentials are invalid
- Redirect to dashboard after successful login

---

## 3.2 Dashboard

### Purpose

Provide an overview of the system

### UI Elements

- Summary cards:
  - Total assets
  - Assets by status (valid, invalid, missing)

- Navigation menu (sidebar or topbar)

### Behavior

- Data loads within 2 seconds
- Clicking summary navigates to detailed view

---

## 3.3 Asset List Page

### Purpose

Allow users to view and manage assets

### UI Elements

- Table of assets:
  - Name
  - Type
  - Department
  - Status
  - Actions (edit, delete)

- Button: Create Asset
- Filter:
  - By department
  - By status

- Search bar

### Behavior

- Clicking a row opens asset details
- Filters update list dynamically
- Pagination for large datasets

---

## 3.4 Asset Detail Page

### Purpose

Display detailed information about a specific asset

### UI Elements

- Asset information (name, type, value, status, department)
- Button: Edit
- Button: Transfer
- History section (changes, assignments)

### Behavior

- Edit opens form with pre-filled data
- History is displayed in chronological order

---

## 3.5 Create / Edit Asset Form

### Purpose

Allow Asset Manager to create or update assets

### UI Elements

- Input fields:
  - Name
  - Type
  - Value
  - Purchase date

- Dropdown: Department
- Dropdown: Status
- Buttons: Save, Cancel

### Behavior

- Validate required fields before submission
- Show success or error message after submission

---

## 3.6 Asset Assignment / Transfer

### Purpose

Assign or transfer assets between departments

### UI Elements

- Dropdown: Select department
- Button: Confirm transfer

### Behavior

- Update asset’s department immediately after confirmation
- Log the change in history

---

## 3.7 Validation Page (Annual Audit)

### Purpose

Support asset validation process

### UI Elements

- List of assets assigned to department
- Status selector for each asset:
  - Valid
  - Invalid
  - Missing

- Button: Submit validation

### Behavior

- Users can update status for each asset
- Submission saves all changes

---

## 3.8 Reports Page

### Purpose

Allow Admin and Auditor to view reports

### UI Elements

- Filters:
  - Date range
  - Department

- Charts or tables showing:
  - Asset status distribution
  - Validation results

### Behavior

- Reports update based on selected filters

---

## 3.9 User Management Page (Admin)

### Purpose

Manage system users

### UI Elements

- Table of users:
  - Name
  - Role
  - Status

- Button: Create User
- Actions: Edit, Deactivate

### Behavior

- Role changes apply immediately
- Deactivated users cannot log in

---

## 4. Navigation

- Sidebar or top navigation must include:
  - Dashboard
  - Assets
  - Validation
  - Reports
  - Users (Admin only)

- Active page should be clearly highlighted

---

## 5. Feedback and Error Handling

- Show loading indicator for all API calls
- Show success message after actions (create, update, delete)
- Show clear error messages when actions fail

---

## 6. Role-Based UI Behavior

- Admin:
  - Full access to all pages

- Asset Manager:
  - Access to asset management and assignment

- Department Staff:
  - Access to asset list (limited) and validation page

- Auditor:
  - Access to validation and reports only

---

## 7. Accessibility and Usability

- All buttons must be clearly labeled
- Forms must show validation errors
- Text must be readable (sufficient contrast)
- Navigation must be consistent across pages

---

## 8. Template

Figma: https://www.figma.com/design/3tYkkuslqHo2lkQFO8GzPJ/Vision-UI-Dashboard-React---MUI-Dashboard--Free-Version---Community-
