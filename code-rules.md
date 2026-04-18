# Quy Tắc Mã Hóa - Hệ Thống Quản Lý Tài Sản

## Mục Đích

Tài liệu này định nghĩa các tiêu chuẩn mã hóa và thực tiễn tốt nhất cho dự án nhằm đảm bảo tính nhất quán, khả năng bảo trì, khả năng đọc và hiệu quả hợp tác trên cả Backend (Spring Boot) và Frontend (React).

---

## Quy Tắc Chung

### 1. Mã Sạch

- Viết mã có thể đọc được, tự giải thích.
- Ưu tiên đơn giản hơn phức tạp.
- Tránh logic trùng lặp (Nguyên tắc DRY).
- Sử dụng tên biến, phương thức và thành phần có ý nghĩa.

### 2. Định Dạng

- Sử dụng thụt lề nhất quán (4 dấu cách cho Java, 2 dấu cách hoặc Prettier cho React).
- Xóa các import, biến và mã chết không được sử dụng.
- Giữ chiều dài dòng có thể đọc được.

## Quy Tắc Kiểm Tra

### Backend

- Kiểm tra đơn vị logic dịch vụ.

---

## Quy Tắc Xem Xét

Trước khi đẩy mã:

- Mã xây dựng thành công.
- Không có lỗi bảng điều khiển.
- Không có mã chết được bình luận.
- Không có dữ liệu nhạy cảm được cam kết.
- Thông qua định dạng/linting.
- Tự xem xét.

---

## Cộng Tác Nhóm

- Tôn trọng phong cách mã hóa.
- Xem xét PR của đồng nghiệp một cách xây dựng.
- Hỏi trước khi thay đổi kiến trúc lớn.

---

# Code Rules

## Purpose

This document defines coding standards and best practices for the project to ensure consistency, maintainability, readability, and collaboration efficiency across both Backend (Spring Boot) and Frontend (React).

---

## General Rules

### 1. Clean Code

- Write readable, self-explanatory code.
- Prefer simplicity over complexity.
- Avoid duplicated logic (DRY principle).
- Use meaningful variable, method, and component names.

### 2. Formatting

- Use consistent indentation (4 spaces for Java, 2 spaces or Prettier standard for React).
- Remove unused imports, variables, and dead code.
- Keep line length readable.

## Testing Rules

### Backend

- Unit test service logic.

---

## Review Rules

Before pushing code:

- Code builds successfully.
- No console errors.
- No commented dead code.
- No sensitive data committed.
- Passed formatting/linting.
- Self-reviewed.

---

## Team Collaboration

- Respect coding style.
- Review teammate PRs constructively.
- Ask before major architecture changes.

---
