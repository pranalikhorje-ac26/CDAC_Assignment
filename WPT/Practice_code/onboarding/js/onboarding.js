// 1. Validate the onboarding form
function validateOnboarding() {

    const name = document.getElementById("fullName").value.trim();

    const email = document.getElementById("email").value.trim();

    const qualification =
        document.getElementById("qualification").value;

    const department =
        document.getElementById("department").value;


    // Clear old error messages
    document.getElementById("nameError").textContent = "";

    document.getElementById("emailError").textContent = "";

    document.getElementById("qualificationError").textContent = "";

    document.getElementById("departmentError").textContent = "";


    let valid = true;


    // Validate name
    if (name === "") {

        document.getElementById("nameError").textContent =
            "Full name is required.";

        valid = false;

    }


    // Validate email using a regular expression
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailPattern.test(email)) {

        document.getElementById("emailError").textContent =
            "Enter a valid email address.";

        valid = false;

    }


    // Validate qualification
    if (qualification === "") {

        document.getElementById("qualificationError").textContent =
            "Please select a qualification.";

        valid = false;

    }


    // Validate department
    if (department === "") {

        document.getElementById("departmentError").textContent =
            "Please select a department.";

        valid = false;

    }


    // Continue only when validation succeeds
    if (valid) {

        startOnboarding(name);

    }

    // Prevent the page from reloading
    return false;

}


// 2. Simulate creating an account
function createAccount(name) {

    return new Promise(function (resolve, reject) {

        if (name.length < 3) {

            reject("Name must contain at least 3 characters.");

        } else {

            setTimeout(function () {

                resolve("Creating your account...");

            }, 1000);

        }

    });

}


// 3. Simulate sending a welcome email
function sendWelcomeEmail() {

    return new Promise(function (resolve) {

        setTimeout(function () {

            resolve("Sending welcome email...");

        }, 2000);

    });

}


// 4. Simulate assigning a laptop
function assignLaptop() {

    return new Promise(function (resolve) {

        setTimeout(function () {

            resolve("Assigning your laptop...");

        }, 1500);

    });

}


// 5. Run onboarding steps one after another
function startOnboarding(name) {

    const status = document.getElementById("onboardingStatus");

    status.textContent = "Starting onboarding...";

    createAccount(name)

        .then(function (message) {

            status.textContent = message;

            return sendWelcomeEmail();

        })

        .then(function (message) {

            status.textContent = message;

            return assignLaptop();

        })

        .then(function (message) {

            status.textContent = message;

            return new Promise(function (resolve) {

                setTimeout(function () {

                    resolve();

                }, 100);

            });

        })

        .then(function () {

            status.textContent = `Welcome aboard, ${name}!`;

            document.getElementById("onboardingForm").reset();

        })

        .catch(function (error) {

            status.textContent = "Error: " + error;

        });

}