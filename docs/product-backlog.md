# TÀI LIỆU THIẾT KẾ BACKEND - BỔ SUNG PHÂN QUYỀN & NGHIỆP VỤ AUDIT

## Quy ước các Role trong hệ thống
Hệ thống sử dụng các Role sau cho Spring Security:
* `ADMIN`: Quản trị viên (Quản lý User, cấu hình hệ thống).
* `ASSET_MANAGER`: Quản lý tài sản (Thêm, sửa, xóa, luân chuyển).
* `DEPT_STAFF`: Nhân viên phòng ban (Chỉ xem tài sản của phòng mình, xác nhận kiểm kê).
* `AUDITOR`: Kiểm toán viên (Tạo đợt kiểm kê, chốt tình trạng tài sản, xem báo cáo).

---

## 1. Cập nhật Phân Quyền (Roles) cho các Nhóm API Cơ Bản

### 1.1. Nhóm Authentication & User Management
* **`POST /api/auth/login`** | Quyền: `[ALL]` (Public, không yêu cầu token)
* **`GET /api/users/me`** | Quyền: `[ALL]` (Yêu cầu có token hợp lệ)
* **`POST /api/users`** | Quyền: `[ADMIN]` (Tạo user mới)
* **`PUT /api/users/{id}/status`** | Quyền: `[ADMIN]` (Khóa/Mở khóa tài khoản)

### 1.2. Nhóm Department
* **`GET /api/departments`** | Quyền: `[ALL]` (Ai đã login đều được xem để nạp Dropdown)

### 1.3. Nhóm Asset Management
* **`GET /api/assets`** * Quyền: `[ADMIN, ASSET_MANAGER, AUDITOR]` (Được xem toàn bộ).
  * Quyền: `[DEPT_STAFF]` (Chỉ được xem tài sản có `departmentId` thuộc về phòng ban của mình - Backend cần tự bắt User hiện tại thuộc phòng nào để filter ngầm).
* **`POST /api/assets`** | Quyền: `[ASSET_MANAGER]`
* **`PUT /api/assets/{id}`** | Quyền: `[ASSET_MANAGER]`
* **`DELETE /api/assets/{id}`** | Quyền: `[ASSET_MANAGER]`

### 1.4. Nhóm Asset Assignment (Luân chuyển)
* **`POST /api/assets/{id}/transfer`** | Quyền: `[ASSET_MANAGER]`
* **`GET /api/assets/{id}/history`** | Quyền: `[ADMIN, ASSET_MANAGER, AUDITOR]`

---

## 2. Chi tiết hóa Nhóm Validation / Audit (Thỏa mãn User Stories)

Phần này được thiết kế lại để giải quyết 3 User Stories: (1) Staff báo cáo tình trạng, (2) Auditor đánh giá chốt sổ, (3) Auditor xem báo cáo.

### API 2.5.1. Tạo đợt kiểm kê mới
* **User Story:** System requirement.
* **Quyền:** `[AUDITOR]`
* **Endpoint:** `POST /api/audits`
* **Input (Request Body):**
  ```json
  {
    "title": "Kiểm kê tài sản Quý 3/2026",
    "startDate": "2026-07-01",
    "endDate": "2026-07-15"
  }

  Output: Trả về auditId (UUID).

API 2.5.2. Lấy danh sách tài sản cần kiểm kê trong đợt
Quyền: [AUDITOR, DEPT_STAFF]

Endpoint: GET /api/audits/{auditId}/assets

Logic:

Nếu là AUDITOR: Trả về toàn bộ danh sách kiểm kê của tất cả các phòng.

Nếu là DEPT_STAFF: Trả về danh sách tài sản CHỈ thuộc phòng ban của staff đó.

Output:

JSON
{
  "content": [
    {
      "assetId": "uuid-asset-1",
      "assetName": "Laptop Dell",
      "staffStatus": "PENDING",     // PENDING, VALID, INVALID, MISSING
      "auditorStatus": "PENDING"
    }
  ]
}
API 2.5.3. Department Staff xác nhận tình trạng (Gửi báo cáo)
User Story: As a Department Staff, I want to confirm the status of each asset so that validation is accurate.

Quyền: [DEPT_STAFF]

Endpoint: PUT /api/audits/{auditId}/assets/{assetId}/staff-confirm

Input (Request Body):

JSON
{
  "status": "VALID", // VALID, INVALID, MISSING
  "note": "Máy vẫn dùng tốt, tuy nhiên sạc hơi lỏng",
  "imageProofUrl": "https://s3.../image.jpg" // Optional: Nếu staff cần upload ảnh chứng minh
}
Output: 200 OK

API 2.5.4. Auditor đánh giá/chốt tình trạng tài sản
User Story: As an Auditor, I want to mark assets as valid, invalid, or missing so that issues are identified.

Quyền: [AUDITOR]

Endpoint: PUT /api/audits/{auditId}/assets/{assetId}/auditor-confirm

Logic: Auditor đọc báo cáo của Staff, có thể đồng ý hoặc đánh giá lại (ví dụ Staff báo VALID nhưng Auditor kiểm tra thấy MISSING). Quyết định của Auditor là quyết định cuối cùng.

Input (Request Body):

JSON
{
  "finalStatus": "INVALID", // VALID, INVALID, MISSING
  "auditorNote": "Xác nhận máy bị hỏng màn hình, cần đem đi sửa"
}
Output: 200 OK

API 2.5.5. Xem kết quả đợt kiểm kê (Báo cáo)
User Story: As an Auditor, I want to view validation results so that I can generate reports.

Quyền: [AUDITOR, ADMIN]

Endpoint: GET /api/audits/{auditId}/results

Output (Response Data): Cấu trúc bao gồm phần tổng hợp KPI và danh sách chi tiết để vẽ Biểu đồ hoặc xuất Excel.

JSON
{
  "auditSummary": {
    "totalAssetsChecked": 500,
    "validCount": 450,
    "invalidCount": 30,
    "missingCount": 20
  },
  "discrepancies": [
    {
       "assetCode": "AST-102",
       "departmentName": "Sales",
       "staffReportedStatus": "VALID",
       "auditorFinalStatus": "MISSING",
       "note": "Nhân viên báo cáo có, nhưng thực tế kiểm tra không thấy tại văn phòng."
    }
  ]
}
3. Prototype Cập nhật: Cấu trúc Entity cho Audit
Để Backend có thể thực hiện được các API Audit trên, cấu trúc Database (Entity) phải hỗ trợ lưu trạng thái riêng biệt giữa Staff báo cáo và Auditor chốt sổ.

Java
package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

// Bảng lưu thông tin Đợt Kiểm kê
@Entity
@Table(name = "audits")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // ONGOING, COMPLETED
}

// Bảng chi tiết kết quả kiểm kê cho từng tài sản trong đợt đó
@Entity
@Table(name = "audit_details")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuditDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private Audit audit;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    // Phẩn Staff báo cáo
    private String staffStatus; // VALID, INVALID, MISSING, PENDING
    private String staffNote;
    private String staffImageProof;

    // Phần Auditor chốt kết quả
    private String auditorFinalStatus; // VALID, INVALID, MISSING, PENDING
    private String auditorNote;
    
    // Lưu lại ai đã thao tác để truy vết
    private UUID staffId;
    private UUID auditorId;
}
4. DTO Prototype cho Audit Controller
Java
package asset.project.dto.request;

import jakarta.validation.constraints.NotBlank;

public record StaffConfirmReq(
    @NotBlank String status,
    String note,
    String imageProofUrl
) {}

public record AuditorConfirmReq(
    @NotBlank String finalStatus,
    String auditorNote
) {}

Với bản cập nhật này, luồng đi của tính năng **Kiểm kê thường niên** đã hoàn toàn logic:
1. `Auditor` tạo đợt kiểm kê. Hệ thống tự động snapshot danh sách các tài sản cần kiểm kê vào bảng `audit_details` (Status mặc định là `PENDING`).
2. `Dept Staff` đăng nhập, gọi API get list tài sản phòng mình, lặp qua list đó để bắn API `staff-confirm` báo cáo tình trạng từng món.
3. `Auditor` xem danh sách, đi kiểm tra chéo, và bắn API `auditor-confirm` để chốt trạng thái cuối cùng.
4. `Auditor` gọi API `results` để lấy data báo cáo, phục vụ việc export báo cáo.