# Use Case Scenarios – Asset Management System

---

## Use Case Index

| UC ID | Use Case Name                        | Actor            |
| ----- | ------------------------------------ | ---------------- |
| UC-01 | Manage User Accounts                 | Administrator    |
| UC-02 | Assign User Roles                    | Administrator    |
| UC-03 | View System-Wide Reports             | Administrator    |
| UC-04 | View Audit Logs                      | Administrator    |
| UC-05 | Create Asset                         | Asset Manager    |
| UC-06 | Update Asset                         | Asset Manager    |
| UC-07 | Archive Asset                        | Asset Manager    |
| UC-08 | Delete Asset                         | Asset Manager    |
| UC-09 | View All Assets                      | Asset Manager    |
| UC-10 | Allocate Asset to Department         | Asset Manager    |
| UC-11 | Transfer Asset Between Departments   | Asset Manager    |
| UC-12 | View Department Assets               | Department Staff |
| UC-13 | Update Asset Status During Inventory | Department Staff |
| UC-14 | Initiate Annual Inventory Process    | Auditor          |
| UC-15 | Review and Update Inventory Status   | Auditor          |
| UC-16 | View Inventory Results               | Auditor          |
| UC-17 | Generate Report                      | Auditor          |

---

## Use Case Scenarios

---

### UC-01 – Manage User Accounts

| Field            | Detail                                                                                    |
| ---------------- | ----------------------------------------------------------------------------------------- |
| **Actor**        | Administrator                                                                             |
| **Description**  | Administrator creates, updates, or disables user accounts in the system.                  |
| **Precondition** | Administrator is authenticated and has account management privileges.                     |
| **Trigger**      | A new employee joins, an employee's role changes, or an employee leaves the organization. |

**Main Flow (Create):**

1. Administrator navigates to the User Management section.
2. Administrator clicks "Create New User."
3. System displays a user creation form.
4. Administrator enters user details (name, email, department, role).
5. Administrator submits the form.
6. System validates the input and creates the account.
7. System sends a welcome notification to the new user.

**Alternative Flow (Update):**

1. Administrator searches for an existing user.
2. Administrator selects the user and clicks "Edit."
3. Administrator modifies the required fields.
4. System saves and reflects the changes.

**Alternative Flow (Disable):**

1. Administrator selects the target user.
2. Administrator clicks "Disable Account."
3. System prompts for confirmation.
4. Administrator confirms; system deactivates the account and revokes access.

**Postcondition:** User account is created, updated, or disabled successfully.

**Exception:** If the email is already registered, the system displays a duplicate account error.

---

### UC-02 – Assign User Roles

| Field            | Detail                                                                  |
| ---------------- | ----------------------------------------------------------------------- |
| **Actor**        | Administrator                                                           |
| **Description**  | Administrator assigns or modifies roles and permissions for a user.     |
| **Precondition** | Administrator is authenticated. Target user account exists.             |
| **Trigger**      | A user's responsibility changes or a new user requires specific access. |

**Main Flow:**

1. Administrator opens the User Management section.
2. Administrator selects a user.
3. Administrator clicks "Assign Role."
4. System displays available roles (Administrator, Asset Manager, Department Staff, Auditor).
5. Administrator selects the appropriate role.
6. System updates the user's permissions accordingly.
7. System logs the role change in the audit trail.

**Postcondition:** User's role and access rights are updated.

**Exception:** If an invalid role is selected, the system prevents the assignment and shows an error.

---

### UC-03 – View System-Wide Reports

| Field            | Detail                                                                                    |
| ---------------- | ----------------------------------------------------------------------------------------- |
| **Actor**        | Administrator                                                                             |
| **Description**  | Administrator views aggregated reports covering all assets, users, and system activities. |
| **Precondition** | Administrator is authenticated.                                                           |
| **Trigger**      | Administrator needs an overview of system performance or asset status.                    |

**Main Flow:**

1. Administrator navigates to the Reports section.
2. Administrator selects report type (e.g., asset summary, user activity, department allocation).
3. Administrator applies filters (date range, department, status).
4. System retrieves and displays the report data.
5. Administrator reviews the report on screen or exports it.

**Postcondition:** Report is displayed and optionally exported.

**Exception:** If no data is found for the applied filters, the system displays an empty result message.

---

### UC-04 – View Audit Logs

| Field            | Detail                                                                                              |
| ---------------- | --------------------------------------------------------------------------------------------------- |
| **Actor**        | Administrator                                                                                       |
| **Description**  | Administrator reviews a chronological log of all system actions for compliance and troubleshooting. |
| **Precondition** | Administrator is authenticated.                                                                     |
| **Trigger**      | Investigation of a system event or routine compliance check.                                        |

**Main Flow:**

1. Administrator opens the Audit Log section.
2. Administrator filters logs by date, user, or action type.
3. System retrieves and displays matching log entries.
4. Administrator reviews the log details (timestamp, actor, action, affected entity).
5. Administrator optionally exports the log.

**Postcondition:** Audit logs are displayed and optionally exported.

**Exception:** If the specified period has no log entries, the system shows a "No records found" message.

---

### UC-05 – Create Asset

| Field            | Detail                                                   |
| ---------------- | -------------------------------------------------------- |
| **Actor**        | Asset Manager                                            |
| **Description**  | Asset Manager registers a new asset into the system.     |
| **Precondition** | Asset Manager is authenticated and authorized.           |
| **Trigger**      | A new asset is procured or received by the organization. |

**Main Flow:**

1. Asset Manager navigates to the Asset Management section.
2. Asset Manager clicks "Add New Asset."
3. System displays an asset registration form.
4. Asset Manager fills in asset details (name, category, serial number, purchase date, value, condition).
5. Asset Manager submits the form.
6. System validates the data and saves the asset with a unique asset ID.
7. System confirms successful registration.

**Postcondition:** Asset is registered in the system and available for allocation.

**Exception:** If the serial number already exists, the system rejects the entry with a duplicate error.

---

### UC-06 – Update Asset

| Field            | Detail                                                                |
| ---------------- | --------------------------------------------------------------------- |
| **Actor**        | Asset Manager                                                         |
| **Description**  | Asset Manager modifies the details of an existing asset.              |
| **Precondition** | Asset Manager is authenticated. The asset record exists.              |
| **Trigger**      | Asset information changes (e.g., condition update, reclassification). |

**Main Flow:**

1. Asset Manager searches for the asset by name, ID, or category.
2. Asset Manager selects the asset and clicks "Edit."
3. System displays the current asset details in an editable form.
4. Asset Manager modifies the relevant fields.
5. Asset Manager saves the changes.
6. System validates and updates the asset record.
7. System logs the modification.

**Postcondition:** Asset details are updated and the change is recorded.

**Exception:** If required fields are missing, the system highlights them and prevents saving.

---

### UC-07 – Archive Asset

| Field            | Detail                                                                                            |
| ---------------- | ------------------------------------------------------------------------------------------------- |
| **Actor**        | Asset Manager                                                                                     |
| **Description**  | Asset Manager archives an asset that is no longer in active use but must be retained for records. |
| **Precondition** | Asset Manager is authenticated. Asset is in active or inactive status.                            |
| **Trigger**      | Asset reaches end-of-life or is retired from operational use.                                     |

**Main Flow:**

1. Asset Manager locates the asset.
2. Asset Manager selects "Archive Asset."
3. System prompts for a reason and confirmation.
4. Asset Manager provides the reason and confirms.
5. System changes the asset status to "Archived" and removes it from active lists.
6. System retains the record for historical and audit purposes.

**Postcondition:** Asset is archived and excluded from active operations.

**Exception:** If the asset is currently allocated, the system requires deallocation before archiving.

---

### UC-08 – Delete Asset

| Field            | Detail                                                             |
| ---------------- | ------------------------------------------------------------------ |
| **Actor**        | Asset Manager                                                      |
| **Description**  | Asset Manager permanently removes an asset record from the system. |
| **Precondition** | Asset Manager is authenticated. Asset is archived or unallocated.  |
| **Trigger**      | Asset record is confirmed redundant or entered in error.           |

**Main Flow:**

1. Asset Manager locates the asset (typically from the archived list).
2. Asset Manager selects "Delete Asset."
3. System displays a permanent deletion warning and requests confirmation.
4. Asset Manager confirms deletion.
5. System permanently removes the asset record.
6. System logs the deletion in the audit trail.

**Postcondition:** Asset record is permanently removed from the system.

**Exception:** If the asset is still allocated to a department, the system blocks deletion and prompts deallocation first.

---

### UC-09 – View All Assets

| Field            | Detail                                                                  |
| ---------------- | ----------------------------------------------------------------------- |
| **Actor**        | Asset Manager                                                           |
| **Description**  | Asset Manager views the complete list of assets across all departments. |
| **Precondition** | Asset Manager is authenticated.                                         |
| **Trigger**      | Asset Manager needs an overview of all organizational assets.           |

**Main Flow:**

1. Asset Manager navigates to the Asset List view.
2. Asset Manager optionally applies filters (category, status, department, date range).
3. System displays matching assets with key details.
4. Asset Manager clicks on any asset to view its full details.

**Postcondition:** Asset list is displayed according to the applied filters.

**Exception:** If no assets match the filter criteria, the system shows an empty result message.

---

### UC-10 – Allocate Asset to Department

| Field            | Detail                                                              |
| ---------------- | ------------------------------------------------------------------- |
| **Actor**        | Asset Manager                                                       |
| **Description**  | Asset Manager assigns an available asset to a specific department.  |
| **Precondition** | Asset Manager is authenticated. Asset is available (unallocated).   |
| **Trigger**      | A department requests an asset or a new asset needs to be deployed. |

**Main Flow:**

1. Asset Manager selects an available asset.
2. Asset Manager clicks "Allocate."
3. System displays a list of departments.
4. Asset Manager selects the target department.
5. Asset Manager confirms the allocation.
6. System updates the asset status to "Allocated" and links it to the department.
7. System notifies the department of the new asset.

**Postcondition:** Asset is allocated to the department and status is updated.

**Exception:** If the asset is already allocated, the system prevents re-allocation without prior deallocation.

---

### UC-11 – Transfer Asset Between Departments

| Field            | Detail                                                                               |
| ---------------- | ------------------------------------------------------------------------------------ |
| **Actor**        | Asset Manager                                                                        |
| **Description**  | Asset Manager moves an asset from one department to another.                         |
| **Precondition** | Asset Manager is authenticated. Asset is currently allocated to a source department. |
| **Trigger**      | A department no longer needs an asset and another department has requested it.       |

**Main Flow:**

1. Asset Manager searches for the asset.
2. Asset Manager selects "Transfer Asset."
3. System displays the current department and a list of available target departments.
4. Asset Manager selects the destination department.
5. Asset Manager provides a transfer reason and confirms.
6. System updates the asset's department assignment.
7. System notifies both the source and destination departments.
8. System logs the transfer in the audit trail.

**Postcondition:** Asset is reassigned to the new department.

**Exception:** If the destination department is the same as the source, the system rejects the transfer request.

---

### UC-12 – View Department Assets

| Field            | Detail                                                                       |
| ---------------- | ---------------------------------------------------------------------------- |
| **Actor**        | Department Staff                                                             |
| **Description**  | Department Staff views the list of assets allocated to their own department. |
| **Precondition** | Department Staff is authenticated and assigned to a department.              |
| **Trigger**      | Staff member needs to review available or assigned assets.                   |

**Main Flow:**

1. Department Staff logs in and navigates to "My Department Assets."
2. System automatically filters and displays assets allocated to the staff member's department.
3. Staff member views asset details (name, category, condition, status).
4. Staff member clicks on an asset for full details.

**Postcondition:** Department assets are displayed for the logged-in user's department only.

**Exception:** If no assets are allocated to the department, the system shows an empty list with an informational message.

---

### UC-13 – Update Asset Status During Inventory

| Field            | Detail                                                                                                 |
| ---------------- | ------------------------------------------------------------------------------------------------------ |
| **Actor**        | Department Staff                                                                                       |
| **Description**  | Department Staff updates the physical condition and status of assets during an active inventory cycle. |
| **Precondition** | An inventory cycle is active. Staff member is authenticated and assigned to the department.            |
| **Trigger**      | An annual inventory process has been initiated and staff must verify their department's assets.        |

**Main Flow:**

1. Department Staff opens the active inventory task for their department.
2. System displays the list of assets to be verified.
3. Staff member physically inspects each asset.
4. For each asset, staff member selects the current status (Good, Damaged, Missing, Under Repair).
5. Staff member optionally adds remarks.
6. Staff member submits the update for each asset.
7. System saves the status and marks the asset as "Verified" in the inventory record.

**Postcondition:** Asset inventory statuses are updated and recorded for auditor review.

**Exception:** If the inventory session has expired or been closed, the system prevents further updates.

---

### UC-14 – Initiate Annual Inventory Process

| Field            | Detail                                                                                         |
| ---------------- | ---------------------------------------------------------------------------------------------- |
| **Actor**        | Auditor                                                                                        |
| **Description**  | Auditor starts a new annual inventory cycle, notifying all departments to verify their assets. |
| **Precondition** | Auditor is authenticated. No other inventory cycle is currently active.                        |
| **Trigger**      | The annual inventory period begins per organizational schedule.                                |

**Main Flow:**

1. Auditor navigates to the Inventory Management section.
2. Auditor clicks "Start New Inventory Cycle."
3. System displays configuration options (cycle name, start date, deadline, departments in scope).
4. Auditor fills in the configuration and confirms.
5. System creates the inventory cycle and assigns verification tasks to all relevant departments.
6. System sends notifications to Department Staff and Asset Managers.

**Postcondition:** Inventory cycle is active and department tasks are assigned.

**Exception:** If a cycle is already in progress, the system prevents starting a new one until the existing cycle is closed.

---

### UC-15 – Review and Update Inventory Status

| Field            | Detail                                                                                      |
| ---------------- | ------------------------------------------------------------------------------------------- |
| **Actor**        | Auditor                                                                                     |
| **Description**  | Auditor reviews the inventory submissions from departments and updates the official status. |
| **Precondition** | Inventory cycle is active. At least one department has submitted updates.                   |
| **Trigger**      | Department Staff have submitted their asset verifications for review.                       |

**Main Flow:**

1. Auditor opens the active inventory cycle.
2. Auditor views the list of departments and their submission status.
3. Auditor selects a department to review its asset status updates.
4. Auditor examines each asset's reported status and remarks.
5. Auditor approves, flags, or overrides individual asset statuses.
6. System records the auditor's review actions and timestamps.
7. Auditor repeats for all departments.

**Postcondition:** Inventory statuses are reviewed and officially recorded by the auditor.

**Exception:** If a department has not submitted their inventory, the auditor can send a reminder or mark it as non-compliant.

---

### UC-16 – View Inventory Results

| Field            | Detail                                                                            |
| ---------------- | --------------------------------------------------------------------------------- |
| **Actor**        | Auditor                                                                           |
| **Description**  | Auditor views the consolidated results of a completed or ongoing inventory cycle. |
| **Precondition** | Auditor is authenticated. An inventory cycle exists (active or completed).        |
| **Trigger**      | Auditor needs to assess overall inventory progress or final outcomes.             |

**Main Flow:**

1. Auditor navigates to Inventory Results.
2. Auditor selects the inventory cycle to review.
3. System displays a summary dashboard (total assets, verified count, missing, damaged, pending).
4. Auditor drills down by department or asset category.
5. Auditor reviews individual asset discrepancies.

**Postcondition:** Inventory results are displayed with full detail visibility.

**Exception:** If the cycle has no submissions yet, the system shows a summary with all statuses as "Pending."

---

### UC-17 – Generate Report

| Field            | Detail                                                                                             |
| ---------------- | -------------------------------------------------------------------------------------------------- |
| **Actor**        | Auditor                                                                                            |
| **Description**  | Auditor generates a formal report based on inventory results or asset data for stakeholder review. |
| **Precondition** | Auditor is authenticated. Relevant inventory or asset data is available.                           |
| **Trigger**      | End of an inventory cycle or a management request for a formal asset report.                       |

**Main Flow:**

1. Auditor navigates to the Report Generation section.
2. Auditor selects the report type (Inventory Summary, Asset Discrepancy, Department Compliance, etc.).
3. Auditor configures parameters (cycle, date range, department scope).
4. Auditor clicks "Generate Report."
5. System compiles the data and renders the report.
6. Auditor previews the report.
7. Auditor exports the report in the desired format (PDF, Excel, etc.).

**Postcondition:** Report is generated and available for download or distribution.

**Exception:** If required data is incomplete (e.g., pending departments), the system warns the auditor before generating.
