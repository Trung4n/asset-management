# Asset Management System - UI Requirements

## 1. Overview

This document defines the user interface (UI) requirements for the Asset Management System. It focuses on what users should see and how they interact with the system. Implementation details (code, styling) are handled by the frontend development team.

---

## 2. General UI Principles

- The interface must be simple and intuitive
- All main actions should be accessible within 3 clicks
- Consistent layout across all pages
- Responsive design (desktop-first, but adaptable)
- Clear feedback for user actions (success, error, loading)

---

## 3. Main Screens and Requirements

## 3.1 Login Page

### Purpose

Allow users to authenticate into the system

### UI Elements

- Input: Email / Username
- Input: Password
- Button: Login
- Error message display

### Behavior

- Show error if credentials are invalid
- Redirect to dashboard after successful login

---

## 3.2 Dashboard

### Purpose

Provide an overview of the system

### UI Elements

- Summary cards:
  - Total assets
  - Assets by status (valid, invalid, missing)

- Navigation menu (sidebar or topbar)

### Behavior

- Data loads within 2 seconds
- Clicking summary navigates to detailed view

---

## 3.3 Asset List Page

### Purpose

Allow users to view and manage assets

### UI Elements

- Table of assets:
  - Name
  - Type
  - Department
  - Status
  - Actions (edit, delete)

- Button: Create Asset
- Filter:
  - By department
  - By status

- Search bar

### Behavior

- Clicking a row opens asset details
- Filters update list dynamically
- Pagination for large datasets

---

## 3.4 Asset Detail Page

### Purpose

Display detailed information about a specific asset

### UI Elements

- Asset information (name, type, value, status, department)
- Button: Edit
- Button: Transfer
- History section (changes, assignments)

### Behavior

- Edit opens form with pre-filled data
- History is displayed in chronological order

---

## 3.5 Create / Edit Asset Form

### Purpose

Allow Asset Manager to create or update assets

### UI Elements

- Input fields:
  - Name
  - Type
  - Value
  - Purchase date

- Dropdown: Department
- Dropdown: Status
- Buttons: Save, Cancel

### Behavior

- Validate required fields before submission
- Show success or error message after submission

---

## 3.6 Asset Assignment / Transfer

### Purpose

Assign or transfer assets between departments

### UI Elements

- Dropdown: Select department
- Button: Confirm transfer

### Behavior

- Update asset’s department immediately after confirmation
- Log the change in history

---

## 3.7 Validation Page (Annual Audit)

### Purpose

Support asset validation process

### UI Elements

- List of assets assigned to department
- Status selector for each asset:
  - Valid
  - Invalid
  - Missing

- Button: Submit validation

### Behavior

- Users can update status for each asset
- Submission saves all changes

---

## 3.8 Reports Page

### Purpose

Allow Admin and Auditor to view reports

### UI Elements

- Filters:
  - Date range
  - Department

- Charts or tables showing:
  - Asset status distribution
  - Validation results

### Behavior

- Reports update based on selected filters

---

## 3.9 User Management Page (Admin)

### Purpose

Manage system users

### UI Elements

- Table of users:
  - Name
  - Role
  - Status

- Button: Create User
- Actions: Edit, Deactivate

### Behavior

- Role changes apply immediately
- Deactivated users cannot log in

---

## 4. Navigation

- Sidebar or top navigation must include:
  - Dashboard
  - Assets
  - Validation
  - Reports
  - Users (Admin only)

- Active page should be clearly highlighted

---

## 5. Feedback and Error Handling

- Show loading indicator for all API calls
- Show success message after actions (create, update, delete)
- Show clear error messages when actions fail

---

## 6. Role-Based UI Behavior

- Admin:
  - Full access to all pages

- Asset Manager:
  - Access to asset management and assignment

- Department Staff:
  - Access to asset list (limited) and validation page

- Auditor:
  - Access to validation and reports only

---

## 7. Accessibility and Usability

- All buttons must be clearly labeled
- Forms must show validation errors
- Text must be readable (sufficient contrast)
- Navigation must be consistent across pages

---
