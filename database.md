## ENUMs

### `user_role`

Vai trò của người dùng trong hệ thống.

| Giá trị            | Mô tả                                     |
| ------------------ | ----------------------------------------- |
| `admin`            | Quản trị viên hệ thống, toàn quyền        |
| `asset_manager`    | Quản lý tài sản, có quyền ghi trên assets |
| `department_staff` | Nhân viên phòng ban, quyền đọc            |
| `auditor`          | Kiểm toán viên, thực hiện kiểm kê         |

---

### `asset_status`

Trạng thái tài sản.

| Giá trị    | Mô tả            |
| ---------- | ---------------- |
| `active`   | Đang sử dụng     |
| `inactive` | Tạm dừng sử dụng |
| `archived` | Đã lưu trữ       |

---

### `asset_category`

Phân loại tài sản.

| Giá trị       | Mô tả             |
| ------------- | ----------------- |
| `electronics` | Thiết bị điện tử  |
| `furniture`   | Nội thất          |
| `vehicle`     | Phương tiện       |
| `equipment`   | Thiết bị, máy móc |
| `software`    | Phần mềm          |
| `other`       | Khác (mặc định)   |

---

### `validation_session_status`

Trạng thái của một phiên kiểm kê.

| Giá trị       | Mô tả          |
| ------------- | -------------- |
| `pending`     | Chờ bắt đầu    |
| `in_progress` | Đang tiến hành |
| `closed`      | Đã đóng        |

---

### `validation_record_status`

Kết quả kiểm kê của từng tài sản.

| Giá trị   | Mô tả                              |
| --------- | ---------------------------------- |
| `valid`   | Hợp lệ, xác nhận tồn tại           |
| `invalid` | Không hợp lệ (hỏng, sai thông tin) |
| `missing` | Không tìm thấy                     |
| `pending` | Chưa kiểm tra                      |

---

### `audit_action`

Loại hành động được ghi lại trong audit log.

| Giá trị                     | Mô tả                              |
| --------------------------- | ---------------------------------- |
| `asset_created`             | Tạo tài sản mới                    |
| `asset_updated`             | Cập nhật thông tin tài sản         |
| `asset_archived`            | Lưu trữ tài sản                    |
| `asset_deleted`             | Xóa tài sản                        |
| `asset_assigned`            | Gán tài sản cho phòng ban          |
| `asset_transferred`         | Chuyển tài sản sang phòng ban khác |
| `validation_initiated`      | Khởi tạo phiên kiểm kê             |
| `validation_record_updated` | Cập nhật kết quả kiểm kê           |
| `role_assigned`             | Gán role cho người dùng            |
| `role_revoked`              | Thu hồi role người dùng            |
| `user_created`              | Tạo tài khoản người dùng           |
| `user_deactivated`          | Vô hiệu hóa tài khoản              |

---

## Tables

### `departments`

Danh sách phòng ban trong tổ chức.

| Cột          | Kiểu           | Ràng buộc                        | Mô tả                        |
| ------------ | -------------- | -------------------------------- | ---------------------------- |
| `id`         | `UUID`         | PK, default `uuid_generate_v4()` | Khóa chính                   |
| `name`       | `VARCHAR(100)` | NOT NULL                         | Tên phòng ban                |
| `code`       | `VARCHAR(20)`  | NOT NULL, UNIQUE                 | Mã phòng ban (ví dụ: IT, HR) |
| `created_at` | `TIMESTAMPTZ`  | NOT NULL, default `NOW()`        | Thời điểm tạo                |
| `updated_at` | `TIMESTAMPTZ`  | NOT NULL, default `NOW()`        | Thời điểm cập nhật gần nhất  |

---

### `users`

Tài khoản người dùng.

| Cột             | Kiểu           | Ràng buộc                                | Mô tả                                    |
| --------------- | -------------- | ---------------------------------------- | ---------------------------------------- |
| `id`            | `UUID`         | PK, default `uuid_generate_v4()`         | Khóa chính (đồng bộ với `auth.users.id`) |
| `email`         | `VARCHAR(255)` | NOT NULL, UNIQUE                         | Địa chỉ email                            |
| `password_hash` | `TEXT`         | NOT NULL                                 | Bcrypt hash (rỗng nếu dùng Google OAuth) |
| `full_name`     | `VARCHAR(150)` | —                                        | Họ và tên                                |
| `role`          | `user_role`    | NULLABLE                                 | Vai trò (`NULL` = chưa được gán role)    |
| `department_id` | `UUID`         | FK → `departments.id` ON DELETE SET NULL | Phòng ban hiện tại                       |
| `is_active`     | `BOOLEAN`      | NOT NULL, default `TRUE`                 | Trạng thái hoạt động                     |
| `created_at`    | `TIMESTAMPTZ`  | NOT NULL, default `NOW()`                | Thời điểm tạo                            |
| `updated_at`    | `TIMESTAMPTZ`  | NOT NULL, default `NOW()`                | Thời điểm cập nhật gần nhất              |

> **Lưu ý:** Password được hash bằng `bcrypt` qua hàm `crypt()` của extension `pgcrypto`. Người dùng đăng nhập qua Google OAuth sẽ có `password_hash = ''`.

---

### `assets`

Thông tin chi tiết tài sản.

| Cột                     | Kiểu             | Ràng buộc                                | Mô tả                                            |
| ----------------------- | ---------------- | ---------------------------------------- | ------------------------------------------------ |
| `id`                    | `UUID`           | PK, default `uuid_generate_v4()`         | Khóa chính                                       |
| `asset_code`            | `VARCHAR(50)`    | NOT NULL, UNIQUE                         | Mã tài sản (ví dụ: IT-2024-001)                  |
| `name`                  | `VARCHAR(200)`   | NOT NULL                                 | Tên tài sản                                      |
| `description`           | `TEXT`           | —                                        | Mô tả chi tiết                                   |
| `category`              | `asset_category` | NOT NULL, default `'other'`              | Phân loại tài sản                                |
| `status`                | `asset_status`   | NOT NULL, default `'active'`             | Trạng thái tài sản                               |
| `purchase_price`        | `NUMERIC(15,2)`  | —                                        | Giá mua (tối đa 15 chữ số, 2 thập phân)          |
| `purchase_date`         | `DATE`           | —                                        | Ngày mua                                         |
| `current_department_id` | `UUID`           | FK → `departments.id` ON DELETE SET NULL | Phòng ban đang quản lý tài sản                   |
| `created_by`            | `UUID`           | FK → `users.id` ON DELETE SET NULL       | Người tạo bản ghi                                |
| `archived_at`           | `TIMESTAMPTZ`    | —                                        | Thời điểm lưu trữ/thanh lý (NULL = chưa lưu trữ) |
| `created_at`            | `TIMESTAMPTZ`    | NOT NULL, default `NOW()`                | Thời điểm tạo                                    |
| `updated_at`            | `TIMESTAMPTZ`    | NOT NULL, default `NOW()`                | Thời điểm cập nhật gần nhất                      |

---

### `asset_assignments`

Lịch sử gán và chuyển tài sản giữa các phòng ban.

| Cột             | Kiểu          | Ràng buộc                                          | Mô tả                                      |
| --------------- | ------------- | -------------------------------------------------- | ------------------------------------------ |
| `id`            | `UUID`        | PK, default `uuid_generate_v4()`                   | Khóa chính                                 |
| `asset_id`      | `UUID`        | NOT NULL, FK → `assets.id` ON DELETE CASCADE       | Tài sản được gán                           |
| `department_id` | `UUID`        | NOT NULL, FK → `departments.id` ON DELETE RESTRICT | Phòng ban nhận tài sản                     |
| `assigned_by`   | `UUID`        | FK → `users.id` ON DELETE SET NULL                 | Người thực hiện gán                        |
| `assigned_at`   | `TIMESTAMPTZ` | NOT NULL, default `NOW()`                          | Thời điểm gán                              |
| `returned_at`   | `TIMESTAMPTZ` | NULLABLE                                           | Thời điểm trả lại (`NULL` = đang được gán) |
| `notes`         | `TEXT`        | —                                                  | Ghi chú                                    |

> **Logic:** `returned_at IS NULL` đồng nghĩa tài sản đang được gán cho phòng ban đó. Mỗi lần chuyển phòng sẽ tạo một bản ghi mới.

---

### `validation_sessions`

Phiên kiểm kê tài sản, mỗi năm một phiên.

| Cột            | Kiểu                        | Ràng buộc                          | Mô tả                                  |
| -------------- | --------------------------- | ---------------------------------- | -------------------------------------- |
| `id`           | `UUID`                      | PK, default `uuid_generate_v4()`   | Khóa chính                             |
| `year`         | `SMALLINT`                  | NOT NULL, UNIQUE                   | Năm kiểm kê (mỗi năm chỉ có 1 session) |
| `status`       | `validation_session_status` | NOT NULL, default `'pending'`      | Trạng thái phiên                       |
| `initiated_by` | `UUID`                      | FK → `users.id` ON DELETE SET NULL | Người khởi tạo phiên                   |
| `started_at`   | `TIMESTAMPTZ`               | NOT NULL, default `NOW()`          | Thời điểm bắt đầu                      |
| `closed_at`    | `TIMESTAMPTZ`               | —                                  | Thời điểm đóng phiên                   |
| `notes`        | `TEXT`                      | —                                  | Ghi chú                                |

---

### `validation_records`

Kết quả kiểm kê của từng tài sản trong một phiên.

| Cột            | Kiểu                       | Ràng buộc                                                 | Mô tả                              |
| -------------- | -------------------------- | --------------------------------------------------------- | ---------------------------------- |
| `id`           | `UUID`                     | PK, default `uuid_generate_v4()`                          | Khóa chính                         |
| `session_id`   | `UUID`                     | NOT NULL, FK → `validation_sessions.id` ON DELETE CASCADE | Phiên kiểm kê                      |
| `asset_id`     | `UUID`                     | NOT NULL, FK → `assets.id` ON DELETE CASCADE              | Tài sản được kiểm                  |
| `status`       | `validation_record_status` | NOT NULL, default `'pending'`                             | Kết quả kiểm kê                    |
| `validated_by` | `UUID`                     | FK → `users.id` ON DELETE SET NULL                        | Người thực hiện kiểm               |
| `validated_at` | `TIMESTAMPTZ`              | —                                                         | Thời điểm kiểm tra                 |
| `notes`        | `TEXT`                     | —                                                         | Ghi chú (lý do, tình trạng cụ thể) |

> **Ràng buộc UNIQUE:** `(session_id, asset_id)` — mỗi tài sản chỉ có một bản ghi trong một phiên.

---

### `audit_logs`

Nhật ký kiểm toán, ghi lại toàn bộ các thay đổi quan trọng trong hệ thống. Bảng này chỉ được thêm (append-only), không sửa hay xóa.

| Cột              | Kiểu           | Ràng buộc                           | Mô tả                           |
| ---------------- | -------------- | ----------------------------------- | ------------------------------- |
| `id`             | `UUID`         | PK, default `uuid_generate_v4()`    | Khóa chính                      |
| `action`         | `audit_action` | NOT NULL                            | Loại hành động                  |
| `performed_by`   | `UUID`         | FK → `users.id` ON DELETE SET NULL  | Người thực hiện                 |
| `asset_id`       | `UUID`         | FK → `assets.id` ON DELETE SET NULL | Tài sản liên quan (nếu có)      |
| `target_user_id` | `UUID`         | FK → `users.id` ON DELETE SET NULL  | Người dùng bị tác động (nếu có) |
| `before_state`   | `JSONB`        | —                                   | Trạng thái trước khi thay đổi   |
| `after_state`    | `JSONB`        | —                                   | Trạng thái sau khi thay đổi     |
| `ip_address`     | `INET`         | —                                   | Địa chỉ IP của người thực hiện  |
| `created_at`     | `TIMESTAMPTZ`  | NOT NULL, default `NOW()`           | Thời điểm ghi log               |

---

## Indexes

| Tên Index                 | Bảng                 | Cột                                    | Ghi chú                                   |
| ------------------------- | -------------------- | -------------------------------------- | ----------------------------------------- |
| `idx_users_email`         | `users`              | `email`                                | Tra cứu theo email                        |
| `idx_users_role`          | `users`              | `role`                                 | Lọc theo vai trò                          |
| `idx_users_department`    | `users`              | `department_id`                        | Lọc theo phòng ban                        |
| `idx_assets_code`         | `assets`             | `asset_code`                           | Tra cứu theo mã tài sản                   |
| `idx_assets_status`       | `assets`             | `status`                               | Lọc theo trạng thái                       |
| `idx_assets_department`   | `assets`             | `current_department_id`                | Tài sản theo phòng ban                    |
| `idx_assignments_asset`   | `asset_assignments`  | `asset_id`                             | Lịch sử gán của một tài sản               |
| `idx_assignments_open`    | `asset_assignments`  | `asset_id` WHERE `returned_at IS NULL` | **Partial index** — chỉ gán đang hiệu lực |
| `idx_val_records_session` | `validation_records` | `session_id`                           | Bản ghi theo phiên                        |
| `idx_val_records_asset`   | `validation_records` | `asset_id`                             | Lịch sử kiểm kê theo tài sản              |
| `idx_audit_asset`         | `audit_logs`         | `asset_id`                             | Audit theo tài sản                        |
| `idx_audit_performed_by`  | `audit_logs`         | `performed_by`                         | Audit theo người thực hiện                |
| `idx_audit_created_at`    | `audit_logs`         | `created_at DESC`                      | Sắp xếp audit theo thời gian mới nhất     |

---

## Functions & Triggers

### Function: `set_updated_at()`

Tự động cập nhật cột `updated_at` thành `NOW()` mỗi khi một row được UPDATE.

**Áp dụng cho các bảng:**

- `departments` — trigger `trg_departments_updated_at`
- `users` — trigger `trg_users_updated_at`
- `assets` — trigger `trg_assets_updated_at`

---

### Function: `handle_new_auth_user()`

Đồng bộ người dùng từ `auth.users` (Supabase) sang `public.users` sau khi đăng nhập Google OAuth thành công.

- Trigger: `trg_on_auth_user_created` — `AFTER INSERT ON auth.users`
- Tạo bản ghi mới trong `public.users` với `role = NULL`
- Sử dụng `ON CONFLICT (id) DO NOTHING` để tránh tạo trùng

---

### Function: `has_role(check_role user_role)`

Helper function dùng trong RLS policies, kiểm tra xem user hiện tại có vai trò chỉ định hay không.

```sql
-- Trả về TRUE nếu user đang đăng nhập có role khớp và is_active = TRUE
SELECT has_role('admin');
```

---

## Row Level Security (RLS)

RLS được bật trên tất cả các bảng. Mọi truy cập đều thông qua `auth.uid()` của Supabase.

| Bảng          | Policy                 | Hành động | Điều kiện                                |
| ------------- | ---------------------- | --------- | ---------------------------------------- |
| `users`       | `users_read_own`       | SELECT    | Chỉ đọc được record của chính mình       |
| `users`       | `users_admin_all`      | ALL       | Admin đọc/ghi tất cả                     |
| `departments` | `dept_read_all`        | SELECT    | Mọi user `is_active = TRUE` đều đọc được |
| `assets`      | `assets_read_all`      | SELECT    | Mọi user `is_active = TRUE` đều đọc được |
| `assets`      | `assets_manager_write` | ALL       | Chỉ `asset_manager` mới được ghi         |

> Các bảng `asset_assignments`, `validation_sessions`, `validation_records`, `audit_logs` đã bật RLS nhưng chưa định nghĩa policy cụ thể trong schema này — cần bổ sung tùy theo yêu cầu nghiệp vụ.

---

## Seed Data

### Departments (5 phòng ban)

| Code | Tên                    |
| ---- | ---------------------- |
| IT   | Information Technology |
| HR   | Human Resources        |
| FIN  | Finance                |
| OPS  | Operations             |
| LOG  | Logistics              |

---

### Users (10 người dùng)

| Email             | Họ tên        | Phòng ban | Role                   |
| ----------------- | ------------- | --------- | ---------------------- |
| alice@company.com | Alice Johnson | IT        | `admin`                |
| bob@company.com   | Bob Smith     | HR        | `asset_manager`        |
| carol@company.com | Carol White   | FIN       | `asset_manager`        |
| dan@company.com   | Dan Brown     | OPS       | `department_staff`     |
| eve@company.com   | Eve Davis     | LOG       | `department_staff`     |
| frank@company.com | Frank Miller  | IT        | `department_staff`     |
| grace@company.com | Grace Lee     | HR        | `auditor`              |
| henry@company.com | Henry Wilson  | FIN       | `auditor`              |
| iris@company.com  | Iris Taylor   | OPS       | `NULL` (chưa gán role) |
| jack@company.com  | Jack Anderson | LOG       | `asset_manager`        |

> Mật khẩu mặc định: `123` (bcrypt hash)

---

### Assets (10 tài sản)

| Mã           | Tên                  | Phân loại   | Trạng thái   | Phòng ban |
| ------------ | -------------------- | ----------- | ------------ | --------- |
| IT-2024-001  | MacBook Pro 14"      | electronics | active       | IT        |
| IT-2024-002  | Dell Monitor 27"     | electronics | active       | IT        |
| IT-2024-003  | Cisco Switch 24-port | equipment   | active       | IT        |
| HR-2024-001  | Standing Desk        | furniture   | active       | HR        |
| FIN-2024-001 | HP LaserJet Pro      | electronics | active       | FIN       |
| OPS-2024-001 | Forklift Toyota 3t   | vehicle     | active       | OPS       |
| LOG-2024-001 | Pallet Jack          | equipment   | active       | LOG       |
| IT-2023-001  | iPad Pro 12.9"       | electronics | inactive     | IT        |
| FIN-2023-001 | Ergonomic Chair      | furniture   | active       | FIN       |
| IT-2022-001  | Dell PowerEdge R740  | equipment   | **archived** | IT        |

---

### Validation Session 2024

Phiên kiểm kê năm 2024 đang ở trạng thái `in_progress`, do Grace Lee (auditor) khởi tạo.

| Tài sản              | Kết quả   | Ghi chú                   |
| -------------------- | --------- | ------------------------- |
| MacBook Pro 14"      | `valid`   | Xác nhận tại phòng IT     |
| Dell Monitor 27"     | `valid`   | Trên bàn làm việc         |
| Cisco Switch 24-port | `valid`   | Trong tủ rack             |
| Standing Desk        | `valid`   | Khu vực HR OK             |
| HP LaserJet Pro      | `valid`   | Máy in hoạt động tốt      |
| Forklift Toyota 3t   | `valid`   | Xe nâng trong kho         |
| Pallet Jack          | `missing` | Không tìm thấy tại vị trí |
| iPad Pro 12.9"       | `invalid` | Màn hình nứt, cần sửa     |
| Ergonomic Chair      | `pending` | Chưa kiểm tra             |
| Dell PowerEdge R740  | `valid`   | Đã thanh lý, xác nhận     |

---

## Entity Relationship Diagram

```
departments
    │
    ├──< users (department_id)
    │
    ├──< assets (current_department_id)
    │       │
    │       ├──< asset_assignments (asset_id)
    │       │           │
    │       │           └── departments (department_id)
    │       │
    │       ├──< validation_records (asset_id)
    │       │           │
    │       │           └── validation_sessions (session_id)
    │       │
    │       └──< audit_logs (asset_id)
    │
    └── (departments referenced by asset_assignments.department_id)

users
    ├──< asset_assignments (assigned_by)
    ├──< validation_sessions (initiated_by)
    ├──< validation_records (validated_by)
    ├──< audit_logs (performed_by)
    └──< audit_logs (target_user_id)
```
