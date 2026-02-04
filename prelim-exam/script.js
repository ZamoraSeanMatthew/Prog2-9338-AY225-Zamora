const csvData = `StudentID,first_name,last_name,LAB WORK 1,LAB WORK 2,LAB WORK 3,PRELIM EXAM,ATTENDANCE GRADE
73900438,Osbourne,Wakenshaw,69,5,52,12,78
114924014,Albie,Gierardi,58,92,16,57,97
111901632,Eleen,Pentony,43,81,34,36,16`;

let records = [];

function parseCSV() {
    let lines = csvData.split("\n");
    for (let i = 1; i < lines.length; i++) {
        let d = lines[i].split(",");
        records.push({
            id: d[0],
            fname: d[1],
            lname: d[2],
            lw1: d[3],
            lw2: d[4],
            lw3: d[5],
            prelim: d[6],
            attendance: d[7]
        });
    }
}

function render() {
    const body = document.getElementById("tableBody");
    body.innerHTML = "";

    records.forEach((r, i) => {
        body.innerHTML += `
        <tr>
            <td>${r.id}</td>
            <td>${r.fname}</td>
            <td>${r.lname}</td>
            <td>${r.lw1}</td>
            <td>${r.lw2}</td>
            <td>${r.lw3}</td>
            <td>${r.prelim}</td>
            <td>${r.attendance}</td>
            <td><button onclick="del(${i})">Delete</button></td>
        </tr>
        `;
    });
}

function nextStep() {
    if (
        document.getElementById("StudentID").value === "" ||
        document.getElementById("first_name").value === "" ||
        document.getElementById("last_name").value === ""
    ) {
        alert("Fill student info first");
        return;
    }
    document.getElementById("gradeSection").style.display = "block";
}

function addRecord() {
    records.push({
        id: StudentID.value,
        fname: first_name.value,
        lname: last_name.value,
        lw1: lw1.value,
        lw2: lw2.value,
        lw3: lw3.value,
        prelim: prelim.value,
        attendance: attendance.value
    });

    render();
    document.getElementById("gradeSection").style.display = "none";

    StudentID.value = "";
    first_name.value = "";
    last_name.value = "";
}

function del(i) {
    records.splice(i, 1);
    render();
}

parseCSV();
render();
