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

- [ ] Code deployed successfully to staging environment
  

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
