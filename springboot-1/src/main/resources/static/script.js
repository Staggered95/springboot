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
        id: Number(document.getElementById("id").value),
        name: document.getElementById("name").value,
        age: Number(document.getElementById("age").value),
        department: document.getElementById("department").value
    };

    await fetch(API,{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(student)
    });

    loadStudents();
}

async function updateStudent() {

    const id = document.getElementById("id").value;

    const student = {
        name: document.getElementById("name").value,
        age: Number(document.getElementById("age").value),
        department: document.getElementById("department").value
    };

    await fetch(`${API}/${id}`,{
        method:"PUT",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(student)
    });

    loadStudents();
}

async function deleteStudent(id){

    await fetch(`${API}/${id}`,{
        method:"DELETE"
    });

    loadStudents();
}

loadStudents();