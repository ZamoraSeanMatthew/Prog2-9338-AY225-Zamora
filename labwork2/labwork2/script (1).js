const correctUsername = "admin";
const correctPassword = "1234";

const beepSound = new Audio("mambo.mp3");

document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    if (username === correctUsername && password === correctPassword) {
        const now = new Date();

        document.getElementById("message").style.color = "green";
        document.getElementById("message").textContent =
            "Welcome, " + username + "!";
        document.getElementById("timestamp").textContent =
            "Login Time: " + now.toLocaleString();

    } else {
        beepSound.play();
        document.getElementById("message").style.color = "red";
        document.getElementById("message").textContent =
            "Incorrect username or password!";
        document.getElementById("timestamp").textContent = "";
    }
});
