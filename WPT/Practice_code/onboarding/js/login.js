// 1. Check username
function checkUsername() {

    const username = document.getElementById("username").value;

    const error = document.getElementById("usernameError");

    if (username.trim() === "") {

        error.textContent = "Username is required.";

        return false;

    } else {

        error.textContent = "";

        return true;

    }

}


// 2. Check password using a regular expression
function checkPassword() {

    const password = document.getElementById("password").value;

    const error = document.getElementById("passwordError");

    // Minimum 8 characters, uppercase, lowercase,
    // number and special character
    const pattern =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z0-9]).{8,}$/;

    if (!pattern.test(password)) {

        error.textContent =
            "Use 8+ characters with uppercase, lowercase, number and special character.";

        return false;

    } else {

        error.textContent = "";

        return true;

    }

}


// 3. Show or hide password
function togglePassword() {

    const password = document.getElementById("password");

    const button = document.querySelector(".password-row button");

    if (password.type === "password") {

        password.setAttribute("type", "text");

        button.textContent = "Hide";

    } else {

        password.setAttribute("type", "password");

        button.textContent = "Show";

    }

}


// 4. Validate the complete login form
function validate() {

    const usernameValid = checkUsername();

    const passwordValid = checkPassword();

    if (usernameValid && passwordValid) {

        document.getElementById("loginMessage").textContent =
            "Login successful!";

        // This is a demonstration, not real authentication.
        // Redirect to the directory page.
        setTimeout(function () {

            window.location.href = "directory.html";

        }, 1000);

    }

    return false;

}