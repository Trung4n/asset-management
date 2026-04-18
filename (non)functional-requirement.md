English version

# Functional Requirements

## Admin

- Manage user accounts (create, update, deactivate)
- Assign user roles
- View system-wide reports
- View audit logs

## Asset Manager

- Create, update, archive, and delete assets
- View all assets
- Assign assets to departments
- Transfer assets between departments

## Department Staff

- View assets assigned to their department
- Update asset validation status during audit

## Auditor

- Initiate annual validation process
- Review and update validation status
- View validation results
- Generate reports

---

# Non-Functional Requirements

## Performance

- Support at least 500 concurrent users

- API response time:
  - ≤ 500 ms for 95% of requests
  - ≤ 1 second for 99% of requests

- Asset list page loads within 2 seconds for up to 10,000 assets

## Availability

- System uptime ≥ 99.5% per month
- Maintenance downtime ≤ 4 hours per month

## Security

- Secure authentication (JWT or equivalent)
- Password encryption using bcrypt (cost ≥ 10)
- Role-based access control enforced
- No critical vulnerabilities in security scans

## Reliability

- No data loss during normal operations
- Daily backups
- Recovery time ≤ 2 hours
- ACID-compliant transactions

## Usability

- New users can complete basic tasks within 10 minutes
- UI response time ≤ 200 ms

## Scalability

- Support at least 100,000 assets
- Query response time ≤ 1 second at this scale

## Maintainability

- Modular architecture
- Unit test coverage ≥ 70%
- Average bug fix time ≤ 2 days

## Logging and Monitoring

- Log all critical actions
- Log retention ≥ 90 days
- Error detection within 1 minute

---

Phiên bản Tiếng Việt

# Yêu Cầu Chức Năng

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

# Yêu Cầu Phi Chức Năng

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
