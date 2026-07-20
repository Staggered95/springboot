const API = "/student";

function formatDate(date) {
    if (!date) return "-";
    return new Date(date).toLocaleString();
}

async function loadStudents() {

    const response = await fetch(API);
    const students = await response.json();

    const tbody = document.getElementById("students");
    tbody.innerHTML = "";

    students.forEach(student => {

        tbody.innerHTML += `
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.department}</td>
            <td>${formatDate(student.createdAt)}</td>
            <td>${formatDate(student.updatedAt)}</td>
            <td>
                <button onclick="deleteStudent(${student.id})">
                    Delete
                </button>
            </td>
        </tr>`;
    });
}

async function createStudent() {

    const student = {
        name: document.getElementById("name").value,
        age: Number(document.getElementById("age").value),
        department: document.getElementById("department").value
    };

    await fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    });

    document.getElementById("name").value = "";
    document.getElementById("age").value = "";
    document.getElementById("department").value = "";

    loadStudents();
}

async function updateStudent() {

    const id = document.getElementById("updateId").value;

    const student = {
        name: document.getElementById("updateName").value,
        age: Number(document.getElementById("updateAge").value),
        department: document.getElementById("updateDepartment").value
    };

    await fetch(`${API}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    });

    document.getElementById("updateId").value = "";
    document.getElementById("updateName").value = "";
    document.getElementById("updateAge").value = "";
    document.getElementById("updateDepartment").value = "";

    loadStudents();
}

async function deleteStudent(id) {

    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });

    loadStudents();
}

loadStudents();