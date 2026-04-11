# 🗓 Sprint Planning - Sprint 1

  

**Project: Asset Management System**  

**Sprint: 1**  

**Sprint Duration: 4 hours**  

**Date: [8h] - [12h]**  

**Scrum Master: Lu Quoc Phap**  

**Product Owner: Nguyen Trung An**  

**Team Members: Nguyen Le Nguyen, Tran Trong Nghia, Hoang Huu Nhan, Tran Gia Kiet, Le Quoc Kiet, Truong Nguyen Gia Bao, Nguyen Chi Thien**

  

---

  

# Sprint Goal

  

> Sprint 1 aims to implement a secure role-based authentication system that enables company staff to log in with their credentials or via Google OAuth. Additionally, the system will provide admin capabilities to manage user accounts and assign appropriate roles (Admin, Asset Manager, Department Staff, Auditor) to employees.

  

---

  

# Product Backlog Selected for Sprint

| ID | Title | Priority | Estimate | Status |
|----|-------|----------|----------|--------|
| 1  | User Account Creation | 1 | 8.0  | In Progress |
| 2  | System Login with Email/Password | 1 | 5.5  | In Progress |
| 3  | Staff's account creation | 1 | 6.0  | In Progress |

---


### US-01 - User Account Creation

As a system administrator, I want to create user accounts for company staff so that they can access the asset management system.


**Acceptance Criteria:**

- System allows account creation with email and password

- Email validation is enforced

- Password meets security requirements (minimum 8 characters, mixed case, numbers)

- Account is created with default role pending assignment

---

### US-02 - System Login with Email/Password

As a company staff member, I want to log in using my email and password so that I can access the system securely.

  

**Acceptance Criteria:**

- Login page displays email and password fields

- Incorrect credentials show error message

- Successful login redirects to dashboard based on user role

- Session token is generated and stored securely

---


### US-03 - Staff's account creation

As a company staff member, I want to create an account or log in using Google so that I can access the system quickly without creating a new password.

**Acceptance Criteria:**

- Admin can create accounts for staffs with a particular role
- Admin can lock/unlock staff's account

---

# User Story Breakdown into Tasks

  
  

## US-01: User Account Creation

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US1-T1 | Create database schema for users table | 1.0 | BE | |
| US1-T2 | Design user registration API endpoints | 1.5 | BE | |
| US1-T3 | Implement password hashing and validation | 1.5 | BE | |
| US1-T4 | Create registration form UI | 2.0 | FE | |
| US1-T5 | Implement email validation logic | 1.0 | BE | |
| US1-T6 | Write acceptance tests for registration | 1.5 | QA | |
| US1-T7 | Conduct manual testing and bug fixes | 1.0 | QA | |

  

**Total Estimated Hours: 9.5h**

  

---

  

## US-02: System Login with Email/Password

  

| Task ID | Task | Estimate (h) | Role | Status |
|---------|------|--------------|------|--------|
| US2-T1 | Design login API with JWT token generation | 2.0 | BE | |
| US2-T2 | Implement session management middleware | 1.5 | BE | |
| US2-T3 | Create login form UI | 1.5 | FE | |
| US2-T4 | Implement role-based dashboard routing | 1.5 | FE | |
| US2-T5 | Add error handling and validation messages | 1.0 | FE | |
| US2-T6 | Write test cases for login functionality | 1.5 | QA | |
| US2-T7 | Manual testing and bug fixes | 1.0 | QA | |

  

**Total Estimated Hours: 10.0h**

  

---

  

## US-03: Google OAuth Integration

  

| Task ID | Task | Estimate (h) | Role | Status |

|---------|------|--------------|------|--------|
| US3-T1 | Set up Google OAuth 2.0 credentials | 1.0 | Backend Lead | |
| US3-T2 | Implement Google OAuth authentication backend | 2.5 | BE | |
| US3-T3 | Create Google login button UI | 1.0 | FE | |
| US3-T4 | Implement frontend Google login flow | 1.5 | FE | |
| US3-T5 | Add user data sync from Google profile | 1.5 | BE | |
| US3-T6 | Write integration tests for Google login | 1.5 | QA | |
| US3-T7 | Manual testing and bug fixes | 1.0 | QA | |

  

**Total Estimated Hours: 10.0h**

  

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
| Google OAuth API rate limiting or downtime | Delayed feature delivery | Medium | Set up proper error handling, implement fallback to email/password login, monitor API status |
| Backend and Frontend integration delays | Feature incompleteness | Medium | Daily standup sync-ups, early API contract definition, mock data for parallel development |
| Security vulnerabilities found during testing | Need to refactor code | High | Implement security code review process, use static analysis tools early, follow OWASP guidelines |
| Database schema changes needed mid-sprint | Rework and delays | Low | Carefully design database schema before coding, get tech lead approval before implementation |
| Team member unavailability | Reduced capacity | Low | Cross-train team members on critical tasks, maintain documentation, enable task handover |
| Password storage/encryption issues | Security risk, critical bugs | Medium | Use well-established libraries (bcrypt), conduct security review before deployment |

  

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

- [ ] Performance benchmarks met (API response ≤500ms)

  

---

  

# 7️⃣ Commitment

  

- **Total Story Points: 36 (estimate)**

- **Total Estimated Hours: 58.0 hours**

- **Planned Velocity: 36 story points**

- **Team Confidence Level: High** - All team members have reviewed requirements and confirm capability to complete sprint goal

  

---

  

# 8️⃣ Additional Notes

  

### Dependencies

- External Service: Google OAuth 2.0 API

- Database Setup: PostgreSQL or MySQL with proper schema

- Email Service: SMTP/Email provider for validation (optional for this sprint)

  

### Technology Stack

- Backend: (Java/Node.js/Python - to be specified)

- Frontend: (React/Vue/Angular - to be specified)

- Database: PostgreSQL/MySQL

- Authentication: JWT, bcrypt

- OAuth: Google OAuth 2.0

  

### Success Criteria

- All 3 user stories successfully completed and tested

- Zero critical security vulnerabilities

- Admin can manage and assign roles to users within the dashboard

  

### Follow-up Actions

- Schedule tech lead architecture review before starting development

- Prepare Google OAuth credentials and test accounts

- Set up CI/CD pipeline for automated testing

- Establish code review guidelines and security checklist