# 🗓 Sprint Planning - Sprint 3

  

**Project: Asset Management System**  

**Sprint: 3**  

**Sprint Duration: 4 hours**  

**Date: 8h30h - 12h**  

**Scrum Master: Lu Quoc Phap**  

**Product Owner: Nguyen Trung An**  

**Team Members: Nguyen Le Nguyen, Tran Trong Nghia, Hoang Huu Nhan, Tran Gia Kiet, Le Quoc Kiet, Truong Nguyen Gia Bao, Nguyen Chi Thien**

---

# Sprint Goal

> Sprint 3 aims to implement the Audit and Asset Validation system that enables Auditors to create inspection cycles, Department Staff to confirm asset status, Auditors to verify and finalize asset conditions, and generate comprehensive audit reports. This sprint focuses on establishing asset validation workflow and audit trail tracking.

  

---

  

# Product Backlog Selected for Sprint

| ID | Title | Priority | Estimate | Status |
|----|-------|----------|----------|--------|
| 1  | Create Audit Inspection Cycle | 1 | 4.0  | Not Started |
| 2  | Staff Asset Status Confirmation | 1 | 5.5  | Not Started |
| 3  | Auditor Asset Status Validation | 1 | 5.0  | Not Started |
| 4  | Audit Results and Reporting | 1 | 4.5  | Not Started |

---

### US-07 - Create Audit Inspection Cycle

As an Auditor, I want to create and initiate an asset inspection cycle so that the organization can begin the asset validation process.

**Acceptance Criteria:**

- Auditor can create a new audit inspection cycle with title, start date, and end date
- System validates that dates are valid and in the future
- Audit cycle is assigned a unique identifier
- Audit status is initially set to ONGOING
- Department Staff are notified when audit cycle begins
- Audit cycle details can be viewed by Auditors and Department Staff

---

### US-08 - Staff Asset Status Confirmation

As a Department Staff member, I want to confirm the status of assets assigned to my department during an audit so that asset validation is accurate.

**Acceptance Criteria:**

- Department Staff can access list of assets in their department for the current audit
- Staff can mark each asset as VALID, INVALID, or MISSING with optional notes
- Staff can upload image proof for asset status (optional)
- System records who confirmed each asset and when
- Staff can review and modify their submissions before audit is finalized
- Confirmation status is saved and cannot be modified after audit completion

---

### US-09 - Auditor Asset Status Validation

As an Auditor, I want to review and finalize the asset status after validating staff reports so that discrepancies are identified.

**Acceptance Criteria:**

- Auditor can view all staff reports for an audit cycle
- Auditor can accept or override staff-reported status
- Auditor can add detailed notes explaining their assessment
- Final status can be marked as VALID, INVALID, or MISSING
- System records staff-reported vs. auditor-finalized status for comparison
- Auditor cannot modify confirmed status once audit is closed
- Only Auditor can finalize asset status

---

### US-10 - Audit Results and Reporting

As an Auditor, I want to view and generate audit reports so that I can analyze asset discrepancies and create management summaries.

**Acceptance Criteria:**

- Auditor can view comprehensive audit summary (total checked, valid, invalid, missing counts)
- System generates detailed discrepancy report showing differences between staff and auditor assessments
- Report displays asset code, department name, staff-reported status, auditor-finalized status, and notes
- Auditor can filter and sort audit results by department or status
- Report data can be exported to Excel format
- Audit audit can be generated and viewed after audit cycle closure

---

# User Story Breakdown into Tasks

  

## US-07: Create Audit Inspection Cycle

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US7-T1 | Create database schema for audit table | 1.0 | BE | |
| US7-T2 | Design audit creation API endpoint | 1.0 | BE | |
| US7-T3 | Implement audit date validation logic | 0.5 | BE | |
| US7-T4 | Create audit creation form UI | 1.0 | FE | |
| US7-T5 | Implement notification system for audit initiation | 1.0 | BE | |
| US7-T6 | Write test cases for audit creation | 0.5 | QA | |
| US7-T7 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 5.5h**

  

---

  

## US-08: Staff Asset Status Confirmation

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US8-T1 | Create database schema for audit details table | 1.0 | BE | |
| US8-T2 | Design staff asset confirmation API endpoint | 1.5 | BE | |
| US8-T3 | Implement file upload for asset proof images | 1.0 | BE | |
| US8-T4 | Create staff asset confirmation form UI | 1.5 | FE | |
| US8-T5 | Implement status selection and notes input | 1.0 | FE | |
| US8-T6 | Set up image upload and preview functionality | 1.0 | FE | |
| US8-T7 | Implement draft save functionality for staff submissions | 0.5 | BE | |
| US8-T8 | Write test cases for status confirmation | 1.0 | QA | |
| US8-T9 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 8.0h**

  

---

  

## US-09: Auditor Asset Status Validation

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US9-T1 | Design auditor asset validation API endpoint | 1.5 | BE | |
| US9-T2 | Implement status override logic with audit trail | 1.0 | BE | |
| US9-T3 | Create comparison view showing staff vs auditor assessments | 1.5 | FE | |
| US9-T4 | Implement auditor notes input and status selection UI | 1.0 | FE | |
| US9-T5 | Build side-by-side view of staff report and auditor assessment | 1.0 | FE | |
| US9-T6 | Implement status finalization logic | 0.5 | BE | |
| US9-T7 | Write test cases for auditor validation | 1.0 | QA | |
| US9-T8 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 8.0h**

  

---

  

## US-10: Audit Results and Reporting

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US10-T1 | Design audit summary API endpoint | 1.0 | BE | |
| US10-T2 | Implement audit discrepancy calculation and aggregation | 1.0 | BE | |
| US10-T3 | Design audit results endpoint with filtering and sorting | 1.0 | BE | |
| US10-T4 | Implement Excel export functionality | 1.0 | BE | |
| US10-T5 | Create audit summary dashboard UI | 1.5 | FE | |
| US10-T6 | Implement results table with filtering and sorting | 1.0 | FE | |
| US10-T7 | Add export to Excel button and download functionality | 0.5 | FE | |
| US10-T8 | Write test cases for audit reporting | 1.0 | QA | |
| US10-T9 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 8.5h**

  

---

  

# Capacity Planning

  

## Team Capacity

  

| Member | Available Days | Hours/Day | Capacity (hours) |
|--------|----------------|-----------|------------------|
| Scrum Master | 10 | 2 | 20 |
| Product Owner | 10 | 1.5 | 15 |
| Backend Developer 1 | 10 | 8 | 80 |
| Backend Developer 2 | 10 | 8 | 80 |
| Frontend Developer | 10 | 8 | 80 |
| QA Engineer | 10 | 8 | 80 |
| Backend Lead/Tech Lead | 10 | 6 | 60 |

  

**Total Team Capacity: 415 hours**

---

# Risk Identification

| Risk | Impact | Probability | Mitigation Plan |
|---|---|---|---|
| Complex audit state management across multiple statuses | Data inconsistency, validation errors | Medium | Implement state machine pattern, thorough transaction testing |
| Image upload and storage scalability | Performance degradation, storage issues | Medium | Use cloud storage (S3/Azure Blob), implement compression, CDN for image delivery |
| Audit calculation accuracy for discrepancies | Incorrect reporting data, trust issues | High | Implement detailed calculation logic with unit tests, independent verification |
| File export performance with large datasets | Application timeout, system overload | Medium | Implement async processing, pagination for exports, progress tracking |
| Concurrent audit access by multiple auditors | Race conditions, overwrites | Medium | Implement row-level locking, optimistic concurrency control |
| Staff confusion about submission deadlines | Incomplete audits, process delays | Low | Send reminders, display countdown timers, clear deadline indicators |
| Integration of audit workflow across roles | Workflow breaks, missing notifications | Medium | Early end-to-end testing, comprehensive permission checks |
| Report generation delay for large audits | User frustration, delayed decision-making | Medium | Query optimization, caching, background job processing |

---
