# Asset Management System - Requirements

## 1. Functional Requirements

### 1.1 Admin

- Manage accounts (login, logout)
- Manage user accounts (create, update, deactivate users)
- Assign roles (Admin, Asset Manager, Department Staff, Auditor)
- View system-wide asset reports
- View asset change history (audit logs)

---

### 1.2 Asset Manager

- Manage accounts (login, logout)
- Create new assets with attributes (name, type, value, purchase date, status)
- Update asset information
- Archive or delete assets
- View all assets
- Assign assets to departments
- Transfer assets between departments

---

### 1.3 Department Staff

- Manage accounts (login, logout)
- View assets assigned to their department
- Confirm asset status during validation (valid / invalid / missing)

---

### 1.4 Auditor

- Initiate annual asset validation process
- Review and update asset validation status
- View validation results
- Generate validation reports

---

## 2. Non-Functional Requirements

### 2.1 Performance

- The system shall support at least **500 concurrent users** without performance degradation.
- API response time shall be:
  - ≤ **500 ms** for 95% of requests
  - ≤ **1 second** for 99% of requests

- Asset list page shall load within **2 seconds** for up to **10,000 assets**.

---

### 2.2 Availability

- The system shall have **≥ 99.5% uptime** per month.
- Scheduled maintenance downtime shall not exceed **4 hours/month**.

---

### 2.3 Security

- All users must authenticate via secure login (JWT or equivalent).
- Passwords must be encrypted using **bcrypt (cost ≥ 10)**.
- Role-based access control (RBAC) must be enforced for all endpoints.
- System shall prevent unauthorized access (0 critical vulnerabilities in security scans).

---

### 2.4 Reliability

- System shall ensure **no data loss** during normal operations.
- Backup shall be performed:
  - At least **once per day**
  - Recovery time ≤ **2 hours**

- Failed transactions shall not corrupt data (ACID compliance).

---

### 2.5 Usability

- New users shall be able to complete basic tasks (view assets, assign assets) within **10 minutes** without training.
- UI response time (interaction feedback) shall be ≤ **200 ms**.

---

### 2.6 Scalability

- System shall support scaling to at least **100,000 assets** without major architectural changes.
- Database queries shall maintain performance (≤ 1 second) at this scale.

---

### 2.7 Maintainability

- Codebase shall follow modular architecture (e.g., MVC or layered architecture).
- Unit test coverage shall be ≥ **70%**.
- Average bug fix time ≤ **2 days**.

---

### 2.8 Logging & Monitoring

- All critical actions (login, asset changes, validation updates) must be logged.
- Logs shall be retained for at least **90 days**.
- System shall detect and report errors within **1 minute**.

---
