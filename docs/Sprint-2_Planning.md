# Sprint Planning - Sprint 2

  

**Project: Asset Management System**  

**Sprint: 2**  

**Sprint Duration: 4 hours**  

**Date: 13h - 16h**  

**Scrum Master: Lu Quoc Phap**  

**Product Owner: Nguyen Trung An**  

**Team Members: Nguyen Le Nguyen, Tran Trong Nghia, Hoang Huu Nhan, Tran Gia Kiet, Le Quoc Kiet, Truong Nguyen Gia Bao, Nguyen Chi Thien**
---
# Sprint Goal

> Sprint 2 aims to implement the Asset Assignment feature that enables Asset Managers to assign assets to departments, transfer assets between departments, and allows Department Staff to view assets assigned to their department. This sprint focuses on establishing asset ownership tracking and departmental asset visibility.

  

---

  

# Product Backlog Selected for Sprint

| ID | Title | Priority | Estimate | Status |
|----|-------|----------|----------|--------|
| 1  | Asset Assignment to Department | 1 | 6.0  | Not Started |
| 2  | Asset Transfer Between Departments | 1 | 5.0  | Not Started |
| 3  | Department Staff Asset View | 1 | 4.5  | Not Started |
| 4  | Create Audit Inspection Cycle | 1 | 4.0  | Not Started |
| 5  | Staff Asset Status Confirmation | 1 | 5.5  | Not Started |
| 6  | Auditor Asset Status Validation | 1 | 5.0  | Not Started |
| 7  | Audit Results and Reporting | 1 | 4.5  | Not Started |

---

### US-04 - Asset Assignment to Department

As an Asset Manager, I want to assign assets to a department so that ownership is clear.

**Acceptance Criteria:**

- Asset Manager can select an asset and assign it to a department
- System validates that the asset exists and is not already assigned
- Assignment history is recorded in the system
- Department Staff can immediately see newly assigned assets
- Audit log records who assigned the asset and when

---

### US-05 - Asset Transfer Between Departments

As an Asset Manager, I want to transfer assets between departments so that changes are properly recorded.

**Acceptance Criteria:**

- Asset Manager can select an assigned asset and transfer it to a different department
- Previous department assignment is retained in history
- Transfer reason/notes can be added (optional)
- New department is notified of the transfer
- Audit log records all transfer details (from, to, date, who, reason)

---

### US-06 - Department Staff Asset View

As a Department Staff, I want to view assets assigned to my department so that I know what we have.

**Acceptance Criteria:**

- Department Staff can access a list of all assets assigned to their department
- Asset list displays key information (ID, name, status, location, assigned date)
- Department Staff can filter and search assets by name or ID
- Asset list updates in real-time when new assets are assigned
- Department Staff cannot modify asset information or assignments

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
- Final status can be marked as VALID, INVALID, MISSING or PENDING
- System records staff-reported vs. auditor-finalized status for comparison
- Auditor cannot modify confirmed status once audit is closed
- Only Auditor can finalize asset status

---

# User Story Breakdown into Tasks

  

## US-04: Asset Assignment to Department

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US4-T1 | Create API endpoint for asset assignment | 1.5 | BE | |
| US4-T2 | Implement assignment validation logic | 1.0 | BE | |
| US4-T3 | Create assignment history tracking in database | 0.5 | BE | |
| US4-T4 | Design asset assignment UI form | 1.0 | FE | |
| US4-T5 | Implement asset selection and department dropdown | 1.0 | FE | |
| US4-T6 | Integrate real-time notifications for new assignments | 1.0 | BE | |
| US4-T7 | Write test cases for assignment functionality | 1.0 | QA | |
| US4-T8 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 1.5h**

  

---

  

## US-05: Asset Transfer Between Departments

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US5-T1 | Design transfer API endpoint | 1.5 | BE | |
| US5-T2 | Implement transfer validation and history recording | 1.5 | BE | |
| US5-T3 | Add transfer reason/notes field to database | 0.5 | BE | |
| US5-T4 | Create transfer form UI with reason input | 1.0 | FE | |
| US5-T5 | Implement department selection and confirmation dialog | 1.0 | FE | |
| US5-T6 | Implement notification system for transfers | 1.0 | BE | |
| US5-T7 | Write test cases for transfer functionality | 1.0 | QA | |
| US5-T8 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 1.5h**

  

---

  

## US-06: Department Staff Asset View

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US6-T1 | Design and implement department asset list API | 1.0 | BE | |
| US6-T2 | Implement access control for department staff view | 0.5 | BE | |
| US6-T3 | Create department asset listing UI | 1.5 | FE | |
| US6-T4 | Implement search and filter functionality | 1.0 | FE | |
| US6-T5 | Set up real-time updates for asset list | 1.0 | BE | |
| US6-T6 | Implement pagination for large asset lists | 0.5 | FE | |
| US6-T7 | Write test cases for department asset view | 1.0 | QA | |
| US6-T8 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 1h**

  

---

## US-07: Create Audit Inspection Cycle

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US7-T1 | Create database schema for audit table | 1.0 | BE | |
| US7-T2 | Design audit creation API endpoint | 1.0 | BE | |
| US7-T3 | Implement audit date validation logic | 0.5 | BE | |
| US7-T4 | Create audit creation form UI | 1.0 | FE | |
| US7-T5 | Implement notification system for audit initiation | 1.0 | BE | |
| US7-T6 | Write test plans for audit creation | 0.5 | Tester | |
| US7-T7 | Manual testing and bug fixes | 0.5 | Tester | |

  

**Total Estimated Hours: 5.5h**

  

---

  

## US-08: Staff Asset Status Confirmation

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US8-T1 | Create database schema for audit details table | 1.0 | BE | |
| US8-T2 | Design staff asset confirmation API endpoint | 1.5 | BE | |
| US8-T4 | Create staff asset confirmation form UI | 1.5 | FE | |
| US8-T5 | Implement status selection and notes input | 1.0 | FE | |
| US8-T6 | Implement save functionality for staff submissions | 0.5 | BE | |
| US8-T7 | Write test cases for status confirmation | 1.0 | QA | |
| US8-T8 | Manual testing and bug fixes | 0.5 | QA | |

**Total Estimated Hours: 8.0h**

---

  

## US-09: Auditor Asset Status Validation

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US9-T1 | Design auditor asset validation API endpoint | 1.5 | BE | |
| US9-T2 | Implement status override logic with audit trail | 1.0 | BE | |
| US9-T3 | Implement auditor notes input and status selection UI | 1.0 | FE | |
| US9-T4 | Build side-by-side view of staff report and auditor assessment | 1.0 | FE | |
| US9-T5 | Implement status finalization logic | 0.5 | BE | |
| US9-T6 | Write test plans for auditor validation | 1.0 | QA | |
| US9-T7 | Manual testing and bug fixes | 0.5 | QA | |

  

**Total Estimated Hours: 8.0h**

  

---

  

**Total Estimated Hours: 8.5h**

  

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
|------|--------|-------------|-----------------|
| Real-time notification system complexity | Delayed feature delivery | Medium | Early POC of notification mechanism, use established libraries (WebSocket, SignalR) |
| Data consistency across department transfers | Potential data loss or duplicate records | Medium | Implement ACID transactions, thorough database testing, backup strategy |
| Performance issues with large asset lists | Slow UI rendering, poor user experience | Medium | Implement pagination and lazy loading, optimize database queries |
| Access control bugs allowing unauthorized asset viewing | Security issue, regulatory risk | High | Implement security code review process, role-based access control testing |
| Asset state management during concurrent transfers | Race conditions and inconsistencies | Medium | Implement optimistic locking, proper transaction handling |
| Integration delay between Frontend and Backend | Feature incompleteness | Medium | Early API contract definition, mock data for parallel development |
| Department Staff confusion about asset updates | User errors, process issues | Low | Clear UI feedback, notifications about asset changes, user documentation |

  

---

  

# Definition of Done (DoD)

  

- [ ] Code is complete and fully functional

- [ ] Code review completed with at least 1 approval

- [ ] Unit tests written and passing (≥80% coverage)

- [ ] No critical or high-priority bugs remain

- [ ] Integration tests passed

- [ ] Manual testing completed by QA

- [ ] Documentation updated (API docs, setup instructions)  

---

  

# Commitment

  

- **Total Story Points: 27 (estimate)**

- **Total Estimated Hours: 22.0 hours**

- **Planned Velocity: 27 story points**

- **Team Confidence Level: High** - Team members have experience from Sprint 1, clear requirements defined

  

---

  

# Additional Notes

  

### Dependencies

- Backend API framework from Sprint 1 (authentication, database structure)
- Database: PostgreSQL or MySQL with asset and department tables
- Frontend framework and routing from Sprint 1
- Real-time notification system (WebSocket or similar)

### Success Criteria

- All 3 user stories successfully completed and tested
- Asset assignment and transfer operations are fully functional
- Department Staff can view their assigned assets in real-time
- Audit logs record all assignment and transfer operations
- Zero critical security vulnerabilities
- API response time meets performance requirements

  

### Follow-up Actions

- Ensure asset and department database schema are properly set up
- Set up notification/messaging system before starting development
- Establish real-time communication protocol between frontend and backend
- Schedule cross-team coordination for API integration
