// Store all employee records
let employees = [];


// 1. Load employees from the API
async function loadEmployees() {

    const message = document.getElementById("statusMessage");

    message.textContent = "Loading employees...";

    try {

        const response = await fetch(
            "https://jsonplaceholder.typicode.com/users"
        );

        // Display HTTP response status in console
        console.log("Response status:", response.status);

        if (!response.ok) {

            throw new Error("Unable to load employees.");

        }

        const data = await response.json();

        // Convert API records into our employee format
        employees = data.map(function (employee) {

            return {
                id: employee.id,
                name: employee.name,
                username: employee.username,
                department: "Not assigned",
                email: employee.email,
                phone: employee.phone
            };

        });

        displayEmployees(employees);

        message.textContent = "Employees loaded successfully.";

    } catch (error) {

        message.textContent = "Error: " + error.message;

    }

}


// 2. Display employees in the table
function displayEmployees(list) {

    const table = document.getElementById("employeeTable");

    table.innerHTML = "";

    for (const employee of list) {

        // Destructuring
        const {
            id,
            name,
            username,
            department,
            email,
            phone
        } = employee;

        const row = document.createElement("tr");

        const values = [
            id,
            name,
            username,
            department,
            email,
            phone
        ];

        // Create table cells
        values.forEach(function (value) {

            const cell = document.createElement("td");

            cell.textContent = value;

            row.appendChild(cell);

        });

        // Create Remove button
        const actionCell = document.createElement("td");

        const button = document.createElement("button");

        button.textContent = "Remove";

        button.onclick = function () {

            removeEmployee(id, row);

        };

        actionCell.appendChild(button);

        row.appendChild(actionCell);

        table.appendChild(row);

    }

    // Update total
    document.getElementById("totalEmployees").textContent =
        `Total employees: ${list.length}`;

}


// 3. Search employees using filter()
function searchEmployees() {

    const field = document.getElementById("searchField").value;

    const text = document.getElementById("searchText").value
        .toLowerCase()
        .trim();

    // Computed property name
    const searchObject = {
        [field]: text
    };

    const filteredEmployees = employees.filter(function (employee) {

        return employee[field]
            .toLowerCase()
            .includes(searchObject[field]);

    });

    displayEmployees(filteredEmployees);

}


// 4. Add a new employee
function addEmployee() {

    const name = document.getElementById("newName").value.trim();

    const department =
        document.getElementById("newDepartment").value;

    if (name === "" || department === "") {

        alert("Please enter the name and select a department.");

        return false;

    }

    // Object shorthand
    const newEmployee = {
        id: Date.now(),
        name,
        username: name.toLowerCase().replace(/\s+/g, ""),
        department,
        email: "not-provided@example.com",
        phone: "Not provided"
    };

    employees.push(newEmployee);

    // Display the current search results, if any
    searchEmployees();

    document.getElementById("addEmployeeForm").reset();

    document.getElementById("statusMessage").textContent =
        "Employee added successfully.";

    return false;

}


// 5. Remove an employee
function removeEmployee(id, row) {

    employees = employees.filter(function (employee) {

        return employee.id !== id;

    });

    // Remove the row from the page
    row.remove();

    // Refresh the current search results and total
    searchEmployees();

}