function computeGrades() {
    let attendance = parseFloat(prompt("Enter Attendance Grade:"));
    let lw1 = parseFloat(prompt("Enter Lab Work 1 Grade:"));
    let lw2 = parseFloat(prompt("Enter Lab Work 2 Grade:"));
    let lw3 = parseFloat(prompt("Enter Lab Work 3 Grade:"));

    // Computation
    let labAverage = (lw1 + lw2 + lw3) / 3;
    let classStanding = (attendance * 0.40) + (labAverage * 0.60);

    let requiredPass = (75 - (classStanding * 0.70)) / 0.30;
    let requiredExcellent = (100 - (classStanding * 0.70)) / 0.30;

    // Remarks
    let passRemark = (requiredPass <= 100)
        ? "You can still pass the Prelim."
        : "Passing is no longer possible.";

    let excellentRemark = (requiredExcellent <= 100)
        ? "You can still achieve an Excellent grade."
        : "Excellent grade is no longer possible.";

    // Output
    let result = `
--- PRELIM GRADE REPORT ---
Attendance: ${attendance}
Lab Work 1: ${lw1}
Lab Work 2: ${lw2}
Lab Work 3: ${lw3}
Lab Work Average: ${labAverage.toFixed(2)}
Class Standing: ${classStanding.toFixed(2)}

Required Prelim Exam to PASS (75): ${requiredPass.toFixed(2)}
Required Prelim Exam for EXCELLENT (100): ${requiredExcellent.toFixed(2)}

Remark (Passing): ${passRemark}
Remark (Excellent): ${excellentRemark}
`;

    document.getElementById("output").textContent = result;
    alert("Computation complete! See results on the page.");
}
