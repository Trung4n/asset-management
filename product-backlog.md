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

## 4. Yêu Cầu Chức Năng

### 4.1 Quản trị viên

- Quản lý tài khoản người dùng (tạo, cập nhật, vô hiệu hóa)
- Phân quyền người dùng
- Xem báo cáo toàn hệ thống
- Xem nhật ký kiểm tra

### 4.2 Quản lý tài sản

- Tạo, cập nhật, lưu trữ và xóa tài sản
- Xem toàn bộ tài sản
- Phân bổ tài sản cho phòng ban
- Chuyển tài sản giữa các phòng ban

### 4.3 Nhân viên phòng ban

- Xem tài sản được phân bổ cho phòng ban của mình
- Cập nhật trạng thái tài sản trong đợt kiểm kê

### 4.4 Kiểm toán viên

- Khởi tạo quy trình kiểm kê hằng năm
- Xem xét và cập nhật trạng thái kiểm kê
- Xem kết quả kiểm kê
- Tạo báo cáo

---

## 5. Tiêu Chí Chấp Nhận

### Phân Bổ Tài Sản

- Với điều kiện tài sản đã tồn tại
- Khi Quản lý tài sản phân bổ tài sản đó cho phòng ban
- Thì tài sản phải xuất hiện trong danh sách tài sản của phòng ban đó

### Kiểm Kê Tài Sản

- Với điều kiện đợt kiểm kê đang hoạt động
- Khi Nhân viên phòng ban cập nhật trạng thái tài sản
- Thì hệ thống phải lưu và phản ánh trạng thái đã cập nhật

---

## 6. Yêu Cầu Phi Chức Năng

### 6.1 Hiệu Năng

- Hỗ trợ ít nhất 500 người dùng đồng thời

- Thời gian phản hồi API:
  - ≤ 500 ms với 95% yêu cầu
  - ≤ 1 giây với 99% yêu cầu

- Trang danh sách tài sản tải trong vòng 2 giây với tối đa 10.000 tài sản

### 6.2 Tính Sẵn Sàng

- Thời gian hoạt động hệ thống ≥ 99.5% mỗi tháng
- Thời gian bảo trì ≤ 4 giờ mỗi tháng

### 6.3 Bảo Mật

- Xác thực an toàn (JWT hoặc tương đương)
- Mã hóa mật khẩu bằng bcrypt (cost ≥ 10)
- Thực thi phân quyền theo vai trò
- Không có lỗ hổng nghiêm trọng trong quá trình quét bảo mật

### 6.4 Độ Tin Cậy

- Không mất dữ liệu trong vận hành bình thường
- Sao lưu hằng ngày
- Thời gian khôi phục ≤ 2 giờ
- Giao dịch tuân thủ ACID

### 6.5 Khả Năng Sử Dụng

- Người dùng mới hoàn thành tác vụ cơ bản trong 10 phút
- Thời gian phản hồi giao diện ≤ 200 ms

### 6.6 Khả Năng Mở Rộng

- Hỗ trợ ít nhất 100.000 tài sản
- Thời gian truy vấn ≤ 1 giây ở quy mô này

### 6.7 Khả Năng Bảo Trì

- Kiến trúc module hóa
- Độ bao phủ Unit Test ≥ 70%
- Thời gian sửa lỗi trung bình ≤ 2 ngày

### 6.8 Ghi Log Và Giám Sát

- Ghi log toàn bộ hành động quan trọng
- Lưu log tối thiểu 90 ngày
- Phát hiện lỗi trong vòng 1 phút

---

## 7. Phạm Vi MVP

Phiên bản đầu tiên của hệ thống sẽ bao gồm:

- CRUD tài sản
- Phân bổ tài sản cho phòng ban
- Quy trình kiểm kê tài sản cơ bản

Không bao gồm trong MVP:

- Phân tích nâng cao
- Dashboard phức tạp
- Tính năng AI

---

## 8. Product Backlog

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

## 4. Functional Requirements

### 4.1 Admin

- Manage user accounts (create, update, deactivate)
- Assign user roles
- View system-wide reports
- View audit logs

### 4.2 Asset Manager

- Create, update, archive, and delete assets
- View all assets
- Assign assets to departments
- Transfer assets between departments

### 4.3 Department Staff

- View assets assigned to their department
- Update asset validation status during audit

### 4.4 Auditor

- Initiate annual validation process
- Review and update validation status
- View validation results
- Generate reports

---

## 5. Acceptance Criteria (Examples)

### Asset Assignment

- Given an asset exists
- When the Asset Manager assigns it to a department
- Then the asset must appear in that department’s asset list

### Asset Validation

- Given a validation process is active
- When Department Staff updates asset status
- Then the system must store and reflect the updated status

---

## 6. Non-Functional Requirements

### 6.1 Performance

- Support at least 500 concurrent users

- API response time:
  - ≤ 500 ms for 95% of requests
  - ≤ 1 second for 99% of requests

- Asset list page loads within 2 seconds for up to 10,000 assets

### 6.2 Availability

- System uptime ≥ 99.5% per month
- Maintenance downtime ≤ 4 hours per month

### 6.3 Security

- Secure authentication (JWT or equivalent)
- Password encryption using bcrypt (cost ≥ 10)
- Role-based access control enforced
- No critical vulnerabilities in security scans

### 6.4 Reliability

- No data loss during normal operations
- Daily backups
- Recovery time ≤ 2 hours
- ACID-compliant transactions

### 6.5 Usability

- New users can complete basic tasks within 10 minutes
- UI response time ≤ 200 ms

### 6.6 Scalability

- Support at least 100,000 assets
- Query response time ≤ 1 second at this scale

### 6.7 Maintainability

- Modular architecture
- Unit test coverage ≥ 70%
- Average bug fix time ≤ 2 days

### 6.8 Logging and Monitoring

- Log all critical actions
- Log retention ≥ 90 days
- Error detection within 1 minute

---

## 7. MVP Scope

The initial version of the system will include:

- Asset CRUD operations
- Asset assignment to departments
- Basic asset validation process

Excluded from MVP:

- Advanced analytics
- Complex dashboards
- AI-based features

---

## 8. Product Backlog

| Feature           | Priority | Description                  |
| ----------------- | -------- | ---------------------------- |
| Asset CRUD        | High     | Core asset management        |
| Asset Assignment  | High     | Assign assets to departments |
| Asset Validation  | High     | Annual validation process    |
| User Management   | Medium   | Manage users and roles       |
| Reporting         | Medium   | View reports and audit logs  |
| Advanced Features | Low      | Future enhancements          |

---
